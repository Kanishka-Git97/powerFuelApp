package com.powerfuel.powerFuelApp.repository;

import com.powerfuel.powerFuelApp.model.FuelStation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;

public interface FuelStationRepository extends JpaRepository<FuelStation,Integer> {
    /*---View Station Details-----*/
    @Query(value="SELECT * FROM fuel_station WHERE id=?1",nativeQuery = true)
    List<FuelStation> getStationDetails(int station_id);

    /*------Update Fuel Station table------*/
    @Transactional
    @Modifying
    @Query(value="UPDATE fuel_station SET name=?1,mobile=?2,email=?3,diesel_capacity=?4,petrol_capacity=?5 WHERE id like ?6",nativeQuery = true)
    void updateStationData(String name,String mobile,String email,double diesel,double petrol,int id);

    /*---------Close Station-----*/
    @Transactional
    @Modifying
    @Query(value = "UPDATE fuel_station SET status=?1 WHERE id like ?2",nativeQuery = true)
    void closeStation(String status,int id);


    /*----Get Current Capacity----both petrol and diesel--*/
    @Query(value ="SELECT petrol_capacity,diesel_capacity FROM fuel_station WHERE id=?1",nativeQuery = true)
    List<Objects> getCurrentCapacity(int id);



}
