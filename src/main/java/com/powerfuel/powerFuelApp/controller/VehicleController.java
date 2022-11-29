package com.powerfuel.powerFuelApp.controller;

import com.powerfuel.powerFuelApp.model.Vehicle;
import com.powerfuel.powerFuelApp.model.VehicleType;
import com.powerfuel.powerFuelApp.service.VehicleService;
import com.powerfuel.powerFuelApp.service.VehicleTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/vehicle")
@CrossOrigin
public class VehicleController {
    @Autowired
    private VehicleService service;
    @Autowired
    private VehicleTypeService vehicleTypeService;

    @PostMapping("/get")
    public Vehicle get(@RequestBody int id){
        return service.getVehicle(id);
    }

    @PostMapping("/add")
    public String add(@RequestBody Vehicle vehicle){

        VehicleType selectedType = vehicleTypeService.get(vehicle.getVehicleType());
        //Update Vehicle Quota
        vehicle.setAvailableQuota(selectedType.getQuota());
        return service.save(vehicle);
    }

}
