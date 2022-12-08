package com.powerfuel.powerFuelApp.repository;

import com.powerfuel.powerFuelApp.model.FuelRequestDetails;
import com.powerfuel.powerFuelApp.model.FuelRequests;
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



    /*----View all Requests by id----*/

//    @Query(value="SELECT * FROM fuel_request_details_tb inner join fuel_requests_tb on fuel_request_details_tb.request_id=fuel_requests_tb.request_id WHERE fuel_requests_tb.station_id=?1",nativeQuery = true)
//    List<FuelRequestDetails> viewAllRequestsByStationId(int station_id);

    @Query(value="SELECT * FROM fuel_request_details_tb,fuel_requests_tb WHERE fuel_request_details_tb.request_id=fuel_requests_tb.request_id AND fuel_requests_tb.station_id=?1",nativeQuery = true)
    List<FuelRequestDetails> viewAllRequestsByStationId(int station_id);


}