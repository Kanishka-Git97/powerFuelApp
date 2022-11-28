package com.powerfuel.powerFuelApp.controller;

import com.fasterxml.jackson.databind.node.ObjectNode;
import com.powerfuel.powerFuelApp.model.Customer;
import com.powerfuel.powerFuelApp.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customers")
@CrossOrigin
public class CustomerController {
    @Autowired
    private  CustomerService service;

    @PostMapping(path = "/register", consumes = "application/x-www-form-urlencoded")
    public String register(Customer customer){
        service.saveCustomer(customer);
        return "Customer Registration Successfully";
    }
    @PostMapping(path = "/validate", consumes = "application/x-www-form-urlencoded")
    public Integer validate(Customer customer){
        return service.validate(customer.getEmail(), customer.getNic());
    }

    @GetMapping("/all")
    public List<Customer> all(){
        return service.getCustomers();
    }
}
