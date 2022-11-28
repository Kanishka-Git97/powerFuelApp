package com.powerfuel.powerFuelApp.service;

import com.powerfuel.powerFuelApp.model.FuelRequests;
import com.powerfuel.powerFuelApp.model.FuelStation;
import com.powerfuel.powerFuelApp.repository.FuelRequestsRepository;
import com.powerfuel.powerFuelApp.repository.FuelStationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FuelRequestsImpl implements FuelRequestService {
    @Autowired
    private FuelRequestsRepository repository;

    public FuelRequests insertFuelRequest(FuelRequests fuelrequests){
        return repository.save(fuelrequests);

    }

}
