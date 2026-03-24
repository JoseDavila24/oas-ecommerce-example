package com.ejemplo.api.model;

import java.net.URI;
import java.util.Objects;
import com.ejemplo.api.model.Category;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import org.openapitools.jackson.nullable.JsonNullable;
import java.io.Serializable;
import java.time.OffsetDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import jakarta.annotation.Generated;

/**
 * Product
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2026-03-24T11:59:02.445371599-06:00[America/Mexico_City]", comments = "Generator version: 7.5.0")
public class Product implements Serializable {

  private static final long serialVersionUID = 1L;

  private String name;

  private String description;

  private Double price;

  private Category category;

  private Boolean inStock = true;

  public Product() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public Product(String name, Double price, Category category) {
    this.name = name;
    this.price = price;
    this.category = category;
  }

  public Product name(String name) {
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

  public Product description(String description) {
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

  public Product price(Double price) {
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

  public Product category(Category category) {
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

  public Product inStock(Boolean inStock) {
    this.inStock = inStock;
    return this;
  }

  /**
   * Indica si el producto está disponible
   * @return inStock
  */
  
  @Schema(name = "inStock", example = "true", description = "Indica si el producto está disponible", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("inStock")
  public Boolean getInStock() {
    return inStock;
  }

  public void setInStock(Boolean inStock) {
    this.inStock = inStock;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Product product = (Product) o;
    return Objects.equals(this.name, product.name) &&
        Objects.equals(this.description, product.description) &&
        Objects.equals(this.price, product.price) &&
        Objects.equals(this.category, product.category) &&
        Objects.equals(this.inStock, product.inStock);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, description, price, category, inStock);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Product {\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    price: ").append(toIndentedString(price)).append("\n");
    sb.append("    category: ").append(toIndentedString(category)).append("\n");
    sb.append("    inStock: ").append(toIndentedString(inStock)).append("\n");
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

