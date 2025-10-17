FROM eclipse-temurin:11-jdk-alpine

# Instalar Maven
RUN apk add --no-cache maven bash

WORKDIR /app

# Copiar pom.xml e baixar dependências (cache layer)
COPY pom.xml .
RUN mvn dependency:go-offline -B

# O código será montado via volume
# Comando roda Maven em modo contínuo
CMD ["mvn", "compile", "exec:java", "-Dexec.mainClass=com.firstmavenproject.App"]