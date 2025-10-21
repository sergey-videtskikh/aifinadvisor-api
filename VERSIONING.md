# Version Management Policy

This document describes the automated semantic versioning policy for the aifinadvisor-api project.

## Semantic Versioning

We follow [Semantic Versioning 2.0.0](https://semver.org/):

- **MAJOR** (X.0.0): Breaking changes that require consumer code updates
- **MINOR** (0.X.0): New features that are backward-compatible
- **PATCH** (0.0.X): Bug fixes and documentation updates

## Automated Version Detection

The version bump type is automatically determined by analyzing:

1. **OpenAPI Specification Changes** (Primary)
2. **Conventional Commit Messages** (Fallback)

### OpenAPI Breaking Changes (MAJOR)

The following changes trigger a **MAJOR** version bump:

- ❌ **Removed endpoints** - Any API path deleted from the specification
- ❌ **Removed HTTP methods** - Any HTTP method removed from an existing endpoint
- ❌ **Removed schemas** - Any schema definition removed from components
- ❌ **Removed required fields** - Required field removed from a schema
- ❌ **Changed field types** - Field type changed (e.g., `string` → `number`)
- ❌ **Removed enum values** - Enum value removed from an existing enum

**Example:**
```yaml
# MAJOR: Removed required field
# Before
Transaction:
  required: [id, amount, date, category]  
  
# After
Transaction:
  required: [id, amount, date]  # category removed → MAJOR
```

### OpenAPI New Features (MINOR)

The following changes trigger a **MINOR** version bump:

- ✨ **New endpoints** - New API path added to the specification
- ✨ **New HTTP methods** - New HTTP method added to existing endpoint
- ✨ **New schemas** - New schema definition added to components
- ✨ **New optional fields** - Optional field added to a schema
- ✨ **New enum values** - New value added to an existing enum (if backward-compatible)

**Example:**
```yaml
# MINOR: New optional field
# Before
Transaction:
  properties:
    id: string
    amount: string
  
# After
Transaction:
  properties:
    id: string
    amount: string
    notes: string  # new optional field → MINOR
```

### Documentation Changes (PATCH)

The following changes trigger a **PATCH** version bump:

- 📝 **Description updates** - Changes to endpoint or field descriptions
- 📝 **Example updates** - Changes to example values
- 📝 **Documentation improvements** - Changes to markdown docs or comments
- 🐛 **Bug fixes** - Code generation bug fixes without API changes

**Example:**
```yaml
# PATCH: Description change only
# Before
amount:
  type: string
  description: "Transaction amount"
  
# After
amount:
  type: string
  description: "Transaction amount in decimal format (e.g., '250.50')"  # → PATCH
```

## Conventional Commits (Fallback)

When OpenAPI comparison is unavailable (e.g., first commit), version bump is determined by commit messages:

### Breaking Changes (MAJOR)

```bash
# Any of these trigger MAJOR bump:
feat!: remove legacy authentication endpoint
fix!: change field type from string to number

# Or explicit BREAKING CHANGE in footer:
feat: update user schema

BREAKING CHANGE: removed deprecated field 'username'
```

### New Features (MINOR)

```bash
feat: add new transaction analytics endpoint
feat(api): add currency field to transactions
```

### Bug Fixes (PATCH)

```bash
fix: correct validation pattern for email field
docs: update API usage examples
chore: regenerate client libraries
```

## How Version Bumps Happen

### Automated (CI/CD)

When you push to `main` branch with changes to `openapi.yaml` or `api-docs/**`:

1. GitHub Actions triggers the build workflow
2. Script analyzes OpenAPI changes (compares with previous commit)
3. Version bump type is determined (major/minor/patch)
4. Version is bumped in all packages:
   - Root `package.json`
   - Frontend `packages/frontend-api/package.json`
   - Backend `packages/backend-api/pom.xml`
   - OpenAPI `openapi.yaml`
5. Packages are published to GitHub Packages
6. GitHub Release is created with changelog

### Manual (Local Development)

You can manually bump versions using npm scripts:

```bash
# Patch version (1.0.4 → 1.0.5)
npm run version:patch

# Minor version (1.0.4 → 1.1.1)
npm run version:minor

# Major version (1.0.4 → 2.0.0)
npm run version:major
```

**Note:** Manual version bumps should only be used for:
- Testing version sync scripts
- Emergency hotfixes
- Overriding automated detection

## Version Synchronization

All packages are kept in sync using `scripts/sync-versions.js`:

```
Root package.json (source of truth)
         ↓
   sync-versions.js
         ├→ Frontend package.json
         ├→ Backend pom.xml
         └→ OpenAPI spec
```

## Testing Version Detection

Test the version detection locally before pushing:

```bash
# See what version bump would be detected
node scripts/detect-version-bump.js

# Output example:
# 🔍 Analyzing changes for semantic version bump...
# 
# ═══════════════════════════════════════════════════════
# 📊 Version Bump Decision: MINOR
# ═══════════════════════════════════════════════════════
# 
# New features detected in OpenAPI:
#   - New endpoint: /api/v1/analytics
#   - New optional field: Transaction.tags
```

## Best Practices

### For API Changes

1. **Plan breaking changes carefully** - Breaking changes require MAJOR version bump and consumer updates
2. **Prefer optional fields** - Add new fields as optional to maintain backward compatibility
3. **Deprecate before removing** - Add deprecation notices before removing fields in next major version
4. **Document migration** - Include migration guide in release notes for MAJOR versions

### For Commits

1. **Use conventional commits** - Helps with automated changelog generation
2. **Be explicit about breaking changes** - Use `!` or `BREAKING CHANGE:` footer
3. **Write descriptive messages** - Helps understand what changed in each version

### For Versioning

1. **Let automation handle it** - Avoid manual version bumps unless necessary
2. **Test in PRs first** - CI validates changes without bumping version
3. **Monitor releases** - Check GitHub Releases page after each publish
4. **Communicate changes** - Notify consumers of MAJOR version updates

## Examples

### Scenario 1: Adding New Endpoint

```yaml
# openapi.yaml
paths:
  /api/v1/reports:  # NEW
    get:
      summary: Get financial reports
      ...
```

**Result:** MINOR version bump (1.0.4 → 1.1.1)

### Scenario 2: Removing Required Field

```yaml
# Before
UserProfile:
  required: [id, email, phoneNumber]
  
# After
UserProfile:
  required: [id, email]  # phoneNumber removed
```

**Result:** MAJOR version bump (1.0.4 → 2.0.0)

### Scenario 3: Fixing Typo in Description

```yaml
# Before
description: "Retreive user data"

# After
description: "Retrieve user data"  # Fixed typo
```

**Result:** PATCH version bump (1.0.4 → 1.0.5)

## Troubleshooting

### Version bump not detected correctly

1. Check that `fetch-depth: 0` is set in workflow checkout step
2. Verify git history is available: `git log --oneline -n 5`
3. Run detection script locally: `node scripts/detect-version-bump.js`

### All changes result in PATCH

1. Verify OpenAPI changes are committed
2. Check that comparison finds differences
3. Review script output for detected changes

### Need to override detection

Use manual version bump:

```bash
# Override automated detection
npm run version:major  # or minor/patch
git push --follow-tags
```

## Related Documentation

- [Semantic Versioning 2.0.0](https://semver.org/)
- [Conventional Commits](https://www.conventionalcommits.org/)
- [OpenAPI Specification 3.0.3](https://spec.openapis.org/oas/v3.0.3)
- [GitHub Packages Documentation](https://docs.github.com/en/packages)

## Support

For questions or issues with versioning:
1. Check this documentation first
2. Review recent workflow runs in GitHub Actions
3. Open an issue in the repository
