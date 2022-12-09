package com.powerfuel.powerFuelApp.service;

import com.powerfuel.powerFuelApp.model.Token;

import java.util.List;

public interface TokenService {
    public String add(Token token);
    public List<Token> all();
    public Integer validation(int vehicle);
    public Token get(int vehicle);
    public List<Token> getTokens(int customer);
}
