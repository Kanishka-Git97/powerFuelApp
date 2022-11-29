package com.powerfuel.powerFuelApp.service;

import com.powerfuel.powerFuelApp.model.FuelType;
import com.powerfuel.powerFuelApp.repository.FuelTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FuelTypeImpl implements FuelTypeService{
    @Autowired
    private FuelTypeRepository repository;

    public FuelType save(FuelType fueltype){return  repository.save(fueltype);}
    public FuelType getFuelType(int id){ return repository.findById(id).orElse(null); }
    public List<FuelType> getAll(){return repository.findAll();}
}
