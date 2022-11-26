package com.powerfuel.powerFuelApp.service;

import com.powerfuel.powerFuelApp.model.District;
import com.powerfuel.powerFuelApp.repository.DistrictRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DistrictImpl implements DistrictService{
    @Autowired
    private DistrictRepository repository;

    public List<District> getDistricts(){
        return repository.findAll();
    }
}
