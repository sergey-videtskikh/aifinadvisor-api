package com.finapp.api.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonValue;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import jakarta.annotation.Generated;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Тип ввода транзакции
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-10-27T12:48:48.819441954Z[Etc/UTC]")
public enum InputType {
  
  MANUAL("MANUAL"),
  
  IMPORT("IMPORT"),
  
  RECEIPT_SCAN("RECEIPT_SCAN");

  private String value;

  InputType(String value) {
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
  public static InputType fromValue(String value) {
    for (InputType b : InputType.values()) {
      if (b.value.equals(value)) {
        return b;
      }
    }
    throw new IllegalArgumentException("Unexpected value '" + value + "'");
  }
}

