package com.powerfuel.powerFuelApp.service;

import com.powerfuel.powerFuelApp.model.Vehicle;

import java.util.List;

public interface VehicleService {
    public Vehicle getVehicle(int id);
    public String save(Vehicle vehicle);
    public List<Vehicle> getVehiclesByOwner(int customer);
}
