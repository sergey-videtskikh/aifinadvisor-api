# FinApp API - Enterprise-Grade OpenAPI Implementation

[![OpenAPI](https://img.shields.io/badge/OpenAPI-3.0.3-green.svg)](https://spec.openapis.org/oas/v3.0.3)
[![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.2.0-brightgreen.svg)](https://spring.io/projects/spring-boot)
[![Java](https://img.shields.io/badge/Java-17-orange.svg)](https://openjdk.java.net/projects/jdk/17/)
[![TypeScript](https://img.shields.io/badge/TypeScript-5.0-blue.svg)](https://www.typescriptlang.org/)

> **Production-ready OpenAPI specification and code generation for FinApp financial application**

## 📋 Table of Contents

- [Overview](#overview)
- [✅ Implemented Features](#-implemented-features)
- [🚀 Quick Start](#-quick-start)
- [📐 API Contract Best Practices](#-api-contract-best-practices)
- [🔧 Development Workflow](#-development-workflow)
- [📚 Generated Clients Usage](#-generated-clients-usage)
- [🎯 Roadmap](#-roadmap)
- [🛠️ Troubleshooting](#️-troubleshooting)

## Overview

This repository contains a **production-grade OpenAPI 3.0.3 specification** for FinApp financial application with automated code generation for both backend (Spring Boot 3 + Java 17) and frontend (TypeScript) clients.

### 🎯 Key Features

- **Enterprise-ready API design** following industry best practices
- **RFC7807 compliant error handling** with ProblemDetails
- **Safe money handling** using decimal string types
- **Comprehensive pagination** support with Spring Boot Page metadata
- **Automated code generation** for Spring Boot 3 and TypeScript
- **CI/CD integration** with validation, generation, and publishing
- **Mock server** support for development

---

## ✅ Implemented Features

### 📊 Data Modeling Excellence

- **✅ Money Safety**: All monetary amounts use `string` with decimal pattern `^\d+\.\d{2}$`
- **✅ UUID Validation**: All IDs use proper UUID format with validation
- **✅ Date/Time Standards**: ISO-8601 format with proper timezone handling
- **✅ Enum Definitions**: Clear enum values with descriptions
- **✅ Type Safety**: Consistent required/nullable field definitions

### 🌐 HTTP Contract Standards

- **✅ RESTful Design**: Proper HTTP methods (GET/POST/PUT/DELETE)
- **✅ Status Codes**: Correct 2xx/4xx/5xx responses
- **✅ Location Headers**: 201 responses include resource location
- **✅ Content Types**: Consistent `application/json` and `application/problem+json`
- **✅ Pagination**: Full Spring Boot Page support with metadata

### 🚨 Error Handling (RFC7807)

- **✅ ProblemDetails Schema**: Complete RFC7807 implementation
- **✅ Structured Errors**: Type, title, status, detail, instance fields
- **✅ Validation Errors**: Detailed field-level error information
- **✅ Consistent Format**: Unified error responses across all endpoints

### 🔐 Security Implementation

- **✅ JWT Bearer Auth**: Proper security scheme definition
- **✅ Global Security**: Applied with auth endpoint overrides
- **✅ PII Protection**: No sensitive data in examples or logs

### 🏗️ Code Generation

- **✅ Spring Boot 3**: Java 17, Jakarta EE, modern Spring features
- **✅ TypeScript Client**: Modern ES6+ with fetch API
- **✅ Interfaces**: Comprehensive type definitions
- **✅ Documentation**: Auto-generated API documentation

### 🔄 CI/CD Integration

- **✅ OpenAPI Validation**: Redocly CLI with strict rules
- **✅ Automated Generation**: Backend and frontend clients
- **✅ Package Publishing**: NPM and Maven packages
- **✅ Semantic Versioning**: Intelligent version bumps based on API changes
  - **MAJOR**: Breaking changes (removed endpoints, changed types)
  - **MINOR**: New features (new endpoints, optional fields)
  - **PATCH**: Bug fixes and documentation updates

### 🛠️ Development Tools

- **✅ Mock Server**: Prism mock server with dynamic responses
- **✅ Linting**: Comprehensive OpenAPI validation rules
- **✅ Hot Reload**: Development workflow with live updates

---

## 🚀 Quick Start

### Prerequisites

- **Node.js** 18+
- **Java** 17+
- **Maven** 3.6+

### Installation

```bash
# Clone repository
git clone https://github.com/sergey-vsv/aifinadvisor-api.git
cd aifinadvisor-api

# Install dependencies
npm install

# Validate and generate code
npm run validate
npm run generate:all
```

### Commands

```bash
# Validation
npm run lint:openapi          # Lint OpenAPI specification
npm run validate              # Full validation

# Code Generation
npm run generate:backend      # Generate Spring Boot client
npm run generate:frontend     # Generate TypeScript client
npm run generate:all          # Generate both clients

# Development
npm run mock:server           # Start mock server on :4010
npm run mock:server:dynamic   # Dynamic mock responses

# Build & Publish
npm run build:packages        # Build all packages
npm run publish:all           # Publish to registries

# Version Management
npm run version:patch         # Bump patch version (1.0.4 → 1.0.5)
npm run version:minor         # Bump minor version (1.0.4 → 1.1.0)
npm run version:major         # Bump major version (1.0.4 → 2.0.0)
node scripts/detect-version-bump.js  # Test semantic version detection
```

---

## 📐 API Contract Best Practices

> **⚠️ MANDATORY REQUIREMENTS**: All API changes MUST follow these standards

### 💰 Money and Financial Data

```yaml
# ✅ CORRECT - Use decimal string with validation
amount:
  type: string
  pattern: '^\\d+\\.\\d{2}$'
  description: "Amount in decimal format (e.g., '250.50')"
  example: "250.50"

# ❌ WRONG - Never use floating point for money
amount:
  type: number
  format: double  # FORBIDDEN
```

**Requirements:**
- All monetary amounts MUST use `string` type
- Pattern MUST be `^\d+\.\d{2}$` for two decimal places
- Currency codes MUST follow ISO-4217 standard
- No floating-point numbers for financial calculations

### 🕒 Date and Time Handling

```yaml
# ✅ CORRECT - ISO-8601 with proper format
createdAt:
  type: string
  format: date-time
  description: "Creation timestamp in UTC"
  example: "2024-03-15T14:30:00Z"

date:
  type: string
  format: date
  description: "Date in YYYY-MM-DD format"
  example: "2024-03-15"
```

**Requirements:**
- All timestamps MUST use `date-time` format (ISO-8601)
- Dates MUST use `date` format (YYYY-MM-DD)
- Timezone MUST be UTC for all timestamps
- No local time formats or string dates

### 🆔 ID and Identifier Standards

```yaml
# ✅ CORRECT - UUID with validation
id:
  type: string
  format: uuid
  description: "Unique identifier"
  example: "123e4567-e89b-12d3-a456-426614174000"
```

**Requirements:**
- All entity IDs MUST use UUID format
- Path parameters MUST include format validation
- UUIDs MUST be version 4 (random)
- No sequential integer IDs for public APIs

### 🚨 Error Handling (RFC7807)

```yaml
# ✅ CORRECT - RFC7807 ProblemDetails
responses:
  '400':
    description: "Validation error"
    content:
      application/problem+json:
        schema:
          $ref: '#/components/schemas/ProblemDetails'

# Required ProblemDetails structure
ProblemDetails:
  type: object
  required: [type, title, status]
  properties:
    type:
      type: string
      format: uri
      example: "https://api.finapp.com/problems/validation-error"
    title:
      type: string
      example: "Validation Error"
    status:
      type: integer
      example: 400
    detail:
      type: string
      example: "Field 'amount' must be positive"
    instance:
      type: string
      format: uri
      example: "/api/v1/transactions/123"
    errors:
      type: array
      items:
        type: object
        properties:
          field: { type: string }
          message: { type: string }
          code: { type: string }
```

**Requirements:**
- ALL error responses MUST use RFC7807 ProblemDetails
- Content-Type MUST be `application/problem+json`
- Required fields: `type`, `title`, `status`
- Validation errors MUST include `errors` array with field details

### 📄 Pagination Standards

```yaml
# ✅ CORRECT - Spring Boot Page parameters
parameters:
  - name: page
    in: query
    schema:
      type: integer
      minimum: 0
      default: 0
  - name: size
    in: query
    schema:
      type: integer
      minimum: 1
      maximum: 100
      default: 20
  - name: sort
    in: query
    schema:
      type: string
      default: "createdAt,desc"

# ✅ CORRECT - Paginated response
responses:
  '200':
    content:
      application/json:
        schema:
          type: object
          properties:
            content:
              type: array
              items: { $ref: '#/components/schemas/EntityDto' }
            totalElements: { type: integer, format: int64 }
            totalPages: { type: integer }
            size: { type: integer }
            number: { type: integer }
            first: { type: boolean }
            last: { type: boolean }
```

**Requirements:**
- All list endpoints MUST support pagination
- Page numbers MUST be 0-based
- Maximum page size MUST be enforced (≤ 100)
- Response MUST include Spring Boot Page metadata
- Sort parameter MUST follow Spring Data format

### 🔗 HTTP Methods and Status Codes

```yaml
# ✅ CORRECT - Proper HTTP semantics
/api/v1/transactions:
  get:    # List resources (200)
  post:   # Create resource (201 + Location header)

/api/v1/transactions/{id}:
  get:    # Get single resource (200, 404)
  put:    # Update resource (200, 404)
  delete: # Delete resource (204, 404)

# ✅ CORRECT - 201 with Location header
responses:
  '201':
    description: "Resource created"
    headers:
      Location:
        schema: { type: string }
        description: "URL of created resource"
    content:
      application/json:
        schema: { $ref: '#/components/schemas/EntityDto' }
```

**Requirements:**
- GET: Read operations (200, 404)
- POST: Create operations (201 + Location header)
- PUT: Full updates (200, 404)
- PATCH: Partial updates (200, 404)
- DELETE: Remove operations (204, 404)
- All 4xx/5xx responses MUST use ProblemDetails

### 🏷️ Operation Standards

```yaml
# ✅ CORRECT - Complete operation definition
/api/v1/transactions:
  post:
    operationId: createTransaction  # REQUIRED - camelCase verb
    tags: [Transactions]           # REQUIRED - logical grouping
    summary: "Create transaction"   # REQUIRED - brief description
    description: |                 # RECOMMENDED - detailed description
      Creates a new transaction with the provided data.
      All monetary amounts must be positive decimal strings.
    security: [BearerAuth: []]     # REQUIRED if not global
```

**Requirements:**
- `operationId` MUST be unique and in camelCase
- `tags` MUST group related operations logically
- `summary` MUST be concise and descriptive
- `description` SHOULD provide detailed information
- `security` MUST be defined (global or per-operation)

### 📝 Schema Documentation

```yaml
# ✅ CORRECT - Well-documented schema
TransactionDto:
  type: object
  required: [id, amount, date, type]
  properties:
    id:
      type: string
      format: uuid
      description: "Unique transaction identifier"
      example: "123e4567-e89b-12d3-a456-426614174000"
    amount:
      type: string
      pattern: '^\\d+\\.\\d{2}$'
      description: "Transaction amount in decimal string format"
      example: "250.50"
    type:
      $ref: '#/components/schemas/TransactionType'
      description: "Type of transaction"
```

**Requirements:**
- All schemas MUST have clear descriptions
- Examples MUST be provided for complex types
- Required fields MUST be explicitly listed
- Constraints MUST be properly defined
- References MUST use $ref for reusability

---

## 🔧 Development Workflow

### Making API Changes

1. **Update OpenAPI Specification**
   ```bash
   # Edit openapi.yaml or api-docs/schemas/*.yaml
   vim openapi.yaml
   ```

2. **Validate Changes**
   ```bash
   npm run validate  # Must pass without errors
   ```

3. **Generate and Test**
   ```bash
   npm run generate:all
   npm run build:packages
   ```

4. **Test with Mock Server**
   ```bash
   npm run mock:server
   curl http://localhost:4010/api/v1/transactions
   ```

5. **Commit and Push**
   ```bash
   git add .
   git commit -m "feat(api): add new endpoint"
   git push
   ```

### Validation Rules

The project uses **Redocly CLI** with strict validation rules:

- ✅ All operations MUST have `operationId`
- ✅ All operations MUST have `summary`
- ✅ All operations MUST have at least one 2xx response
- ✅ All operations MUST have appropriate 4xx responses
- ✅ No unresolved $ref references
- ✅ No unused components
- ✅ Consistent naming conventions

### Automated Semantic Versioning

Version bumps are **automatically determined** by analyzing changes to the OpenAPI specification:

**🔴 MAJOR Version (Breaking Changes)**
- ❌ Removed endpoints or HTTP methods
- ❌ Removed schemas or required fields
- ❌ Changed field types (e.g., `string` → `number`)
- ❌ Removed enum values

**🟡 MINOR Version (New Features)**
- ✨ New endpoints or HTTP methods
- ✨ New schemas or optional fields
- ✨ New enum values

**🟢 PATCH Version (Bug Fixes)**
- 📝 Description or example updates
- 📝 Documentation improvements
- 🐛 Code generation bug fixes

**How It Works:**

1. Push changes to `openapi.yaml` or `api-docs/**`
2. CI/CD compares with previous commit
3. Detects breaking changes vs new features
4. Automatically bumps version (major/minor/patch)
5. Publishes to NPM and Maven registries
6. Creates GitHub Release with changelog

**Test Version Detection:**
```bash
# See what version bump would be applied
node scripts/detect-version-bump.js

# Output:
# 🔍 Analyzing changes for semantic version bump...
# 📊 Version Bump Decision: MINOR
# New features detected in OpenAPI:
#   - New endpoint: /api/v1/analytics
```

**Manual Override:**
```bash
npm run version:major  # Force major version bump
npm run version:minor  # Force minor version bump
npm run version:patch  # Force patch version bump
```

📖 **See [VERSIONING.md](VERSIONING.md) for complete versioning policy**

---

## 📚 Generated Clients Usage

### TypeScript Frontend

```typescript
import { Configuration, TransactionsApi, AuthenticationApi } from '@finapp/api-client';

// Configure API client
const config = new Configuration({
  basePath: process.env.NEXT_PUBLIC_API_URL,
  accessToken: () => localStorage.getItem('token') || '',
});

const transactionsApi = new TransactionsApi(config);
const authApi = new AuthenticationApi(config);

// Use with React Query
import { useQuery } from '@tanstack/react-query';

export const useTransactions = (page = 0, size = 20) => {
  return useQuery({
    queryKey: ['transactions', page, size],
    queryFn: () => transactionsApi.getTransactions({
      page,
      size,
      sort: 'date,desc'
    }),
  });
};

// Handle errors with ProblemDetails
try {
  const transaction = await transactionsApi.createTransaction({
    createTransactionRequest: {
      amount: "250.50",
      categoryId: "123e4567-e89b-12d3-a456-426614174000",
      name: "Lunch",
      type: "EXPENSE",
      accountId: "456e7890-e89b-12d3-a456-426614174001"
    }
  });
} catch (error) {
  if (error.status === 400) {
    const problemDetails = await error.json();
    console.log(problemDetails.title); // "Validation Error"
    problemDetails.errors?.forEach(err => {
      console.log(`${err.field}: ${err.message}`);
    });
  }
}
```

### Spring Boot Backend

```java
// Import generated interfaces
import com.finapp.api.controller.TransactionsApi;
import com.finapp.api.model.*;

@RestController
public class TransactionController implements TransactionsApi {

    @Override
    public ResponseEntity<PagedTransactionsResponse> getTransactions(
            Integer page,
            Integer size,
            String sort,
            String categoryId,
            TransactionType type) {

        Pageable pageable = PageRequest.of(
            page != null ? page : 0,
            size != null ? size : 20,
            Sort.by(Sort.Direction.DESC, "date")
        );

        Page<Transaction> transactions = transactionService.findAll(pageable);

        PagedTransactionsResponse response = new PagedTransactionsResponse()
            .content(transactions.getContent().stream()
                .map(this::toDto)
                .collect(Collectors.toList()))
            .totalElements(transactions.getTotalElements())
            .totalPages(transactions.getTotalPages())
            .size(transactions.getSize())
            .number(transactions.getNumber())
            .first(transactions.isFirst())
            .last(transactions.isLast());

        return ResponseEntity.ok(response);
    }

    @Override
    public ResponseEntity<TransactionDto> createTransaction(
            CreateTransactionRequest request) {

        // Validate amount format
        if (!request.getAmount().matches("^\\d+\\.\\d{2}$")) {
            throw new ValidationException("Invalid amount format");
        }

        Transaction transaction = transactionService.create(request);

        return ResponseEntity
            .created(URI.create("/api/v1/transactions/" + transaction.getId()))
            .body(toDto(transaction));
    }
}

// Exception handling with ProblemDetails
@ControllerAdvice
public class ApiExceptionHandler {

    @ExceptionHandler(ValidationException.class)
    public ResponseEntity<ProblemDetails> handleValidation(ValidationException ex) {
        ProblemDetails problem = new ProblemDetails()
            .type(URI.create("https://api.finapp.com/problems/validation-error"))
            .title("Validation Error")
            .status(400)
            .detail(ex.getMessage())
            .instance(URI.create(getCurrentRequestPath()));

        return ResponseEntity.badRequest()
            .contentType(MediaType.APPLICATION_PROBLEM_JSON)
            .body(problem);
    }
}
```

---

## 🎯 Roadmap

### 🟡 Medium Priority (Next Sprint)

- [ ] **Enhanced Filtering**
  - Date range filters (`dateFrom`, `dateTo`)
  - Amount range filters (`amountMin`, `amountMax`)
  - Text search in transaction names

- [ ] **API Versioning Strategy**
  - URL versioning (`/api/v2/`)
  - Deprecation headers (`Deprecation`, `Sunset`)
  - Migration documentation

- [ ] **Advanced Pagination**
  - Cursor-based pagination for large datasets
  - Configurable sort fields validation
  - Performance optimizations

### 🟢 Low Priority (Future)

- [ ] **ETag Support**
  - Optimistic locking with `If-Match` headers
  - Cache validation with `If-None-Match`
  - Conditional updates

- [ ] **Rate Limiting**
  - Rate limit headers (`X-RateLimit-*`)
  - `Retry-After` header support
  - Per-user rate limiting

- [ ] **File Upload Support**
  - Receipt image uploads
  - `multipart/form-data` endpoints
  - File size and type validation

- [ ] **Webhook Support**
  - Event subscription endpoints
  - Webhook validation
  - Retry mechanisms

- [ ] **GraphQL Integration**
  - GraphQL schema generation
  - REST/GraphQL hybrid approach
  - Unified documentation

### 📋 Technical Debt

- [ ] Add missing `description` fields to operations (warnings)
- [ ] Add 4XX response to GET `/categories`
- [ ] Update Redocly CLI to latest version
- [ ] Implement OpenAPI 3.1 features
- [ ] Add comprehensive integration tests

---

## 🛠️ Troubleshooting

### Common Issues

**❌ OpenAPI Generator Fails**
```bash
# Check Java version
java -version  # Must be 17+

# Clear cache and regenerate
npm run clean
npm run generate:all
```

**❌ TypeScript Build Errors**
```bash
# Update generated models
npm run copy:frontend
cd packages/frontend-api && npm run build
```

**❌ Mock Server Not Starting**
```bash
# Check port availability
lsof -i :4010

# Try different port
npx prism mock openapi.yaml --port 4011
```

**❌ Validation Errors**
```bash
# Check specific rules
npx redocly lint openapi.yaml --format=stylish

# Disable specific rules temporarily
# Edit .redocly.yaml
```

### Getting Help

- **API Documentation**: View generated Swagger UI at mock server
- **Issues**: Report bugs in GitHub Issues
- **Code Examples**: Check `/examples` directory
- **Best Practices**: Follow this README requirements

---

## 📄 License

MIT License - see [LICENSE](LICENSE) file for details.

---

**📞 Support**: For questions about API design or implementation, create an issue or contact the development team.

**🎯 Remember**: This API follows strict enterprise standards. All changes must comply with the documented best practices and pass validation before merging.