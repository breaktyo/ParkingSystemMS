FROM maven:3.9-eclipse-temurin-17 AS build

WORKDIR /app

# Kopiowanie plików projektu
COPY pom.xml .
COPY src ./src

# Budowanie aplikacji
RUN mvn clean package -DskipTests


# Obraz produkcyjny
FROM eclipse-temurin:17-jre-alpine

WORKDIR /app

# Kopiowanie zbudowanego JAR
COPY --from=build /app/target/sensor-service-1.0-SNAPSHOT.jar app.jar

# Eksponowanie portu gRPC
EXPOSE 50051

# Uruchomienie aplikacji
ENTRYPOINT ["java", "-jar", "app.jar"]