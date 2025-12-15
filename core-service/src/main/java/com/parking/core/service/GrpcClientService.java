package com.parking.core.service;

import com.parking.core.model.ParkingSpot;
import com.parking.sensor.grpc.ParkingSensorServiceGrpc;
import com.parking.sensor.grpc.SensorRequest;
import com.parking.sensor.grpc.SpotUpdate;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Service
@Slf4j
public class GrpcClientService {

    @Value("${grpc.sensor.host}")
    private String sensorHost;

    @Value("${grpc.sensor.port}")
    private int sensorPort;

    private ManagedChannel channel;
    private final Map<Long, ParkingSpot> spotCache = new ConcurrentHashMap<>();

    @PostConstruct
    public void init() {
        channel = ManagedChannelBuilder.forAddress(sensorHost, sensorPort)
                .usePlaintext()
                .build();

        ParkingSensorServiceGrpc.ParkingSensorServiceStub asyncStub = 
            ParkingSensorServiceGrpc.newStub(channel);

        asyncStub.streamSpotStatus(SensorRequest.newBuilder().build(), new StreamObserver<SpotUpdate>() {
            @Override
            public void onNext(SpotUpdate update) {
                String status = update.getIsOccupied() ? "OCCUPIED" : "AVAILABLE";
                log.info("Received spot update: id={}, occupied={}, status={}", 
                    update.getSpotId(), update.getIsOccupied(), status);
                spotCache.put((long) update.getSpotId(), 
                    new ParkingSpot((long) update.getSpotId(), status));
            }

            @Override
            public void onError(Throwable t) {
                log.error("gRPC stream error", t);
            }

            @Override
            public void onCompleted() {
                log.info("gRPC stream completed");
            }
        });

        log.info("gRPC client connected to {}:{}", sensorHost, sensorPort);
    }

    public Map<Long, ParkingSpot> getSpotCache() {
        return spotCache;
    }

    @PreDestroy
    public void shutdown() {
        if (channel != null) {
            channel.shutdown();
        }
    }
}
