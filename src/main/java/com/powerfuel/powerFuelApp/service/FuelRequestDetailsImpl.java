package com.powerfuel.powerFuelApp.service;

import com.powerfuel.powerFuelApp.model.FuelRequestDetails;
import com.powerfuel.powerFuelApp.model.FuelRequests;
import com.powerfuel.powerFuelApp.repository.FuelRequestDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FuelRequestDetailsImpl implements FuelRequestDetailsService {
    @Autowired
    private FuelRequestDetailsRepository repository;

    public FuelRequestDetails insertRequestDetails(FuelRequestDetails fuelrequestdetails){
        return repository.save(fuelrequestdetails);
    }

    public List<Object> getPendingList(int request_id){
        return repository.getPendingList(request_id);
    }

    public String getRequestedFuelType(int request_id){
        return repository.getRequestedFuelType(request_id);
    }

    public List<FuelRequestDetails> viewAllRequestsByStationId(int station_id){
        return repository.viewAllRequestsByStationId(station_id);
    }
}