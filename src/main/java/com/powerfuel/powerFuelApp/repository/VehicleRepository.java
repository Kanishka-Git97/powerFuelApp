package com.powerfuel.powerFuelApp.repository;

import com.powerfuel.powerFuelApp.model.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface VehicleRepository extends JpaRepository<Vehicle, Integer> {
    @Query(value = "SELECT COUNT(*) FROM vehicle WHERE registration=?1 OR chassis=?2", nativeQuery = true)
    Integer validate(String registration, String chassis);
}