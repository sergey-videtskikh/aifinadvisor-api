# CLAUDE.md

This file provides guidance to Claude Code (claude.ai/code) when working with code in this repository.

## MCP Server Integration

This project should be worked with using the available MCP servers for optimal productivity:

### JetBrains MCP Server (Primary)
**ALWAYS use JetBrains MCP server tools for project operations:**
- `mcp__jetbrains__*` tools for file operations, search, and project analysis
- `mcp__jetbrains__list_directory_tree` for exploring project structure
- `mcp__jetbrains__get_file_text_by_path` for reading files
- `mcp__jetbrains__replace_text_in_file` for editing files
- `mcp__jetbrains__find_files_by_name_keyword` and `mcp__jetbrains__search_in_files_by_text` for searching
- `mcp__jetbrains__execute_terminal_command` for running commands

### GitHub MCP Server (For Git Operations)
**Use GitHub MCP server for repository operations:**
- `mcp__github__*` tools for GitHub API operations
- `mcp__github__get_pull_request*` for PR analysis
- `mcp__github__create_pull_request` for creating PRs
- `mcp__github__list_*` tools for repository exploration

### When to use each:
- **File operations**: Always use JetBrains MCP server
- **Project analysis**: JetBrains MCP server  
- **GitHub operations**: GitHub MCP server
- **Terminal commands**: JetBrains `execute_terminal_command`
- **Never use**: Raw `Bash` tool when MCP servers are available

## Commands

### Validation and Linting
```bash
npm run lint:openapi          # Lint OpenAPI specification with Redocly CLI
npm run validate              # Full validation (lint + generator validation)
```

### Code Generation
```bash
npm run generate:backend      # Generate Spring Boot 3 client (Java 17 + Jakarta EE)
npm run generate:frontend     # Generate TypeScript client with fetch API
npm run generate:all          # Generate both backend and frontend clients
npm run prepare:packages      # Generate all + copy to workspace packages
npm run copy:packages         # Copy generated code to packages (backend + frontend)
```

### Build and Development
```bash
npm run build:packages        # Build all workspace packages
npm run build:frontend-package # Build only the frontend TypeScript package
npm run mock:server           # Start Prism mock server on port 4010
npm run mock:server:dynamic   # Start mock server with dynamic responses
```

### Version Management
```bash
npm run version:patch         # Bump patch version and sync to all packages
npm run version:minor         # Bump minor version and sync to all packages
npm run version:major         # Bump major version and sync to all packages
```

### Publishing
```bash
npm run publish:all           # Publish both frontend (NPM) and backend (Maven) packages
npm run publish:frontend      # Publish TypeScript package to NPM
npm run publish:backend       # Deploy Java package to Maven repository
```

### Utilities
```bash
npm run clean                 # Remove generated/ and packages/*/src directories
```

## Architecture

### Project Structure
This is a **monorepo workspace** that generates API client libraries from an OpenAPI specification:

- **Root**: OpenAPI 3.0.3 specification (`openapi.yaml`) with enterprise-grade financial API
- **Generated Code**: Spring Boot 3 (Java 17) and TypeScript clients generated in `generated/`
- **Workspace Packages**:
  - `packages/backend-api/`: Spring Boot client interfaces (deployed to Maven)
  - `packages/frontend-api/`: TypeScript client (published to NPM as `@sergey-videtskikh/finapp-api-client`)

### Code Generation Flow
1. **Validation**: OpenAPI spec validated with strict Redocly rules
2. **Generation**: OpenAPI Generator CLI creates both clients in `generated/`
3. **Copy**: Generated code copied to workspace packages with build configurations
4. **Build**: Frontend package compiled to ES6+ modules
5. **Publish**: Packages published to their respective registries

