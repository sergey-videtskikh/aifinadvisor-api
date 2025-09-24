package com.finapp.api.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonTypeName;
import java.time.LocalDate;
import org.springframework.format.annotation.DateTimeFormat;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import jakarta.annotation.Generated;

/**
 * DailyTransactionsResponseDaysInner
 */

@JsonTypeName("DailyTransactionsResponse_days_inner")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-09-24T14:36:51.813686573Z[Etc/UTC]")
public class DailyTransactionsResponseDaysInner {

  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
  private LocalDate date;

  private String income;

  private String expense;

  private Integer transactionCount;

  public DailyTransactionsResponseDaysInner date(LocalDate date) {
    this.date = date;
    return this;
  }

  /**
   * Get date
   * @return date
  */
  @Valid 
  @Schema(name = "date", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("date")
  public LocalDate getDate() {
    return date;
  }

  public void setDate(LocalDate date) {
    this.date = date;
  }

  public DailyTransactionsResponseDaysInner income(String income) {
    this.income = income;
    return this;
  }

  /**
   * Get income
   * @return income
  */
  @Pattern(regexp = "^\\d+\\.\\d{2}$") 
  @Schema(name = "income", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("income")
  public String getIncome() {
    return income;
  }

  public void setIncome(String income) {
    this.income = income;
  }

  public DailyTransactionsResponseDaysInner expense(String expense) {
    this.expense = expense;
    return this;
  }

  /**
   * Get expense
   * @return expense
  */
  @Pattern(regexp = "^\\d+\\.\\d{2}$") 
  @Schema(name = "expense", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("expense")
  public String getExpense() {
    return expense;
  }

  public void setExpense(String expense) {
    this.expense = expense;
  }

  public DailyTransactionsResponseDaysInner transactionCount(Integer transactionCount) {
    this.transactionCount = transactionCount;
    return this;
  }

  /**
   * Get transactionCount
   * @return transactionCount
  */
  
  @Schema(name = "transactionCount", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("transactionCount")
  public Integer getTransactionCount() {
    return transactionCount;
  }

  public void setTransactionCount(Integer transactionCount) {
    this.transactionCount = transactionCount;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    DailyTransactionsResponseDaysInner dailyTransactionsResponseDaysInner = (DailyTransactionsResponseDaysInner) o;
    return Objects.equals(this.date, dailyTransactionsResponseDaysInner.date) &&
        Objects.equals(this.income, dailyTransactionsResponseDaysInner.income) &&
        Objects.equals(this.expense, dailyTransactionsResponseDaysInner.expense) &&
        Objects.equals(this.transactionCount, dailyTransactionsResponseDaysInner.transactionCount);
  }

  @Override
  public int hashCode() {
    return Objects.hash(date, income, expense, transactionCount);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class DailyTransactionsResponseDaysInner {\n");
    sb.append("    date: ").append(toIndentedString(date)).append("\n");
    sb.append("    income: ").append(toIndentedString(income)).append("\n");
    sb.append("    expense: ").append(toIndentedString(expense)).append("\n");
    sb.append("    transactionCount: ").append(toIndentedString(transactionCount)).append("\n");
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

