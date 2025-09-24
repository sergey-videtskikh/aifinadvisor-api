package com.finapp.api.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import java.time.OffsetDateTime;
import java.util.Arrays;
import java.util.UUID;
import org.openapitools.jackson.nullable.JsonNullable;
import org.springframework.format.annotation.DateTimeFormat;
import java.util.NoSuchElementException;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import jakarta.annotation.Generated;

/**
 * ReceiptResponse
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-09-24T17:10:51.802634+03:00[Europe/Moscow]")
public class ReceiptResponse {

  private UUID id;

  private String filename;

  private String originalFilename;

  private String contentType;

  private Integer fileSize;

  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
  private OffsetDateTime uploadedAt;

  private JsonNullable<UUID> transactionId = JsonNullable.<UUID>undefined();

  private JsonNullable<String> description = JsonNullable.<String>undefined();

  private String downloadUrl;

  public ReceiptResponse id(UUID id) {
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

  public ReceiptResponse filename(String filename) {
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

  public ReceiptResponse originalFilename(String originalFilename) {
    this.originalFilename = originalFilename;
    return this;
  }

  /**
   * Get originalFilename
   * @return originalFilename
  */
  
  @Schema(name = "originalFilename", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("originalFilename")
  public String getOriginalFilename() {
    return originalFilename;
  }

  public void setOriginalFilename(String originalFilename) {
    this.originalFilename = originalFilename;
  }

  public ReceiptResponse contentType(String contentType) {
    this.contentType = contentType;
    return this;
  }

  /**
   * Get contentType
   * @return contentType
  */
  
  @Schema(name = "contentType", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("contentType")
  public String getContentType() {
    return contentType;
  }

  public void setContentType(String contentType) {
    this.contentType = contentType;
  }

  public ReceiptResponse fileSize(Integer fileSize) {
    this.fileSize = fileSize;
    return this;
  }

  /**
   * Get fileSize
   * @return fileSize
  */
  
  @Schema(name = "fileSize", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("fileSize")
  public Integer getFileSize() {
    return fileSize;
  }

  public void setFileSize(Integer fileSize) {
    this.fileSize = fileSize;
  }

  public ReceiptResponse uploadedAt(OffsetDateTime uploadedAt) {
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

  public ReceiptResponse transactionId(UUID transactionId) {
    this.transactionId = JsonNullable.of(transactionId);
    return this;
  }

  /**
   * Get transactionId
   * @return transactionId
  */
  @Valid 
  @Schema(name = "transactionId", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("transactionId")
  public JsonNullable<UUID> getTransactionId() {
    return transactionId;
  }

  public void setTransactionId(JsonNullable<UUID> transactionId) {
    this.transactionId = transactionId;
  }

  public ReceiptResponse description(String description) {
    this.description = JsonNullable.of(description);
    return this;
  }

  /**
   * Get description
   * @return description
  */
  
  @Schema(name = "description", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("description")
  public JsonNullable<String> getDescription() {
    return description;
  }

  public void setDescription(JsonNullable<String> description) {
    this.description = description;
  }

  public ReceiptResponse downloadUrl(String downloadUrl) {
    this.downloadUrl = downloadUrl;
    return this;
  }

  /**
   * URL для скачивания
   * @return downloadUrl
  */
  
  @Schema(name = "downloadUrl", description = "URL для скачивания", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("downloadUrl")
  public String getDownloadUrl() {
    return downloadUrl;
  }

  public void setDownloadUrl(String downloadUrl) {
    this.downloadUrl = downloadUrl;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ReceiptResponse receiptResponse = (ReceiptResponse) o;
    return Objects.equals(this.id, receiptResponse.id) &&
        Objects.equals(this.filename, receiptResponse.filename) &&
        Objects.equals(this.originalFilename, receiptResponse.originalFilename) &&
        Objects.equals(this.contentType, receiptResponse.contentType) &&
        Objects.equals(this.fileSize, receiptResponse.fileSize) &&
        Objects.equals(this.uploadedAt, receiptResponse.uploadedAt) &&
        equalsNullable(this.transactionId, receiptResponse.transactionId) &&
        equalsNullable(this.description, receiptResponse.description) &&
        Objects.equals(this.downloadUrl, receiptResponse.downloadUrl);
  }

  private static <T> boolean equalsNullable(JsonNullable<T> a, JsonNullable<T> b) {
    return a == b || (a != null && b != null && a.isPresent() && b.isPresent() && Objects.deepEquals(a.get(), b.get()));
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, filename, originalFilename, contentType, fileSize, uploadedAt, hashCodeNullable(transactionId), hashCodeNullable(description), downloadUrl);
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
    sb.append("class ReceiptResponse {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    filename: ").append(toIndentedString(filename)).append("\n");
    sb.append("    originalFilename: ").append(toIndentedString(originalFilename)).append("\n");
    sb.append("    contentType: ").append(toIndentedString(contentType)).append("\n");
    sb.append("    fileSize: ").append(toIndentedString(fileSize)).append("\n");
    sb.append("    uploadedAt: ").append(toIndentedString(uploadedAt)).append("\n");
    sb.append("    transactionId: ").append(toIndentedString(transactionId)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    downloadUrl: ").append(toIndentedString(downloadUrl)).append("\n");
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

