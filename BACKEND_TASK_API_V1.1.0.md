# Задание для Backend: Внедрение API v1.1.0

**Приоритет:** High  
**Версия API:** 1.1.0  
**Дата создания:** 2025-10-21  
**Исполнитель:** Backend Team  

---

## 📋 Обзор изменений

В API v1.1.0 добавлены два новых опциональных поля:

1. **`description`** - для транзакций (подробное описание)
2. **`displayOrder`** - для категорий (пользовательский порядок сортировки)

Оба поля **опциональные** и **обратно совместимые** (MINOR версия).

---

## 🎯 Цели

- [ ] Обновить зависимость API клиента до v1.1.0
- [ ] Добавить поддержку поля `description` в транзакциях
- [ ] Добавить поддержку поля `displayOrder` в категориях
- [ ] Провести миграцию существующих данных
- [ ] Покрыть тестами новую функциональность
- [ ] Обновить документацию

---

## 📦 Часть 1: Обновление зависимостей

### **build.gradle.kts**

```kotlin
dependencies {
    // Обновить версию API клиента
    implementation("com.finapp:finapp-api-client:1.1.0") // было: 1.0.5
}
```

### **Проверка:**

```bash
./gradlew dependencies | grep finapp-api-client
# Должно показать: com.finapp:finapp-api-client:1.1.0
```

---

## 🔧 Часть 2: Поле `description` для транзакций

### **2.1. Entity (`Transaction.kt`)**

**Путь:** `finapp-core/src/main/kotlin/com/finapp/domain/Transaction.kt`

**Изменения:**

```kotlin
@Document(collection = "transactions")
data class Transaction(
    @Id
    val id: String = UUID.randomUUID().toString(),
    
    val amount: String, // Decimal string
    val currency: String = "RUB",
    val date: LocalDate,
    val categoryId: String,
    val name: String,
    
    // 🆕 НОВОЕ ПОЛЕ
    val description: String? = null,
    
    val type: TransactionType,
    val inputType: InputType = InputType.MANUAL,
    val accountId: String,
    val excluded: Boolean = false,
    
    val tenantId: String,
    val createdAt: Instant = Instant.now(),
    val updatedAt: Instant = Instant.now()
)
```

**Важно:**
- Тип: `String?` (nullable)
- Значение по умолчанию: `null`
- Не требует индекса (не используется для поиска)

---

### **2.2. Mapper (`TransactionMapper.kt`)**

**Путь:** `finapp-application/src/main/kotlin/com/finapp/mapper/TransactionMapper.kt`

**Изменения:**

```kotlin
fun Transaction.toDto(): TransactionDto = TransactionDto(
    id = this.id,
    amount = this.amount,
    currency = this.currency,
    date = this.date,
    categoryId = this.categoryId,
    name = this.name,
    description = this.description, // 🆕 Маппинг нового поля
    type = this.type,
    inputType = this.inputType,
    accountId = this.accountId,
    excluded = this.excluded
)

fun CreateTransactionRequest.toEntity(tenantId: String): Transaction = Transaction(
    amount = this.amount,
    currency = this.currency ?: "RUB",
    date = this.date ?: LocalDate.now(),
    categoryId = this.categoryId,
    name = this.name,
    description = this.description, // 🆕 Маппинг из request
    type = this.type,
    inputType = this.inputType ?: InputType.MANUAL,
    accountId = this.accountId,
    excluded = this.excluded ?: false,
    tenantId = tenantId
)

fun UpdateTransactionRequest.applyTo(existing: Transaction): Transaction = existing.copy(
    amount = this.amount,
    currency = this.currency ?: existing.currency,
    date = this.date ?: existing.date,
    categoryId = this.categoryId,
    name = this.name,
    description = this.description, // 🆕 Обновление описания
    type = this.type,
    accountId = this.accountId,
    excluded = this.excluded ?: existing.excluded,
    updatedAt = Instant.now()
)

fun PatchTransactionRequest.applyTo(existing: Transaction): Transaction = existing.copy(
    amount = this.amount ?: existing.amount,
    currency = this.currency ?: existing.currency,
    date = this.date ?: existing.date,
    categoryId = this.categoryId ?: existing.categoryId,
    name = this.name ?: existing.name,
    description = this.description ?: existing.description, // 🆕 Частичное обновление
    type = this.type ?: existing.type,
    accountId = this.accountId ?: existing.accountId,
    excluded = this.excluded ?: existing.excluded,
    updatedAt = Instant.now()
)
```

