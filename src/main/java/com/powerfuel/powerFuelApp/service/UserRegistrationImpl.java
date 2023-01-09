package com.powerfuel.powerFuelApp.service;

import com.powerfuel.powerFuelApp.model.User;
import com.powerfuel.powerFuelApp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserRegistrationImpl implements UserRegistrationService {
    @Autowired
    private UserRepository repository;
    public User userRegistration (User user){
        return repository.save(user);
    }

}
