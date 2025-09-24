# FinApp API Frontend Library

Эта библиотека содержит автоматически сгенерированный TypeScript клиент для FinApp API на основе OpenAPI спецификации.

## 🚀 Установка

### npm

```bash
npm install @sergey-videtskikh/finapp-api-client
```

### yarn

```bash
yarn add @sergey-videtskikh/finapp-api-client
```

### pnpm

```bash
pnpm add @sergey-videtskikh/finapp-api-client
```

## 🔐 Аутентификация GitHub Packages

### .npmrc (в корне проекта)

```ini
@sergey-videtskikh:registry=https://npm.pkg.github.com
//npm.pkg.github.com/:_authToken=ВАШ_GITHUB_PAT_TOKEN
```

### Personal Access Token (PAT)

1. Перейдите в GitHub Settings → Developer settings → Personal access tokens
2. Создайте новый токен с правами `read:packages`
3. Добавьте токен в `.npmrc` или переменную окружения

### Environment Variable

```bash
export NPM_TOKEN=ВАШ_GITHUB_PAT_TOKEN
echo "//npm.pkg.github.com/:_authToken=${NPM_TOKEN}" >> ~/.npmrc
```

## 🛠 Использование

### Базовая настройка

```typescript
import {
  AuthenticationApi,
  TransactionsApi,
  CategoriesApi,
  Configuration,
  ConfigurationParameters,
} from '@sergey-videtskikh/finapp-api-client';

// Конфигурация API
const config: ConfigurationParameters = {
  basePath: 'https://api.finapp.com/api/v1',
  // или для локальной разработки:
  // basePath: 'http://localhost:8080/api/v1',

  accessToken: 'ваш-jwt-token', // Bearer token

  // Дополнительные headers
  headers: {
    'Accept': 'application/json',
    'Content-Type': 'application/json',
  },
};

const configuration = new Configuration(config);

// Инициализация API клиентов
const authApi = new AuthenticationApi(configuration);
const transactionsApi = new TransactionsApi(configuration);
const categoriesApi = new CategoriesApi(configuration);
```

### React Hook для API

```typescript
// hooks/useApi.ts
import { useMemo } from 'react';
import { useAuth } from './useAuth'; // Ваш хук аутентификации
import {
  AuthenticationApi,
  TransactionsApi,
  CategoriesApi,
  Configuration,
} from '@sergey-videtskikh/finapp-api-client';

export const useApi = () => {
  const { token } = useAuth();

  const configuration = useMemo(() => {
    return new Configuration({
      basePath: process.env.NEXT_PUBLIC_API_BASE_URL || 'http://localhost:8080/api/v1',
      accessToken: token,
      headers: {
        'Accept': 'application/json',
        'Content-Type': 'application/json',
      },
    });
  }, [token]);

  const apis = useMemo(() => ({
    auth: new AuthenticationApi(configuration),
    transactions: new TransactionsApi(configuration),
    categories: new CategoriesApi(configuration),
  }), [configuration]);

  return apis;
};
```

### Аутентификация

```typescript
import { LoginRequest, RegisterRequest } from '@sergey-videtskikh/finapp-api-client';

// Вход пользователя
const login = async (email: string, password: string) => {
  try {
    const loginRequest: LoginRequest = {
      login: email,
      password: password,
    };

    const response = await authApi.authenticateUser({ loginRequest });

    // Сохранить JWT токен
    localStorage.setItem('token', response.token);

    return response;
  } catch (error) {
    console.error('Login failed:', error);
    throw error;
  }
};

// Регистрация пользователя
const register = async (userData: {
  email: string;
  password: string;
  firstName: string;
  lastName: string;
}) => {
  try {
    const registerRequest: RegisterRequest = {
      login: userData.email,
      password: userData.password,
      firstName: userData.firstName,
      lastName: userData.lastName,
    };

    await authApi.registerUser({ registerRequest });
  } catch (error) {
    console.error('Registration failed:', error);
    throw error;
  }
};
```

### Работа с транзакциями

