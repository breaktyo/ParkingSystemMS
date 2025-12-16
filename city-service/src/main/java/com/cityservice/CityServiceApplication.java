package com.cityservice;

import com.cityservice.service.impl.CityZoneServiceImpl;
import jakarta.xml.ws.Endpoint;


public class CityServiceApplication {
    
    private static final String SERVICE_URL = "http://0.0.0.0:8081/ws/city";
    
    public static void main(String[] args) {
        System.out.println("===========================================");
        System.out.println("  City Service - Rejestr Stref Parkingowych");
        System.out.println("===========================================");
        
        try {
            CityZoneServiceImpl implementor = new CityZoneServiceImpl();
            Endpoint endpoint = Endpoint.publish(SERVICE_URL, implementor);
            
            System.out.println("\n✓ Serwis uruchomiony pomyślnie!");
            System.out.println("✓ WSDL dostępny pod adresem:");
            System.out.println("  " + SERVICE_URL + "?wsdl");
            System.out.println("\n✓ Nasłuchiwanie na porcie 8081...");
            System.out.println("✓ Aby zatrzymać serwis, naciśnij Ctrl+C");
            System.out.println("===========================================\n");
            
            Thread.currentThread().join();
            
        } catch (InterruptedException e) {
            System.err.println("\n⚠ Serwis został przerwany");
            Thread.currentThread().interrupt();
        } catch (Exception e) {
            System.err.println("\n✗ Błąd podczas uruchamiania serwisu:");
            e.printStackTrace();
            System.exit(1);
        }
    }
}