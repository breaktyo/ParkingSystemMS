package com.parking.sensor;

import com.parking.sensor.service.SensorServiceImpl;
import io.grpc.Server;
import io.grpc.ServerBuilder;

import java.io.IOException;
import java.util.logging.Logger;

public class SensorServer {
    
    private static final Logger logger = Logger.getLogger(SensorServer.class.getName());
    private static final int PORT = 50051;
    
    private Server server;

    public void start() throws IOException {
        server = ServerBuilder.forPort(PORT)
                .addService(new SensorServiceImpl())
                .build()
                .start();
        
        logger.info("Sensor Service started on port " + PORT);
        
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            logger.info("Shutting down gRPC server...");
            SensorServer.this.stop();
            logger.info("Server shut down.");
        }));
    }

    public void stop() {
        if (server != null) {
            server.shutdown();
        }
    }

    public void blockUntilShutdown() throws InterruptedException {
        if (server != null) {
            server.awaitTermination();
        }
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        final SensorServer server = new SensorServer();
        server.start();
        server.blockUntilShutdown();
    }
}