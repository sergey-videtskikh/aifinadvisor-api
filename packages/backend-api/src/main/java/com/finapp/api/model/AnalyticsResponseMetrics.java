package com.finapp.api.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonTypeName;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import jakarta.annotation.Generated;

/**
 * AnalyticsResponseMetrics
 */

@JsonTypeName("AnalyticsResponse_metrics")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-09-24T19:20:01.059020+03:00[Europe/Moscow]")
public class AnalyticsResponseMetrics {

  private String income;

  private String expense;

  private String balance;

  public AnalyticsResponseMetrics income(String income) {
    this.income = income;
    return this;
  }

  /**
   * Сумма доходов за период
   * @return income
  */
  @Pattern(regexp = "^\\d+\\.\\d{2}$") 
  @Schema(name = "income", description = "Сумма доходов за период", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("income")
  public String getIncome() {
    return income;
  }

  public void setIncome(String income) {
    this.income = income;
  }

  public AnalyticsResponseMetrics expense(String expense) {
    this.expense = expense;
    return this;
  }

  /**
   * Сумма расходов за период
   * @return expense
  */
  @Pattern(regexp = "^\\d+\\.\\d{2}$") 
  @Schema(name = "expense", description = "Сумма расходов за период", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("expense")
  public String getExpense() {
    return expense;
  }

  public void setExpense(String expense) {
    this.expense = expense;
  }

  public AnalyticsResponseMetrics balance(String balance) {
    this.balance = balance;
    return this;
  }

  /**
   * Итоговый баланс
   * @return balance
  */
  @Pattern(regexp = "^\\d+\\.\\d{2}$") 
  @Schema(name = "balance", description = "Итоговый баланс", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("balance")
  public String getBalance() {
    return balance;
  }

  public void setBalance(String balance) {
    this.balance = balance;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AnalyticsResponseMetrics analyticsResponseMetrics = (AnalyticsResponseMetrics) o;
    return Objects.equals(this.income, analyticsResponseMetrics.income) &&
        Objects.equals(this.expense, analyticsResponseMetrics.expense) &&
        Objects.equals(this.balance, analyticsResponseMetrics.balance);
  }

  @Override
  public int hashCode() {
    return Objects.hash(income, expense, balance);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AnalyticsResponseMetrics {\n");
    sb.append("    income: ").append(toIndentedString(income)).append("\n");
    sb.append("    expense: ").append(toIndentedString(expense)).append("\n");
    sb.append("    balance: ").append(toIndentedString(balance)).append("\n");
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

