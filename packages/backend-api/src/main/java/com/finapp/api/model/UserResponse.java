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
 * UserResponse
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-09-24T20:42:31.196223853Z[Etc/UTC]")
public class UserResponse {

  private UUID id;

  private String email;

  private String firstName;

  private String lastName;

  private JsonNullable<String> phoneNumber = JsonNullable.<String>undefined();

  private JsonNullable<String> telegramNickname = JsonNullable.<String>undefined();

  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
  private OffsetDateTime createdAt;

  private Boolean isEmailVerified;

  private String defaultCurrency = "RUB";

  public UserResponse id(UUID id) {
    this.id = id;
    return this;
  }

  /**
   * User ID
   * @return id
  */
  @Valid 
  @Schema(name = "id", description = "User ID", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("id")
  public UUID getId() {
    return id;
  }

  public void setId(UUID id) {
    this.id = id;
  }

  public UserResponse email(String email) {
    this.email = email;
    return this;
  }

  /**
   * Email пользователя
   * @return email
  */
  @jakarta.validation.constraints.Email 
  @Schema(name = "email", description = "Email пользователя", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("email")
  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public UserResponse firstName(String firstName) {
    this.firstName = firstName;
    return this;
  }

  /**
   * Имя пользователя
   * @return firstName
  */
  
  @Schema(name = "firstName", description = "Имя пользователя", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("firstName")
  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public UserResponse lastName(String lastName) {
    this.lastName = lastName;
    return this;
  }

  /**
   * Фамилия пользователя
   * @return lastName
  */
  
  @Schema(name = "lastName", description = "Фамилия пользователя", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("lastName")
  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public UserResponse phoneNumber(String phoneNumber) {
    this.phoneNumber = JsonNullable.of(phoneNumber);
    return this;
  }

  /**
   * Номер телефона
   * @return phoneNumber
  */
  
  @Schema(name = "phoneNumber", description = "Номер телефона", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("phoneNumber")
  public JsonNullable<String> getPhoneNumber() {
    return phoneNumber;
  }

  public void setPhoneNumber(JsonNullable<String> phoneNumber) {
    this.phoneNumber = phoneNumber;
  }

  public UserResponse telegramNickname(String telegramNickname) {
    this.telegramNickname = JsonNullable.of(telegramNickname);
    return this;
  }

  /**
   * Telegram никнейм
   * @return telegramNickname
  */
  
  @Schema(name = "telegramNickname", description = "Telegram никнейм", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("telegramNickname")
  public JsonNullable<String> getTelegramNickname() {
    return telegramNickname;
  }

  public void setTelegramNickname(JsonNullable<String> telegramNickname) {
    this.telegramNickname = telegramNickname;
  }

  public UserResponse createdAt(OffsetDateTime createdAt) {
    this.createdAt = createdAt;
    return this;
  }

  /**
   * Дата создания аккаунта
   * @return createdAt
  */
  @Valid 
  @Schema(name = "createdAt", description = "Дата создания аккаунта", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("createdAt")
  public OffsetDateTime getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(OffsetDateTime createdAt) {
    this.createdAt = createdAt;
  }

  public UserResponse isEmailVerified(Boolean isEmailVerified) {
    this.isEmailVerified = isEmailVerified;
    return this;
  }

  /**
   * Подтвержден ли email
   * @return isEmailVerified
  */
  
  @Schema(name = "isEmailVerified", description = "Подтвержден ли email", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("isEmailVerified")
  public Boolean getIsEmailVerified() {
    return isEmailVerified;
  }

  public void setIsEmailVerified(Boolean isEmailVerified) {
    this.isEmailVerified = isEmailVerified;
  }

  public UserResponse defaultCurrency(String defaultCurrency) {
    this.defaultCurrency = defaultCurrency;
    return this;
  }

  /**
   * Валюта по умолчанию (ISO-4217)
   * @return defaultCurrency
  */
  @Pattern(regexp = "^[A-Z]{3}$") 
  @Schema(name = "defaultCurrency", description = "Валюта по умолчанию (ISO-4217)", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("defaultCurrency")
  public String getDefaultCurrency() {
    return defaultCurrency;
  }

  public void setDefaultCurrency(String defaultCurrency) {
    this.defaultCurrency = defaultCurrency;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    UserResponse userResponse = (UserResponse) o;
    return Objects.equals(this.id, userResponse.id) &&
        Objects.equals(this.email, userResponse.email) &&
        Objects.equals(this.firstName, userResponse.firstName) &&
        Objects.equals(this.lastName, userResponse.lastName) &&
        equalsNullable(this.phoneNumber, userResponse.phoneNumber) &&
        equalsNullable(this.telegramNickname, userResponse.telegramNickname) &&
        Objects.equals(this.createdAt, userResponse.createdAt) &&
        Objects.equals(this.isEmailVerified, userResponse.isEmailVerified) &&
        Objects.equals(this.defaultCurrency, userResponse.defaultCurrency);
  }

  private static <T> boolean equalsNullable(JsonNullable<T> a, JsonNullable<T> b) {
    return a == b || (a != null && b != null && a.isPresent() && b.isPresent() && Objects.deepEquals(a.get(), b.get()));
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, email, firstName, lastName, hashCodeNullable(phoneNumber), hashCodeNullable(telegramNickname), createdAt, isEmailVerified, defaultCurrency);
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
    sb.append("class UserResponse {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    email: ").append(toIndentedString(email)).append("\n");
    sb.append("    firstName: ").append(toIndentedString(firstName)).append("\n");
    sb.append("    lastName: ").append(toIndentedString(lastName)).append("\n");
    sb.append("    phoneNumber: ").append(toIndentedString(phoneNumber)).append("\n");
    sb.append("    telegramNickname: ").append(toIndentedString(telegramNickname)).append("\n");
    sb.append("    createdAt: ").append(toIndentedString(createdAt)).append("\n");
    sb.append("    isEmailVerified: ").append(toIndentedString(isEmailVerified)).append("\n");
    sb.append("    defaultCurrency: ").append(toIndentedString(defaultCurrency)).append("\n");
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

