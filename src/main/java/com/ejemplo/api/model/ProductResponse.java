package com.ejemplo.api.model;

import java.net.URI;
import java.util.Objects;
import com.ejemplo.api.model.Category;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import java.time.OffsetDateTime;
import org.springframework.format.annotation.DateTimeFormat;
import org.openapitools.jackson.nullable.JsonNullable;
import java.io.Serializable;
import java.time.OffsetDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import jakarta.annotation.Generated;

/**
 * ProductResponse
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2026-03-24T11:59:02.445371599-06:00[America/Mexico_City]", comments = "Generator version: 7.5.0")
public class ProductResponse implements Serializable {

  private static final long serialVersionUID = 1L;

  private String name;

  private String description;

  private Double price;

  private Category category;

  private Boolean inStock = true;

  private String id;

  private String sku;

  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
  private OffsetDateTime createdAt;

  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
  private OffsetDateTime updatedAt;

  public ProductResponse() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public ProductResponse(String name, Double price, Category category, Boolean inStock, String id, String sku, OffsetDateTime createdAt) {
    this.name = name;
    this.price = price;
    this.category = category;
    this.inStock = inStock;
    this.id = id;
    this.sku = sku;
    this.createdAt = createdAt;
  }

  public ProductResponse name(String name) {
    this.name = name;
    return this;
  }

  /**
   * Nombre del producto
   * @return name
  */
  @NotNull @Size(min = 1, max = 200) 
  @Schema(name = "name", example = "Laptop Gaming", description = "Nombre del producto", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("name")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public ProductResponse description(String description) {
    this.description = description;
    return this;
  }

  /**
   * Descripción detallada del producto
   * @return description
  */
  @Size(max = 1000) 
  @Schema(name = "description", example = "Laptop de alto rendimiento para gaming", description = "Descripción detallada del producto", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("description")
  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public ProductResponse price(Double price) {
    this.price = price;
    return this;
  }

  /**
   * Precio del producto en USD
   * minimum: 0
   * @return price
  */
  @NotNull @DecimalMin("0") 
  @Schema(name = "price", example = "1299.99", description = "Precio del producto en USD", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("price")
  public Double getPrice() {
    return price;
  }

  public void setPrice(Double price) {
    this.price = price;
  }

  public ProductResponse category(Category category) {
    this.category = category;
    return this;
  }

  /**
   * Get category
   * @return category
  */
  @NotNull @Valid 
  @Schema(name = "category", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("category")
  public Category getCategory() {
    return category;
  }

  public void setCategory(Category category) {
    this.category = category;
  }

  public ProductResponse inStock(Boolean inStock) {
    this.inStock = inStock;
    return this;
  }

  /**
   * Indica si el producto está disponible
   * @return inStock
  */
  @NotNull 
  @Schema(name = "inStock", example = "true", description = "Indica si el producto está disponible", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("inStock")
  public Boolean getInStock() {
    return inStock;
  }

  public void setInStock(Boolean inStock) {
    this.inStock = inStock;
  }

  public ProductResponse id(String id) {
    this.id = id;
    return this;
  }

  /**
   * ID único del producto
   * @return id
  */
  @NotNull @Pattern(regexp = "^prod-[0-9]+$") 
  @Schema(name = "id", example = "prod-12345", description = "ID único del producto", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("id")
  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public ProductResponse sku(String sku) {
    this.sku = sku;
    return this;
  }

  /**
   * Código SKU del producto
   * @return sku
  */
  @NotNull 
  @Schema(name = "sku", example = "LAP-GAM-001", description = "Código SKU del producto", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("sku")
  public String getSku() {
    return sku;
  }

  public void setSku(String sku) {
    this.sku = sku;
  }

  public ProductResponse createdAt(OffsetDateTime createdAt) {
    this.createdAt = createdAt;
    return this;
  }

  /**
   * Fecha y hora de creación
   * @return createdAt
  */
  @NotNull @Valid 
  @Schema(name = "createdAt", example = "2024-01-15T10:30Z", description = "Fecha y hora de creación", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("createdAt")
  public OffsetDateTime getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(OffsetDateTime createdAt) {
    this.createdAt = createdAt;
  }

  public ProductResponse updatedAt(OffsetDateTime updatedAt) {
    this.updatedAt = updatedAt;
    return this;
  }

  /**
   * Fecha y hora de última actualización
   * @return updatedAt
  */
  @Valid 
  @Schema(name = "updatedAt", example = "2024-01-15T10:30Z", description = "Fecha y hora de última actualización", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("updatedAt")
  public OffsetDateTime getUpdatedAt() {
    return updatedAt;
  }

  public void setUpdatedAt(OffsetDateTime updatedAt) {
    this.updatedAt = updatedAt;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ProductResponse productResponse = (ProductResponse) o;
    return Objects.equals(this.name, productResponse.name) &&
        Objects.equals(this.description, productResponse.description) &&
        Objects.equals(this.price, productResponse.price) &&
        Objects.equals(this.category, productResponse.category) &&
        Objects.equals(this.inStock, productResponse.inStock) &&
        Objects.equals(this.id, productResponse.id) &&
        Objects.equals(this.sku, productResponse.sku) &&
        Objects.equals(this.createdAt, productResponse.createdAt) &&
        Objects.equals(this.updatedAt, productResponse.updatedAt);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, description, price, category, inStock, id, sku, createdAt, updatedAt);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ProductResponse {\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    price: ").append(toIndentedString(price)).append("\n");
    sb.append("    category: ").append(toIndentedString(category)).append("\n");
    sb.append("    inStock: ").append(toIndentedString(inStock)).append("\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    sku: ").append(toIndentedString(sku)).append("\n");
    sb.append("    createdAt: ").append(toIndentedString(createdAt)).append("\n");
    sb.append("    updatedAt: ").append(toIndentedString(updatedAt)).append("\n");
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

