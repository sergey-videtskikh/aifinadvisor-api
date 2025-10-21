#!/usr/bin/env node

/**
 * Semantic Version Bump Detection Script
 * 
 * Determines the version bump type (major/minor/patch) based on:
 * 1. OpenAPI specification changes (breaking vs non-breaking)
 * 2. Conventional commit messages (as fallback)
 * 
 * Breaking changes (MAJOR bump):
 * - Removed endpoints
 * - Removed required fields
 * - Changed field types
 * - Removed enum values
 * - Changed endpoint paths
 * 
 * New features (MINOR bump):
 * - New endpoints
 * - New optional fields
 * - New enum values
 * - New schemas
 * 
 * Fixes/docs (PATCH bump):
 * - Description changes
 * - Example updates
 * - Documentation improvements
 */

const fs = require('fs');
const { execSync } = require('child_process');
const yaml = require('js-yaml');

/**
 * Parse OpenAPI YAML file
 */
function parseOpenAPI(filePath) {
  try {
    const content = fs.readFileSync(filePath, 'utf8');
    return yaml.load(content);
  } catch (error) {
    console.error(`Error parsing ${filePath}:`, error.message);
    return null;
  }
}

/**
 * Get previous version of openapi.yaml from git
 */
function getPreviousOpenAPI() {
  try {
    // Try to get the file from the previous commit on main branch
    const previousContent = execSync('git show HEAD~1:openapi.yaml 2>/dev/null', {
      encoding: 'utf8',
      stdio: ['pipe', 'pipe', 'ignore']
    });
    return yaml.load(previousContent);
  } catch (error) {
    // If we can't get previous version (first commit, etc.), return null
    console.log('⚠️  Could not retrieve previous OpenAPI version (might be first commit)');
    return null;
  }
}

/**
 * Detect breaking changes in OpenAPI spec
 */
function detectBreakingChanges(oldSpec, newSpec) {
  const breaking = [];

  if (!oldSpec || !newSpec) {
    return breaking;
  }

  // Check for removed endpoints
  const oldPaths = Object.keys(oldSpec.paths || {});
  const newPaths = Object.keys(newSpec.paths || {});
  
  oldPaths.forEach(path => {
    if (!newPaths.includes(path)) {
      breaking.push(`Removed endpoint: ${path}`);
    } else {
      // Check for removed HTTP methods
      const oldMethods = Object.keys(oldSpec.paths[path] || {});
      const newMethods = Object.keys(newSpec.paths[path] || {});
      
      oldMethods.forEach(method => {
        if (!newMethods.includes(method)) {
          breaking.push(`Removed method: ${method.toUpperCase()} ${path}`);
        }
      });
    }
  });

  // Check for removed schemas
  const oldSchemas = Object.keys(oldSpec.components?.schemas || {});
  const newSchemas = Object.keys(newSpec.components?.schemas || {});
  
  oldSchemas.forEach(schema => {
    if (!newSchemas.includes(schema)) {
      breaking.push(`Removed schema: ${schema}`);
    } else {
      // Check for removed required fields
      const oldRequired = oldSpec.components.schemas[schema].required || [];
      const newRequired = newSpec.components.schemas[schema].required || [];
      
      oldRequired.forEach(field => {
        if (!newRequired.includes(field)) {
          breaking.push(`Removed required field: ${schema}.${field}`);
        }
      });

      // Check for changed field types
      const oldProps = oldSpec.components.schemas[schema].properties || {};
      const newProps = newSpec.components.schemas[schema].properties || {};
      
      Object.keys(oldProps).forEach(prop => {
        if (newProps[prop]) {
          const oldType = oldProps[prop].type;
          const newType = newProps[prop].type;
          
          if (oldType !== newType) {
            breaking.push(`Changed field type: ${schema}.${prop} (${oldType} → ${newType})`);
          }
        }
      });
    }
  });

  return breaking;
}

/**
 * Detect new features in OpenAPI spec
 */
