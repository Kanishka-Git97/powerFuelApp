package com.powerfuel.powerFuelApp.service;

import com.powerfuel.powerFuelApp.model.FuelStation;
import com.powerfuel.powerFuelApp.repository.FuelStationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class FuelStationImpl implements FuelStationService {
    @Autowired
    private FuelStationRepository repository;

    public FuelStation registerFuelStation(FuelStation fuelstation){
        return repository.save(fuelstation);
    }

    public List<FuelStation> getAllStationDetails(){
        return repository.getAllStationDetails();
    }

    public void updateStationData(String address,double diesel,int district,String email,String mobile,String name,double petrol,String status,int id){
        repository.updateStationData(address, diesel, district, email, mobile, name, petrol, status, id);
    }

    public void closeStation(String status,int id){
        repository.closeStation(status, id);
    }

    public List<Objects> getCurrentCapacity(int id){
        return repository.getCurrentCapacity(id);
    }

    public int validateStation(String email){
        return repository.validateStation(email);
    }

    public List<FuelStation> getNearestStations(int district){return repository.getNearestStations(district);}
    public FuelStation getStation(int id){return repository.findById(id).orElse(null);}

    public List<FuelStation> getSingleStationDetails(int id){
        return repository.getSingleStationDetails(id);
    }

}
