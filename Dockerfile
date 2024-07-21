# Etapa 1: Construccion
FROM maven:3.9.8-eclipse-temurin-17 AS build
WORKDIR /app
COPY . /app
RUN mvn clean package

# Etapa 2: Crear la imagen de ejecucion
FROM eclipse-temurin:17.0.11_9-jre
WORKDIR /app
COPY --from=build /app/boot/target/boot-0.0.1-SNAPSHOT.jar ./app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
