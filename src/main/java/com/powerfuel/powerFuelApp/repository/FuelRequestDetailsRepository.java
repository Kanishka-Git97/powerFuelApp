package com.powerfuel.powerFuelApp.repository;

import com.powerfuel.powerFuelApp.model.FuelRequestDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;

public interface FuelRequestDetailsRepository extends JpaRepository<FuelRequestDetails,Integer> {

    /*----Update Fuel details table-----*/
    @Transactional
    @Modifying
    @Query(value = "UPDATE fuel_request_details_tb SET status=?1 WHERE request_id=?2",nativeQuery = true)
    void updateRequestsDetails(String status,int request_id);

    /*------Get pending types from request details table-----*/
    @Query(value="SELECT fuel_type,status FROM fuel_request_details_tb WHERE request_id=?1 AND status='pending'",nativeQuery = true)
    List<Object> getPendingList(int request_id);

    /*-----------get already requested fuel type--------*/
    @Query(value="SELECT fuel_type FROM fuel_request_details_tb WHERE request_id=?1 AND status='pending'",nativeQuery = true)
    String getRequestedFuelType(int request_id);


}