---

### **2.3. Тесты для `description`**

**Путь:** `finapp-application/src/test/kotlin/com/finapp/service/TransactionServiceTest.kt`

**Добавить тесты:**

```kotlin
@Test
fun `createTransaction with description should save description`() {
    // Given
    val request = CreateTransactionRequest(
        amount = "100.50",
        currency = "RUB",
        date = LocalDate.now(),
        categoryId = categoryId,
        name = "Обед",
        description = "Обед с коллегами в кафе на Тверской", // 🆕
        type = TransactionType.EXPENSE,
        accountId = accountId
    )
    
    // When
    val result = transactionService.create(request)
    
    // Then
    assertThat(result.description).isEqualTo("Обед с коллегами в кафе на Тверской")
}

@Test
fun `createTransaction without description should have null description`() {
    // Given
    val request = CreateTransactionRequest(
        amount = "100.50",
        categoryId = categoryId,
        name = "Обед",
        type = TransactionType.EXPENSE,
        accountId = accountId
        // description не передано
    )
    
    // When
    val result = transactionService.create(request)
    
    // Then
    assertThat(result.description).isNull()
}

@Test
fun `patchTransaction should update only description`() {
    // Given
    val existing = createTransaction(description = "Старое описание")
    val patchRequest = PatchTransactionRequest(
        description = "Новое описание"
    )
    
    // When
    val result = transactionService.patch(existing.id, patchRequest)
    
    // Then
    assertThat(result.description).isEqualTo("Новое описание")
    assertThat(result.name).isEqualTo(existing.name) // Не изменилось
    assertThat(result.amount).isEqualTo(existing.amount) // Не изменилось
}
```

---

## 🔧 Часть 3: Поле `displayOrder` для категорий

### **3.1. Entity (`Category.kt`)**

**Путь:** `finapp-core/src/main/kotlin/com/finapp/domain/Category.kt`

**Изменения:**

```kotlin
@Document(collection = "categories")
data class Category(
    @Id
    val id: String = UUID.randomUUID().toString(),
    
    val name: String,
    val type: CategoryType,
    val parentId: String? = null,
    val icon: String? = null,
    val iconColor: String? = null,
    
    // 🆕 НОВОЕ ПОЛЕ
    @Indexed
    val displayOrder: Int = 0,
    
    val tenantId: String,
    val createdAt: Instant = Instant.now(),
    val updatedAt: Instant = Instant.now()
)
```

**Важно:**
- Тип: `Int` (non-nullable)
- Значение по умолчанию: `0`
- Добавить индекс `@Indexed` для эффективной сортировки
- Для иерархических категорий: `displayOrder` работает независимо на каждом уровне

---

### **3.2. Repository (`CategoryRepository.kt`)**

**Путь:** `finapp-core/src/main/kotlin/com/finapp/repository/CategoryRepository.kt`

**Добавить методы сортировки:**

```kotlin
interface CategoryRepository : MongoRepository<Category, String> {
    
    // Существующие методы
    fun findAllByTenantId(tenantId: String): List<Category>
    fun findByIdAndTenantId(id: String, tenantId: String): Category?
    
    // 🆕 НОВЫЙ МЕТОД: Сортировка по displayOrder
    fun findAllByTenantIdOrderByDisplayOrderAscNameAsc(
        tenantId: String
    ): List<Category>
    
    // 🆕 НОВЫЙ МЕТОД: Получить категории по родителю с сортировкой
    fun findAllByTenantIdAndParentIdOrderByDisplayOrderAscNameAsc(
        tenantId: String,
        parentId: String?
    ): List<Category>
    
    // 🆕 НОВЫЙ МЕТОД: Получить максимальный displayOrder для следующей вставки
    fun findTopByTenantIdAndParentIdOrderByDisplayOrderDesc(
        tenantId: String,
        parentId: String?
    ): Category?
}
```

---

