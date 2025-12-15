package com.parking.core.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.xml.namespace.QName;
import java.net.URL;

@Component
@Slf4j
public class SoapClientService {

    @Value("${soap.city.url}")
    private String cityServiceUrl;

    public boolean checkZoneValidity(String zone) {
        try {
            URL wsdlUrl = new URL(cityServiceUrl + "?wsdl");
            QName serviceName = new QName("http://service.city.parking.com/", "CityService");
            jakarta.xml.ws.Service service = jakarta.xml.ws.Service.create(wsdlUrl, serviceName);
            
            QName portName = new QName("http://service.city.parking.com/", "CityServicePort");
            CityServicePortType port = service.getPort(portName, CityServicePortType.class);
            
            boolean valid = port.checkZoneValidity(zone);
            log.info("SOAP zone validation for '{}': {}", zone, valid);
            return valid;
            
        } catch (Exception e) {
            log.error("SOAP call failed", e);
            return false;
        }
    }

    // Interfejs proxy dla SOAP (uproszczony)
    public interface CityServicePortType {
        boolean checkZoneValidity(String zone);
    }
}