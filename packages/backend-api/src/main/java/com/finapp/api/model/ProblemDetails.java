package com.finapp.api.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.finapp.api.model.ProblemDetailsErrorsInner;
import java.net.URI;
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
 * ProblemDetails
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-09-24T09:51:35.301899+03:00[Europe/Moscow]")
public class ProblemDetails {

  private URI type;

  private String title;

  private Integer status;

  private String detail;

  private URI instance;

  @Valid
  private List<@Valid ProblemDetailsErrorsInner> errors;

  public ProblemDetails() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public ProblemDetails(URI type, String title, Integer status) {
    this.type = type;
    this.title = title;
    this.status = status;
  }

  public ProblemDetails type(URI type) {
    this.type = type;
    return this;
  }

  /**
   * URI идентифицирующий тип проблемы
   * @return type
  */
  @NotNull @Valid 
  @Schema(name = "type", example = "https://api.finapp.com/problems/validation-error", description = "URI идентифицирующий тип проблемы", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("type")
  public URI getType() {
    return type;
  }

  public void setType(URI type) {
    this.type = type;
  }

  public ProblemDetails title(String title) {
    this.title = title;
    return this;
  }

  /**
   * Краткое описание типа проблемы
   * @return title
  */
  @NotNull 
  @Schema(name = "title", example = "Validation Error", description = "Краткое описание типа проблемы", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("title")
  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public ProblemDetails status(Integer status) {
    this.status = status;
    return this;
  }

  /**
   * HTTP статус код
   * @return status
  */
  @NotNull 
  @Schema(name = "status", example = "400", description = "HTTP статус код", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("status")
  public Integer getStatus() {
    return status;
  }

  public void setStatus(Integer status) {
    this.status = status;
  }

  public ProblemDetails detail(String detail) {
    this.detail = detail;
    return this;
  }

  /**
   * Детальное описание проблемы
   * @return detail
  */
  
  @Schema(name = "detail", example = "Поле 'amount' должно быть положительным числом", description = "Детальное описание проблемы", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("detail")
  public String getDetail() {
    return detail;
  }

  public void setDetail(String detail) {
    this.detail = detail;
  }

  public ProblemDetails instance(URI instance) {
    this.instance = instance;
    return this;
  }

  /**
   * URI идентифицирующий конкретный случай проблемы
   * @return instance
  */
  @Valid 
  @Schema(name = "instance", example = "/api/v1/transactions/123", description = "URI идентифицирующий конкретный случай проблемы", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("instance")
  public URI getInstance() {
    return instance;
  }

  public void setInstance(URI instance) {
    this.instance = instance;
  }

  public ProblemDetails errors(List<@Valid ProblemDetailsErrorsInner> errors) {
    this.errors = errors;
    return this;
  }

  public ProblemDetails addErrorsItem(ProblemDetailsErrorsInner errorsItem) {
    if (this.errors == null) {
      this.errors = new ArrayList<>();
    }
    this.errors.add(errorsItem);
    return this;
  }

  /**
   * Детали ошибок валидации
   * @return errors
  */
  @Valid 
  @Schema(name = "errors", description = "Детали ошибок валидации", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("errors")
  public List<@Valid ProblemDetailsErrorsInner> getErrors() {
    return errors;
  }

  public void setErrors(List<@Valid ProblemDetailsErrorsInner> errors) {
    this.errors = errors;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ProblemDetails problemDetails = (ProblemDetails) o;
    return Objects.equals(this.type, problemDetails.type) &&
        Objects.equals(this.title, problemDetails.title) &&
        Objects.equals(this.status, problemDetails.status) &&
        Objects.equals(this.detail, problemDetails.detail) &&
        Objects.equals(this.instance, problemDetails.instance) &&
        Objects.equals(this.errors, problemDetails.errors);
  }

  @Override
  public int hashCode() {
    return Objects.hash(type, title, status, detail, instance, errors);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ProblemDetails {\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    title: ").append(toIndentedString(title)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    detail: ").append(toIndentedString(detail)).append("\n");
    sb.append("    instance: ").append(toIndentedString(instance)).append("\n");
    sb.append("    errors: ").append(toIndentedString(errors)).append("\n");
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

