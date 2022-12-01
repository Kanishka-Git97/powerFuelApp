package com.powerfuel.powerFuelApp.repository;

import com.powerfuel.powerFuelApp.model.Token;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TokenRepository extends JpaRepository<Token, Integer> {
}