### **3.3. Service (`CategoryService.kt`)**

**Путь:** `finapp-application/src/main/kotlin/com/finapp/service/CategoryService.kt`

**Изменения:**

```kotlin
@Service
class CategoryService(
    private val categoryRepository: CategoryRepository,
    private val tenantContext: TenantContext
) {
    
    // 🆕 ОБНОВИТЬ: Сортировка по displayOrder
    fun findAll(): List<CategoryDto> {
        val tenantId = tenantContext.getCurrentTenantId()
        return categoryRepository
            .findAllByTenantIdOrderByDisplayOrderAscNameAsc(tenantId)
            .map { it.toDto() }
    }
    
    // 🆕 ОБНОВИТЬ: Автоматический displayOrder при создании
    fun create(request: CreateCategoryRequest): CategoryDto {
        val tenantId = tenantContext.getCurrentTenantId()
        
        // Если displayOrder не указан, вычислить следующий
        val displayOrder = request.displayOrder 
            ?: getNextDisplayOrder(tenantId, request.parentId)
        
        val category = Category(
            name = request.name,
            type = request.type,
            parentId = request.parentId,
            icon = request.icon,
            iconColor = request.iconColor,
            displayOrder = displayOrder, // 🆕
            tenantId = tenantId
        )
        
        return categoryRepository.save(category).toDto()
    }
    
    // 🆕 НОВЫЙ МЕТОД: Вычислить следующий displayOrder
    private fun getNextDisplayOrder(tenantId: String, parentId: String?): Int {
        val lastCategory = categoryRepository
            .findTopByTenantIdAndParentIdOrderByDisplayOrderDesc(tenantId, parentId)
        
        return (lastCategory?.displayOrder ?: 0) + 1
    }
    
    // 🆕 ОБНОВИТЬ: Обновление displayOrder
    fun update(id: String, request: UpdateCategoryRequest): CategoryDto {
        val existing = findByIdOrThrow(id)
        
        val updated = existing.copy(
            name = request.name,
            type = request.type,
            icon = request.icon,
            color = request.color,
            parentId = request.parentId,
            displayOrder = request.displayOrder ?: existing.displayOrder, // 🆕
            updatedAt = Instant.now()
        )
        
        return categoryRepository.save(updated).toDto()
    }
    
    // 🆕 НОВЫЙ МЕТОД: Массовое изменение порядка (опционально)
    @Transactional
    fun reorder(categoryIds: List<String>): List<CategoryDto> {
        val tenantId = tenantContext.getCurrentTenantId()
        val categories = categoryRepository.findAllById(categoryIds)
            .filter { it.tenantId == tenantId }
        
        val reordered = categoryIds.mapIndexed { index, categoryId ->
            categories.find { it.id == categoryId }?.copy(
                displayOrder = index + 1,
                updatedAt = Instant.now()
            )
        }.filterNotNull()
        
        return categoryRepository.saveAll(reordered).map { it.toDto() }
    }
}
```

---

### **3.4. API Adapter (опционально для reorder)**

**Путь:** `finapp-application/src/main/kotlin/com/finapp/adapter/CategoriesApiAdapter.kt`

**Добавить endpoint для массового изменения порядка:**

```kotlin
@RestController
class CategoriesApiAdapter(
    private val categoryService: CategoryService
) : CategoriesApi {
    
    // Существующие методы...
    
    // 🆕 НОВЫЙ ENDPOINT (если нужен bulk reorder)
    @PostMapping("/categories/reorder")
    fun reorderCategories(
        @RequestBody categoryIds: List<String>
    ): ResponseEntity<List<CategoryDto>> {
        val result = categoryService.reorder(categoryIds)
        return ResponseEntity.ok(result)
    }
}
```

---

### **3.5. Mapper (`CategoryMapper.kt`)**

**Путь:** `finapp-application/src/main/kotlin/com/finapp/mapper/CategoryMapper.kt`

**Обновить маппинг:**

```kotlin
fun Category.toDto(): CategoryDto = CategoryDto(
    id = this.id,
    name = this.name,
    type = this.type,
    parentId = this.parentId,
    icon = this.icon,
    iconColor = this.iconColor,
    displayOrder = this.displayOrder, // 🆕
    children = emptyList() // Заполняется отдельно если нужна иерархия
)
```

