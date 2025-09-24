#!/usr/bin/env node

const fs = require('fs');
const path = require('path');

// Path to the backend pom.xml
const pomPath = path.join('packages', 'backend-api', 'pom.xml');

if (fs.existsSync(pomPath)) {
  let pomContent = fs.readFileSync(pomPath, 'utf8');

  // Add distributionManagement if it doesn't exist
  if (!pomContent.includes('<distributionManagement>')) {
    const distributionManagement = `
    <distributionManagement>
        <repository>
            <id>github</id>
            <name>GitHub Packages</name>
            <url>https://maven.pkg.github.com/sergey-videtskikh/aifinadvisor-api</url>
        </repository>
    </distributionManagement>`;

    // Insert distributionManagement before the closing </project> tag
    pomContent = pomContent.replace('</project>', `${distributionManagement}\n</project>`);

    fs.writeFileSync(pomPath, pomContent);
    console.log('✅ Added distributionManagement to backend pom.xml');
  } else {
    console.log('✅ Backend pom.xml already has distributionManagement');
  }
} else {
  console.log('❌ Backend pom.xml not found');
}