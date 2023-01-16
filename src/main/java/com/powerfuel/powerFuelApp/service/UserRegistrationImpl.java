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


    public void updateEmployeeDetails(String name,String password,String role,String user_name,int id,String status){
        repository.updateEmployeeDetails(name, password, role, user_name, id,status);
    }

    /*---validate user and get response----*/
    public List<User> validateLogin(String user_name,String password,String company_id){
        return repository.validateLogin(user_name, password, company_id);
    }

}
