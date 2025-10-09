package com.finapp.api.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonTypeName;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import jakarta.annotation.Generated;

/**
 * ProblemDetailsErrorsInner
 */

@JsonTypeName("ProblemDetails_errors_inner")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-10-09T21:12:14.599634+03:00[Europe/Moscow]")
public class ProblemDetailsErrorsInner {

  private String field;

  private String message;

  private String code;

  public ProblemDetailsErrorsInner field(String field) {
    this.field = field;
    return this;
  }

  /**
   * Поле с ошибкой
   * @return field
  */
  
  @Schema(name = "field", example = "amount", description = "Поле с ошибкой", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("field")
  public String getField() {
    return field;
  }

  public void setField(String field) {
    this.field = field;
  }

  public ProblemDetailsErrorsInner message(String message) {
    this.message = message;
    return this;
  }

  /**
   * Сообщение об ошибке
   * @return message
  */
  
  @Schema(name = "message", example = "должно быть положительным числом", description = "Сообщение об ошибке", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("message")
  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public ProblemDetailsErrorsInner code(String code) {
    this.code = code;
    return this;
  }

  /**
   * Код ошибки
   * @return code
  */
  
  @Schema(name = "code", example = "POSITIVE_NUMBER_REQUIRED", description = "Код ошибки", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("code")
  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ProblemDetailsErrorsInner problemDetailsErrorsInner = (ProblemDetailsErrorsInner) o;
    return Objects.equals(this.field, problemDetailsErrorsInner.field) &&
        Objects.equals(this.message, problemDetailsErrorsInner.message) &&
        Objects.equals(this.code, problemDetailsErrorsInner.code);
  }

  @Override
  public int hashCode() {
    return Objects.hash(field, message, code);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ProblemDetailsErrorsInner {\n");
    sb.append("    field: ").append(toIndentedString(field)).append("\n");
    sb.append("    message: ").append(toIndentedString(message)).append("\n");
    sb.append("    code: ").append(toIndentedString(code)).append("\n");
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

