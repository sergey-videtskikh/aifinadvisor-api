package com.finapp.api.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.finapp.api.model.CategoryType;
import java.util.Arrays;
import java.util.UUID;
import org.openapitools.jackson.nullable.JsonNullable;
import java.util.NoSuchElementException;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import jakarta.annotation.Generated;

/**
 * UpdateCategoryRequest
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-09-24T19:20:01.059020+03:00[Europe/Moscow]")
public class UpdateCategoryRequest {

  private String name;

  private CategoryType type;

  private JsonNullable<String> icon = JsonNullable.<String>undefined();

  private JsonNullable<@Pattern(regexp = "^#([A-Fa-f0-9]{6}|[A-Fa-f0-9]{3})$") String> color = JsonNullable.<String>undefined();

  private JsonNullable<UUID> parentId = JsonNullable.<UUID>undefined();

  public UpdateCategoryRequest() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public UpdateCategoryRequest(String name, CategoryType type) {
    this.name = name;
    this.type = type;
  }

  public UpdateCategoryRequest name(String name) {
    this.name = name;
    return this;
  }

  /**
   * Название категории
   * @return name
  */
  @NotNull @Size(min = 1, max = 100) 
  @Schema(name = "name", description = "Название категории", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("name")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public UpdateCategoryRequest type(CategoryType type) {
    this.type = type;
    return this;
  }

  /**
   * Get type
   * @return type
  */
  @NotNull @Valid 
  @Schema(name = "type", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("type")
  public CategoryType getType() {
    return type;
  }

  public void setType(CategoryType type) {
    this.type = type;
  }

  public UpdateCategoryRequest icon(String icon) {
    this.icon = JsonNullable.of(icon);
    return this;
  }

  /**
   * Иконка категории
   * @return icon
  */
  
  @Schema(name = "icon", description = "Иконка категории", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("icon")
  public JsonNullable<String> getIcon() {
    return icon;
  }

  public void setIcon(JsonNullable<String> icon) {
    this.icon = icon;
  }

  public UpdateCategoryRequest color(String color) {
    this.color = JsonNullable.of(color);
    return this;
  }

  /**
   * Цвет категории в HEX формате
   * @return color
  */
  @Pattern(regexp = "^#([A-Fa-f0-9]{6}|[A-Fa-f0-9]{3})$") 
  @Schema(name = "color", description = "Цвет категории в HEX формате", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("color")
  public JsonNullable<@Pattern(regexp = "^#([A-Fa-f0-9]{6}|[A-Fa-f0-9]{3})$") String> getColor() {
    return color;
  }

  public void setColor(JsonNullable<String> color) {
    this.color = color;
  }

  public UpdateCategoryRequest parentId(UUID parentId) {
    this.parentId = JsonNullable.of(parentId);
    return this;
  }

  /**
   * ID родительской категории
   * @return parentId
  */
  @Valid 
  @Schema(name = "parentId", description = "ID родительской категории", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("parentId")
  public JsonNullable<UUID> getParentId() {
    return parentId;
  }

  public void setParentId(JsonNullable<UUID> parentId) {
    this.parentId = parentId;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    UpdateCategoryRequest updateCategoryRequest = (UpdateCategoryRequest) o;
    return Objects.equals(this.name, updateCategoryRequest.name) &&
        Objects.equals(this.type, updateCategoryRequest.type) &&
        equalsNullable(this.icon, updateCategoryRequest.icon) &&
        equalsNullable(this.color, updateCategoryRequest.color) &&
        equalsNullable(this.parentId, updateCategoryRequest.parentId);
  }

  private static <T> boolean equalsNullable(JsonNullable<T> a, JsonNullable<T> b) {
    return a == b || (a != null && b != null && a.isPresent() && b.isPresent() && Objects.deepEquals(a.get(), b.get()));
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, type, hashCodeNullable(icon), hashCodeNullable(color), hashCodeNullable(parentId));
  }

  private static <T> int hashCodeNullable(JsonNullable<T> a) {
    if (a == null) {
      return 1;
    }
    return a.isPresent() ? Arrays.deepHashCode(new Object[]{a.get()}) : 31;
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class UpdateCategoryRequest {\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    icon: ").append(toIndentedString(icon)).append("\n");
    sb.append("    color: ").append(toIndentedString(color)).append("\n");
    sb.append("    parentId: ").append(toIndentedString(parentId)).append("\n");
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

