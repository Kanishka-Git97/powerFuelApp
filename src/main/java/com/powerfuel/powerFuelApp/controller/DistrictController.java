package com.powerfuel.powerFuelApp.controller;

import com.fasterxml.jackson.databind.node.ObjectNode;
import com.powerfuel.powerFuelApp.model.District;
import com.powerfuel.powerFuelApp.service.DistrictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/districts")
@CrossOrigin
public class DistrictController {
    @Autowired
    private DistrictService service;

    @GetMapping("/all")
    public List<District> all(){
        return  service.getDistricts();
    }

    @PostMapping("/get")
    public District get(@RequestBody ObjectNode data){
        return  service.getDistrict(data.get("id").asInt());
    }
}
