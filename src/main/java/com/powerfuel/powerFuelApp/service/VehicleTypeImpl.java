package com.powerfuel.powerFuelApp.service;

import com.powerfuel.powerFuelApp.model.VehicleType;
import com.powerfuel.powerFuelApp.repository.VehicleTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehicleTypeImpl implements VehicleTypeService{
    @Autowired
    private VehicleTypeRepository repository;

    public VehicleType save(VehicleType vehicleType){return  repository.save(vehicleType);}
    public List<VehicleType> all(){
        return  repository.findAll();
    }
    public VehicleType get(int id){
        return repository.findById(id).orElse(null);
    }
}
