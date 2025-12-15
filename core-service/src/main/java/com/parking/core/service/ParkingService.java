package com.parking.core.service;

import com.parking.core.config.RabbitMQConfig;
import com.parking.core.model.ParkingSpot;
import com.parking.core.model.ReservationRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
@RequiredArgsConstructor
@Slf4j
public class ParkingService {

    private final GrpcClientService grpcClientService;
    private final SoapClientService soapClientService;
    private final RabbitTemplate rabbitTemplate;

    public Collection<ParkingSpot> getAllSpots() {
        return grpcClientService.getSpotCache().values();
    }

    public void reserveSpot(ReservationRequest request) {
        boolean isZoneValid = soapClientService.checkZoneValidity(request.getZone());
        if (!isZoneValid) {
            throw new IllegalArgumentException("Invalid zone: " + request.getZone());
        }

        ParkingSpot spot = grpcClientService.getSpotCache().get(request.getSpotId());
        if (spot == null || !"AVAILABLE".equals(spot.getStatus())) {
            throw new IllegalStateException("Spot not available: " + request.getSpotId());
        }


        rabbitTemplate.convertAndSend(
            RabbitMQConfig.EXCHANGE,
            RabbitMQConfig.ROUTING_KEY,
            request
        );
        
        log.info("Reservation sent to queue: {}", request);
    }
}