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
 * ImportWarning
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-10-21T10:36:47.145286399Z[Etc/UTC]")
public class ImportWarning {

  private Integer row;

  private String message;

  private String suggestion;

  public ImportWarning row(Integer row) {
    this.row = row;
    return this;
  }

  /**
   * Get row
   * @return row
  */
  
  @Schema(name = "row", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("row")
  public Integer getRow() {
    return row;
  }

  public void setRow(Integer row) {
    this.row = row;
  }

  public ImportWarning message(String message) {
    this.message = message;
    return this;
  }

  /**
   * Get message
   * @return message
  */
  
  @Schema(name = "message", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("message")
  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public ImportWarning suggestion(String suggestion) {
    this.suggestion = suggestion;
    return this;
  }

  /**
   * Get suggestion
   * @return suggestion
  */
  
  @Schema(name = "suggestion", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("suggestion")
  public String getSuggestion() {
    return suggestion;
  }

  public void setSuggestion(String suggestion) {
    this.suggestion = suggestion;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ImportWarning importWarning = (ImportWarning) o;
    return Objects.equals(this.row, importWarning.row) &&
        Objects.equals(this.message, importWarning.message) &&
        Objects.equals(this.suggestion, importWarning.suggestion);
  }

  @Override
  public int hashCode() {
    return Objects.hash(row, message, suggestion);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ImportWarning {\n");
    sb.append("    row: ").append(toIndentedString(row)).append("\n");
    sb.append("    message: ").append(toIndentedString(message)).append("\n");
    sb.append("    suggestion: ").append(toIndentedString(suggestion)).append("\n");
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

