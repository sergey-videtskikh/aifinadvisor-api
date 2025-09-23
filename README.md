# FinApp API Libraries

Этот репозиторий автоматически генерирует и публикует версионированные библиотеки API для бэкенда и фронтенда FinApp.

## 📦 Публикуемые пакеты

### Backend (Maven)
```xml
<dependency>
    <groupId>com.finapp</groupId>
    <artifactId>finapp-api-client</artifactId>
    <version>1.0.0</version>
</dependency>
```

### Frontend (NPM)
```bash
npm install @finapp/api-client@1.0.0
```

## 🚀 Быстрый старт

### Локальная разработка
```bash
npm install                    # Установка зависимостей
npm run validate              # Проверка OpenAPI спецификации
npm run build:packages        # Сборка всех пакетов
npm run publish:all           # Публикация (требует настройки)
```

### Версионирование
```bash
npm run version:patch         # 1.0.0 → 1.0.1
npm run version:minor         # 1.0.0 → 1.1.0
npm run version:major         # 1.0.0 → 2.0.0
```

## 📁 Структура проекта

```
├── openapi.yaml              # Главная OpenAPI спецификация
├── api-docs/                 # Модульные YAML файлы
│   ├── paths/               # Эндпоинты по модулям
│   └── schemas/             # Схемы данных
├── packages/                # Готовые пакеты для публикации
│   ├── backend-api/         # Maven пакет (Java/Spring Boot)
│   └── frontend-api/        # NPM пакет (TypeScript)
├── generated/               # Промежуточный сгенерированный код
├── scripts/                 # Утилиты для версионирования
└── .github/workflows/       # CI/CD для автопубликации
```

## 🔄 Автоматическая публикация

При коммите в `main` с изменениями в `api-docs/` или `openapi.yaml`:

1. **GitHub Actions** автоматически:
   - Валидирует OpenAPI спецификацию
   - Генерирует код для обеих платформ
   - Увеличивает patch версию
   - Публикует пакеты в GitHub Packages
   - Создает релиз с инструкциями по использованию

2. **Проекты** могут обновлять зависимости на новые версии

## 💻 Использование в проектах

### Backend (Spring Boot)
```java
// Добавьте в pom.xml зависимость
// Импортируйте сгенерированные интерфейсы
import com.finapp.api.controller.TransactionsApi;
import com.finapp.api.model.Transaction;
import com.finapp.api.model.CreateTransactionRequest;

@RestController
public class TransactionsController implements TransactionsApi {
    @Override
    public ResponseEntity<Transaction> createTransaction(CreateTransactionRequest request) {
        // Ваша бизнес-логика
        return ResponseEntity.ok(transaction);
    }
}
```

### Frontend (React/Vue/Angular)
```typescript
// Установите пакет: npm install @finapp/api-client
import { DefaultApi, Configuration } from '@finapp/api-client';

const apiClient = new DefaultApi(new Configuration({
  basePath: 'https://api.finapp.com/api/v1',
  accessToken: 'your-jwt-token'
}));

// Type-safe вызовы API
const transaction = await apiClient.createTransaction({
  amount: 100,
  categoryId: 1,
  description: 'Coffee'
});
```

## 🛠 Конфигурация

### OpenAPI Generator (openapitools.json)
- **Backend**: Spring Boot 3, Java 17, только интерфейсы
- **Frontend**: TypeScript, ES2020, Fetch API

### Публикация
- **Maven**: GitHub Packages (com.finapp:finapp-api-client)
- **NPM**: GitHub Packages (@finapp/api-client)

## 📝 Разработка

### Добавление нового API
1. Обновите файлы в `api-docs/`
2. Добавьте ссылки в `openapi.yaml`
3. Протестируйте локально: `npm run validate`
4. Коммитьте - автопубликация сработает автоматически

### Локальная генерация
```bash
npm run generate:all          # Генерация кода
npm run copy:packages         # Копирование в пакеты
npm run build:packages        # Сборка пакетов
```

### Ручная публикация
```bash
npm run version:patch         # Увеличить версию
npm run publish:all           # Опубликовать пакеты
```