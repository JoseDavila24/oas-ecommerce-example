FROM maven:3.9.9-eclipse-temurin-25

WORKDIR /app

# Mantener el contenedor vivo para ejecutar comandos manualmente
CMD ["tail", "-f", "/dev/null"]