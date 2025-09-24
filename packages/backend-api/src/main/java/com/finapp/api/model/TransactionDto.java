package com.finapp.api.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.finapp.api.model.InputType;
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
 * TransactionDto
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-09-24T20:42:31.196223853Z[Etc/UTC]")
public class TransactionDto {

  private UUID id;

  private String amount;

  private String currency = "RUB";

  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
  private LocalDate date;

  private UUID categoryId;

  private String name;

  private TransactionType type;

  private InputType inputType;

  private UUID accountId;

  private Boolean excluded = false;

  public TransactionDto id(UUID id) {
    this.id = id;
    return this;
  }

  /**
   * ID транзакции
   * @return id
  */
  @Valid 
  @Schema(name = "id", description = "ID транзакции", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("id")
  public UUID getId() {
    return id;
  }

  public void setId(UUID id) {
    this.id = id;
  }

  public TransactionDto amount(String amount) {
    this.amount = amount;
    return this;
  }

  /**
   * Сумма транзакции в формате decimal string (копейки)
   * @return amount
  */
  @Pattern(regexp = "^\\d+\\.\\d{2}$") 
  @Schema(name = "amount", example = "250.50", description = "Сумма транзакции в формате decimal string (копейки)", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("amount")
  public String getAmount() {
    return amount;
  }

  public void setAmount(String amount) {
    this.amount = amount;
  }

  public TransactionDto currency(String currency) {
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

  public TransactionDto date(LocalDate date) {
    this.date = date;
    return this;
  }

  /**
   * Дата транзакции
   * @return date
  */
  @Valid 
  @Schema(name = "date", example = "Mon Sep 15 00:00:00 UTC 2025", description = "Дата транзакции", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("date")
  public LocalDate getDate() {
    return date;
  }

  public void setDate(LocalDate date) {
    this.date = date;
  }

  public TransactionDto categoryId(UUID categoryId) {
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

  public TransactionDto name(String name) {
    this.name = name;
    return this;
  }

  /**
   * Название транзакции
   * @return name
  */
  
  @Schema(name = "name", example = "Обед в кафе", description = "Название транзакции", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("name")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public TransactionDto type(TransactionType type) {
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

  public TransactionDto inputType(InputType inputType) {
    this.inputType = inputType;
    return this;
  }

  /**
   * Get inputType
   * @return inputType
  */
  @Valid 
  @Schema(name = "inputType", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("inputType")
  public InputType getInputType() {
    return inputType;
  }

  public void setInputType(InputType inputType) {
    this.inputType = inputType;
  }

  public TransactionDto accountId(UUID accountId) {
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

  public TransactionDto excluded(Boolean excluded) {
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
    TransactionDto transactionDto = (TransactionDto) o;
    return Objects.equals(this.id, transactionDto.id) &&
        Objects.equals(this.amount, transactionDto.amount) &&
        Objects.equals(this.currency, transactionDto.currency) &&
        Objects.equals(this.date, transactionDto.date) &&
        Objects.equals(this.categoryId, transactionDto.categoryId) &&
        Objects.equals(this.name, transactionDto.name) &&
        Objects.equals(this.type, transactionDto.type) &&
        Objects.equals(this.inputType, transactionDto.inputType) &&
        Objects.equals(this.accountId, transactionDto.accountId) &&
        Objects.equals(this.excluded, transactionDto.excluded);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, amount, currency, date, categoryId, name, type, inputType, accountId, excluded);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TransactionDto {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    amount: ").append(toIndentedString(amount)).append("\n");
    sb.append("    currency: ").append(toIndentedString(currency)).append("\n");
    sb.append("    date: ").append(toIndentedString(date)).append("\n");
    sb.append("    categoryId: ").append(toIndentedString(categoryId)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    inputType: ").append(toIndentedString(inputType)).append("\n");
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

