package com.example.geektrust.controller;

import com.example.geektrust.service.DriverService;

public class DriverController {

    private final DriverService driverService = new DriverService();

    public void addDriver(String[] inputs) {
        driverService.addDriver(inputs);
    }
}
