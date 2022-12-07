package com.powerfuel.powerFuelApp.repository;

import com.powerfuel.powerFuelApp.model.FuelRequests;
import com.powerfuel.powerFuelApp.model.FuelStation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface FuelRequestsRepository extends JpaRepository<FuelRequests,Integer> {

    /*------Update Fuel Request Table----*/
    @Transactional
    @Modifying
    @Query(value = "UPDATE fuel_requests_tb SET request_date=?1,request_status=?2 WHERE request_id=?3",nativeQuery = true)
    void updateRequest(String date,String status,int request_id);


    /*------Get Request id from selected station----*/
    @Query(value="SELECT request_id FROM fuel_requests_tb WHERE station_id=?1 AND request_status='pending'",nativeQuery = true)
    int getRequestId(int station_id);

    /*--------validate whether a request can be commenced-----*/
    @Query(value="SELECT COUNT(*) FROM fuel_requests_tb WHERE station_id=?1 AND request_status='pending'",nativeQuery = true)
    int validateStationRequest(int station_id);


    /*----View all Requests by id----*/

    @Query(value="SELECT * FROM fuel_requests_tb WHERE station_id=?1",nativeQuery = true)
    List<Object> viewAllRequestsByStationId(int station_id);



}