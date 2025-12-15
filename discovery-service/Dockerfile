# Stage 1: Build
FROM eclipse-temurin:17-jdk-alpine AS build
WORKDIR /app

# Kopiowanie plików Maven
COPY pom.xml .
COPY src ./src

# Instalacja Maven i build aplikacji
RUN apk add --no-cache maven && \
    mvn clean package -DskipTests

# Stage 2: Runtime
FROM eclipse-temurin:17-jre-alpine
WORKDIR /app

# Kopiowanie zbudowanego JAR
COPY --from=build /app/target/discovery-service-1.0.0.jar app.jar

# Eksponowanie portu
EXPOSE 8761

# Healthcheck
HEALTHCHECK --interval=30s --timeout=3s --start-period=40s --retries=3 \
  CMD wget --quiet --tries=1 --spider http://localhost:8761/actuator/health || exit 1

# Uruchomienie aplikacji
ENTRYPOINT ["java", "-jar", "app.jar"]