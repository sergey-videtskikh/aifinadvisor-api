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
 * ChangePasswordRequest
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-10-27T14:18:21.767051747Z[Etc/UTC]")
public class ChangePasswordRequest {

  private String currentPassword;

  private String newPassword;

  private String confirmPassword;

  public ChangePasswordRequest() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public ChangePasswordRequest(String currentPassword, String newPassword) {
    this.currentPassword = currentPassword;
    this.newPassword = newPassword;
  }

  public ChangePasswordRequest currentPassword(String currentPassword) {
    this.currentPassword = currentPassword;
    return this;
  }

  /**
   * Текущий пароль пользователя для подтверждения
   * @return currentPassword
  */
  @NotNull 
  @Schema(name = "currentPassword", example = "currentSecretPassword123", description = "Текущий пароль пользователя для подтверждения", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("currentPassword")
  public String getCurrentPassword() {
    return currentPassword;
  }

  public void setCurrentPassword(String currentPassword) {
    this.currentPassword = currentPassword;
  }

  public ChangePasswordRequest newPassword(String newPassword) {
    this.newPassword = newPassword;
    return this;
  }

  /**
   * Новый пароль
   * @return newPassword
  */
  @NotNull @Size(min = 8, max = 128) 
  @Schema(name = "newPassword", example = "NewSecurePassword123!", description = "Новый пароль", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("newPassword")
  public String getNewPassword() {
    return newPassword;
  }

  public void setNewPassword(String newPassword) {
    this.newPassword = newPassword;
  }

  public ChangePasswordRequest confirmPassword(String confirmPassword) {
    this.confirmPassword = confirmPassword;
    return this;
  }

  /**
   * Подтверждение нового пароля
   * @return confirmPassword
  */
  
  @Schema(name = "confirmPassword", example = "NewSecurePassword123!", description = "Подтверждение нового пароля", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("confirmPassword")
  public String getConfirmPassword() {
    return confirmPassword;
  }

  public void setConfirmPassword(String confirmPassword) {
    this.confirmPassword = confirmPassword;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ChangePasswordRequest changePasswordRequest = (ChangePasswordRequest) o;
    return Objects.equals(this.currentPassword, changePasswordRequest.currentPassword) &&
        Objects.equals(this.newPassword, changePasswordRequest.newPassword) &&
        Objects.equals(this.confirmPassword, changePasswordRequest.confirmPassword);
  }

  @Override
  public int hashCode() {
    return Objects.hash(currentPassword, newPassword, confirmPassword);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ChangePasswordRequest {\n");
    sb.append("    currentPassword: ").append("*").append("\n");
    sb.append("    newPassword: ").append("*").append("\n");
    sb.append("    confirmPassword: ").append("*").append("\n");
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

