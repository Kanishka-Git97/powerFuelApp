package com.powerfuel.powerFuelApp.repository;

import com.powerfuel.powerFuelApp.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
}