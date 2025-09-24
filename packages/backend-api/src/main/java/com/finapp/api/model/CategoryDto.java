package com.finapp.api.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.finapp.api.model.CategoryType;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
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
 * CategoryDto
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-09-24T19:20:01.059020+03:00[Europe/Moscow]")
public class CategoryDto {

  private UUID id;

  private String name;

  private CategoryType type;

  private JsonNullable<UUID> parentId = JsonNullable.<UUID>undefined();

  private JsonNullable<String> icon = JsonNullable.<String>undefined();

  private JsonNullable<String> iconColor = JsonNullable.<String>undefined();

  @Valid
  private List<@Valid CategoryDto> children;

  public CategoryDto id(UUID id) {
    this.id = id;
    return this;
  }

  /**
   * ID категории
   * @return id
  */
  @Valid 
  @Schema(name = "id", description = "ID категории", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("id")
  public UUID getId() {
    return id;
  }

  public void setId(UUID id) {
    this.id = id;
  }

  public CategoryDto name(String name) {
    this.name = name;
    return this;
  }

  /**
   * Название категории
   * @return name
  */
  
  @Schema(name = "name", description = "Название категории", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("name")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public CategoryDto type(CategoryType type) {
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

  public CategoryDto parentId(UUID parentId) {
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

  public CategoryDto icon(String icon) {
    this.icon = JsonNullable.of(icon);
    return this;
  }

  /**
   * Иконка категории
   * @return icon
  */
  
  @Schema(name = "icon", example = "solar:wallet-money-line-duotone", description = "Иконка категории", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("icon")
  public JsonNullable<String> getIcon() {
    return icon;
  }

  public void setIcon(JsonNullable<String> icon) {
    this.icon = icon;
  }

  public CategoryDto iconColor(String iconColor) {
    this.iconColor = JsonNullable.of(iconColor);
    return this;
  }

  /**
   * Цвет иконки в HEX-формате
   * @return iconColor
  */
  
  @Schema(name = "iconColor", example = "#10B981", description = "Цвет иконки в HEX-формате", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("iconColor")
  public JsonNullable<String> getIconColor() {
    return iconColor;
  }

  public void setIconColor(JsonNullable<String> iconColor) {
    this.iconColor = iconColor;
  }

  public CategoryDto children(List<@Valid CategoryDto> children) {
    this.children = children;
    return this;
  }

  public CategoryDto addChildrenItem(CategoryDto childrenItem) {
    if (this.children == null) {
      this.children = new ArrayList<>();
    }
    this.children.add(childrenItem);
    return this;
  }

  /**
   * Список вложенных подкатегорий
   * @return children
  */
  @Valid 
  @Schema(name = "children", description = "Список вложенных подкатегорий", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("children")
  public List<@Valid CategoryDto> getChildren() {
    return children;
  }

  public void setChildren(List<@Valid CategoryDto> children) {
    this.children = children;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CategoryDto categoryDto = (CategoryDto) o;
    return Objects.equals(this.id, categoryDto.id) &&
        Objects.equals(this.name, categoryDto.name) &&
        Objects.equals(this.type, categoryDto.type) &&
        equalsNullable(this.parentId, categoryDto.parentId) &&
        equalsNullable(this.icon, categoryDto.icon) &&
        equalsNullable(this.iconColor, categoryDto.iconColor) &&
        Objects.equals(this.children, categoryDto.children);
  }

  private static <T> boolean equalsNullable(JsonNullable<T> a, JsonNullable<T> b) {
    return a == b || (a != null && b != null && a.isPresent() && b.isPresent() && Objects.deepEquals(a.get(), b.get()));
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, type, hashCodeNullable(parentId), hashCodeNullable(icon), hashCodeNullable(iconColor), children);
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
    sb.append("class CategoryDto {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    parentId: ").append(toIndentedString(parentId)).append("\n");
    sb.append("    icon: ").append(toIndentedString(icon)).append("\n");
    sb.append("    iconColor: ").append(toIndentedString(iconColor)).append("\n");
    sb.append("    children: ").append(toIndentedString(children)).append("\n");
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

