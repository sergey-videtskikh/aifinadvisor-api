package com.finapp.api.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonTypeName;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import jakarta.annotation.Generated;

/**
 * PagedTransactionsResponseSort
 */

@JsonTypeName("PagedTransactionsResponse_sort")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-10-21T10:36:47.145286399Z[Etc/UTC]")
public class PagedTransactionsResponseSort {

  private Boolean empty;

  private Boolean sorted;

  private Boolean unsorted;

  public PagedTransactionsResponseSort empty(Boolean empty) {
    this.empty = empty;
    return this;
  }

  /**
   * Отсутствует ли сортировка
   * @return empty
  */
  
  @Schema(name = "empty", description = "Отсутствует ли сортировка", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("empty")
  public Boolean getEmpty() {
    return empty;
  }

  public void setEmpty(Boolean empty) {
    this.empty = empty;
  }

  public PagedTransactionsResponseSort sorted(Boolean sorted) {
    this.sorted = sorted;
    return this;
  }

  /**
   * Применена ли сортировка
   * @return sorted
  */
  
  @Schema(name = "sorted", description = "Применена ли сортировка", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("sorted")
  public Boolean getSorted() {
    return sorted;
  }

  public void setSorted(Boolean sorted) {
    this.sorted = sorted;
  }

  public PagedTransactionsResponseSort unsorted(Boolean unsorted) {
    this.unsorted = unsorted;
    return this;
  }

  /**
   * Не применена ли сортировка
   * @return unsorted
  */
  
  @Schema(name = "unsorted", description = "Не применена ли сортировка", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("unsorted")
  public Boolean getUnsorted() {
    return unsorted;
  }

  public void setUnsorted(Boolean unsorted) {
    this.unsorted = unsorted;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PagedTransactionsResponseSort pagedTransactionsResponseSort = (PagedTransactionsResponseSort) o;
    return Objects.equals(this.empty, pagedTransactionsResponseSort.empty) &&
        Objects.equals(this.sorted, pagedTransactionsResponseSort.sorted) &&
        Objects.equals(this.unsorted, pagedTransactionsResponseSort.unsorted);
  }

  @Override
  public int hashCode() {
    return Objects.hash(empty, sorted, unsorted);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PagedTransactionsResponseSort {\n");
    sb.append("    empty: ").append(toIndentedString(empty)).append("\n");
    sb.append("    sorted: ").append(toIndentedString(sorted)).append("\n");
    sb.append("    unsorted: ").append(toIndentedString(unsorted)).append("\n");
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

