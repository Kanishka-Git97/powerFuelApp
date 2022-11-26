package com.powerfuel.powerFuelApp.repository;

import com.powerfuel.powerFuelApp.model.FuelRequests;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface FuelRequestsRepository extends JpaRepository<FuelRequests,Integer> {

    /*------Update Fuel Request Table----*/
    @Transactional
    @Modifying
    @Query(value = "UPDATE fuel_requests_tb SET request_date=?1,request_status=?2 WHERE request_id=?3",nativeQuery = true)
    void updateRequest(String date,String status,int request_id);

}
