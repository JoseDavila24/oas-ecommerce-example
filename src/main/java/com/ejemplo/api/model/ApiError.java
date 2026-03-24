package com.ejemplo.api.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import java.time.OffsetDateTime;
import java.util.HashMap;
import java.util.Map;
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
 * Estructura estándar para errores de la API
 */

@Schema(name = "ApiError", description = "Estructura estándar para errores de la API")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2026-03-24T11:59:02.445371599-06:00[America/Mexico_City]", comments = "Generator version: 7.5.0")
public class ApiError implements Serializable {

  private static final long serialVersionUID = 1L;

  /**
   * Código de error. Valores comunes en esta API: - INVALID_INPUT (400) - PRODUCT_NOT_FOUND (404) - PRODUCT_EXISTS (409 - conflicto en creación) - PRODUCT_HAS_ORDERS (409 - conflicto en eliminación) - INTERNAL_ERROR (500) 
   */
  public enum CodeEnum {
    INVALID_INPUT("INVALID_INPUT"),
    
    PRODUCT_NOT_FOUND("PRODUCT_NOT_FOUND"),
    
    PRODUCT_EXISTS("PRODUCT_EXISTS"),
    
    PRODUCT_HAS_ORDERS("PRODUCT_HAS_ORDERS"),
    
    INTERNAL_ERROR("INTERNAL_ERROR");

    private String value;

    CodeEnum(String value) {
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
    public static CodeEnum fromValue(String value) {
      for (CodeEnum b : CodeEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
  }

  private CodeEnum code;

  private String message;

  @Valid
  private Map<String, Object> details = new HashMap<>();

  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
  private OffsetDateTime timestamp;

  private String path;

  public ApiError() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public ApiError(CodeEnum code, String message, OffsetDateTime timestamp) {
    this.code = code;
    this.message = message;
    this.timestamp = timestamp;
  }

  public ApiError code(CodeEnum code) {
    this.code = code;
    return this;
  }

  /**
   * Código de error. Valores comunes en esta API: - INVALID_INPUT (400) - PRODUCT_NOT_FOUND (404) - PRODUCT_EXISTS (409 - conflicto en creación) - PRODUCT_HAS_ORDERS (409 - conflicto en eliminación) - INTERNAL_ERROR (500) 
   * @return code
  */
  @NotNull 
  @Schema(name = "code", example = "PRODUCT_NOT_FOUND", description = "Código de error. Valores comunes en esta API: - INVALID_INPUT (400) - PRODUCT_NOT_FOUND (404) - PRODUCT_EXISTS (409 - conflicto en creación) - PRODUCT_HAS_ORDERS (409 - conflicto en eliminación) - INTERNAL_ERROR (500) ", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("code")
  public CodeEnum getCode() {
    return code;
  }

  public void setCode(CodeEnum code) {
    this.code = code;
  }

  public ApiError message(String message) {
    this.message = message;
    return this;
  }

  /**
   * Mensaje descriptivo del error
   * @return message
  */
  @NotNull 
  @Schema(name = "message", example = "El producto especificado no existe", description = "Mensaje descriptivo del error", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("message")
  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public ApiError details(Map<String, Object> details) {
    this.details = details;
    return this;
  }

  public ApiError putDetailsItem(String key, Object detailsItem) {
    if (this.details == null) {
      this.details = new HashMap<>();
    }
    this.details.put(key, detailsItem);
    return this;
  }

  /**
   * Detalles adicionales del error
   * @return details
  */
  
  @Schema(name = "details", description = "Detalles adicionales del error", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("details")
  public Map<String, Object> getDetails() {
    return details;
  }

  public void setDetails(Map<String, Object> details) {
    this.details = details;
  }

  public ApiError timestamp(OffsetDateTime timestamp) {
    this.timestamp = timestamp;
    return this;
  }

  /**
   * Fecha y hora del error
   * @return timestamp
  */
  @NotNull @Valid 
  @Schema(name = "timestamp", example = "2024-01-15T10:30Z", description = "Fecha y hora del error", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("timestamp")
  public OffsetDateTime getTimestamp() {
    return timestamp;
  }

  public void setTimestamp(OffsetDateTime timestamp) {
    this.timestamp = timestamp;
  }

  public ApiError path(String path) {
    this.path = path;
    return this;
  }

  /**
   * Ruta donde ocurrió el error
   * @return path
  */
  
  @Schema(name = "path", example = "/api/v1/products/prod-12345", description = "Ruta donde ocurrió el error", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("path")
  public String getPath() {
    return path;
  }

  public void setPath(String path) {
    this.path = path;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ApiError apiError = (ApiError) o;
    return Objects.equals(this.code, apiError.code) &&
        Objects.equals(this.message, apiError.message) &&
        Objects.equals(this.details, apiError.details) &&
        Objects.equals(this.timestamp, apiError.timestamp) &&
        Objects.equals(this.path, apiError.path);
  }

  @Override
  public int hashCode() {
    return Objects.hash(code, message, details, timestamp, path);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ApiError {\n");
    sb.append("    code: ").append(toIndentedString(code)).append("\n");
    sb.append("    message: ").append(toIndentedString(message)).append("\n");
    sb.append("    details: ").append(toIndentedString(details)).append("\n");
    sb.append("    timestamp: ").append(toIndentedString(timestamp)).append("\n");
    sb.append("    path: ").append(toIndentedString(path)).append("\n");
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

