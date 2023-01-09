package com.powerfuel.powerFuelApp.service;

import com.powerfuel.powerFuelApp.model.VehicleType;

import java.util.List;

public interface VehicleTypeService {
    public VehicleType save(VehicleType vehicleType);
    public List<VehicleType> all();
    public VehicleType get(int id);
}
