# Etapa de build
FROM ubuntu:22.04 AS build

RUN apt-get update && \
    apt-get install -y openjdk-21-jdk

# Directorio de trabajo
WORKDIR /app

# Copiamos todo el proyecto
COPY . .

RUN chmod +x gradlew
RUN ./gradlew bootJar --no-daemon

# Etapa de runtime
# Opción 1: Amazon Corretto (recomendado en tu caso)
FROM amazoncorretto:21

# Opción 2 alternativa por si prefieres Temurin:
# FROM eclipse-temurin:21-jre-jammy

WORKDIR /app
EXPOSE 8080

# Ajusta el nombre del JAR si cambia (asegúrate que este nombre es correcto)
COPY --from=build /app/build/libs/backendApiMicroService-1.jar app.jar

ENTRYPOINT ["java", "-jar", "app.jar"]