### Key Features
- **Money Safety**: All monetary amounts use decimal strings with pattern `^\d+\.\d{2}$`
- **RFC7807 Error Handling**: Complete ProblemDetails implementation for all errors
- **UUID Identifiers**: All entity IDs use UUID v4 format with validation
- **Spring Boot Pagination**: Full Page metadata support for list endpoints
- **JWT Authentication**: Bearer token security scheme with auth endpoint overrides

### OpenAPI Specification Details
- **Location**: `openapi.yaml` (root level, references modular structure in `api-docs/`)
- **Format**: OpenAPI 3.0.3 with enterprise patterns
- **Documentation**: Comprehensive Russian documentation in `api-docs/README.md`
- **Validation**: Strict Redocly rules enforce consistency and best practices

### Generated Clients
- **Backend**: Spring Boot 3 interfaces (`interfaceOnly=true`) for implementation in controllers
- **Frontend**: TypeScript with fetch API, ES6+ features, and full type definitions
- **Config**: Backend uses Java 17 + Jakarta EE, frontend targets modern browsers

### Development Workflow
1. Modify `openapi.yaml` or files in `api-docs/`
2. Run `npm run validate` to check for errors
3. Run `npm run generate:all` to regenerate clients
4. Test with `npm run mock:server` if needed
5. Build packages with `npm run build:packages`

## OpenAPI Best Practices (MANDATORY)

This project follows **enterprise-grade OpenAPI standards**. ALL changes must comply with these requirements:

### 💰 Financial Data Standards
- **Money amounts**: MUST use `string` with pattern `^\d+\.\d{2}$` (NEVER float/double)
- **Currencies**: MUST include ISO-4217 currency codes (`RUB`, `USD`, `EUR`)
- **Example**: `{"amount": "250.50", "currency": "RUB"}`

### 🚨 Error Handling (RFC7807 ONLY)
- **ALL errors**: MUST use `ProblemDetails` schema with `application/problem+json`
- **NEVER use**: Legacy `ErrorResponse` with `application/json`
- **Required fields**: `type`, `title`, `status`
- **Validation errors**: Include `errors` array with field details

### 🌐 HTTP Contracts
- **201 responses**: MUST include `Location` header
- **GET by ID**: MUST include `ETag` header for optimistic locking
- **PATCH updates**: MUST require `If-Match` header with ETag
- **DELETE operations**: MUST return 204 (no content)
- **Pagination**: MUST use Spring Boot Page format with deterministic sorting

### 🆔 Data Types
- **All IDs**: MUST use UUID v4 format with validation
- **Dates/Times**: MUST use ISO-8601 UTC format (`date-time`, `date`)
- **Enums**: MUST have explicit descriptions
- **Required fields**: MUST be explicitly listed

### 📋 Documentation
- **ALL operations**: MUST have `summary` AND `description`
- **ALL schemas**: MUST have field descriptions and examples
- **Content-Type**: MUST be consistent (`application/json` for success, `application/problem+json` for errors)

### 🔐 Security
- **JWT Bearer**: Applied globally with auth endpoint overrides
- **No PII**: Never expose sensitive data in examples or logs
- **HTTPS**: Production servers must use HTTPS only

### ⚠️ CRITICAL: Validation Before Changes
```bash
# ALWAYS run before committing:
npm run validate  # Must pass without warnings
npm run lint:openapi  # Must be clean
```

### Breaking Changes Policy
- **Major version**: Required for removing fields, changing types, or removing endpoints
- **Minor version**: Adding optional fields, new endpoints
- **Patch version**: Documentation, examples, non-breaking fixes

## Important Notes
- **No Direct Editing**: Never edit files in `generated/` or `packages/*/src/` - they are overwritten
- **Version Sync**: Use version scripts to keep root and package versions synchronized
- **Validation First**: Always validate before generating to avoid broken builds
- **Enterprise Standards**: Follow strict RFC7807, UUID, and decimal money patterns documented in README.md
- **MCP Server First**: Always use JetBrains MCP server tools instead of raw file operations