```typescript
import {
  CreateTransactionRequest,
  UpdateTransactionRequest,
  PatchTransactionRequest,
  TransactionType,
  InputType,
} from '@sergey-videtskikh/finapp-api-client';

// Получить список транзакций
const getTransactions = async (page = 0, size = 20) => {
  try {
    const response = await transactionsApi.getTransactions({
      page,
      size,
      sort: 'date,desc',
    });

    return response;
  } catch (error) {
    console.error('Failed to fetch transactions:', error);
    throw error;
  }
};

// Создать новую транзакцию
const createTransaction = async (transactionData: {
  amount: string;
  currency: string;
  categoryId: string;
  name: string;
  type: TransactionType;
  accountId: string;
}) => {
  try {
    const request: CreateTransactionRequest = {
      amount: transactionData.amount,
      currency: transactionData.currency,
      date: new Date().toISOString().split('T')[0], // YYYY-MM-DD
      categoryId: transactionData.categoryId,
      name: transactionData.name,
      type: transactionData.type,
      inputType: InputType.Manual,
      accountId: transactionData.accountId,
      excluded: false,
    };

    const response = await transactionsApi.createTransaction({
      createTransactionRequest: request,
    });

    return response;
  } catch (error) {
    console.error('Failed to create transaction:', error);
    throw error;
  }
};

// Получить транзакцию по ID с ETag
const getTransaction = async (id: string) => {
  try {
    const response = await transactionsApi.getTransactionById({ id });

    // ETag доступен в headers ответа
    const etag = response.headers?.get('ETag');

    return { data: response, etag };
  } catch (error) {
    console.error('Failed to fetch transaction:', error);
    throw error;
  }
};

// Частичное обновление с оптимистичной блокировкой
const patchTransaction = async (
  id: string,
  etag: string,
  updates: Partial<PatchTransactionRequest>
) => {
  try {
    const response = await transactionsApi.patchTransaction({
      id,
      ifMatch: etag,
      patchTransactionRequest: updates,
    });

    return response;
  } catch (error) {
    if (error.status === 412) {
      throw new Error('Transaction was modified by another user. Please refresh and try again.');
    }
    console.error('Failed to update transaction:', error);
    throw error;
  }
};

// Удалить транзакцию
const deleteTransaction = async (id: string) => {
  try {
    await transactionsApi.deleteTransaction({ id });
  } catch (error) {
    console.error('Failed to delete transaction:', error);
    throw error;
  }
};
```

### React компоненты

```typescript
// components/TransactionsList.tsx
import React, { useEffect, useState } from 'react';
import { useApi } from '../hooks/useApi';
import { TransactionDto, PagedTransactionsResponse } from '@sergey-videtskikh/finapp-api-client';

export const TransactionsList: React.FC = () => {
  const { transactions: transactionsApi } = useApi();
  const [transactions, setTransactions] = useState<PagedTransactionsResponse | null>(null);
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState<string | null>(null);

  useEffect(() => {
    const fetchTransactions = async () => {
      try {
        setLoading(true);
        const response = await transactionsApi.getTransactions({
          page: 0,
          size: 20,
          sort: 'date,desc',
        });
        setTransactions(response);
      } catch (err) {
        setError(err instanceof Error ? err.message : 'Unknown error');
      } finally {
        setLoading(false);
      }
    };

    fetchTransactions();
  }, [transactionsApi]);

  if (loading) return <div>Loading...</div>;
  if (error) return <div>Error: {error}</div>;
  if (!transactions?.content) return <div>No transactions found</div>;

  return (
    <div>
      <h2>Transactions</h2>
      {transactions.content.map((transaction: TransactionDto) => (
        <div key={transaction.id} className="transaction-item">
          <h3>{transaction.name}</h3>
          <p>Amount: {transaction.amount} {transaction.currency}</p>
          <p>Date: {transaction.date}</p>
          <p>Type: {transaction.type}</p>
        </div>
      ))}

      {/* Пагинация */}
      <div className="pagination">
        <span>
          Page {(transactions.number ?? 0) + 1} of {transactions.totalPages}
        </span>
      </div>
    </div>
  );
};
```

### Error Handling

