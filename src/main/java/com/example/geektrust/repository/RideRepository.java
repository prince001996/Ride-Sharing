package com.example.geektrust.repository;

import com.example.geektrust.model.Ride;

import java.util.HashMap;

public class RideRepository {
    private static final HashMap<String, Ride> ridesMap = new HashMap<>();

    public Ride getRide(String rideId) {
        return ridesMap.get(rideId);
    }

    public boolean exists(String rideId) {
        return ridesMap.containsKey(rideId);
    }

    public void save(Ride ride) {
        ridesMap.put(ride.getId(), ride);
    }
}
