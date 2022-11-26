package com.powerfuel.powerFuelApp.service;

import com.powerfuel.powerFuelApp.model.Customer;
import com.powerfuel.powerFuelApp.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerImpl implements CustomerService{
    @Autowired
    private CustomerRepository repository;
    public Customer saveCustomer(Customer customer){
        return repository.save(customer);
    }
}
