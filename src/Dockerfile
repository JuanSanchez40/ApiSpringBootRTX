FROM ubuntu:lastest AS build
RUN apt-get update
RUN apt-get install openjdk-19-jdk -y
COPY . .
RUN ./gradlew bootJar --no-daemon

FROM openjdk:19-jdk-slim
EXPOSE 9000
COPY --from=build /build/libs/backendApiMicroService-1.jar app.jar

ENTRYPOINT ["java", "-jar", "app.jar"]