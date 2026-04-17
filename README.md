### Prerrequisitos
- **Docker Desktop** instalado y funcionando (descargar de [docker.com](https://www.docker.com/products/docker-desktop/)).
- Tener el repositorio clonado localmente.

> **Nota sobre los comandos:**  
> Docker Compose V2 utiliza `docker compose` (sin guion) como plugin de la CLI de Docker. Si tu instalación es muy antigua y aún usas Compose V1, el comando sería `docker-compose` (con guion). En esta guía se emplea la sintaxis moderna **`docker compose`**.

---

### 1. Construir la imagen y levantar el contenedor
Abre una terminal (PowerShell, cmd, bash) en la raíz del proyecto y ejecuta:

```bash
docker compose up -d --build
```

- `--build` reconstruye la imagen desde el Dockerfile (la primera vez tardará unos minutos porque descarga Java, Maven y las dependencias del proyecto).
- `-d` ejecuta el contenedor en segundo plano (*detached*), para que no bloquees la terminal.

Si todo va bien, verás los logs de construcción y luego un mensaje indicando que el contenedor está corriendo.

---

### 2. Acceder al contenedor para ejecutar comandos Maven
El contenedor está en funcionamiento, pero necesitas una terminal dentro de él para ejecutar `mvn`. Usa:

```bash
docker compose exec dev bash
```

Esto te dejará dentro del contenedor, en la carpeta `/app` (tu código está montado allí). Desde aquí puedes ejecutar cualquier comando Maven:

```bash
# Ejemplos:
mvn generate-sources
mvn clean generate-sources
mvn spring-boot:run
```

- Al ejecutar `mvn spring-boot:run`, la aplicación arrancará y estará disponible en **http://localhost:8080** desde tu navegador o Postman.
- Para detener el proceso de Spring Boot, presiona `Ctrl + C`.

---

### 3. Salir del contenedor sin detenerlo
Cuando termines de usar la terminal, escribe:

```bash
exit
```

El contenedor sigue corriendo en segundo plano. Puedes volver a entrar cuando quieras con `docker compose exec dev bash`.

---

### 4. Detener el contenedor
Cuando ya no necesites el entorno, puedes detener el contenedor con:

```bash
docker compose down
```

Esto detiene y elimina el contenedor, **pero mantiene la imagen construida**. Si vuelves a levantar el entorno después, no necesitarás reconstruir la imagen (a menos que modifiques el Dockerfile).

---

### 5. ¿Qué hacer con la imagen? ¿La borro o la dejo?

- **Dejarla construida** es recomendable si vas a seguir trabajando en el proyecto. La próxima vez que ejecutes `docker compose up -d` (sin `--build`) arrancará inmediatamente sin reconstruir.
- **Para liberar espacio**, puedes eliminar la imagen después de detener el contenedor:
  ```bash
  docker compose down --rmi all   # elimina contenedor e imagen asociada
  ```
  O, si prefieres borrar manualmente:
  ```bash
  docker image rm oas-ecommerce-example-dev
  ```
- Si tienes muchas imágenes sin usar, puedes limpiar todas las no utilizadas con:
  ```bash
  docker image prune -a
  ```
  (Esto eliminará imágenes que no estén siendo usadas por ningún contenedor, incluyendo esta si el contenedor ya está detenido).

---

### Consejos adicionales

- **Recarga automática (hot reload)**: si agregas la dependencia `spring-boot-devtools` en tu `pom.xml`, al ejecutar `mvn spring-boot:run` los cambios en el código se recargarán automáticamente (sin necesidad de reiniciar manualmente).
- **Puerto personalizado**: si tu aplicación usa otro puerto (ej. 9090), modifica el mapeo en `docker-compose.yml` cambiando `"8080:8080"` por `"9090:9090"` (o el que corresponda).
- **Problemas con permisos en Linux/macOS**: si usas Linux o macOS, puede que necesites ajustar permisos del volumen. En Windows no suele haber inconvenientes.

---

### Resumen de comandos rápidos

| Acción | Comando |
|--------|--------|
| Construir y levantar contenedor | `docker compose up -d --build` |
| Entrar al contenedor | `docker compose exec dev bash` |
| Detener contenedor (manteniendo imagen) | `docker compose down` |
| Detener y eliminar también la imagen | `docker compose down --rmi all` |

---

Si tu instalación de Docker es anterior a la integración de Compose V2 y debes usar el comando con guion, simplemente reemplaza `docker compose` por `docker-compose` en todos los ejemplos.
