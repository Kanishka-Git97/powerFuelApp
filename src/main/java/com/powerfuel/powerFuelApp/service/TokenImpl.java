package com.powerfuel.powerFuelApp.service;

import com.powerfuel.powerFuelApp.model.Token;
import com.powerfuel.powerFuelApp.repository.TokenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TokenImpl implements TokenService{

    @Autowired
    private TokenRepository repository;

    public Token add(Token token){
        return repository.save(token);
    }

}
