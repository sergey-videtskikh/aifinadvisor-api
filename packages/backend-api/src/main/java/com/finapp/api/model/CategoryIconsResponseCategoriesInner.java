package com.finapp.api.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.finapp.api.model.CategoryIconDto;
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
 * CategoryIconsResponseCategoriesInner
 */

@JsonTypeName("CategoryIconsResponse_categories_inner")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-10-27T14:18:21.767051747Z[Etc/UTC]")
public class CategoryIconsResponseCategoriesInner {

  private String name;

  @Valid
  private List<@Valid CategoryIconDto> icons;

  public CategoryIconsResponseCategoriesInner name(String name) {
    this.name = name;
    return this;
  }

  /**
   * Get name
   * @return name
  */
  
  @Schema(name = "name", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("name")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public CategoryIconsResponseCategoriesInner icons(List<@Valid CategoryIconDto> icons) {
    this.icons = icons;
    return this;
  }

  public CategoryIconsResponseCategoriesInner addIconsItem(CategoryIconDto iconsItem) {
    if (this.icons == null) {
      this.icons = new ArrayList<>();
    }
    this.icons.add(iconsItem);
    return this;
  }

  /**
   * Get icons
   * @return icons
  */
  @Valid 
  @Schema(name = "icons", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("icons")
  public List<@Valid CategoryIconDto> getIcons() {
    return icons;
  }

  public void setIcons(List<@Valid CategoryIconDto> icons) {
    this.icons = icons;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CategoryIconsResponseCategoriesInner categoryIconsResponseCategoriesInner = (CategoryIconsResponseCategoriesInner) o;
    return Objects.equals(this.name, categoryIconsResponseCategoriesInner.name) &&
        Objects.equals(this.icons, categoryIconsResponseCategoriesInner.icons);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, icons);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CategoryIconsResponseCategoriesInner {\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    icons: ").append(toIndentedString(icons)).append("\n");
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

