package com.powerfuel.powerFuelApp.repository;

import com.powerfuel.powerFuelApp.model.Token;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface TokenRepository extends JpaRepository<Token, Integer> {

    @Query(value = "SELECT COUNT(*) FROM customer_que WHERE status='Pending' AND vehicle=?1 OR status='Active' AND vehicle=?1", nativeQuery = true)
    Integer validateVehicle(int id);

    @Query(value = "SELECT * FROM customer_que WHERE status='Active' OR status='Pending' AND vehicle=?1 LIMIT 1", nativeQuery = true)
    Token get(int vehicle);

}