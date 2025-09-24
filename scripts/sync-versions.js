#!/usr/bin/env node

const fs = require('fs');
const path = require('path');
const semver = require('semver');

// Read main package.json version
const mainPackageJson = JSON.parse(fs.readFileSync('package.json', 'utf8'));
const newVersion = mainPackageJson.version;

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
    "@finapp:registry": "https://npm.pkg.github.com"
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

// Update OpenAPI spec version
const openApiPath = 'openapi.yaml';
if (fs.existsSync(openApiPath)) {
  let openApiContent = fs.readFileSync(openApiPath, 'utf8');

  // Replace version in OpenAPI spec
  openApiContent = openApiContent.replace(
    /version:\s*[\d\.]+([-\w]*)?/,
    `version: ${newVersion}`
  );

  fs.writeFileSync(openApiPath, openApiContent);
  console.log(`✅ Updated OpenAPI spec to ${newVersion}`);
}

console.log(`🎉 All packages synced to version ${newVersion}`);