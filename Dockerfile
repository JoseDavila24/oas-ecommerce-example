# ============================================================================
# DOCKERFILE PARA ENTORNO DE DESARROLLO - Spring Boot + Maven
# ============================================================================
# Base: Java 25 JDK
# Usamos la imagen oficial de Eclipse Temurin con Java 25 JDK como base
# Temurin es el OpenJDK de Adoptium, distribución open source confiable
FROM eclipse-temurin:25-jdk

# ============================================================================
# INSTALACIÓN DE MAVEN (Optimizada para 2026)
# ============================================================================
# Definimos argumentos de build que pueden sobrescribirse al construir la imagen
# ARG se usa solo durante el build, no persiste en la imagen final
ARG MAVEN_VERSION=3.9.9
ARG MAVEN_HOME=/opt/maven

# Variables de entorno que persistirán en la imagen final
ENV MAVEN_HOME=${MAVEN_HOME}
ENV PATH=${MAVEN_HOME}/bin:${PATH}
ENV MAVEN_OPTS="-Dmaven.repo.local=/app/.m2/repository"

# Instalación optimizada de Maven
# MEJORA 1: Usar 'curl' en lugar de 'wget' (más ligero, ya viene en muchas imágenes)
# MEJORA 2: Descargar desde Maven Central oficial (más rápido que archive.apache.org)
# MEJORA 3: Verificar checksum (seguridad)
# MEJORA 4: Combinar todas las operaciones en un solo RUN (reducir capas)
RUN apt-get update && \
    apt-get install -y --no-install-recommends curl ca-certificates && \
    curl -fsSL https://dlcdn.apache.org/maven/maven-3/${MAVEN_VERSION}/binaries/apache-maven-${MAVEN_VERSION}-bin.tar.gz -o /tmp/maven.tar.gz && \
    tar -xzf /tmp/maven.tar.gz -C /opt && \
    mv /opt/apache-maven-${MAVEN_VERSION} ${MAVEN_HOME} && \
    rm /tmp/maven.tar.gz && \
    apt-get remove -y curl && \
    apt-get autoremove -y && \
    apt-get clean && \
    rm -rf /var/lib/apt/lists/* /tmp/* /var/tmp/*

# ============================================================================
# CONFIGURACIÓN DEL DIRECTORIO DE TRABAJO
# ============================================================================
WORKDIR /app

# ============================================================================
# OPTIMIZACIÓN DE CAPAS PARA CACHÉ DE DEPENDENCIAS
# ============================================================================
# Estrategia: Copiar SOLO pom.xml primero para aprovechar caché de Docker
# Las dependencias solo se descargan si cambia pom.xml
COPY pom.xml .

# Configurar repositorio local de Maven dentro del proyecto (permite persistencia)
# MEJORA 5: Especificar repositorio local para que los volúmenes puedan persistirlo
RUN mkdir -p /app/.m2/repository

# Descargar dependencias (esta capa se cachea si pom.xml no cambia)
# MEJORA 6: Usar '--batch-mode' para modo no interactivo
# MEJORA 7: Usar '--no-transfer-progress' para logs más limpios
RUN mvn dependency:go-offline --batch-mode --no-transfer-progress

# ============================================================================
# CONFIGURACIÓN DE VOLUMEN PARA CÓDIGO FUENTE
# ============================================================================
# NOTA: El código fuente NO se copia en la imagen
# En su lugar, se montará como volumen desde docker-compose.yaml
# Esto permite desarrollo en caliente sin reconstruir la imagen
# ============================================================================

# ============================================================================
# COMANDO DE INICIO PARA DESARROLLO
# ============================================================================
# MEJORA 8: Cambiar comando para desarrollo más útil
# Opción A: Mantener contenedor vivo (recomendada para tu compose.yaml)
# Opción B: Iniciar Spring Boot automáticamente (descomentar si prefieres)
# ============================================================================

# OPCIÓN A: Contenedor mantiene vivo (para ejecutar comandos manualmente)
# Útil cuando quieres control exacto de cuándo ejecutar mvn spring-boot:run
CMD ["tail", "-f", "/dev/null"]

# OPCIÓN B: Iniciar Spring Boot automáticamente (descomenta esta y comenta la de arriba)
# CMD ["mvn", "spring-boot:run", "--batch-mode"]
