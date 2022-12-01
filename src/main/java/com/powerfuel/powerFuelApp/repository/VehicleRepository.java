package com.powerfuel.powerFuelApp.repository;

import com.powerfuel.powerFuelApp.model.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface VehicleRepository extends JpaRepository<Vehicle, Integer> {
    @Query(value = "SELECT COUNT(*) FROM vehicle WHERE registration=?1 OR chassis=?2", nativeQuery = true)
    Integer validate(String registration, String chassis);

    @Query(value = "SELECT * FROM vehicle WHERE customer_id=?1", nativeQuery = true)
    List<Vehicle> getVehiclesByOwner(int customer);
}