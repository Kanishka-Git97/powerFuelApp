package com.powerfuel.powerFuelApp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.annotation.JsonProperty.Access;
import com.powerfuel.powerFuelApp.repository.AccessRepository;

@Service

public class AccessImpl implements AccessService {
    @Autowired
    private AccessRepository repository;
    public Access access_lvl (Access access){
        return repository.save(access);
    }
    
}
