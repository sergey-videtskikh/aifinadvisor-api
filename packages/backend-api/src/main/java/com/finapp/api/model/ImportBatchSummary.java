package com.finapp.api.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import java.time.OffsetDateTime;
import java.util.UUID;
import org.springframework.format.annotation.DateTimeFormat;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import jakarta.annotation.Generated;

/**
 * ImportBatchSummary
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-10-21T10:36:47.145286399Z[Etc/UTC]")
public class ImportBatchSummary {

  private UUID importId;

  private String filename;

  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
  private OffsetDateTime uploadedAt;

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

  private Integer successCount;

  private Integer errorCount;

  private Integer totalCount;

  public ImportBatchSummary importId(UUID importId) {
    this.importId = importId;
    return this;
  }

  /**
   * Get importId
   * @return importId
  */
  @Valid 
  @Schema(name = "importId", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("importId")
  public UUID getImportId() {
    return importId;
  }

  public void setImportId(UUID importId) {
    this.importId = importId;
  }

  public ImportBatchSummary filename(String filename) {
    this.filename = filename;
    return this;
  }

  /**
   * Get filename
   * @return filename
  */
  
  @Schema(name = "filename", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("filename")
  public String getFilename() {
    return filename;
  }

  public void setFilename(String filename) {
    this.filename = filename;
  }

  public ImportBatchSummary uploadedAt(OffsetDateTime uploadedAt) {
    this.uploadedAt = uploadedAt;
    return this;
  }

  /**
   * Get uploadedAt
   * @return uploadedAt
  */
  @Valid 
  @Schema(name = "uploadedAt", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("uploadedAt")
  public OffsetDateTime getUploadedAt() {
    return uploadedAt;
  }

  public void setUploadedAt(OffsetDateTime uploadedAt) {
    this.uploadedAt = uploadedAt;
  }

  public ImportBatchSummary status(StatusEnum status) {
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

  public ImportBatchSummary successCount(Integer successCount) {
    this.successCount = successCount;
    return this;
  }

  /**
   * Get successCount
   * @return successCount
  */
  
  @Schema(name = "successCount", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("successCount")
  public Integer getSuccessCount() {
    return successCount;
  }

  public void setSuccessCount(Integer successCount) {
    this.successCount = successCount;
  }

  public ImportBatchSummary errorCount(Integer errorCount) {
    this.errorCount = errorCount;
    return this;
  }

  /**
   * Get errorCount
   * @return errorCount
  */
  
  @Schema(name = "errorCount", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("errorCount")
  public Integer getErrorCount() {
    return errorCount;
  }

  public void setErrorCount(Integer errorCount) {
    this.errorCount = errorCount;
  }

  public ImportBatchSummary totalCount(Integer totalCount) {
    this.totalCount = totalCount;
    return this;
  }

  /**
   * Get totalCount
   * @return totalCount
  */
  
  @Schema(name = "totalCount", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("totalCount")
  public Integer getTotalCount() {
    return totalCount;
  }

  public void setTotalCount(Integer totalCount) {
    this.totalCount = totalCount;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ImportBatchSummary importBatchSummary = (ImportBatchSummary) o;
    return Objects.equals(this.importId, importBatchSummary.importId) &&
        Objects.equals(this.filename, importBatchSummary.filename) &&
        Objects.equals(this.uploadedAt, importBatchSummary.uploadedAt) &&
        Objects.equals(this.status, importBatchSummary.status) &&
        Objects.equals(this.successCount, importBatchSummary.successCount) &&
        Objects.equals(this.errorCount, importBatchSummary.errorCount) &&
        Objects.equals(this.totalCount, importBatchSummary.totalCount);
  }

  @Override
  public int hashCode() {
    return Objects.hash(importId, filename, uploadedAt, status, successCount, errorCount, totalCount);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ImportBatchSummary {\n");
    sb.append("    importId: ").append(toIndentedString(importId)).append("\n");
    sb.append("    filename: ").append(toIndentedString(filename)).append("\n");
    sb.append("    uploadedAt: ").append(toIndentedString(uploadedAt)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    successCount: ").append(toIndentedString(successCount)).append("\n");
    sb.append("    errorCount: ").append(toIndentedString(errorCount)).append("\n");
    sb.append("    totalCount: ").append(toIndentedString(totalCount)).append("\n");
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

