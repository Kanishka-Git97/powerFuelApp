package com.powerfuel.powerFuelApp.service;

import com.powerfuel.powerFuelApp.model.Customer;
import com.powerfuel.powerFuelApp.model.Token;
import com.powerfuel.powerFuelApp.model.Vehicle;
import com.powerfuel.powerFuelApp.repository.CustomerRepository;
import com.powerfuel.powerFuelApp.repository.TokenRepository;
import com.powerfuel.powerFuelApp.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TokenImpl implements TokenService{

    @Autowired
    private TokenRepository repository;
    @Autowired
    private VehicleRepository vehicleRepository;
    @Autowired
    private CustomerRepository customerRepository;

    public String add(Token token){
        if(repository.validateVehicle(token.getVehicle()) > 0) return "already listed";
        Vehicle vehicle = vehicleRepository.findById(token.getVehicle()).orElse(null);
        if(vehicle != null){
            Customer customer = customerRepository.findById(vehicle.getCustomer()).orElse(null);
        }
        //Get Fuel Quantity in Shed
        //Todo: Need to Validate with Requested Quantity
        double fuelQty = 0.0;
        vehicle.setAvailableQuota(vehicle.getAvailableQuota() - token.getQty());
        vehicleRepository.save(vehicle);
        repository.save(token);
        return "true";
    }

    public List<Token> all(){
        return repository.findAll();
    }
    public Token get(int vehicle){
        return  repository.get(vehicle);
    }

    //Validation
    public Integer validation(int vehicle){
        return repository.validateVehicle(vehicle);
    }



}
