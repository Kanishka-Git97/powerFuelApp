package com.powerfuel.powerFuelApp.service;

import com.powerfuel.powerFuelApp.model.FuelType;

import java.util.List;

public interface FuelTypeService {
    public FuelType getFuelType(int id);
    public FuelType save(FuelType fueltype);
    public List<FuelType> getAll();
    public FuelType get(int id);
}
