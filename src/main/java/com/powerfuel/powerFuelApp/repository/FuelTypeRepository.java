package com.powerfuel.powerFuelApp.repository;

import com.powerfuel.powerFuelApp.model.FuelType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FuelTypeRepository extends JpaRepository<FuelType, Integer> {
}