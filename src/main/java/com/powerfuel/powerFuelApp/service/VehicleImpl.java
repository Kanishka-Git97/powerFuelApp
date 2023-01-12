package com.powerfuel.powerFuelApp.service;

import com.powerfuel.powerFuelApp.model.Vehicle;
import com.powerfuel.powerFuelApp.model.VehicleType;
import com.powerfuel.powerFuelApp.repository.VehicleRepository;
import com.powerfuel.powerFuelApp.repository.VehicleTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class VehicleImpl implements VehicleService{
    @Autowired
    private VehicleRepository repository;
    @Autowired
    private VehicleTypeRepository vehicleTypeRepository;
    public Vehicle getVehicle(int id){
        return repository.findById(id).orElse(null);
    }

    public String save(Vehicle vehicle){
        if(repository.validate(vehicle.getRegistration(), vehicle.getChassis()) > 0) return "Duplicate";
        repository.save(vehicle);
        return "Vehicle Registered";
    }

    public List<Vehicle> getVehiclesByOwner(int customer){
       return repository.getVehiclesByOwner(customer);
    }

    public String updateFuel(){
        Date today = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("dd");
        SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd");
        String fullToday = dateFormatter.format(today);


        String date = formatter.format(today);
        System.out.println(fullToday);
        if(date.equals("10")){

            List<Vehicle> vehicles = repository.findAll();
            int i = 0;
            int length = vehicles.size();
            while(i < length){
                Vehicle vehicle = vehicles.get(i);
                if(vehicle.getLastUpdate().equals(fullToday)){
                    return "Already Refreshed";
                }
                VehicleType vehicleType = vehicleTypeRepository.findById(vehicle.getVehicleType()).orElse(null);
                double fuelQty = vehicleType.getQuota();
                vehicle.setAvailableQuota(fuelQty);
                repository.save(vehicle);
                i++;
            }
            return "Successfully Updated";
        }
        else{
            return "Today is Not 1st of Month";
        }

    }
}
