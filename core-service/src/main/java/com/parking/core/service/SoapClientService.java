package com.parking.core.service;

import com.parking.core.soapclient.CityZoneService_Service; // the Service class
import com.parking.core.soapclient.CityZoneService;     
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.net.URL;
import javax.xml.namespace.QName;

@Component
@Slf4j
public class SoapClientService {

    @Value("${soap.city.url}")
    private String cityServiceUrl;

    public boolean checkZoneValidity(String zone) {
        try {
            // Use the generated Service class directly
            int zoneId = Integer.parseInt(zone);
            URL wsdlUrl = new URL(cityServiceUrl + "?wsdl");
            QName serviceName = new QName("http://service.cityservice.com/", "CityZoneService");

            CityZoneService_Service service = new CityZoneService_Service(wsdlUrl, serviceName);

            CityZoneService port = service.getCityZonePort();

            boolean valid = port.checkZoneValidity(zoneId);
            log.info("SOAP zone validation for '{}': {}", zoneId, valid);
            return valid;

        } catch (Exception e) {
            log.error("SOAP call failed", e);
            return false;
        }
    }
}
