package com.powerfuel.powerFuelApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.fasterxml.jackson.annotation.JsonProperty.Access;

public interface AccessRepository extends JpaRepository <Access,Integer> {
         /*----- User Access----*/
         @Query(value = "SELECT COUNT(*) FROM access_tbl WHERE name=?1 ",nativeQuery = true)
         int validateStation(String name);
    
    
}
