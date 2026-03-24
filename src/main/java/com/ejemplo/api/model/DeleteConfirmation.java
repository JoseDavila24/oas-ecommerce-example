package com.ejemplo.api.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
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
 * DeleteConfirmation
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2026-03-24T11:59:02.445371599-06:00[America/Mexico_City]", comments = "Generator version: 7.5.0")
public class DeleteConfirmation implements Serializable {

  private static final long serialVersionUID = 1L;

  private String id;

  private String message;

  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
  private OffsetDateTime deletedAt;

  public DeleteConfirmation() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public DeleteConfirmation(String id, String message, OffsetDateTime deletedAt) {
    this.id = id;
    this.message = message;
    this.deletedAt = deletedAt;
  }

  public DeleteConfirmation id(String id) {
    this.id = id;
    return this;
  }

  /**
   * ID del producto eliminado
   * @return id
  */
  @NotNull 
  @Schema(name = "id", example = "prod-12345", description = "ID del producto eliminado", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("id")
  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public DeleteConfirmation message(String message) {
    this.message = message;
    return this;
  }

  /**
   * Mensaje de confirmación
   * @return message
  */
  @NotNull 
  @Schema(name = "message", example = "Producto eliminado exitosamente", description = "Mensaje de confirmación", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("message")
  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public DeleteConfirmation deletedAt(OffsetDateTime deletedAt) {
    this.deletedAt = deletedAt;
    return this;
  }

  /**
   * Fecha y hora de eliminación
   * @return deletedAt
  */
  @NotNull @Valid 
  @Schema(name = "deletedAt", example = "2024-01-15T15:45Z", description = "Fecha y hora de eliminación", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("deletedAt")
  public OffsetDateTime getDeletedAt() {
    return deletedAt;
  }

  public void setDeletedAt(OffsetDateTime deletedAt) {
    this.deletedAt = deletedAt;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    DeleteConfirmation deleteConfirmation = (DeleteConfirmation) o;
    return Objects.equals(this.id, deleteConfirmation.id) &&
        Objects.equals(this.message, deleteConfirmation.message) &&
        Objects.equals(this.deletedAt, deleteConfirmation.deletedAt);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, message, deletedAt);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class DeleteConfirmation {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    message: ").append(toIndentedString(message)).append("\n");
    sb.append("    deletedAt: ").append(toIndentedString(deletedAt)).append("\n");
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

