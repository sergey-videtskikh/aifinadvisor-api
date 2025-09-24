package com.finapp.api.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
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
 * RegisterRequest
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-09-24T12:11:35.130175186Z[Etc/UTC]")
public class RegisterRequest {

  private String login;

  private String password;

  private String firstName;

  private String lastName;

  private JsonNullable<String> phone = JsonNullable.<String>undefined();

  private JsonNullable<String> telegramNickname = JsonNullable.<String>undefined();

  public RegisterRequest() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public RegisterRequest(String login, String password, String firstName, String lastName) {
    this.login = login;
    this.password = password;
    this.firstName = firstName;
    this.lastName = lastName;
  }

  public RegisterRequest login(String login) {
    this.login = login;
    return this;
  }

  /**
   * Login (email) для входа
   * @return login
  */
  @NotNull @jakarta.validation.constraints.Email 
  @Schema(name = "login", example = "ivan.ivanov@example.com", description = "Login (email) для входа", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("login")
  public String getLogin() {
    return login;
  }

  public void setLogin(String login) {
    this.login = login;
  }

  public RegisterRequest password(String password) {
    this.password = password;
    return this;
  }

  /**
   * Пароль
   * @return password
  */
  @NotNull @Size(min = 8) 
  @Schema(name = "password", example = "SecurePassword123", description = "Пароль", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("password")
  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public RegisterRequest firstName(String firstName) {
    this.firstName = firstName;
    return this;
  }

  /**
   * Имя
   * @return firstName
  */
  @NotNull @Size(min = 2, max = 50) 
  @Schema(name = "firstName", example = "Иван", description = "Имя", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("firstName")
  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public RegisterRequest lastName(String lastName) {
    this.lastName = lastName;
    return this;
  }

  /**
   * Фамилия
   * @return lastName
  */
  @NotNull @Size(min = 2, max = 50) 
  @Schema(name = "lastName", example = "Иванов", description = "Фамилия", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("lastName")
  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public RegisterRequest phone(String phone) {
    this.phone = JsonNullable.of(phone);
    return this;
  }

  /**
   * Номер телефона
   * @return phone
  */
  
  @Schema(name = "phone", example = "+79261234567", description = "Номер телефона", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("phone")
  public JsonNullable<String> getPhone() {
    return phone;
  }

  public void setPhone(JsonNullable<String> phone) {
    this.phone = phone;
  }

  public RegisterRequest telegramNickname(String telegramNickname) {
    this.telegramNickname = JsonNullable.of(telegramNickname);
    return this;
  }

  /**
   * Telegram никнейм
   * @return telegramNickname
  */
  
  @Schema(name = "telegramNickname", example = "ivan_ivanov", description = "Telegram никнейм", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("telegramNickname")
  public JsonNullable<String> getTelegramNickname() {
    return telegramNickname;
  }

  public void setTelegramNickname(JsonNullable<String> telegramNickname) {
    this.telegramNickname = telegramNickname;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    RegisterRequest registerRequest = (RegisterRequest) o;
    return Objects.equals(this.login, registerRequest.login) &&
        Objects.equals(this.password, registerRequest.password) &&
        Objects.equals(this.firstName, registerRequest.firstName) &&
        Objects.equals(this.lastName, registerRequest.lastName) &&
        equalsNullable(this.phone, registerRequest.phone) &&
        equalsNullable(this.telegramNickname, registerRequest.telegramNickname);
  }

  private static <T> boolean equalsNullable(JsonNullable<T> a, JsonNullable<T> b) {
    return a == b || (a != null && b != null && a.isPresent() && b.isPresent() && Objects.deepEquals(a.get(), b.get()));
  }

  @Override
  public int hashCode() {
    return Objects.hash(login, password, firstName, lastName, hashCodeNullable(phone), hashCodeNullable(telegramNickname));
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
    sb.append("class RegisterRequest {\n");
    sb.append("    login: ").append(toIndentedString(login)).append("\n");
    sb.append("    password: ").append("*").append("\n");
    sb.append("    firstName: ").append(toIndentedString(firstName)).append("\n");
    sb.append("    lastName: ").append(toIndentedString(lastName)).append("\n");
    sb.append("    phone: ").append(toIndentedString(phone)).append("\n");
    sb.append("    telegramNickname: ").append(toIndentedString(telegramNickname)).append("\n");
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

