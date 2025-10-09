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
 * Частичное обновление транзакции - все поля опциональны
 */

@Schema(name = "PatchTransactionRequest", description = "Частичное обновление транзакции - все поля опциональны")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-10-09T21:12:14.599634+03:00[Europe/Moscow]")
public class PatchTransactionRequest {

  private String amount;

  private String currency;

  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
  private LocalDate date;

  private UUID categoryId;

  private String name;

  private TransactionType type;

  private UUID accountId;

  private Boolean excluded;

  public PatchTransactionRequest amount(String amount) {
    this.amount = amount;
    return this;
  }

  /**
   * Новая сумма транзакции
   * @return amount
  */
  @Pattern(regexp = "^\\d+\\.\\d{2}$") 
  @Schema(name = "amount", example = "300.00", description = "Новая сумма транзакции", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("amount")
  public String getAmount() {
    return amount;
  }

  public void setAmount(String amount) {
    this.amount = amount;
  }

  public PatchTransactionRequest currency(String currency) {
    this.currency = currency;
    return this;
  }

  /**
   * Новый код валюты ISO-4217
   * @return currency
  */
  @Pattern(regexp = "^[A-Z]{3}$") 
  @Schema(name = "currency", example = "USD", description = "Новый код валюты ISO-4217", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("currency")
  public String getCurrency() {
    return currency;
  }

  public void setCurrency(String currency) {
    this.currency = currency;
  }

  public PatchTransactionRequest date(LocalDate date) {
    this.date = date;
    return this;
  }

  /**
   * Новая дата транзакции
   * @return date
  */
  @Valid 
  @Schema(name = "date", example = "Wed Sep 17 03:00:00 MSK 2025", description = "Новая дата транзакции", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("date")
  public LocalDate getDate() {
    return date;
  }

  public void setDate(LocalDate date) {
    this.date = date;
  }

  public PatchTransactionRequest categoryId(UUID categoryId) {
    this.categoryId = categoryId;
    return this;
  }

  /**
   * Новая категория
   * @return categoryId
  */
  @Valid 
  @Schema(name = "categoryId", description = "Новая категория", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("categoryId")
  public UUID getCategoryId() {
    return categoryId;
  }

  public void setCategoryId(UUID categoryId) {
    this.categoryId = categoryId;
  }

  public PatchTransactionRequest name(String name) {
    this.name = name;
    return this;
  }

  /**
   * Новое название транзакции
   * @return name
  */
  @Size(min = 1, max = 100) 
  @Schema(name = "name", example = "Обновленное название", description = "Новое название транзакции", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("name")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public PatchTransactionRequest type(TransactionType type) {
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

  public PatchTransactionRequest accountId(UUID accountId) {
    this.accountId = accountId;
    return this;
  }

  /**
   * Новый ID счета
   * @return accountId
  */
  @Valid 
  @Schema(name = "accountId", description = "Новый ID счета", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("accountId")
  public UUID getAccountId() {
    return accountId;
  }

  public void setAccountId(UUID accountId) {
    this.accountId = accountId;
  }

  public PatchTransactionRequest excluded(Boolean excluded) {
    this.excluded = excluded;
    return this;
  }

  /**
   * Новое значение флага исключения
   * @return excluded
  */
  
  @Schema(name = "excluded", description = "Новое значение флага исключения", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
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
    PatchTransactionRequest patchTransactionRequest = (PatchTransactionRequest) o;
    return Objects.equals(this.amount, patchTransactionRequest.amount) &&
        Objects.equals(this.currency, patchTransactionRequest.currency) &&
        Objects.equals(this.date, patchTransactionRequest.date) &&
        Objects.equals(this.categoryId, patchTransactionRequest.categoryId) &&
        Objects.equals(this.name, patchTransactionRequest.name) &&
        Objects.equals(this.type, patchTransactionRequest.type) &&
        Objects.equals(this.accountId, patchTransactionRequest.accountId) &&
        Objects.equals(this.excluded, patchTransactionRequest.excluded);
  }

  @Override
  public int hashCode() {
    return Objects.hash(amount, currency, date, categoryId, name, type, accountId, excluded);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PatchTransactionRequest {\n");
    sb.append("    amount: ").append(toIndentedString(amount)).append("\n");
    sb.append("    currency: ").append(toIndentedString(currency)).append("\n");
    sb.append("    date: ").append(toIndentedString(date)).append("\n");
    sb.append("    categoryId: ").append(toIndentedString(categoryId)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
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

