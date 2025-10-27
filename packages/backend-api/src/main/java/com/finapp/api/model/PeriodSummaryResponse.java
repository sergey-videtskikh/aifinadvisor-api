package com.finapp.api.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.finapp.api.model.PeriodSummaryResponsePeriodsInner;
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
 * PeriodSummaryResponse
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-10-27T12:48:48.819441954Z[Etc/UTC]")
public class PeriodSummaryResponse {

  @Valid
  private List<@Valid PeriodSummaryResponsePeriodsInner> periods;

  private String currency = "RUB";

  public PeriodSummaryResponse periods(List<@Valid PeriodSummaryResponsePeriodsInner> periods) {
    this.periods = periods;
    return this;
  }

  public PeriodSummaryResponse addPeriodsItem(PeriodSummaryResponsePeriodsInner periodsItem) {
    if (this.periods == null) {
      this.periods = new ArrayList<>();
    }
    this.periods.add(periodsItem);
    return this;
  }

  /**
   * Get periods
   * @return periods
  */
  @Valid 
  @Schema(name = "periods", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("periods")
  public List<@Valid PeriodSummaryResponsePeriodsInner> getPeriods() {
    return periods;
  }

  public void setPeriods(List<@Valid PeriodSummaryResponsePeriodsInner> periods) {
    this.periods = periods;
  }

  public PeriodSummaryResponse currency(String currency) {
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
    PeriodSummaryResponse periodSummaryResponse = (PeriodSummaryResponse) o;
    return Objects.equals(this.periods, periodSummaryResponse.periods) &&
        Objects.equals(this.currency, periodSummaryResponse.currency);
  }

  @Override
  public int hashCode() {
    return Objects.hash(periods, currency);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PeriodSummaryResponse {\n");
    sb.append("    periods: ").append(toIndentedString(periods)).append("\n");
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

