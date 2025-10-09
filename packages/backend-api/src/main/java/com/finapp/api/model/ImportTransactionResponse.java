package com.finapp.api.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.finapp.api.model.ImportError;
import com.finapp.api.model.ImportWarning;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import jakarta.annotation.Generated;

/**
 * ImportTransactionResponse
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-10-09T19:39:04.913677996Z[Etc/UTC]")
public class ImportTransactionResponse {

  private UUID importId;

  private Integer successCount;

  private Integer errorCount;

  private Integer warningCount;

  @Valid
  private List<@Valid ImportError> errors;

  @Valid
  private List<@Valid ImportWarning> warnings;

  private String processingTime;

  /**
   * Gets or Sets status
   */
  public enum StatusEnum {
    COMPLETED("COMPLETED"),
    
    COMPLETED_WITH_ERRORS("COMPLETED_WITH_ERRORS"),
    
    FAILED("FAILED");

    private String value;

    StatusEnum(String value) {
      this.value = value;
    }

    @JsonValue
    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static StatusEnum fromValue(String value) {
      for (StatusEnum b : StatusEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
  }

  private StatusEnum status;

  public ImportTransactionResponse importId(UUID importId) {
    this.importId = importId;
    return this;
  }

  /**
   * ID импорта
   * @return importId
  */
  @Valid 
  @Schema(name = "importId", description = "ID импорта", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("importId")
  public UUID getImportId() {
    return importId;
  }

  public void setImportId(UUID importId) {
    this.importId = importId;
  }

  public ImportTransactionResponse successCount(Integer successCount) {
    this.successCount = successCount;
    return this;
  }

  /**
   * Количество успешно импортированных записей
   * @return successCount
  */
  
  @Schema(name = "successCount", description = "Количество успешно импортированных записей", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("successCount")
  public Integer getSuccessCount() {
    return successCount;
  }

  public void setSuccessCount(Integer successCount) {
    this.successCount = successCount;
  }

  public ImportTransactionResponse errorCount(Integer errorCount) {
    this.errorCount = errorCount;
    return this;
  }

  /**
   * Количество записей с ошибками
   * @return errorCount
  */
  
  @Schema(name = "errorCount", description = "Количество записей с ошибками", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("errorCount")
  public Integer getErrorCount() {
    return errorCount;
  }

  public void setErrorCount(Integer errorCount) {
    this.errorCount = errorCount;
  }

  public ImportTransactionResponse warningCount(Integer warningCount) {
    this.warningCount = warningCount;
    return this;
  }

  /**
   * Количество записей с предупреждениями
   * @return warningCount
  */
  
  @Schema(name = "warningCount", description = "Количество записей с предупреждениями", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("warningCount")
  public Integer getWarningCount() {
    return warningCount;
  }

  public void setWarningCount(Integer warningCount) {
    this.warningCount = warningCount;
  }

  public ImportTransactionResponse errors(List<@Valid ImportError> errors) {
    this.errors = errors;
    return this;
  }

  public ImportTransactionResponse addErrorsItem(ImportError errorsItem) {
    if (this.errors == null) {
      this.errors = new ArrayList<>();
    }
    this.errors.add(errorsItem);
    return this;
  }

  /**
   * Get errors
   * @return errors
  */
  @Valid 
  @Schema(name = "errors", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("errors")
  public List<@Valid ImportError> getErrors() {
    return errors;
  }

  public void setErrors(List<@Valid ImportError> errors) {
    this.errors = errors;
  }

  public ImportTransactionResponse warnings(List<@Valid ImportWarning> warnings) {
    this.warnings = warnings;
    return this;
  }

  public ImportTransactionResponse addWarningsItem(ImportWarning warningsItem) {
    if (this.warnings == null) {
      this.warnings = new ArrayList<>();
    }
    this.warnings.add(warningsItem);
    return this;
  }

  /**
   * Get warnings
   * @return warnings
  */
  @Valid 
  @Schema(name = "warnings", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("warnings")
  public List<@Valid ImportWarning> getWarnings() {
    return warnings;
  }

  public void setWarnings(List<@Valid ImportWarning> warnings) {
    this.warnings = warnings;
  }

  public ImportTransactionResponse processingTime(String processingTime) {
    this.processingTime = processingTime;
    return this;
  }

  /**
   * Время обработки
   * @return processingTime
  */
  
  @Schema(name = "processingTime", description = "Время обработки", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("processingTime")
  public String getProcessingTime() {
    return processingTime;
  }

  public void setProcessingTime(String processingTime) {
    this.processingTime = processingTime;
  }

  public ImportTransactionResponse status(StatusEnum status) {
    this.status = status;
    return this;
  }

  /**
   * Get status
   * @return status
  */
  
  @Schema(name = "status", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("status")
  public StatusEnum getStatus() {
    return status;
  }

  public void setStatus(StatusEnum status) {
    this.status = status;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ImportTransactionResponse importTransactionResponse = (ImportTransactionResponse) o;
    return Objects.equals(this.importId, importTransactionResponse.importId) &&
        Objects.equals(this.successCount, importTransactionResponse.successCount) &&
        Objects.equals(this.errorCount, importTransactionResponse.errorCount) &&
        Objects.equals(this.warningCount, importTransactionResponse.warningCount) &&
        Objects.equals(this.errors, importTransactionResponse.errors) &&
        Objects.equals(this.warnings, importTransactionResponse.warnings) &&
        Objects.equals(this.processingTime, importTransactionResponse.processingTime) &&
        Objects.equals(this.status, importTransactionResponse.status);
  }

  @Override
  public int hashCode() {
    return Objects.hash(importId, successCount, errorCount, warningCount, errors, warnings, processingTime, status);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ImportTransactionResponse {\n");
    sb.append("    importId: ").append(toIndentedString(importId)).append("\n");
    sb.append("    successCount: ").append(toIndentedString(successCount)).append("\n");
    sb.append("    errorCount: ").append(toIndentedString(errorCount)).append("\n");
    sb.append("    warningCount: ").append(toIndentedString(warningCount)).append("\n");
    sb.append("    errors: ").append(toIndentedString(errors)).append("\n");
    sb.append("    warnings: ").append(toIndentedString(warnings)).append("\n");
    sb.append("    processingTime: ").append(toIndentedString(processingTime)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
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

