package com.powerfuel.powerFuelApp.repository;

import com.powerfuel.powerFuelApp.model.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScheduleRepository extends JpaRepository<Schedule, Integer> {
}