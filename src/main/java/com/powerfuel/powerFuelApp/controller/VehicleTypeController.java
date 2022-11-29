package com.powerfuel.powerFuelApp.controller;

import com.powerfuel.powerFuelApp.model.VehicleType;
import com.powerfuel.powerFuelApp.service.VehicleTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vehicletype")
@CrossOrigin
public class VehicleTypeController {
    @Autowired
    private VehicleTypeService service;

    @PostMapping("/add")
    public VehicleType add(@RequestBody VehicleType vehicleType){
        return service.save(vehicleType);
    }

    @GetMapping("/all")
    public List<VehicleType> all(){
        return service.all();
    }
}
