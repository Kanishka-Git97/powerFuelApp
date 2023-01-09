package com.powerfuel.powerFuelApp.repository;

import com.powerfuel.powerFuelApp.model.FuelStation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;

public interface FuelStationRepository extends JpaRepository<FuelStation,Integer> {
    /*-----Validate Station Registration----*/
    @Query(value = "SELECT COUNT(*) FROM fuel_station WHERE email=?1 ",nativeQuery = true)
    int validateStation(String email);


    /*---View Station Details-----*/
    @Query(value="SELECT * FROM fuel_station WHERE id=?1",nativeQuery = true)
    List<FuelStation> getStationDetails(int station_id);

    /*---View Station Details-----*/
    @Query(value="SELECT * FROM fuel_station",nativeQuery = true)
    List<FuelStation> getAllStationDetails();

    /*------Update Fuel Station table------*/
    @Transactional
    @Modifying
    @Query(value="UPDATE fuel_station SET address=?1,diesel_capacity=?2,district=?3,email=?4,mobile=?5,name=?6,petrol_capacity=?7,status=?8 WHERE id like ?9",nativeQuery = true)
    void updateStationData(String address,double diesel,int district,String email,String mobile,String name,double petrol,String status,int id);

    /*---------Close Station-----*/
    @Transactional
    @Modifying
    @Query(value = "UPDATE fuel_station SET status=?1 WHERE id like ?2",nativeQuery = true)
    void closeStation(String status,int id);


    /*----Get Current Capacity----both petrol and diesel--*/
    @Query(value ="SELECT petrol_capacity,diesel_capacity FROM fuel_station WHERE id=?1",nativeQuery = true)
    List<Objects> getCurrentCapacity(int id);

    @Query(value = "SELECT * FROM fuel_station WHERE district=?1 AND status='Open'", nativeQuery = true)
    List<FuelStation> getNearestStations(int district);

    /*---------Select one station by its id------------------*/
    @Query(value="SELECT * FROM fuel_station WHERE id=?1",nativeQuery = true)
    List<FuelStation> getSingleStationDetails(int id);


}
