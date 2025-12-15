package com.parking.workerservice.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class ReservationListener {
    
    private static final Logger logger = LoggerFactory.getLogger(ReservationListener.class);
    
    @RabbitListener(queues = "parking.reservations")
    public void processReservation(ReservationRequest request) {
        try {
            logger.info(
                "Otrzymano rezerwację: spotId={}, userId={}, zone={}",
                request.getSpotId(),
                request.getUserId(),
                request.getZone()
            );
            
            // Symulacja przetwarzania
            Thread.sleep(2000);
            
            // Wyciągnięcie numeru miejsca z komunikatu (zakładając format JSON lub prosty tekst)
            //String parkingSpot = extractParkingSpot(message);
            
            System.out.println(" [x] Przetworzono rezerwację dla miejsca {}. Potwierdzenie wysłane.", request.getSpotId());
            logger.info(
                "Rezerwacja miejsca {} zakończona sukcesem",
                request.getSpotId()
            );
            
        } catch (InterruptedException e) {
            logger.error("Błąd podczas przetwarzania rezerwacji", e);
            Thread.currentThread().interrupt();
        }
    }
    
    private String extractParkingSpot(String message) {
        // Prosta ekstrakcja - dostosuj do formatu Twoich komunikatów
        // Jeśli message to JSON: {"parkingSpot": "A12", ...}
        if (message.contains("parkingSpot")) {
            int start = message.indexOf("parkingSpot") + 15;
            int end = message.indexOf("\"", start);
            return message.substring(start, end);
        }
        return "UNKNOWN";
    }
}