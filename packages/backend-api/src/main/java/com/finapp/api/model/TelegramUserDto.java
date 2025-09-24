package com.finapp.api.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import java.net.URI;
import java.util.Arrays;
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
 * TelegramUserDto
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-09-24T01:35:44.050761+03:00[Europe/Moscow]")
public class TelegramUserDto {

  private Long id;

  private String firstName;

  private JsonNullable<String> lastName = JsonNullable.<String>undefined();

  private JsonNullable<String> username = JsonNullable.<String>undefined();

  private JsonNullable<URI> photoUrl = JsonNullable.<URI>undefined();

  private Long authDate;

  private String hash;

  public TelegramUserDto() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public TelegramUserDto(Long id, String firstName, Long authDate, String hash) {
    this.id = id;
    this.firstName = firstName;
    this.authDate = authDate;
    this.hash = hash;
  }

  public TelegramUserDto id(Long id) {
    this.id = id;
    return this;
  }

  /**
   * Telegram User ID
   * @return id
  */
  @NotNull 
  @Schema(name = "id", description = "Telegram User ID", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("id")
  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public TelegramUserDto firstName(String firstName) {
    this.firstName = firstName;
    return this;
  }

  /**
   * Имя пользователя из Telegram
   * @return firstName
  */
  @NotNull 
  @Schema(name = "first_name", description = "Имя пользователя из Telegram", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("first_name")
  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public TelegramUserDto lastName(String lastName) {
    this.lastName = JsonNullable.of(lastName);
    return this;
  }

  /**
   * Фамилия пользователя из Telegram
   * @return lastName
  */
  
  @Schema(name = "last_name", description = "Фамилия пользователя из Telegram", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("last_name")
  public JsonNullable<String> getLastName() {
    return lastName;
  }

  public void setLastName(JsonNullable<String> lastName) {
    this.lastName = lastName;
  }

  public TelegramUserDto username(String username) {
    this.username = JsonNullable.of(username);
    return this;
  }

  /**
   * Username пользователя в Telegram
   * @return username
  */
  
  @Schema(name = "username", description = "Username пользователя в Telegram", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("username")
  public JsonNullable<String> getUsername() {
    return username;
  }

  public void setUsername(JsonNullable<String> username) {
    this.username = username;
  }

  public TelegramUserDto photoUrl(URI photoUrl) {
    this.photoUrl = JsonNullable.of(photoUrl);
    return this;
  }

  /**
   * URL фотографии профиля
   * @return photoUrl
  */
  @Valid 
  @Schema(name = "photo_url", description = "URL фотографии профиля", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("photo_url")
  public JsonNullable<URI> getPhotoUrl() {
    return photoUrl;
  }

  public void setPhotoUrl(JsonNullable<URI> photoUrl) {
    this.photoUrl = photoUrl;
  }

  public TelegramUserDto authDate(Long authDate) {
    this.authDate = authDate;
    return this;
  }

  /**
   * Unix timestamp авторизации
   * @return authDate
  */
  @NotNull 
  @Schema(name = "auth_date", description = "Unix timestamp авторизации", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("auth_date")
  public Long getAuthDate() {
    return authDate;
  }

  public void setAuthDate(Long authDate) {
    this.authDate = authDate;
  }

  public TelegramUserDto hash(String hash) {
    this.hash = hash;
    return this;
  }

  /**
   * Хеш для проверки подлинности данных
   * @return hash
  */
  @NotNull 
  @Schema(name = "hash", description = "Хеш для проверки подлинности данных", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("hash")
  public String getHash() {
    return hash;
  }

  public void setHash(String hash) {
    this.hash = hash;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    TelegramUserDto telegramUserDto = (TelegramUserDto) o;
    return Objects.equals(this.id, telegramUserDto.id) &&
        Objects.equals(this.firstName, telegramUserDto.firstName) &&
        equalsNullable(this.lastName, telegramUserDto.lastName) &&
        equalsNullable(this.username, telegramUserDto.username) &&
        equalsNullable(this.photoUrl, telegramUserDto.photoUrl) &&
        Objects.equals(this.authDate, telegramUserDto.authDate) &&
        Objects.equals(this.hash, telegramUserDto.hash);
  }

  private static <T> boolean equalsNullable(JsonNullable<T> a, JsonNullable<T> b) {
    return a == b || (a != null && b != null && a.isPresent() && b.isPresent() && Objects.deepEquals(a.get(), b.get()));
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, firstName, hashCodeNullable(lastName), hashCodeNullable(username), hashCodeNullable(photoUrl), authDate, hash);
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
    sb.append("class TelegramUserDto {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    firstName: ").append(toIndentedString(firstName)).append("\n");
    sb.append("    lastName: ").append(toIndentedString(lastName)).append("\n");
    sb.append("    username: ").append(toIndentedString(username)).append("\n");
    sb.append("    photoUrl: ").append(toIndentedString(photoUrl)).append("\n");
    sb.append("    authDate: ").append(toIndentedString(authDate)).append("\n");
    sb.append("    hash: ").append(toIndentedString(hash)).append("\n");
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

