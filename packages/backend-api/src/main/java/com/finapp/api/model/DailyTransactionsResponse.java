package com.finapp.api.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.finapp.api.model.DailyTransactionsResponseDaysInner;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import jakarta.annotation.Generated;

/**
 * DailyTransactionsResponse
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-09-24T17:10:51.802634+03:00[Europe/Moscow]")
public class DailyTransactionsResponse {

  @Valid
  private List<@Valid DailyTransactionsResponseDaysInner> days;

  private String currency = "RUB";

  public DailyTransactionsResponse days(List<@Valid DailyTransactionsResponseDaysInner> days) {
    this.days = days;
    return this;
  }

  public DailyTransactionsResponse addDaysItem(DailyTransactionsResponseDaysInner daysItem) {
    if (this.days == null) {
      this.days = new ArrayList<>();
    }
    this.days.add(daysItem);
    return this;
  }

  /**
   * Get days
   * @return days
  */
  @Valid 
  @Schema(name = "days", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("days")
  public List<@Valid DailyTransactionsResponseDaysInner> getDays() {
    return days;
  }

  public void setDays(List<@Valid DailyTransactionsResponseDaysInner> days) {
    this.days = days;
  }

  public DailyTransactionsResponse currency(String currency) {
    this.currency = currency;
    return this;
  }

  /**
   * Get currency
   * @return currency
  */
  @Pattern(regexp = "^[A-Z]{3}$") 
  @Schema(name = "currency", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("currency")
  public String getCurrency() {
    return currency;
  }

  public void setCurrency(String currency) {
    this.currency = currency;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    DailyTransactionsResponse dailyTransactionsResponse = (DailyTransactionsResponse) o;
    return Objects.equals(this.days, dailyTransactionsResponse.days) &&
        Objects.equals(this.currency, dailyTransactionsResponse.currency);
  }

  @Override
  public int hashCode() {
    return Objects.hash(days, currency);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class DailyTransactionsResponse {\n");
    sb.append("    days: ").append(toIndentedString(days)).append("\n");
    sb.append("    currency: ").append(toIndentedString(currency)).append("\n");
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

