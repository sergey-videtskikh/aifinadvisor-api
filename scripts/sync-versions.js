#!/usr/bin/env node

const fs = require('fs');
const path = require('path');
const semver = require('semver');

// Read OpenAPI spec version
const openApiPath = 'openapi.yaml';
const openApiContent = fs.readFileSync(openApiPath, 'utf8');
const versionMatch = openApiContent.match(/version:\s*(.+)/);
const newVersion = versionMatch ? versionMatch[1].trim() : '1.0.0';

// Skip updating main package.json - let npm version handle it
console.log(`ℹ️ Skipping main package.json update - npm version will handle it`);

console.log(`🔄 Syncing version to ${newVersion}`);

// Update frontend package.json
const frontendPackagePath = path.join('packages', 'frontend-api', 'package.json');
if (fs.existsSync(frontendPackagePath)) {
  const frontendPackage = JSON.parse(fs.readFileSync(frontendPackagePath, 'utf8'));
  frontendPackage.version = newVersion;

  // Fix repository URL and add publishConfig for GitHub Packages
  frontendPackage.repository = {
    "type": "git",
    "url": "https://github.com/sergey-videtskikh/aifinadvisor-api.git"
  };

  frontendPackage.publishConfig = {
    "@sergey-videtskikh:registry": "https://npm.pkg.github.com"
  };

  fs.writeFileSync(frontendPackagePath, JSON.stringify(frontendPackage, null, 2) + '\n');
  console.log(`✅ Updated frontend package to ${newVersion}`);
}

// Update backend pom.xml
const pomPath = path.join('packages', 'backend-api', 'pom.xml');
if (fs.existsSync(pomPath)) {
  let pomContent = fs.readFileSync(pomPath, 'utf8');

  // Replace version in pom.xml
  pomContent = pomContent.replace(
    /<version>[\d\.]+([-\w]*)?<\/version>/,
    `<version>${newVersion}</version>`
  );

  fs.writeFileSync(pomPath, pomContent);
  console.log(`✅ Updated backend pom.xml to ${newVersion}`);
}

// Note: OpenAPI spec is the source of truth for version, so we don't update it here

console.log(`🎉 All packages synced to version ${newVersion}`);