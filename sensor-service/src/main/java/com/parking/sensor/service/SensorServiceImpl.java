package com.parking.sensor.service;

import com.parking.sensor.grpc.ParkingSensorServiceGrpc;
import com.parking.sensor.grpc.SensorRequest;
import com.parking.sensor.grpc.SpotUpdate;
import io.grpc.stub.StreamObserver;

import java.util.Random;
import java.util.logging.Logger;

public class SensorServiceImpl extends ParkingSensorServiceGrpc.ParkingSensorServiceImplBase {
    
    private static final Logger logger = Logger.getLogger(SensorServiceImpl.class.getName());
    private static final Random random = new Random();
    private static final int MIN_SPOT_ID = 1;
    private static final int MAX_SPOT_ID = 10;
    private static final int STREAM_INTERVAL_MS = 2000;

    @Override
    public void streamSpotStatus(SensorRequest request, StreamObserver<SpotUpdate> responseObserver) {
        logger.info("Starting spot status stream for sensor: " + request.getSensorId());
        
        try {
            while (true) {
                int spotId = MIN_SPOT_ID + random.nextInt(MAX_SPOT_ID);
                
                boolean isOccupied = random.nextBoolean();
                
                SpotUpdate update = SpotUpdate.newBuilder()
                        .setSpotId(spotId)
                        .setIsOccupied(isOccupied)
                        .build();
                
                responseObserver.onNext(update);
                logger.info(String.format("Sent update: Spot %d is %s", 
                        spotId, isOccupied ? "OCCUPIED" : "FREE"));
                
                Thread.sleep(STREAM_INTERVAL_MS);
            }
        } catch (InterruptedException e) {
            logger.warning("Stream interrupted: " + e.getMessage());
            Thread.currentThread().interrupt();
        } catch (Exception e) {
            logger.severe("Error in stream: " + e.getMessage());
            responseObserver.onError(e);
            return;
        }
        
        responseObserver.onCompleted();
    }
}