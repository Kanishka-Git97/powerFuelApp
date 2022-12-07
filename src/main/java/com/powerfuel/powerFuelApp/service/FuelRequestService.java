package com.powerfuel.powerFuelApp.service;

import com.powerfuel.powerFuelApp.model.FuelRequests;

import java.util.List;

public interface FuelRequestService {
    public FuelRequests insertFuelRequest(FuelRequests fuelrequests);


    public int getRequestId(int station_id);


    public int validateStationRequest(int station_id);

    public List<Object> viewAllRequestsByStationId(int station_id);
}