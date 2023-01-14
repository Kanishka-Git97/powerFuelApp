package com.powerfuel.powerFuelApp.service;

import com.powerfuel.powerFuelApp.model.User;

import java.util.List;

public interface UserRegistrationService {
    public User userRegistration (User user);

    /*-----view all the employees for certain company---*/
    public List<User> getAllEmployees(String station_id);

    /*----get single employee details------*/
    public List<User> getSingleEmployee(int id);

    /*-----update employee details---*/
    public void updateEmployeeDetails(String name,String password,String role,String user_name,int id);

}
