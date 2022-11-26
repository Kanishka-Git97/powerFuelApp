package com.powerfuel.powerFuelApp.controller;

import com.powerfuel.powerFuelApp.model.District;
import com.powerfuel.powerFuelApp.service.DistrictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
