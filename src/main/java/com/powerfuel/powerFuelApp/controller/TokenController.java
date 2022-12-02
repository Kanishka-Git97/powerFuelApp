package com.powerfuel.powerFuelApp.controller;

import com.fasterxml.jackson.databind.node.ObjectNode;
import com.powerfuel.powerFuelApp.model.Token;
import com.powerfuel.powerFuelApp.service.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/token")
@CrossOrigin
public class TokenController {
    @Autowired
    private TokenService service;

    @PostMapping("/add")
    public String add(@RequestBody Token token){
       return service.add(token);
    }
    @GetMapping("/all")
    public List<Token> all(){
       return service.all();
    }

    @PostMapping("/validate")
    public Integer validate(@RequestBody ObjectNode data){
        return service.validation(data.get("id").asInt());
    }

    @PostMapping("/get")
    public Token get(@RequestBody ObjectNode data){
        return service.get(data.get("id").asInt());
    }
}
