package com.powerfuel.powerFuelApp.service;

import com.powerfuel.powerFuelApp.model.FuelRequests;

public interface FuelRequestService {
    public FuelRequests insertFuelRequest(FuelRequests fuelrequests);


    public int getRequestId(int station_id);


    public int validateStationRequest(int station_id);
}
