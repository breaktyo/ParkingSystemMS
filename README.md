# System Parkingu Miejskiego - Instrukcja uruchomienia

### Wymagania:
- Java 17
- Maven
- Docker Desktop

### Pierwsze uruchomienie:
1. Otwórz terminal w folderze głównym.
2. Zbuduj wszystkie moduły w każdym z folderów (oprócz frontend):
```
   mvn clean package
```
3. Uruchom cały system w Dockerze:
```
   docker compose up --build
```
4. Jeśli w Dockerze nie uruchomi się core-service oraz sensor-service, to uruchom je przez konsolę:
```
   cd sensor-service
   java -jar target/sensor-service-1.0-SNAPSHOT.jar
   cd core-service
   mvn spring-boot:run
```
5. Uruchom frontend na http://localhost:3000
```
   cd frontend
   python -m http.server 3000
```

### Adresy:
- Frontend: http://localhost:3000
- Eureka: http://localhost:8761
- RabbitMQ Management: http://localhost:15672 (guest/guest)