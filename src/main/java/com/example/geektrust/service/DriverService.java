package com.example.geektrust.service;

import com.example.geektrust.model.Driver;
import com.example.geektrust.model.Location;
import com.example.geektrust.repository.DriverRepository;

public class DriverService {

    private static final DriverRepository driverRepository = new DriverRepository();

    public void addDriver(String[] inputs) {
        String driverId = inputs[1];
        double x = Double.parseDouble(inputs[2]);
        double y = Double.parseDouble(inputs[3]);
        Location location = new Location(x, y);
        Driver driver = new Driver(driverId, location);
        driverRepository.addDriver(driver);
    }
}
