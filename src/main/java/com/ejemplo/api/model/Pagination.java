package com.ejemplo.api.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import org.openapitools.jackson.nullable.JsonNullable;
import java.io.Serializable;
import java.time.OffsetDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import jakarta.annotation.Generated;

/**
 * Pagination
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2026-03-24T11:59:02.445371599-06:00[America/Mexico_City]", comments = "Generator version: 7.5.0")
public class Pagination implements Serializable {

  private static final long serialVersionUID = 1L;

  private Integer total;

  private Integer page;

  private Integer limit;

  private Integer totalPages;

  public Pagination() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public Pagination(Integer total, Integer page, Integer limit, Integer totalPages) {
    this.total = total;
    this.page = page;
    this.limit = limit;
    this.totalPages = totalPages;
  }

  public Pagination total(Integer total) {
    this.total = total;
    return this;
  }

  /**
   * Total de productos
   * minimum: 0
   * @return total
  */
  @NotNull @Min(0) 
  @Schema(name = "total", example = "150", description = "Total de productos", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("total")
  public Integer getTotal() {
    return total;
  }

  public void setTotal(Integer total) {
    this.total = total;
  }

  public Pagination page(Integer page) {
    this.page = page;
    return this;
  }

  /**
   * Página actual
   * minimum: 1
   * @return page
  */
  @NotNull @Min(1) 
  @Schema(name = "page", example = "1", description = "Página actual", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("page")
  public Integer getPage() {
    return page;
  }

  public void setPage(Integer page) {
    this.page = page;
  }

  public Pagination limit(Integer limit) {
    this.limit = limit;
    return this;
  }

  /**
   * Elementos por página
   * minimum: 1
   * maximum: 100
   * @return limit
  */
  @NotNull @Min(1) @Max(100) 
  @Schema(name = "limit", example = "20", description = "Elementos por página", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("limit")
  public Integer getLimit() {
    return limit;
  }

  public void setLimit(Integer limit) {
    this.limit = limit;
  }

  public Pagination totalPages(Integer totalPages) {
    this.totalPages = totalPages;
    return this;
  }

  /**
   * Total de páginas
   * minimum: 0
   * @return totalPages
  */
  @NotNull @Min(0) 
  @Schema(name = "totalPages", example = "8", description = "Total de páginas", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("totalPages")
  public Integer getTotalPages() {
    return totalPages;
  }

  public void setTotalPages(Integer totalPages) {
    this.totalPages = totalPages;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Pagination pagination = (Pagination) o;
    return Objects.equals(this.total, pagination.total) &&
        Objects.equals(this.page, pagination.page) &&
        Objects.equals(this.limit, pagination.limit) &&
        Objects.equals(this.totalPages, pagination.totalPages);
  }

  @Override
  public int hashCode() {
    return Objects.hash(total, page, limit, totalPages);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Pagination {\n");
    sb.append("    total: ").append(toIndentedString(total)).append("\n");
    sb.append("    page: ").append(toIndentedString(page)).append("\n");
    sb.append("    limit: ").append(toIndentedString(limit)).append("\n");
    sb.append("    totalPages: ").append(toIndentedString(totalPages)).append("\n");
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

