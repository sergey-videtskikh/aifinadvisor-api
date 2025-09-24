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
 * CreateTransactionRequest
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-09-24T09:51:35.301899+03:00[Europe/Moscow]")
public class CreateTransactionRequest {

  private String amount;

  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
  private LocalDate date;

  private UUID categoryId;

  private String name;

  private TransactionType type;

  private InputType inputType;

  private UUID accountId;

  private Boolean excluded = false;

  public CreateTransactionRequest() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public CreateTransactionRequest(String amount, UUID categoryId, String name, TransactionType type, UUID accountId) {
    this.amount = amount;
    this.categoryId = categoryId;
    this.name = name;
    this.type = type;
    this.accountId = accountId;
  }

  public CreateTransactionRequest amount(String amount) {
    this.amount = amount;
    return this;
  }

  /**
   * Сумма транзакции в формате decimal string (копейки)
   * @return amount
  */
  @NotNull @Pattern(regexp = "^\\d+\\.\\d{2}$") 
  @Schema(name = "amount", example = "250.50", description = "Сумма транзакции в формате decimal string (копейки)", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("amount")
  public String getAmount() {
    return amount;
  }

  public void setAmount(String amount) {
    this.amount = amount;
  }

  public CreateTransactionRequest date(LocalDate date) {
    this.date = date;
    return this;
  }

  /**
   * Дата транзакции
   * @return date
  */
  @Valid 
  @Schema(name = "date", example = "Mon Sep 15 03:00:00 MSK 2025", description = "Дата транзакции", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("date")
  public LocalDate getDate() {
    return date;
  }

  public void setDate(LocalDate date) {
    this.date = date;
  }

  public CreateTransactionRequest categoryId(UUID categoryId) {
    this.categoryId = categoryId;
    return this;
  }

  /**
   * ID категории
   * @return categoryId
  */
  @NotNull @Valid 
  @Schema(name = "categoryId", description = "ID категории", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("categoryId")
  public UUID getCategoryId() {
    return categoryId;
  }

  public void setCategoryId(UUID categoryId) {
    this.categoryId = categoryId;
  }

  public CreateTransactionRequest name(String name) {
    this.name = name;
    return this;
  }

  /**
   * Название транзакции
   * @return name
  */
  @NotNull @Size(min = 1, max = 100) 
  @Schema(name = "name", example = "Обед в кафе", description = "Название транзакции", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("name")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public CreateTransactionRequest type(TransactionType type) {
    this.type = type;
    return this;
  }

  /**
   * Get type
   * @return type
  */
  @NotNull @Valid 
  @Schema(name = "type", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("type")
  public TransactionType getType() {
    return type;
  }

  public void setType(TransactionType type) {
    this.type = type;
  }

  public CreateTransactionRequest inputType(InputType inputType) {
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

  public CreateTransactionRequest accountId(UUID accountId) {
    this.accountId = accountId;
    return this;
  }

  /**
   * ID счета
   * @return accountId
  */
  @NotNull @Valid 
  @Schema(name = "accountId", description = "ID счета", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("accountId")
  public UUID getAccountId() {
    return accountId;
  }

  public void setAccountId(UUID accountId) {
    this.accountId = accountId;
  }

  public CreateTransactionRequest excluded(Boolean excluded) {
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
    CreateTransactionRequest createTransactionRequest = (CreateTransactionRequest) o;
    return Objects.equals(this.amount, createTransactionRequest.amount) &&
        Objects.equals(this.date, createTransactionRequest.date) &&
        Objects.equals(this.categoryId, createTransactionRequest.categoryId) &&
        Objects.equals(this.name, createTransactionRequest.name) &&
        Objects.equals(this.type, createTransactionRequest.type) &&
        Objects.equals(this.inputType, createTransactionRequest.inputType) &&
        Objects.equals(this.accountId, createTransactionRequest.accountId) &&
        Objects.equals(this.excluded, createTransactionRequest.excluded);
  }

  @Override
  public int hashCode() {
    return Objects.hash(amount, date, categoryId, name, type, inputType, accountId, excluded);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CreateTransactionRequest {\n");
    sb.append("    amount: ").append(toIndentedString(amount)).append("\n");
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

