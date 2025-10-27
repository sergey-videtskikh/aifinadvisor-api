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
 * ImportError
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-10-27T12:48:48.819441954Z[Etc/UTC]")
public class ImportError {

  private Integer row;

  private String field;

  private String message;

  private String value;

  public ImportError row(Integer row) {
    this.row = row;
    return this;
  }

  /**
   * Номер строки
   * @return row
  */
  
  @Schema(name = "row", description = "Номер строки", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("row")
  public Integer getRow() {
    return row;
  }

  public void setRow(Integer row) {
    this.row = row;
  }

  public ImportError field(String field) {
    this.field = field;
    return this;
  }

  /**
   * Поле с ошибкой
   * @return field
  */
  
  @Schema(name = "field", description = "Поле с ошибкой", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("field")
  public String getField() {
    return field;
  }

  public void setField(String field) {
    this.field = field;
  }

  public ImportError message(String message) {
    this.message = message;
    return this;
  }

  /**
   * Сообщение об ошибке
   * @return message
  */
  
  @Schema(name = "message", description = "Сообщение об ошибке", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("message")
  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public ImportError value(String value) {
    this.value = value;
    return this;
  }

  /**
   * Значение, вызвавшее ошибку
   * @return value
  */
  
  @Schema(name = "value", description = "Значение, вызвавшее ошибку", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("value")
  public String getValue() {
    return value;
  }

  public void setValue(String value) {
    this.value = value;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ImportError importError = (ImportError) o;
    return Objects.equals(this.row, importError.row) &&
        Objects.equals(this.field, importError.field) &&
        Objects.equals(this.message, importError.message) &&
        Objects.equals(this.value, importError.value);
  }

  @Override
  public int hashCode() {
    return Objects.hash(row, field, message, value);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ImportError {\n");
    sb.append("    row: ").append(toIndentedString(row)).append("\n");
    sb.append("    field: ").append(toIndentedString(field)).append("\n");
    sb.append("    message: ").append(toIndentedString(message)).append("\n");
    sb.append("    value: ").append(toIndentedString(value)).append("\n");
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

