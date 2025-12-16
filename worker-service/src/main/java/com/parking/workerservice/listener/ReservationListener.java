package com.parking.workerservice.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class ReservationListener {
    
    private static final Logger logger = LoggerFactory.getLogger(ReservationListener.class);
    
    @RabbitListener(queues = "parking.reservations")
    public void processReservation(String request) {
        try {
            logger.info(
                "Otrzymano rezerwację: {}", request
            );
            
            Thread.sleep(2000);
            
        
            
            //System.out.println(" [x] Przetworzono rezerwację dla miejsca {}. Potwierdzenie wysłane.", request);
            logger.info(
                "Rezerwacja miejsca {} zakończona sukcesem",
                request
            );
            
        } catch (InterruptedException e) {
            logger.error("Błąd podczas przetwarzania rezerwacji", e);
            Thread.currentThread().interrupt();
        }
    }
    
    private String extractParkingSpot(String message) {
        if (message.contains("parkingSpot")) {
            int start = message.indexOf("parkingSpot") + 15;
            int end = message.indexOf("\"", start);
            return message.substring(start, end);
        }
        return "UNKNOWN";
    }
}