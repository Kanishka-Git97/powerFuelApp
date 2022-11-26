package com.powerfuel.powerFuelApp.controller;

import com.powerfuel.powerFuelApp.model.Customer;
import com.powerfuel.powerFuelApp.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customer")
@CrossOrigin
public class CustomerController {
    @Autowired
    private  CustomerService service;

    @PostMapping("/register")
    public String register(@RequestBody Customer customer){
        service.saveCustomer(customer);
        return "Customer Registration Successfully";
    }
}