---

### **3.6. Тесты для `displayOrder`**

**Путь:** `finapp-application/src/test/kotlin/com/finapp/service/CategoryServiceTest.kt`

**Добавить тесты:**

```kotlin
@Test
fun `createCategory without displayOrder should auto-assign next order`() {
    // Given
    createCategory(name = "Category 1", displayOrder = 1)
    createCategory(name = "Category 2", displayOrder = 2)
    
    val request = CreateCategoryRequest(
        name = "Category 3",
        type = CategoryType.EXPENSE
        // displayOrder не указан
    )
    
    // When
    val result = categoryService.create(request)
    
    // Then
    assertThat(result.displayOrder).isEqualTo(3) // Автоматически 3
}

@Test
fun `createCategory with custom displayOrder should use provided value`() {
    // Given
    val request = CreateCategoryRequest(
        name = "Important Category",
        type = CategoryType.EXPENSE,
        displayOrder = 1 // Явно указываем первым
    )
    
    // When
    val result = categoryService.create(request)
    
    // Then
    assertThat(result.displayOrder).isEqualTo(1)
}

@Test
fun `findAll should return categories sorted by displayOrder`() {
    // Given
    createCategory(name = "C", displayOrder = 3)
    createCategory(name = "A", displayOrder = 1)
    createCategory(name = "B", displayOrder = 2)
    
    // When
    val result = categoryService.findAll()
    
    // Then
    assertThat(result.map { it.name }).containsExactly("A", "B", "C")
}

@Test
fun `reorder should update displayOrder for all categories`() {
    // Given
    val cat1 = createCategory(name = "Category 1", displayOrder = 1)
    val cat2 = createCategory(name = "Category 2", displayOrder = 2)
    val cat3 = createCategory(name = "Category 3", displayOrder = 3)
    
    // When - меняем порядок: 3, 1, 2
    val result = categoryService.reorder(listOf(cat3.id, cat1.id, cat2.id))
    
    // Then
    assertThat(result[0].name).isEqualTo("Category 3")
    assertThat(result[0].displayOrder).isEqualTo(1)
    assertThat(result[1].name).isEqualTo("Category 1")
    assertThat(result[1].displayOrder).isEqualTo(2)
    assertThat(result[2].name).isEqualTo("Category 2")
    assertThat(result[2].displayOrder).isEqualTo(3)
}

@Test
fun `hierarchical categories should have independent displayOrder per level`() {
    // Given - создаем иерархию
    val parent = createCategory(name = "Parent", displayOrder = 1)
    val child1 = createCategory(name = "Child 1", parentId = parent.id, displayOrder = 1)
    val child2 = createCategory(name = "Child 2", parentId = parent.id, displayOrder = 2)
    
    // When
    val children = categoryRepository
        .findAllByTenantIdAndParentIdOrderByDisplayOrderAscNameAsc(
            tenantContext.getCurrentTenantId(),
            parent.id
        )
    
    // Then
    assertThat(children.map { it.name }).containsExactly("Child 1", "Child 2")
}
```

---

## 🗄️ Часть 4: Миграция данных

### **4.1. Миграция для `description` в транзакциях**

**НЕ ТРЕБУЕТСЯ** - поле опциональное, `null` по умолчанию является валидным значением.

---

### **4.2. Миграция для `displayOrder` в категориях**

**Путь:** `finapp-application/src/main/kotlin/com/finapp/migration/AddDisplayOrderMigration.kt`

**Создать миграцию:**

```kotlin
@Component
class AddDisplayOrderMigration(
    private val categoryRepository: CategoryRepository
) {
    
    private val logger = LoggerFactory.getLogger(javaClass)
    
    @PostConstruct
    fun migrate() {
        logger.info("Starting displayOrder migration for existing categories...")
        
        val categories = categoryRepository.findAll()
        val categoriesWithoutOrder = categories.filter { it.displayOrder == 0 }
        
        if (categoriesWithoutOrder.isEmpty()) {
            logger.info("No categories need displayOrder migration")
            return
        }
        
        // Группируем по tenantId и parentId
        val grouped = categoriesWithoutOrder.groupBy { it.tenantId to it.parentId }
        
        val migrated = grouped.flatMap { (key, cats) ->
            cats.sortedBy { it.name }.mapIndexed { index, category ->
                category.copy(
                    displayOrder = index + 1,
                    updatedAt = Instant.now()
                )
            }
        }
        
        categoryRepository.saveAll(migrated)
        
        logger.info("Migrated ${migrated.size} categories with displayOrder")
    }
}
```

