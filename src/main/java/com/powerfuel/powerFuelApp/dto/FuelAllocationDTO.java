package com.powerfuel.powerFuelApp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class FuelAllocationDTO {

    int allocationId;
    int requestID;
    String allocatedDate;
    String stationId;
    String status;
    String fuelType;
    int requested_quantity;
    int allocated_quantity;

}
