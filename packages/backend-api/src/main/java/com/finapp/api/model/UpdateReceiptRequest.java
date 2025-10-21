package com.finapp.api.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
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
 * UpdateReceiptRequest
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-10-21T10:50:17.094476136Z[Etc/UTC]")
public class UpdateReceiptRequest {

  private String description;

  private JsonNullable<UUID> transactionId = JsonNullable.<UUID>undefined();

  public UpdateReceiptRequest description(String description) {
    this.description = description;
    return this;
  }

  /**
   * Описание чека
   * @return description
  */
  
  @Schema(name = "description", description = "Описание чека", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("description")
  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public UpdateReceiptRequest transactionId(UUID transactionId) {
    this.transactionId = JsonNullable.of(transactionId);
    return this;
  }

  /**
   * ID транзакции для привязки
   * @return transactionId
  */
  @Valid 
  @Schema(name = "transactionId", description = "ID транзакции для привязки", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("transactionId")
  public JsonNullable<UUID> getTransactionId() {
    return transactionId;
  }

  public void setTransactionId(JsonNullable<UUID> transactionId) {
    this.transactionId = transactionId;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    UpdateReceiptRequest updateReceiptRequest = (UpdateReceiptRequest) o;
    return Objects.equals(this.description, updateReceiptRequest.description) &&
        equalsNullable(this.transactionId, updateReceiptRequest.transactionId);
  }

  private static <T> boolean equalsNullable(JsonNullable<T> a, JsonNullable<T> b) {
    return a == b || (a != null && b != null && a.isPresent() && b.isPresent() && Objects.deepEquals(a.get(), b.get()));
  }

  @Override
  public int hashCode() {
    return Objects.hash(description, hashCodeNullable(transactionId));
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
    sb.append("class UpdateReceiptRequest {\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    transactionId: ").append(toIndentedString(transactionId)).append("\n");
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

