package com.cityservice.service.impl;

import com.cityservice.service.CityZoneService;
import jakarta.jws.WebService;

/**
 * Implementacja serwisu stref parkingowych
 * Symulacja: parzyste ID = legalne, nieparzyste = nielegalne
 */
@WebService(
    endpointInterface = "com.cityservice.service.CityZoneService",
    serviceName = "CityZoneService",
    portName = "CityZonePort",
    targetNamespace = "http://service.cityservice.com/"
)
public class CityZoneServiceImpl implements CityZoneService {
    
    @Override
    public boolean checkZoneValidity(int spotId) {
        boolean isValid = (spotId % 2 == 0);
        
        System.out.println("Sprawdzono strefę ID: " + spotId + 
                         " -> " + (isValid ? "LEGALNA" : "NIELEGALNA"));
        
        return isValid;
    }
}