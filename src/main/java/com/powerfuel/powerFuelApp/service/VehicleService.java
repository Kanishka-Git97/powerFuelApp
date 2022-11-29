package com.powerfuel.powerFuelApp.service;

import com.powerfuel.powerFuelApp.model.Vehicle;

public interface VehicleService {
    public Vehicle getVehicle(int id);
    public String save(Vehicle vehicle);
}
