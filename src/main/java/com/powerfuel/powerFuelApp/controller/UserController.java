package com.powerfuel.powerFuelApp.controller;

import com.fasterxml.jackson.databind.node.ObjectNode;
import com.powerfuel.powerFuelApp.model.User;
import com.powerfuel.powerFuelApp.service.UserRegistrationService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@CrossOrigin

public class UserController {
    @Autowired
    private UserRegistrationService userRegistrationService;




    @PostMapping("/register")
    public String registerUser(@RequestBody ObjectNode data){
        User newUser=new User();


        String name=data.get("name").asText();
        String companytp=data.get("company_id").asText();
        String username=data.get("user_name").asText();
        String password=data.get("password").asText();

        String role=data.get("role").asText();
        String status=data.get("status").asText();


        newUser.setName(name);
        newUser.setCompanyId(companytp);
        newUser.setUserName(username);
        newUser.setPassword(password);
        newUser.setRole(role);
        newUser.setStatus(status);

        userRegistrationService.userRegistration(newUser);

        return "success";



    }
}
