package com.finapp.api.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.finapp.api.model.AnalyticsResponseMetrics;
import com.finapp.api.model.TransactionDto;
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
 * AnalyticsResponse
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-10-21T10:36:47.145286399Z[Etc/UTC]")
public class AnalyticsResponse {

  private AnalyticsResponseMetrics metrics;

  private String currency = "RUB";

  @Valid
  private List<@Valid TransactionDto> recentTransactions;

  public AnalyticsResponse metrics(AnalyticsResponseMetrics metrics) {
    this.metrics = metrics;
    return this;
  }

  /**
   * Get metrics
   * @return metrics
  */
  @Valid 
  @Schema(name = "metrics", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("metrics")
  public AnalyticsResponseMetrics getMetrics() {
    return metrics;
  }

  public void setMetrics(AnalyticsResponseMetrics metrics) {
    this.metrics = metrics;
  }

  public AnalyticsResponse currency(String currency) {
    this.currency = currency;
    return this;
  }

  /**
   * Код валюты ISO-4217
   * @return currency
  */
  @Pattern(regexp = "^[A-Z]{3}$") 
  @Schema(name = "currency", description = "Код валюты ISO-4217", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("currency")
  public String getCurrency() {
    return currency;
  }

  public void setCurrency(String currency) {
    this.currency = currency;
  }

  public AnalyticsResponse recentTransactions(List<@Valid TransactionDto> recentTransactions) {
    this.recentTransactions = recentTransactions;
    return this;
  }

  public AnalyticsResponse addRecentTransactionsItem(TransactionDto recentTransactionsItem) {
    if (this.recentTransactions == null) {
      this.recentTransactions = new ArrayList<>();
    }
    this.recentTransactions.add(recentTransactionsItem);
    return this;
  }

  /**
   * Get recentTransactions
   * @return recentTransactions
  */
  @Valid 
  @Schema(name = "recentTransactions", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("recentTransactions")
  public List<@Valid TransactionDto> getRecentTransactions() {
    return recentTransactions;
  }

  public void setRecentTransactions(List<@Valid TransactionDto> recentTransactions) {
    this.recentTransactions = recentTransactions;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AnalyticsResponse analyticsResponse = (AnalyticsResponse) o;
    return Objects.equals(this.metrics, analyticsResponse.metrics) &&
        Objects.equals(this.currency, analyticsResponse.currency) &&
        Objects.equals(this.recentTransactions, analyticsResponse.recentTransactions);
  }

  @Override
  public int hashCode() {
    return Objects.hash(metrics, currency, recentTransactions);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AnalyticsResponse {\n");
    sb.append("    metrics: ").append(toIndentedString(metrics)).append("\n");
    sb.append("    currency: ").append(toIndentedString(currency)).append("\n");
    sb.append("    recentTransactions: ").append(toIndentedString(recentTransactions)).append("\n");
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