**Альтернативный подход (через Mongock):**

```kotlin
@ChangeLog(order = "002")
class AddDisplayOrderChangeLog {
    
    @ChangeSet(
        order = "001",
        id = "add-displayOrder-to-categories",
        author = "backend-team"
    )
    fun addDisplayOrder(mongoTemplate: MongoTemplate) {
        val categories = mongoTemplate.findAll(Category::class.java)
        
        categories
            .groupBy { it.tenantId to it.parentId }
            .forEach { (_, cats) ->
                cats.sortedBy { it.name }.forEachIndexed { index, category ->
                    mongoTemplate.updateFirst(
                        Query.query(Criteria.where("_id").`is`(category.id)),
                        Update().set("displayOrder", index + 1),
                        Category::class.java
                    )
                }
            }
    }
}
```

---

## 📊 Часть 5: Индексы MongoDB

### **5.1. Индекс для `displayOrder`**

**Путь:** `finapp-core/src/main/kotlin/com/finapp/config/MongoIndexConfig.kt`

**Добавить индексы:**

```kotlin
@Configuration
class MongoIndexConfig(
    private val mongoTemplate: MongoTemplate
) {
    
    @PostConstruct
    fun createIndexes() {
        // Индекс для сортировки категорий
        mongoTemplate.indexOps(Category::class.java)
            .ensureIndex(
                Index()
                    .on("tenantId", Sort.Direction.ASC)
                    .on("displayOrder", Sort.Direction.ASC)
                    .on("name", Sort.Direction.ASC)
                    .named("idx_category_tenant_display_order")
            )
        
        // Индекс для иерархической сортировки
        mongoTemplate.indexOps(Category::class.java)
            .ensureIndex(
                Index()
                    .on("tenantId", Sort.Direction.ASC)
                    .on("parentId", Sort.Direction.ASC)
                    .on("displayOrder", Sort.Direction.ASC)
                    .named("idx_category_hierarchy_display_order")
            )
    }
}
```

---

## ✅ Acceptance Criteria

### **Для `description` в транзакциях:**

- [ ] Можно создать транзакцию с описанием
- [ ] Можно создать транзакцию без описания (description = null)
- [ ] Можно обновить описание через PUT
- [ ] Можно обновить только описание через PATCH
- [ ] Описание возвращается в GET /transactions
- [ ] Описание возвращается в GET /transactions/{id}
- [ ] Валидация: максимальная длина 500 символов (если добавляется на бэкенде)
- [ ] Покрыто unit-тестами

### **Для `displayOrder` в категориях:**

- [ ] Можно создать категорию с явным displayOrder
- [ ] При создании без displayOrder автоматически присваивается следующий номер
- [ ] GET /categories возвращает категории отсортированные по displayOrder ASC
- [ ] Можно обновить displayOrder через PUT
- [ ] Иерархические категории имеют независимый displayOrder на каждом уровне
- [ ] Fallback сортировка по name при одинаковом displayOrder
- [ ] Существующие категории получили displayOrder при миграции
- [ ] Покрыто unit-тестами и интеграционными тестами

---

## 🧪 Тестирование

### **Manual Testing Checklist:**

**Транзакции:**
```bash
# 1. Создать транзакцию с описанием
POST /api/v1/transactions
{
  "amount": "250.50",
  "categoryId": "...",
  "name": "Обед",
  "description": "Обед с коллегами в кафе на Тверской",
  "type": "EXPENSE",
  "accountId": "..."
}

# 2. Создать транзакцию без описания
POST /api/v1/transactions
{
  "amount": "100.00",
  "categoryId": "...",
  "name": "Кофе",
  "type": "EXPENSE",
  "accountId": "..."
}

# 3. Обновить только описание
PATCH /api/v1/transactions/{id}
{
  "description": "Обновленное описание"
}

# 4. Проверить что description возвращается
GET /api/v1/transactions?page=0&size=20
```