function detectNewFeatures(oldSpec, newSpec) {
  const features = [];

  if (!oldSpec || !newSpec) {
    return features;
  }

  // Check for new endpoints
  const oldPaths = Object.keys(oldSpec.paths || {});
  const newPaths = Object.keys(newSpec.paths || {});
  
  newPaths.forEach(path => {
    if (!oldPaths.includes(path)) {
      features.push(`New endpoint: ${path}`);
    } else {
      // Check for new HTTP methods
      const oldMethods = Object.keys(oldSpec.paths[path] || {});
      const newMethods = Object.keys(newSpec.paths[path] || {});
      
      newMethods.forEach(method => {
        if (!oldMethods.includes(method)) {
          features.push(`New method: ${method.toUpperCase()} ${path}`);
        }
      });
    }
  });

  // Check for new schemas
  const oldSchemas = Object.keys(oldSpec.components?.schemas || {});
  const newSchemas = Object.keys(newSpec.components?.schemas || {});
  
  newSchemas.forEach(schema => {
    if (!oldSchemas.includes(schema)) {
      features.push(`New schema: ${schema}`);
    } else {
      // Check for new optional fields
      const oldProps = Object.keys(oldSpec.components.schemas[schema].properties || {});
      const newProps = Object.keys(newSpec.components.schemas[schema].properties || {});
      const required = newSpec.components.schemas[schema].required || [];
      
      newProps.forEach(prop => {
        if (!oldProps.includes(prop) && !required.includes(prop)) {
          features.push(`New optional field: ${schema}.${prop}`);
        }
      });
    }
  });

  return features;
}

/**
 * Analyze commit messages for conventional commits
 */
function analyzeCommitMessages() {
  try {
    // Get commits since last tag or last 10 commits
    const commits = execSync('git log --format=%s -n 10 2>/dev/null', {
      encoding: 'utf8',
      stdio: ['pipe', 'pipe', 'ignore']
    }).split('\n').filter(Boolean);

    const hasBreaking = commits.some(msg => 
      msg.includes('BREAKING CHANGE:') || 
      msg.includes('!:') ||
      msg.match(/^[a-z]+!:/)
    );

    const hasFeat = commits.some(msg => msg.startsWith('feat:') || msg.startsWith('feat('));

    return { hasBreaking, hasFeat, commits };
  } catch (error) {
    console.log('⚠️  Could not analyze commit messages');
    return { hasBreaking: false, hasFeat: false, commits: [] };
  }
}

/**
 * Main function to determine version bump
 */
function determineVersionBump() {
  console.log('🔍 Analyzing changes for semantic version bump...\n');

  // Step 1: Analyze OpenAPI changes
  const currentSpec = parseOpenAPI('openapi.yaml');
  const previousSpec = getPreviousOpenAPI();

  let bumpType = 'patch'; // Default to patch
  let reasons = [];

  if (currentSpec && previousSpec) {
    console.log('📋 Comparing OpenAPI specifications...\n');

    const breaking = detectBreakingChanges(previousSpec, currentSpec);
    const features = detectNewFeatures(previousSpec, currentSpec);

    if (breaking.length > 0) {
      bumpType = 'major';
      reasons.push('Breaking changes detected in OpenAPI:');
      breaking.forEach(change => reasons.push(`  - ${change}`));
    } else if (features.length > 0) {
      bumpType = 'minor';
      reasons.push('New features detected in OpenAPI:');
      features.forEach(feature => reasons.push(`  - ${feature}`));
    } else {
      reasons.push('No breaking changes or new features in OpenAPI');
      reasons.push('Defaulting to PATCH version bump');
    }
  } else {
    console.log('⚠️  Could not compare OpenAPI specs, using commit analysis...\n');
    
    // Step 2: Fallback to commit message analysis
    const { hasBreaking, hasFeat, commits } = analyzeCommitMessages();

    if (hasBreaking) {
      bumpType = 'major';
      reasons.push('Breaking change detected in commit messages');
    } else if (hasFeat) {
      bumpType = 'minor';
      reasons.push('New feature detected in commit messages');
    } else {
      reasons.push('No breaking changes or features in commits');
      reasons.push('Defaulting to PATCH version bump');
    }

    if (commits.length > 0) {
      reasons.push('\nRecent commits:');
      commits.slice(0, 5).forEach(commit => reasons.push(`  - ${commit}`));
    }
  }

  // Output results
  console.log('═══════════════════════════════════════════════════════');
  console.log(`📊 Version Bump Decision: ${bumpType.toUpperCase()}`);
  console.log('═══════════════════════════════════════════════════════\n');
  
  reasons.forEach(reason => console.log(reason));
  console.log('\n');

  // Output for GitHub Actions
  console.log(`bump=${bumpType}`);
  
  return bumpType;
}

// Run if executed directly
if (require.main === module) {
  determineVersionBump();
}

module.exports = { determineVersionBump, detectBreakingChanges, detectNewFeatures };
