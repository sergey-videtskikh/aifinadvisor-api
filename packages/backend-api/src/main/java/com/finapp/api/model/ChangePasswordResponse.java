package com.finapp.api.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import java.time.OffsetDateTime;
import java.util.Arrays;
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
 * ChangePasswordResponse
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-09-24T20:42:31.196223853Z[Etc/UTC]")
public class ChangePasswordResponse {

  private Boolean success;

  private String message;

  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
  private OffsetDateTime changedAt;

  private JsonNullable<String> newToken = JsonNullable.<String>undefined();

  public ChangePasswordResponse success(Boolean success) {
    this.success = success;
    return this;
  }

  /**
   * Флаг успешного изменения пароля
   * @return success
  */
  
  @Schema(name = "success", example = "true", description = "Флаг успешного изменения пароля", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("success")
  public Boolean getSuccess() {
    return success;
  }

  public void setSuccess(Boolean success) {
    this.success = success;
  }

  public ChangePasswordResponse message(String message) {
    this.message = message;
    return this;
  }

  /**
   * Сообщение об успешном изменении пароля
   * @return message
  */
  
  @Schema(name = "message", example = "Пароль успешно изменен", description = "Сообщение об успешном изменении пароля", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("message")
  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public ChangePasswordResponse changedAt(OffsetDateTime changedAt) {
    this.changedAt = changedAt;
    return this;
  }

  /**
   * Дата и время изменения пароля
   * @return changedAt
  */
  @Valid 
  @Schema(name = "changedAt", example = "2024-03-15T14:30Z", description = "Дата и время изменения пароля", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("changedAt")
  public OffsetDateTime getChangedAt() {
    return changedAt;
  }

  public void setChangedAt(OffsetDateTime changedAt) {
    this.changedAt = changedAt;
  }

  public ChangePasswordResponse newToken(String newToken) {
    this.newToken = JsonNullable.of(newToken);
    return this;
  }

  /**
   * Новый JWT токен, если требуется обновление сессии
   * @return newToken
  */
  
  @Schema(name = "newToken", description = "Новый JWT токен, если требуется обновление сессии", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("newToken")
  public JsonNullable<String> getNewToken() {
    return newToken;
  }

  public void setNewToken(JsonNullable<String> newToken) {
    this.newToken = newToken;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ChangePasswordResponse changePasswordResponse = (ChangePasswordResponse) o;
    return Objects.equals(this.success, changePasswordResponse.success) &&
        Objects.equals(this.message, changePasswordResponse.message) &&
        Objects.equals(this.changedAt, changePasswordResponse.changedAt) &&
        equalsNullable(this.newToken, changePasswordResponse.newToken);
  }

  private static <T> boolean equalsNullable(JsonNullable<T> a, JsonNullable<T> b) {
    return a == b || (a != null && b != null && a.isPresent() && b.isPresent() && Objects.deepEquals(a.get(), b.get()));
  }

  @Override
  public int hashCode() {
    return Objects.hash(success, message, changedAt, hashCodeNullable(newToken));
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
    sb.append("class ChangePasswordResponse {\n");
    sb.append("    success: ").append(toIndentedString(success)).append("\n");
    sb.append("    message: ").append(toIndentedString(message)).append("\n");
    sb.append("    changedAt: ").append(toIndentedString(changedAt)).append("\n");
    sb.append("    newToken: ").append(toIndentedString(newToken)).append("\n");
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

