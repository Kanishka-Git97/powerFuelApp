package com.powerfuel.powerFuelApp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class FuelDispatchDTO {

    private int dispatchID;
    private int allocationID;
    private String dispatchDate;
    private String transportUnit;
    private String expectedDeliveryTime;
    private int fuelQty;
    private String status;
}
