package com.powerfuel.powerFuelApp.repository;


import com.powerfuel.powerFuelApp.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

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


    /*-----update registered employees----------*/
    @Transactional
    @Modifying
    @Query(value="UPDATE user_registration SET name=?1,password=?2,role=?3,user_name=?4,status=?6 WHERE id=?5",nativeQuery = true)
    void updateEmployeeDetails(String name,String password,String role,String user_name,int id,String status);

    /*-----login related Queries starts here-------*/
    @Query(value = "SELECT * FROM user_registration WHERE user_name=?1 AND password=?2 AND company_id=?3 ",nativeQuery = true)
    List<User> validateLogin(String user_name,String password,String company_id);



}
