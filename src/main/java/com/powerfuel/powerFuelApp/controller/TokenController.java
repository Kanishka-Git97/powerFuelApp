package com.powerfuel.powerFuelApp.controller;

import com.powerfuel.powerFuelApp.model.Token;
import com.powerfuel.powerFuelApp.service.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/token")
@CrossOrigin
public class TokenController {
    @Autowired
    private TokenService service;

    @PostMapping("/add")
    public String add(@RequestBody Token token){
        service.add(token);
        return "Successfully Added";
    }
}
