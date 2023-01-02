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

    public List<FuelStation> getStationDetails(int station_id){
        return repository.getStationDetails(station_id);
    }
    public List<FuelStation> getAllStationDetails(){
        return repository.getAllStationDetails();
    }
    public void updateStationData(String name,String mobile,double diesel,double petrol,String status,String email){
        repository.updateStationData(name, mobile, diesel, petrol,status,email);
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
