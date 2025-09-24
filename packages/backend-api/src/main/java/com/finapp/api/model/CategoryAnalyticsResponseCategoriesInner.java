package com.finapp.api.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonTypeName;
import java.util.UUID;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import jakarta.annotation.Generated;

/**
 * CategoryAnalyticsResponseCategoriesInner
 */

@JsonTypeName("CategoryAnalyticsResponse_categories_inner")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-09-24T17:10:51.802634+03:00[Europe/Moscow]")
public class CategoryAnalyticsResponseCategoriesInner {

  private UUID categoryId;

  private String categoryName;

  private String amount;

  private Double percentage;

  private Integer transactionCount;

  public CategoryAnalyticsResponseCategoriesInner categoryId(UUID categoryId) {
    this.categoryId = categoryId;
    return this;
  }

  /**
   * Get categoryId
   * @return categoryId
  */
  @Valid 
  @Schema(name = "categoryId", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("categoryId")
  public UUID getCategoryId() {
    return categoryId;
  }

  public void setCategoryId(UUID categoryId) {
    this.categoryId = categoryId;
  }

  public CategoryAnalyticsResponseCategoriesInner categoryName(String categoryName) {
    this.categoryName = categoryName;
    return this;
  }

  /**
   * Get categoryName
   * @return categoryName
  */
  
  @Schema(name = "categoryName", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("categoryName")
  public String getCategoryName() {
    return categoryName;
  }

  public void setCategoryName(String categoryName) {
    this.categoryName = categoryName;
  }

  public CategoryAnalyticsResponseCategoriesInner amount(String amount) {
    this.amount = amount;
    return this;
  }

  /**
   * Get amount
   * @return amount
  */
  @Pattern(regexp = "^\\d+\\.\\d{2}$") 
  @Schema(name = "amount", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("amount")
  public String getAmount() {
    return amount;
  }

  public void setAmount(String amount) {
    this.amount = amount;
  }

  public CategoryAnalyticsResponseCategoriesInner percentage(Double percentage) {
    this.percentage = percentage;
    return this;
  }

  /**
   * Get percentage
   * @return percentage
  */
  
  @Schema(name = "percentage", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("percentage")
  public Double getPercentage() {
    return percentage;
  }

  public void setPercentage(Double percentage) {
    this.percentage = percentage;
  }

  public CategoryAnalyticsResponseCategoriesInner transactionCount(Integer transactionCount) {
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
    CategoryAnalyticsResponseCategoriesInner categoryAnalyticsResponseCategoriesInner = (CategoryAnalyticsResponseCategoriesInner) o;
    return Objects.equals(this.categoryId, categoryAnalyticsResponseCategoriesInner.categoryId) &&
        Objects.equals(this.categoryName, categoryAnalyticsResponseCategoriesInner.categoryName) &&
        Objects.equals(this.amount, categoryAnalyticsResponseCategoriesInner.amount) &&
        Objects.equals(this.percentage, categoryAnalyticsResponseCategoriesInner.percentage) &&
        Objects.equals(this.transactionCount, categoryAnalyticsResponseCategoriesInner.transactionCount);
  }

  @Override
  public int hashCode() {
    return Objects.hash(categoryId, categoryName, amount, percentage, transactionCount);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CategoryAnalyticsResponseCategoriesInner {\n");
    sb.append("    categoryId: ").append(toIndentedString(categoryId)).append("\n");
    sb.append("    categoryName: ").append(toIndentedString(categoryName)).append("\n");
    sb.append("    amount: ").append(toIndentedString(amount)).append("\n");
    sb.append("    percentage: ").append(toIndentedString(percentage)).append("\n");
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

