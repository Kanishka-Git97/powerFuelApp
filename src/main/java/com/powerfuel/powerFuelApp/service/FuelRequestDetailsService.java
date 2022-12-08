package com.powerfuel.powerFuelApp.service;

import com.powerfuel.powerFuelApp.model.FuelRequestDetails;

import java.util.List;

public interface FuelRequestDetailsService {

    public FuelRequestDetails insertRequestDetails(FuelRequestDetails fuelrequestdetails);

    public List<Object> getPendingList(int request_id);

    public String getRequestedFuelType(int request_id);

    public List<FuelRequestDetails> viewAllRequestsByStationId(int station_id);
}