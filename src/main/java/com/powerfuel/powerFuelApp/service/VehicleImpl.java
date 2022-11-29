package com.powerfuel.powerFuelApp.service;

import com.powerfuel.powerFuelApp.model.Vehicle;
import com.powerfuel.powerFuelApp.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VehicleImpl implements VehicleService{
    @Autowired
    private VehicleRepository repository;
    public Vehicle getVehicle(int id){
        return repository.findById(id).orElse(null);
    }

    public String save(Vehicle vehicle){
        if(repository.validate(vehicle.getRegistration(), vehicle.getChassis()) > 0) return "Duplicate";
        repository.save(vehicle);
        return "Vehicle Registered";
    }

}
