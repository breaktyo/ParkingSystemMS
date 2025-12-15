# Etap 1: Build
FROM maven:3.9-eclipse-temurin-17 AS build
WORKDIR /app

# Kopiowanie plików projektu
COPY pom.xml .
COPY src ./src

# Budowanie aplikacji
RUN mvn clean package -DskipTests

# Etap 2: Runtime
FROM eclipse-temurin:17-jre-alpine
WORKDIR /app

# Kopiowanie zbudowanego JAR-a
COPY --from=build /app/target/*.jar app.jar

# Eksponowanie portu (opcjonalnie, dla health endpoint)
EXPOSE 8082

# Uruchomienie aplikacji
ENTRYPOINT ["java", "-jar", "app.jar"]