package com.powerfuel.powerFuelApp.service;

import com.powerfuel.powerFuelApp.model.User;
import com.powerfuel.powerFuelApp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserRegistrationImpl implements UserRegistrationService {
    @Autowired
    private UserRepository repository;
    public User userRegistration (User user){
        return repository.save(user);
    }

    public List<User> getAllEmployees(String station_id){
        return repository.getAllEmployees(station_id);
    }

    /*----get single employee details---*/
    public List<User> getSingleEmployee(int id){
        return  repository.getSingleEmployee(id);
    }

}
