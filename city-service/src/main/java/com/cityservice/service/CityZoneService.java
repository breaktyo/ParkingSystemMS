package com.cityservice.service;

import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebService;
import jakarta.jws.soap.SOAPBinding;


@WebService(name = "CityZoneService", targetNamespace = "http://service.cityservice.com/")
@SOAPBinding(style = SOAPBinding.Style.RPC)
public interface CityZoneService {
    
    @WebMethod
    boolean checkZoneValidity(@WebParam(name = "spotId") int spotId);
}