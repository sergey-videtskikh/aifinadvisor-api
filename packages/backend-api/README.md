# FinApp API Backend Library

Эта библиотека содержит автоматически сгенерированные Java интерфейсы для Spring Boot API на основе OpenAPI спецификации FinApp.

## 🚀 Установка

### Maven

Добавьте в ваш `pom.xml`:

```xml
<dependencies>
    <dependency>
        <groupId>com.finapp</groupId>
        <artifactId>finapp-api-client</artifactId>
        <version>1.2.0</version>
    </dependency>
</dependencies>

<!-- GitHub Packages репозиторий -->
<repositories>
    <repository>
        <id>github-sergey-videtskikh</id>
        <url>https://maven.pkg.github.com/sergey-videtskikh/aifinadvisor-api</url>
    </repository>
</repositories>
```

### Gradle

Добавьте в ваш `build.gradle`:

```gradle
repositories {
    maven {
        name = "GitHubPackages"
        url = "https://maven.pkg.github.com/sergey-videtskikh/aifinadvisor-api"
        credentials {
            username = project.findProperty("gpr.user") ?: System.getenv("USERNAME")
            password = project.findProperty("gpr.key") ?: System.getenv("TOKEN")
        }
    }
}

dependencies {
    implementation 'com.finapp:finapp-api-client:1.2.0'
}
```

## 🔐 Аутентификация GitHub Packages

### Maven (~/.m2/settings.xml)

```xml
<settings xmlns="http://maven.apache.org/SETTINGS/1.0.0">
    <servers>
        <server>
            <id>github-sergey-videtskikh</id>
            <username>ВАШ_GITHUB_USERNAME</username>
            <password>ВАШ_GITHUB_PAT_TOKEN</password>
        </server>
    </servers>
</settings>
```

### Gradle (gradle.properties)

```properties
gpr.user=ВАШ_GITHUB_USERNAME
gpr.key=ВАШ_GITHUB_PAT_TOKEN
```

### Personal Access Token (PAT)

1. Перейдите в GitHub Settings → Developer settings → Personal access tokens
2. Создайте новый токен с правами `read:packages`
3. Используйте его как `password`/`gpr.key`

## 🛠 Использование

### Spring Boot Configuration

```java
@Configuration
@EnableWebMvc
public class ApiConfig implements WebMvcConfigurer {

    @Bean
    public AuthenticationApi authenticationApi() {
        return new AuthenticationApiController();
    }

    @Bean
    public TransactionsApi transactionsApi() {
        return new TransactionsApiController();
    }

    @Bean
    public CategoriesApi categoriesApi() {
        return new CategoriesApiController();
    }
}
```

### Controller Implementation

```java
@RestController
public class AuthenticationApiController implements AuthenticationApi {

    @Override
    public ResponseEntity<JwtResponse> authenticateUser(LoginRequest loginRequest) {
        // Ваша бизнес-логика аутентификации
        JwtResponse response = authService.authenticate(loginRequest);
        return ResponseEntity.ok(response);
    }

    @Override
    public ResponseEntity<Void> registerUser(RegisterRequest registerRequest) {
        // Ваша бизнес-логика регистрации
        userService.register(registerRequest);
        return ResponseEntity.status(201).build();
    }
}
```

### Transaction Controller

```java
@RestController
public class TransactionsApiController implements TransactionsApi {

    @Autowired
    private TransactionService transactionService;

    @Override
    public ResponseEntity<PagedTransactionsResponse> getTransactions(
            Integer page, Integer size, String sort,
            String categoryId, TransactionType type) {

        PagedTransactionsResponse response = transactionService
            .getTransactions(page, size, sort, categoryId, type);
        return ResponseEntity.ok(response);
    }

    @Override
    public ResponseEntity<TransactionDto> createTransaction(
            CreateTransactionRequest request) {

        TransactionDto transaction = transactionService.create(request);
        return ResponseEntity.status(201)
            .header("Location", "/api/v1/transactions/" + transaction.getId())
            .body(transaction);
    }

    @Override
    public ResponseEntity<TransactionDto> getTransactionById(String id) {
        TransactionDto transaction = transactionService.findById(id);
        String etag = transactionService.generateETag(transaction);

        return ResponseEntity.ok()
            .header("ETag", etag)
            .body(transaction);
    }

    @Override
    public ResponseEntity<TransactionDto> patchTransaction(
            String id, String ifMatch, PatchTransactionRequest request) {

        // Проверка оптимистичной блокировки
        if (!transactionService.validateETag(id, ifMatch)) {
            return ResponseEntity.status(412).build(); // Precondition Failed
        }

        TransactionDto updated = transactionService.patch(id, request);
        String newEtag = transactionService.generateETag(updated);

        return ResponseEntity.ok()
            .header("ETag", newEtag)
            .body(updated);
    }

    @Override
    public ResponseEntity<Void> deleteTransaction(String id) {
        transactionService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
```

### Error Handling

```java
@ControllerAdvice
public class ApiExceptionHandler {

    @ExceptionHandler(ValidationException.class)
    public ResponseEntity<ProblemDetails> handleValidation(ValidationException ex) {
        ProblemDetails problem = new ProblemDetails()
            .type("https://api.finapp.com/problems/validation-error")
            .title("Validation Error")
            .status(400)
            .detail(ex.getMessage())
            .instance("/api/v1/transactions");

        return ResponseEntity.badRequest()
            .contentType(MediaType.APPLICATION_PROBLEM_JSON)
            .body(problem);
    }

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<ProblemDetails> handleNotFound(EntityNotFoundException ex) {
        ProblemDetails problem = new ProblemDetails()
            .type("https://api.finapp.com/problems/not-found")
            .title("Resource Not Found")
            .status(404)
            .detail(ex.getMessage());

        return ResponseEntity.status(404)
            .contentType(MediaType.APPLICATION_PROBLEM_JSON)
            .body(problem);
    }
}
```

## 📋 Доступные API

### Authentication API
- `POST /auth/login` - Аутентификация пользователя
- `POST /auth/register` - Регистрация пользователя
- `POST /auth/telegram` - Telegram аутентификация
- `POST /auth/change-password` - Смена пароля

### Transactions API
- `GET /transactions` - Получить список транзакций (с пагинацией)
- `POST /transactions` - Создать новую транзакцию
- `GET /transactions/{id}` - Получить транзакцию по ID (с ETag)
- `PUT /transactions/{id}` - Полное обновление транзакции
- `PATCH /transactions/{id}` - Частичное обновление (с оптимистичной блокировкой)
- `DELETE /transactions/{id}` - Удалить транзакцию

### Categories API
- `GET /categories` - Получить список категорий
- `POST /categories` - Создать новую категорию

## 🏗 Архитектура

- **Interface-only generation** - Генерируются только интерфейсы, реализация остается за вами
- **Spring Boot 3 compatibility** - Поддержка Spring Boot 3.x
- **RFC7807 Error Handling** - Стандартизированные ошибки через ProblemDetails
- **ETag Support** - Оптимистичная блокировка для PATCH операций
- **ISO-4217 Currency** - Стандартные коды валют
- **Enterprise-grade** - Следование лучшим практикам API design

## 📝 Примечания

- Все DTO классы содержат валидационные аннотации
- Поддерживается как синхронная, так и асинхронная обработка
- Автоматическая сериализация/десериализация JSON
- Swagger/OpenAPI документация в runtime

## 🔄 Обновления

Библиотека автоматически генерируется при каждом обновлении OpenAPI спецификации.

Следите за релизами: https://github.com/sergey-videtskikh/aifinadvisor-api/releases