**Категории:**
```bash
# 1. Создать категорию без displayOrder
POST /api/v1/categories
{
  "name": "Продукты",
  "type": "EXPENSE"
}
# Ожидаем: displayOrder будет автоматически присвоен

# 2. Создать категорию с displayOrder = 1
POST /api/v1/categories
{
  "name": "Важная категория",
  "type": "EXPENSE",
  "displayOrder": 1
}

# 3. Получить список отсортированный по displayOrder
GET /api/v1/categories
# Ожидаем: категории отсортированы по displayOrder ASC

# 4. Обновить displayOrder
PUT /api/v1/categories/{id}
{
  "name": "Продукты",
  "type": "EXPENSE",
  "displayOrder": 5
}

# 5. Проверить иерархию
POST /api/v1/categories
{
  "name": "Подкатегория",
  "type": "EXPENSE",
  "parentId": "{parent-id}",
  "displayOrder": 1
}
```

---

## 📚 Документация

### **Обновить:**

1. **API Documentation** - добавить примеры использования новых полей
2. **README.md** - описать новые возможности
3. **CHANGELOG.md** - добавить entry для v1.1.0

**Пример для CHANGELOG.md:**

```markdown
## [1.1.0] - 2025-10-21

### Added
- **Transaction description**: Опциональное поле `description` для подробного описания транзакций (макс. 500 символов)
- **Category displayOrder**: Опциональное поле `displayOrder` для пользовательской сортировки категорий
- Автоматическое присвоение `displayOrder` при создании категории
- Сортировка категорий по `displayOrder ASC, name ASC`
- Миграция существующих категорий с автоматическим displayOrder

### Changed
- Обновлена зависимость `finapp-api-client` до версии 1.1.0
```

---

## ⚠️ Important Notes

### **1. Обратная совместимость**

- Оба поля опциональные
- Старые клиенты продолжат работать без изменений
- Новые клиенты могут использовать новые поля

### **2. Производительность**

- Добавить индекс на `displayOrder` для эффективной сортировки
- Избегать N+1 запросов при загрузке иерархии категорий
- Использовать batch операции для reorder

### **3. Tenant Isolation**

- `displayOrder` работает в рамках одного tenant
- Миграция должна учитывать `tenantId`
- При автоматическом присвоении учитывать tenant

### **4. Fallback поведение**

- Если `displayOrder` одинаковый → сортировка по `name`
- Если `displayOrder` не задан при создании → автоматически следующий номер
- Для существующих категорий → миграция присвоит порядок по алфавиту

---

## 📅 Timeline

| Задача | Оценка | Приоритет |
|--------|--------|-----------|
| Обновление зависимостей | 0.5h | High |
| Транзакции: Entity + Mapper | 1h | High |
| Транзакции: Тесты | 1h | High |
| Категории: Entity + Repository | 1h | High |
| Категории: Service + автоматический order | 2h | High |
| Категории: Тесты | 2h | High |
| Миграция displayOrder | 1h | Medium |
| Индексы MongoDB | 0.5h | Medium |
| Endpoint для reorder (опционально) | 1h | Low |
| Документация | 1h | Medium |

**Total:** ~11 часов

---

## 🎯 Definition of Done

- [ ] Код написан и прошел code review
- [ ] Unit тесты написаны и проходят (coverage ≥ 80%)
- [ ] Integration тесты написаны и проходят
- [ ] Миграция выполнена на dev окружении
- [ ] Индексы созданы в MongoDB
- [ ] Manual testing выполнен согласно чек-листу
- [ ] Документация обновлена
- [ ] CHANGELOG.md обновлен
- [ ] PR создан и одобрен
- [ ] Задеплоено на dev окружение
- [ ] QA протестировал функциональность

---

## 📞 Contacts

**Questions:** Backend Team Lead  
**API Spec:** https://github.com/sergey-videtskikh/aifinadvisor-api  
**Backend Repo:** https://github.com/sergey-videtskikh/aifinadvisor-back

---

**Good luck! 🚀**
