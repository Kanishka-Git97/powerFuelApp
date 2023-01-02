package com.powerfuel.powerFuelApp.service;

import com.powerfuel.powerFuelApp.model.FuelStation;

import java.util.List;
import java.util.Objects;

public interface FuelStationService {

    public FuelStation registerFuelStation(FuelStation fuelstation);

    public List<FuelStation> getStationDetails(int station_id);

    public void updateStationData(String address,double diesel,int district,String email,String mobile,String name,double petrol,String status,int id);
    public void closeStation(String status,int id);

    public List<Objects> getCurrentCapacity(int id);

    public int validateStation(String email);
    public List<FuelStation> getNearestStations(int district);
    public FuelStation getStation(int id);
    public List<FuelStation> getAllStationDetails();
    public List<FuelStation> getSingleStationDetails(int id);

}
