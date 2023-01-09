package com.powerfuel.powerFuelApp.repository;

import com.powerfuel.powerFuelApp.model.Token;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TokenRepository extends JpaRepository<Token, Integer> {

    @Query(value = "SELECT COUNT(*) FROM customer_que WHERE status='Pending' AND vehicle=?1 OR status='Active' AND vehicle=?1", nativeQuery = true)
    Integer validateVehicle(int id);

    @Query(value = "SELECT * FROM customer_que WHERE status='Active' OR status='Pending' AND vehicle=?1 LIMIT 1", nativeQuery = true)
    Token get(int vehicle);

    @Query(value = "SELECT * FROM `customer_que` INNER JOIN `vehicle` ON vehicle.id = customer_que.vehicle WHERE vehicle.customer_id=?1 ORDER BY customer_que.update_at DESC", nativeQuery = true)
    List<Token> getTokens(int customer);
}