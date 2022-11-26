package com.powerfuel.powerFuelApp.repository;

import com.powerfuel.powerFuelApp.model.FuelRequests;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FuelRequestsRepository extends JpaRepository<FuelRequests,Integer> {
}
