package com.example.geektrust.repository;

import com.example.geektrust.model.Driver;
import com.example.geektrust.model.Rider;

import java.util.HashMap;
import java.util.List;

public class RiderRepository {
    private static final HashMap<String, Rider> riderMap = new HashMap<>();
    private static final HashMap<String, List<Driver>> riderDriverMatches = new HashMap<>();

    public void addRider(Rider rider) {
        riderMap.put(rider.getId(), rider.clone());
    }

    public Rider getRider(String riderId) {
        return riderMap.get(riderId).clone();
    }

    public void updateRiderDriverMatches(String riderId, List<Driver> closestDrivers) {
        riderDriverMatches.put(riderId, closestDrivers);
    }

    public List<Driver> getCLosestDriverToRider(String riderId) {
        return riderDriverMatches.get(riderId);
    }

}
