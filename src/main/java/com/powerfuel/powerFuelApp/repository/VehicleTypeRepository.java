package com.powerfuel.powerFuelApp.repository;

import com.powerfuel.powerFuelApp.model.VehicleType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VehicleTypeRepository extends JpaRepository<VehicleType, Integer> {
}