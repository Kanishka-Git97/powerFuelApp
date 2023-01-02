package com.powerfuel.powerFuelApp.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "fuelAllocation")
public class FuelAllocation {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int allocationId;
    int requestID;
    Date allocatedDate;
    String stationId;
    String status;
    String fuelType;
    int requested_quantity;
    int allocated_quantity;

}
