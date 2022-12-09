package com.powerfuel.powerFuelApp.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "FuelDispatch")
public class FuelDispatch {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int dispatchID;
    private int allocationID;
    private String dispatchDate;
    private String transportUnit;
    private String expectedDeliveryTime;
    private int fuelQty;
    private String status;





}
