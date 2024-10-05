FROM ubuntu:latest AS build
COPY . .
RUN gradle clean package -DskipTests

FROM openjdk:19
COPY --from=build /build/libs/backendApiMicroService-1.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]