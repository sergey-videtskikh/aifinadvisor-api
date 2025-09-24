package com.finapp.api.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.finapp.api.model.CategoryIconsResponseCategoriesInner;
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
 * CategoryIconsResponse
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-09-24T17:10:51.802634+03:00[Europe/Moscow]")
public class CategoryIconsResponse {

  @Valid
  private List<@Valid CategoryIconsResponseCategoriesInner> categories;

  public CategoryIconsResponse categories(List<@Valid CategoryIconsResponseCategoriesInner> categories) {
    this.categories = categories;
    return this;
  }

  public CategoryIconsResponse addCategoriesItem(CategoryIconsResponseCategoriesInner categoriesItem) {
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
  public List<@Valid CategoryIconsResponseCategoriesInner> getCategories() {
    return categories;
  }

  public void setCategories(List<@Valid CategoryIconsResponseCategoriesInner> categories) {
    this.categories = categories;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CategoryIconsResponse categoryIconsResponse = (CategoryIconsResponse) o;
    return Objects.equals(this.categories, categoryIconsResponse.categories);
  }

  @Override
  public int hashCode() {
    return Objects.hash(categories);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CategoryIconsResponse {\n");
    sb.append("    categories: ").append(toIndentedString(categories)).append("\n");
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

