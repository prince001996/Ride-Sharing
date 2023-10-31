package com.example.geektrust.controller;

import com.example.geektrust.service.RiderService;

public class RiderController {
    private static final RiderService riderService = new RiderService();

    public void addRider(String[] inputs) {
        riderService.addRider(inputs);
    }

    public void matchDriver(String[] inputs) {
        riderService.matchDriver(inputs);
    }
}
