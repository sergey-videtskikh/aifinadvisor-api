# API Documentation Structure

Данная директория содержит модульную структуру OpenAPI документации для FinApp API.

## Структура файлов

```
api-docs/
├── README.md                    # Этот файл с описанием структуры
├── paths/                       # Эндпоинты API, сгруппированные по модулям
│   ├── auth.yaml               # Аутентификация (/api/v1/auth/*)
│   ├── user.yaml               # Пользователи (/api/v1/user/*)
│   ├── dashboard.yaml          # Дашборд (/api/v1/dashboard)
│   ├── transactions.yaml       # Транзакции (/api/v1/transactions/*)
│   ├── categories.yaml         # Категории (/api/v1/categories/*)
│   └── dictionaries.yaml       # Справочники (/api/v1/dictionaries/*)
├── schemas/                     # Схемы данных, сгруппированные по доменам
│   ├── common.yaml             # Общие схемы (ErrorResponse, ValidationErrorResponse)
│   ├── auth.yaml               # Схемы для аутентификации
│   ├── user.yaml               # Схемы пользователей
│   ├── dashboard.yaml          # Схемы дашборда
│   ├── transactions.yaml       # Схемы транзакций
│   ├── categories.yaml         # Схемы категорий
│   └── dictionaries.yaml       # Схемы справочников
└── components/                  # Компоненты (зарезервировано для будущего использования)
```

## Основные принципы

### 1. Модульность
- Каждый логический модуль API имеет свой отдельный файл
- Пути (paths) и схемы (schemas) разделены по доменам
- Общие компоненты вынесены в отдельные файлы

### 2. Переиспользование
- Общие схемы ошибок находятся в `schemas/common.yaml`
- Схемы используются через `$ref` для избежания дублирования
- Все схемы доступны для переиспользования между модулями

### 3. Соглашения по именованию
- Файлы называются в единственном числе (auth.yaml, user.yaml)
- Схемы используют PascalCase (UserResponse, CreateTransactionRequest)
- Пути используют kebab-case в URL и описаниях

## Как добавить новый модуль

### 1. Создание нового эндпоинта
1. Создайте файл в `paths/` (например, `accounts.yaml`)
2. Добавьте эндпоинты в формате OpenAPI 3.0
3. Добавьте ссылки на новые пути в главный `api-docs.yaml`

### 2. Создание новых схем
1. Создайте файл в `schemas/` (например, `accounts.yaml`)
2. Определите все необходимые схемы для модуля
3. Добавьте ссылки на схемы в главный `api-docs.yaml` в раздел `components.schemas`

### 3. Использование $ref
```yaml
# Ссылка на схему в том же файле
$ref: '#/CategoryDto'

# Ссылка на схему в другом файле
$ref: '../schemas/common.yaml#/ErrorResponse'

# Ссылка на путь из главного файла
$ref: './api-docs/paths/auth.yaml#/~1api~1v1~1auth~1login'
```

## Валидация документации

Для проверки корректности структуры можно использовать:

```bash
# Установка swagger-codegen или openapi-generator
npm install -g @apidevtools/swagger-cli

# Валидация главного файла
swagger-cli validate api-docs.yaml

# Или с помощью Docker
docker run --rm -v "${PWD}:/workspace" openapitools/openapi-generator-cli validate -i /workspace/api-docs.yaml
```

## Генерация документации

Swagger UI автоматически подхватывает модульную структуру при запуске приложения:
- Локально: http://localhost:8080/swagger-ui.html
- Продакшн: https://api.finapp.com/swagger-ui.html

## Лучшие практики

1. **Консистентность**: Следуйте одинаковому стилю во всех модулях
2. **Полнота**: Включайте все возможные HTTP статусы и их описания
3. **Примеры**: Добавляйте примеры запросов и ответов где это необходимо
4. **Описания**: Используйте понятные описания на русском языке
5. **Валидация**: Всегда проверяйте изменения перед коммитом