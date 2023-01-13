package com.powerfuel.powerFuelApp.repository;


import com.powerfuel.powerFuelApp.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface UserRepository extends JpaRepository <User,Integer>{
    /*----- User Registration----*/
    @Query(value = "SELECT COUNT(*) FROM user_registration WHERE user_name=?1 ",nativeQuery = true)
    int validateStation(String user_name);

    /*------Get Employees from specific station----*/
    @Query(value = "SELECT * FROM user_registration WHERE company_id=?1 ",nativeQuery = true)
    List<User> getAllEmployees(String station_id);

    /*-------get single use details---*/
    @Query(value = "SELECT * FROM user_registration WHERE id=?1 ",nativeQuery = true)
    List<User> getSingleEmployee(int id);




}
