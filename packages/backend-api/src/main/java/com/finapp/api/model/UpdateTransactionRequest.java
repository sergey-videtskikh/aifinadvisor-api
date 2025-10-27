package com.finapp.api.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.finapp.api.model.TransactionType;
import java.time.LocalDate;
import java.util.UUID;
import org.springframework.format.annotation.DateTimeFormat;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import jakarta.annotation.Generated;

/**
 * UpdateTransactionRequest
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-10-27T12:48:48.819441954Z[Etc/UTC]")
public class UpdateTransactionRequest {

  private String amount;

  private String currency;

  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
  private LocalDate date;

  private UUID categoryId;

  private String name;

  private String description;

  private TransactionType type;

  private UUID accountId;

  private Boolean excluded;

  public UpdateTransactionRequest amount(String amount) {
    this.amount = amount;
    return this;
  }

  /**
   * Сумма транзакции в формате decimal string (копейки)
   * @return amount
  */
  @Pattern(regexp = "^\\d+\\.\\d{2}$") 
  @Schema(name = "amount", example = "260.00", description = "Сумма транзакции в формате decimal string (копейки)", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("amount")
  public String getAmount() {
    return amount;
  }

  public void setAmount(String amount) {
    this.amount = amount;
  }

  public UpdateTransactionRequest currency(String currency) {
    this.currency = currency;
    return this;
  }

  /**
   * Код валюты ISO-4217
   * @return currency
  */
  @Pattern(regexp = "^[A-Z]{3}$") 
  @Schema(name = "currency", example = "RUB", description = "Код валюты ISO-4217", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("currency")
  public String getCurrency() {
    return currency;
  }

  public void setCurrency(String currency) {
    this.currency = currency;
  }

  public UpdateTransactionRequest date(LocalDate date) {
    this.date = date;
    return this;
  }

  /**
   * Дата транзакции
   * @return date
  */
  @Valid 
  @Schema(name = "date", example = "Tue Sep 16 00:00:00 UTC 2025", description = "Дата транзакции", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("date")
  public LocalDate getDate() {
    return date;
  }

  public void setDate(LocalDate date) {
    this.date = date;
  }

  public UpdateTransactionRequest categoryId(UUID categoryId) {
    this.categoryId = categoryId;
    return this;
  }

  /**
   * ID категории
   * @return categoryId
  */
  @Valid 
  @Schema(name = "categoryId", description = "ID категории", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("categoryId")
  public UUID getCategoryId() {
    return categoryId;
  }

  public void setCategoryId(UUID categoryId) {
    this.categoryId = categoryId;
  }

  public UpdateTransactionRequest name(String name) {
    this.name = name;
    return this;
  }

  /**
   * Название транзакции
   * @return name
  */
  @Size(min = 1, max = 100) 
  @Schema(name = "name", description = "Название транзакции", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("name")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public UpdateTransactionRequest description(String description) {
    this.description = description;
    return this;
  }

  /**
   * Подробное описание транзакции
   * @return description
  */
  @Size(max = 500) 
  @Schema(name = "description", description = "Подробное описание транзакции", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("description")
  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public UpdateTransactionRequest type(TransactionType type) {
    this.type = type;
    return this;
  }

  /**
   * Get type
   * @return type
  */
  @Valid 
  @Schema(name = "type", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("type")
  public TransactionType getType() {
    return type;
  }

  public void setType(TransactionType type) {
    this.type = type;
  }

  public UpdateTransactionRequest accountId(UUID accountId) {
    this.accountId = accountId;
    return this;
  }

  /**
   * ID счета
   * @return accountId
  */
  @Valid 
  @Schema(name = "accountId", description = "ID счета", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("accountId")
  public UUID getAccountId() {
    return accountId;
  }

  public void setAccountId(UUID accountId) {
    this.accountId = accountId;
  }

  public UpdateTransactionRequest excluded(Boolean excluded) {
    this.excluded = excluded;
    return this;
  }

  /**
   * Исключить из расчетов
   * @return excluded
  */
  
  @Schema(name = "excluded", description = "Исключить из расчетов", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("excluded")
  public Boolean getExcluded() {
    return excluded;
  }

  public void setExcluded(Boolean excluded) {
    this.excluded = excluded;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    UpdateTransactionRequest updateTransactionRequest = (UpdateTransactionRequest) o;
    return Objects.equals(this.amount, updateTransactionRequest.amount) &&
        Objects.equals(this.currency, updateTransactionRequest.currency) &&
        Objects.equals(this.date, updateTransactionRequest.date) &&
        Objects.equals(this.categoryId, updateTransactionRequest.categoryId) &&
        Objects.equals(this.name, updateTransactionRequest.name) &&
        Objects.equals(this.description, updateTransactionRequest.description) &&
        Objects.equals(this.type, updateTransactionRequest.type) &&
        Objects.equals(this.accountId, updateTransactionRequest.accountId) &&
        Objects.equals(this.excluded, updateTransactionRequest.excluded);
  }

  @Override
  public int hashCode() {
    return Objects.hash(amount, currency, date, categoryId, name, description, type, accountId, excluded);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class UpdateTransactionRequest {\n");
    sb.append("    amount: ").append(toIndentedString(amount)).append("\n");
    sb.append("    currency: ").append(toIndentedString(currency)).append("\n");
    sb.append("    date: ").append(toIndentedString(date)).append("\n");
    sb.append("    categoryId: ").append(toIndentedString(categoryId)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    accountId: ").append(toIndentedString(accountId)).append("\n");
    sb.append("    excluded: ").append(toIndentedString(excluded)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

