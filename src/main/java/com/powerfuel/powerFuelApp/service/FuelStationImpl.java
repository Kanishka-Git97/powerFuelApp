package com.powerfuel.powerFuelApp.service;

import com.powerfuel.powerFuelApp.model.FuelStation;
import com.powerfuel.powerFuelApp.repository.FuelStationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FuelStationImpl implements FuelStationService {
    @Autowired
    private FuelStationRepository repositoory;

    public FuelStation registerFuelStation(FuelStation fuelstation){
        return repositoory.save(fuelstation);
    }

}
