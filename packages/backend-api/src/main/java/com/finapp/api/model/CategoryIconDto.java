package com.finapp.api.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import jakarta.annotation.Generated;

/**
 * CategoryIconDto
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-09-24T19:20:01.059020+03:00[Europe/Moscow]")
public class CategoryIconDto {

  private String id;

  private String name;

  private String unicode;

  private String category;

  public CategoryIconDto id(String id) {
    this.id = id;
    return this;
  }

  /**
   * Get id
   * @return id
  */
  
  @Schema(name = "id", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("id")
  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public CategoryIconDto name(String name) {
    this.name = name;
    return this;
  }

  /**
   * Название иконки
   * @return name
  */
  
  @Schema(name = "name", description = "Название иконки", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("name")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public CategoryIconDto unicode(String unicode) {
    this.unicode = unicode;
    return this;
  }

  /**
   * Unicode символ
   * @return unicode
  */
  
  @Schema(name = "unicode", description = "Unicode символ", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("unicode")
  public String getUnicode() {
    return unicode;
  }

  public void setUnicode(String unicode) {
    this.unicode = unicode;
  }

  public CategoryIconDto category(String category) {
    this.category = category;
    return this;
  }

  /**
   * Категория иконки
   * @return category
  */
  
  @Schema(name = "category", description = "Категория иконки", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("category")
  public String getCategory() {
    return category;
  }

  public void setCategory(String category) {
    this.category = category;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CategoryIconDto categoryIconDto = (CategoryIconDto) o;
    return Objects.equals(this.id, categoryIconDto.id) &&
        Objects.equals(this.name, categoryIconDto.name) &&
        Objects.equals(this.unicode, categoryIconDto.unicode) &&
        Objects.equals(this.category, categoryIconDto.category);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, unicode, category);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CategoryIconDto {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    unicode: ").append(toIndentedString(unicode)).append("\n");
    sb.append("    category: ").append(toIndentedString(category)).append("\n");
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

