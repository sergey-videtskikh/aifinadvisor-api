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
 * PeriodSummaryResponsePeriodsInner
 */

@JsonTypeName("PeriodSummaryResponse_periods_inner")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-10-21T10:50:17.094476136Z[Etc/UTC]")
public class PeriodSummaryResponsePeriodsInner {

  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
  private LocalDate period;

  private String income;

  private String expense;

  private String balance;

  public PeriodSummaryResponsePeriodsInner period(LocalDate period) {
    this.period = period;
    return this;
  }

  /**
   * Месяц в формате YYYY-MM
   * @return period
  */
  @Valid 
  @Schema(name = "period", description = "Месяц в формате YYYY-MM", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("period")
  public LocalDate getPeriod() {
    return period;
  }

  public void setPeriod(LocalDate period) {
    this.period = period;
  }

  public PeriodSummaryResponsePeriodsInner income(String income) {
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

  public PeriodSummaryResponsePeriodsInner expense(String expense) {
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

  public PeriodSummaryResponsePeriodsInner balance(String balance) {
    this.balance = balance;
    return this;
  }

  /**
   * Get balance
   * @return balance
  */
  @Pattern(regexp = "^\\d+\\.\\d{2}$") 
  @Schema(name = "balance", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
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
    PeriodSummaryResponsePeriodsInner periodSummaryResponsePeriodsInner = (PeriodSummaryResponsePeriodsInner) o;
    return Objects.equals(this.period, periodSummaryResponsePeriodsInner.period) &&
        Objects.equals(this.income, periodSummaryResponsePeriodsInner.income) &&
        Objects.equals(this.expense, periodSummaryResponsePeriodsInner.expense) &&
        Objects.equals(this.balance, periodSummaryResponsePeriodsInner.balance);
  }

  @Override
  public int hashCode() {
    return Objects.hash(period, income, expense, balance);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PeriodSummaryResponsePeriodsInner {\n");
    sb.append("    period: ").append(toIndentedString(period)).append("\n");
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

