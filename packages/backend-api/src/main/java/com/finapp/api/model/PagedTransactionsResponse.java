package com.finapp.api.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.finapp.api.model.PagedTransactionsResponseSort;
import com.finapp.api.model.TransactionDto;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import jakarta.annotation.Generated;

/**
 * PagedTransactionsResponse
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-09-24T17:10:51.802634+03:00[Europe/Moscow]")
public class PagedTransactionsResponse {

  @Valid
  private List<@Valid TransactionDto> content;

  private Long totalElements;

  private Integer totalPages;

  private Integer size;

  private Integer number;

  private Integer numberOfElements;

  private Boolean first;

  private Boolean last;

  private Boolean empty;

  private PagedTransactionsResponseSort sort;

  public PagedTransactionsResponse content(List<@Valid TransactionDto> content) {
    this.content = content;
    return this;
  }

  public PagedTransactionsResponse addContentItem(TransactionDto contentItem) {
    if (this.content == null) {
      this.content = new ArrayList<>();
    }
    this.content.add(contentItem);
    return this;
  }

  /**
   * Массив транзакций на текущей странице
   * @return content
  */
  @Valid 
  @Schema(name = "content", description = "Массив транзакций на текущей странице", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("content")
  public List<@Valid TransactionDto> getContent() {
    return content;
  }

  public void setContent(List<@Valid TransactionDto> content) {
    this.content = content;
  }

  public PagedTransactionsResponse totalElements(Long totalElements) {
    this.totalElements = totalElements;
    return this;
  }

  /**
   * Общее количество транзакций
   * @return totalElements
  */
  
  @Schema(name = "totalElements", example = "150", description = "Общее количество транзакций", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("totalElements")
  public Long getTotalElements() {
    return totalElements;
  }

  public void setTotalElements(Long totalElements) {
    this.totalElements = totalElements;
  }

  public PagedTransactionsResponse totalPages(Integer totalPages) {
    this.totalPages = totalPages;
    return this;
  }

  /**
   * Общее количество страниц
   * @return totalPages
  */
  
  @Schema(name = "totalPages", example = "8", description = "Общее количество страниц", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("totalPages")
  public Integer getTotalPages() {
    return totalPages;
  }

  public void setTotalPages(Integer totalPages) {
    this.totalPages = totalPages;
  }

  public PagedTransactionsResponse size(Integer size) {
    this.size = size;
    return this;
  }

  /**
   * Размер страницы
   * @return size
  */
  
  @Schema(name = "size", example = "20", description = "Размер страницы", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("size")
  public Integer getSize() {
    return size;
  }

  public void setSize(Integer size) {
    this.size = size;
  }

  public PagedTransactionsResponse number(Integer number) {
    this.number = number;
    return this;
  }

  /**
   * Номер текущей страницы (начиная с 0)
   * @return number
  */
  
  @Schema(name = "number", example = "0", description = "Номер текущей страницы (начиная с 0)", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("number")
  public Integer getNumber() {
    return number;
  }

  public void setNumber(Integer number) {
    this.number = number;
  }

  public PagedTransactionsResponse numberOfElements(Integer numberOfElements) {
    this.numberOfElements = numberOfElements;
    return this;
  }

  /**
   * Количество элементов на текущей странице
   * @return numberOfElements
  */
  
  @Schema(name = "numberOfElements", example = "20", description = "Количество элементов на текущей странице", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("numberOfElements")
  public Integer getNumberOfElements() {
    return numberOfElements;
  }

  public void setNumberOfElements(Integer numberOfElements) {
    this.numberOfElements = numberOfElements;
  }

  public PagedTransactionsResponse first(Boolean first) {
    this.first = first;
    return this;
  }

  /**
   * Первая ли это страница
   * @return first
  */
  
  @Schema(name = "first", example = "true", description = "Первая ли это страница", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("first")
  public Boolean getFirst() {
    return first;
  }

  public void setFirst(Boolean first) {
    this.first = first;
  }

  public PagedTransactionsResponse last(Boolean last) {
    this.last = last;
    return this;
  }

  /**
   * Последняя ли это страница
   * @return last
  */
  
  @Schema(name = "last", example = "false", description = "Последняя ли это страница", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("last")
  public Boolean getLast() {
    return last;
  }

  public void setLast(Boolean last) {
    this.last = last;
  }

  public PagedTransactionsResponse empty(Boolean empty) {
    this.empty = empty;
    return this;
  }

  /**
   * Пустая ли текущая страница
   * @return empty
  */
  
  @Schema(name = "empty", example = "false", description = "Пустая ли текущая страница", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("empty")
  public Boolean getEmpty() {
    return empty;
  }

  public void setEmpty(Boolean empty) {
    this.empty = empty;
  }

  public PagedTransactionsResponse sort(PagedTransactionsResponseSort sort) {
    this.sort = sort;
    return this;
  }

  /**
   * Get sort
   * @return sort
  */
  @Valid 
  @Schema(name = "sort", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("sort")
  public PagedTransactionsResponseSort getSort() {
    return sort;
  }

  public void setSort(PagedTransactionsResponseSort sort) {
    this.sort = sort;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PagedTransactionsResponse pagedTransactionsResponse = (PagedTransactionsResponse) o;
    return Objects.equals(this.content, pagedTransactionsResponse.content) &&
        Objects.equals(this.totalElements, pagedTransactionsResponse.totalElements) &&
        Objects.equals(this.totalPages, pagedTransactionsResponse.totalPages) &&
        Objects.equals(this.size, pagedTransactionsResponse.size) &&
        Objects.equals(this.number, pagedTransactionsResponse.number) &&
        Objects.equals(this.numberOfElements, pagedTransactionsResponse.numberOfElements) &&
        Objects.equals(this.first, pagedTransactionsResponse.first) &&
        Objects.equals(this.last, pagedTransactionsResponse.last) &&
        Objects.equals(this.empty, pagedTransactionsResponse.empty) &&
        Objects.equals(this.sort, pagedTransactionsResponse.sort);
  }

  @Override
  public int hashCode() {
    return Objects.hash(content, totalElements, totalPages, size, number, numberOfElements, first, last, empty, sort);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PagedTransactionsResponse {\n");
    sb.append("    content: ").append(toIndentedString(content)).append("\n");
    sb.append("    totalElements: ").append(toIndentedString(totalElements)).append("\n");
    sb.append("    totalPages: ").append(toIndentedString(totalPages)).append("\n");
    sb.append("    size: ").append(toIndentedString(size)).append("\n");
    sb.append("    number: ").append(toIndentedString(number)).append("\n");
    sb.append("    numberOfElements: ").append(toIndentedString(numberOfElements)).append("\n");
    sb.append("    first: ").append(toIndentedString(first)).append("\n");
    sb.append("    last: ").append(toIndentedString(last)).append("\n");
    sb.append("    empty: ").append(toIndentedString(empty)).append("\n");
    sb.append("    sort: ").append(toIndentedString(sort)).append("\n");
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

