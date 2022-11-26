package com.powerfuel.powerFuelApp.service;

import com.powerfuel.powerFuelApp.model.FuelRequestDetails;
import com.powerfuel.powerFuelApp.repository.FuelRequestDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FuelRequestDetailsImpl implements FuelRequestDetailsService {
    @Autowired
    private FuelRequestDetailsRepository repository;

    public FuelRequestDetails insertRequestDetails(FuelRequestDetails fuelrequestdetails){
        return repository.save(fuelrequestdetails);
    }
}
