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
 * Currency
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-10-27T12:48:48.819441954Z[Etc/UTC]")
public class Currency {

  private String code;

  private String name;

  private String symbol;

  public Currency code(String code) {
    this.code = code;
    return this;
  }

  /**
   * Код валюты ISO-4217
   * @return code
  */
  @Pattern(regexp = "^[A-Z]{3}$") 
  @Schema(name = "code", example = "RUB", description = "Код валюты ISO-4217", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("code")
  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public Currency name(String name) {
    this.name = name;
    return this;
  }

  /**
   * Название валюты
   * @return name
  */
  
  @Schema(name = "name", example = "Российский рубль", description = "Название валюты", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("name")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Currency symbol(String symbol) {
    this.symbol = symbol;
    return this;
  }

  /**
   * Символ валюты
   * @return symbol
  */
  
  @Schema(name = "symbol", example = "₽", description = "Символ валюты", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("symbol")
  public String getSymbol() {
    return symbol;
  }

  public void setSymbol(String symbol) {
    this.symbol = symbol;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Currency currency = (Currency) o;
    return Objects.equals(this.code, currency.code) &&
        Objects.equals(this.name, currency.name) &&
        Objects.equals(this.symbol, currency.symbol);
  }

  @Override
  public int hashCode() {
    return Objects.hash(code, name, symbol);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Currency {\n");
    sb.append("    code: ").append(toIndentedString(code)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    symbol: ").append(toIndentedString(symbol)).append("\n");
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

