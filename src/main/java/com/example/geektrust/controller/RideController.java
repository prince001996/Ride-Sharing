package com.example.geektrust.controller;

import com.example.geektrust.service.RideService;

public class RideController {
    private static final RideService rideService = new RideService();

    public void startRide(String[] inputs) {
        rideService.startRide(inputs);
    }

    public void stopRide(String[] inputs) {
        rideService.stopRide(inputs);
    }

    public void getBill(String[] inputs) {
        rideService.getBill(inputs);
    }
}