```typescript
import { ProblemDetails } from '@sergey-videtskikh/finapp-api-client';

// Универсальный обработчик ошибок API
export const handleApiError = (error: any): string => {
  if (error.status === 401) {
    // Redirect to login
    window.location.href = '/login';
    return 'Authentication required';
  }

  if (error.status === 403) {
    return 'Access denied';
  }

  if (error.status === 404) {
    return 'Resource not found';
  }

  if (error.status === 412) {
    return 'Resource was modified by another user. Please refresh and try again.';
  }

  // Парсинг RFC7807 ProblemDetails
  if (error.body && typeof error.body === 'object') {
    const problemDetails = error.body as ProblemDetails;

    if (problemDetails.detail) {
      return problemDetails.detail;
    }

    if (problemDetails.title) {
      return problemDetails.title;
    }

    // Обработка ошибок валидации
    if (problemDetails.errors && problemDetails.errors.length > 0) {
      return problemDetails.errors
        .map(err => `${err.field}: ${err.message}`)
        .join(', ');
    }
  }

  return 'An unexpected error occurred';
};

// React Hook для обработки ошибок
export const useApiError = () => {
  const [error, setError] = useState<string | null>(null);

  const handleError = useCallback((err: any) => {
    const message = handleApiError(err);
    setError(message);
  }, []);

  const clearError = useCallback(() => {
    setError(null);
  }, []);

  return { error, handleError, clearError };
};
```

### TypeScript типы

```typescript
import {
  TransactionType,
  InputType,
  CategoryType,
  TransactionDto,
  CreateTransactionRequest,
  ProblemDetails,
} from '@sergey-videtskikh/finapp-api-client';

// Все типы автоматически сгенерированы и типобезопасны

// Enum значения:
// TransactionType: 'INCOME' | 'EXPENSE' | 'TRANSFER'
// InputType: 'MANUAL' | 'IMPORT' | 'RECEIPT_SCAN'
// CategoryType: 'INCOME' | 'EXPENSE'

// Проверка типов
const transaction: TransactionDto = {
  id: 'uuid',
  amount: '100.50',
  currency: 'RUB', // ISO-4217
  date: '2025-09-24',
  categoryId: 'category-uuid',
  name: 'Transaction name',
  type: TransactionType.Expense,
  inputType: InputType.Manual,
  accountId: 'account-uuid',
  excluded: false,
};
```

## 📋 Доступные API методы

### AuthenticationApi
- `authenticateUser()` - Вход пользователя
- `registerUser()` - Регистрация пользователя
- `authenticateWithTelegram()` - Telegram аутентификация
- `changeUserPassword()` - Смена пароля

### TransactionsApi
- `getTransactions()` - Список транзакций (с пагинацией и фильтрацией)
- `createTransaction()` - Создание новой транзакции
- `getTransactionById()` - Получение транзакции по ID (с ETag)
- `updateTransaction()` - Полное обновление транзакции
- `patchTransaction()` - Частичное обновление (с оптимистичной блокировкой)
- `deleteTransaction()` - Удаление транзакции

### CategoriesApi
- `getCategories()` - Список категорий
- `createCategory()` - Создание новой категории

## 🏗 Архитектура

- **Fetch-based** - Использует современный Fetch API
- **TypeScript-first** - Полная типобезопасность
- **Tree-shakable** - Только используемые части попадают в bundle
- **RFC7807 compatible** - Стандартные ошибки через ProblemDetails
- **ETag support** - Оптимистичная блокировка
- **ISO-4217 currencies** - Стандартные коды валют

## 🔧 Environment Variables

```bash
# .env.local (Next.js)
NEXT_PUBLIC_API_BASE_URL=https://api.finapp.com/api/v1

# .env (React/Vite)
REACT_APP_API_BASE_URL=https://api.finapp.com/api/v1
VITE_API_BASE_URL=https://api.finapp.com/api/v1
```

## 📝 Примечания

- Библиотека поддерживает CommonJS и ES Modules
- Включает TypeScript definitions (.d.ts файлы)
- Автоматическая валидация данных на уровне типов
- Совместима с React, Vue, Angular и vanilla JavaScript

## 🔄 Обновления

Библиотека автоматически генерируется при каждом обновлении OpenAPI спецификации.

Следите за релизами: https://github.com/sergey-videtskikh/aifinadvisor-api/releases

## 📦 Размер bundle

- Minified: ~45KB
- Gzipped: ~12KB
- Tree-shaking friendly

## Совместимость

### Environment
* Node.js
* Webpack
* Browserify

### Language level
* ES5 - you must have a Promises/A+ library installed
* ES6

### Module system
* CommonJS
* ES6 module system

It can be used in both TypeScript and JavaScript. In TypeScript, the definition should be automatically resolved via `package.json`.