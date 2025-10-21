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
 * DefaultCategoryDto
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-10-21T10:50:17.094476136Z[Etc/UTC]")
public class DefaultCategoryDto {

  private UUID id;

  private String name;

  private CategoryType type;

  private JsonNullable<String> icon = JsonNullable.<String>undefined();

  private JsonNullable<String> color = JsonNullable.<String>undefined();

  private JsonNullable<UUID> parentId = JsonNullable.<UUID>undefined();

  public DefaultCategoryDto id(UUID id) {
    this.id = id;
    return this;
  }

  /**
   * Get id
   * @return id
  */
  @Valid 
  @Schema(name = "id", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("id")
  public UUID getId() {
    return id;
  }

  public void setId(UUID id) {
    this.id = id;
  }

  public DefaultCategoryDto name(String name) {
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

  public DefaultCategoryDto type(CategoryType type) {
    this.type = type;
    return this;
  }

  /**
   * Get type
   * @return type
  */
  @Valid 
  @Schema(name = "type", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("type")
  public CategoryType getType() {
    return type;
  }

  public void setType(CategoryType type) {
    this.type = type;
  }

  public DefaultCategoryDto icon(String icon) {
    this.icon = JsonNullable.of(icon);
    return this;
  }

  /**
   * Get icon
   * @return icon
  */
  
  @Schema(name = "icon", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("icon")
  public JsonNullable<String> getIcon() {
    return icon;
  }

  public void setIcon(JsonNullable<String> icon) {
    this.icon = icon;
  }

  public DefaultCategoryDto color(String color) {
    this.color = JsonNullable.of(color);
    return this;
  }

  /**
   * Get color
   * @return color
  */
  
  @Schema(name = "color", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("color")
  public JsonNullable<String> getColor() {
    return color;
  }

  public void setColor(JsonNullable<String> color) {
    this.color = color;
  }

  public DefaultCategoryDto parentId(UUID parentId) {
    this.parentId = JsonNullable.of(parentId);
    return this;
  }

  /**
   * Get parentId
   * @return parentId
  */
  @Valid 
  @Schema(name = "parentId", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
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
    DefaultCategoryDto defaultCategoryDto = (DefaultCategoryDto) o;
    return Objects.equals(this.id, defaultCategoryDto.id) &&
        Objects.equals(this.name, defaultCategoryDto.name) &&
        Objects.equals(this.type, defaultCategoryDto.type) &&
        equalsNullable(this.icon, defaultCategoryDto.icon) &&
        equalsNullable(this.color, defaultCategoryDto.color) &&
        equalsNullable(this.parentId, defaultCategoryDto.parentId);
  }

  private static <T> boolean equalsNullable(JsonNullable<T> a, JsonNullable<T> b) {
    return a == b || (a != null && b != null && a.isPresent() && b.isPresent() && Objects.deepEquals(a.get(), b.get()));
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, type, hashCodeNullable(icon), hashCodeNullable(color), hashCodeNullable(parentId));
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
    sb.append("class DefaultCategoryDto {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
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

