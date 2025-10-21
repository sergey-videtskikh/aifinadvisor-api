package com.finapp.api.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.finapp.api.model.CategoryAnalyticsResponseCategoriesInner;
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
 * CategoryAnalyticsResponse
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-10-21T10:36:47.145286399Z[Etc/UTC]")
public class CategoryAnalyticsResponse {

  @Valid
  private List<@Valid CategoryAnalyticsResponseCategoriesInner> categories;

  private String totalAmount;

  private String currency = "RUB";

  public CategoryAnalyticsResponse categories(List<@Valid CategoryAnalyticsResponseCategoriesInner> categories) {
    this.categories = categories;
    return this;
  }

  public CategoryAnalyticsResponse addCategoriesItem(CategoryAnalyticsResponseCategoriesInner categoriesItem) {
    if (this.categories == null) {
      this.categories = new ArrayList<>();
    }
    this.categories.add(categoriesItem);
    return this;
  }

  /**
   * Get categories
   * @return categories
  */
  @Valid 
  @Schema(name = "categories", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("categories")
  public List<@Valid CategoryAnalyticsResponseCategoriesInner> getCategories() {
    return categories;
  }

  public void setCategories(List<@Valid CategoryAnalyticsResponseCategoriesInner> categories) {
    this.categories = categories;
  }

  public CategoryAnalyticsResponse totalAmount(String totalAmount) {
    this.totalAmount = totalAmount;
    return this;
  }

  /**
   * Get totalAmount
   * @return totalAmount
  */
  @Pattern(regexp = "^\\d+\\.\\d{2}$") 
  @Schema(name = "totalAmount", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("totalAmount")
  public String getTotalAmount() {
    return totalAmount;
  }

  public void setTotalAmount(String totalAmount) {
    this.totalAmount = totalAmount;
  }

  public CategoryAnalyticsResponse currency(String currency) {
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
    CategoryAnalyticsResponse categoryAnalyticsResponse = (CategoryAnalyticsResponse) o;
    return Objects.equals(this.categories, categoryAnalyticsResponse.categories) &&
        Objects.equals(this.totalAmount, categoryAnalyticsResponse.totalAmount) &&
        Objects.equals(this.currency, categoryAnalyticsResponse.currency);
  }

  @Override
  public int hashCode() {
    return Objects.hash(categories, totalAmount, currency);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CategoryAnalyticsResponse {\n");
    sb.append("    categories: ").append(toIndentedString(categories)).append("\n");
    sb.append("    totalAmount: ").append(toIndentedString(totalAmount)).append("\n");
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

