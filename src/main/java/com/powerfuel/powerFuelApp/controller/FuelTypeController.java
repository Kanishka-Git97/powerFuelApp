package com.powerfuel.powerFuelApp.controller;

import com.fasterxml.jackson.databind.node.ObjectNode;
import com.powerfuel.powerFuelApp.model.FuelType;
import com.powerfuel.powerFuelApp.service.FuelTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/fueltype")
@CrossOrigin
public class FuelTypeController {
    @Autowired
    private FuelTypeService service;

    @PostMapping("/add")
    public FuelType add(@RequestBody FuelType fuelType){
        return  service.save(fuelType);
    }
    @GetMapping("/all")
    public List<FuelType> all(){
        return service.getAll();
    }

    @PostMapping("/get")
    public FuelType get(@RequestBody ObjectNode data){
        return service.get(data.get("id").asInt());
    }


}
