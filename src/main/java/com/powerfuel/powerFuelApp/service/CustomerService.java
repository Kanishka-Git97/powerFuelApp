package com.powerfuel.powerFuelApp.service;

import com.powerfuel.powerFuelApp.model.Customer;

import java.util.List;

public interface CustomerService {
    public Customer saveCustomer(Customer customer);
    public List<Customer> getCustomers();
}
