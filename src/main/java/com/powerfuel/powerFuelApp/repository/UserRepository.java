package com.powerfuel.powerFuelApp.repository;


import com.powerfuel.powerFuelApp.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface UserRepository extends JpaRepository <User,Integer>{
    /*----- User Registration----*/
    @Query(value = "SELECT COUNT(*) FROM user_registration WHERE user_name=?1 ",nativeQuery = true)
    int validateStation(String user_name);




}
