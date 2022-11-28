package com.powerfuel.powerFuelApp.repository;

import com.powerfuel.powerFuelApp.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {

    @Query(value = "SELECT COUNT(*) FROM customer WHERE email=?1 OR nic=?2", nativeQuery = true)
    Integer validatate(String email, String nic);
}