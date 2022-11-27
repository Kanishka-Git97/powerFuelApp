package com.powerfuel.powerFuelApp.service;

import com.powerfuel.powerFuelApp.model.FuelStation;

import java.util.List;
import java.util.Objects;

public interface FuelStationService {

    public FuelStation registerFuelStation(FuelStation fuelstation);

    public List<FuelStation> getStationDetails(int station_id);

    public void updateStationData(String name,String mobile,double diesel,double petrol,String status,String email);

    public void closeStation(String status,int id);

    public List<Objects> getCurrentCapacity(int id);

    public int validateStation(String email);
}
