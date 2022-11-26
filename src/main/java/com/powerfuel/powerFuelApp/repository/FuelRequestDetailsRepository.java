package com.powerfuel.powerFuelApp.repository;

import com.powerfuel.powerFuelApp.model.FuelRequestDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface FuelRequestDetailsRepository extends JpaRepository<FuelRequestDetails,Integer> {

    /*----Update Fuel details table-----*/
    @Transactional
    @Modifying
    @Query(value = "UPDATE fuel_request_details_tb SET status=?1 WHERE request_id=?2",nativeQuery = true)
    void updateRequestsDetails(String status,int request_id);
}
