# Dockerfile dla City Service
FROM eclipse-temurin:17-jdk-alpine

# Informacje o obrazie
LABEL maintainer="city-service"
LABEL description="SOAP Web Service - Rejestr Stref Parkingowych"

# Katalog roboczy
WORKDIR /app

# Kopiowanie pliku JAR (po zbudowaniu projektu)
COPY target/city-service-1.0.0.jar /app/city-service.jar

# Eksponowanie portu 8081
EXPOSE 8081

# Uruchomienie aplikacji
ENTRYPOINT ["java", "-jar", "city-service.jar"]

# Healthcheck (sprawdzenie czy WSDL jest dostępny)
HEALTHCHECK --interval=30s --timeout=3s --start-period=40s --retries=3 \
  CMD wget --quiet --tries=1 --spider http://localhost:8081/ws/city?wsdl || exit 1