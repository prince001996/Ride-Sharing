package com.example.geektrust.repository;

import com.example.geektrust.model.Driver;
import com.example.geektrust.model.DriverStatus;
import com.example.geektrust.model.Location;
import com.example.geektrust.model.Rider;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;

public class DriverRepository {
    private static final HashMap<String, Driver> driversMap = new HashMap<>();

    public void addDriver(Driver driver) {
        driversMap.put(driver.getId(), driver.clone());
    }

    public Driver getDriver(String driverId) {
        return driversMap.get(driverId).clone();
    }

    public List<Driver> getClosestDriverWithin5KmToRider(Rider rider) {
        List<Driver> closestDrivers = new ArrayList<>();
        Location riderOrigin = rider.getOrigin();
        Predicate<Driver> driverPredicateLessThan5km = (driver) -> {
            return (riderOrigin.distanceBetween(driver.getOrigin()) <= 5);
        };
        Predicate<Driver> availableDrivers = (driver) -> {
            return driver.getDriverStatus() == DriverStatus.AVAILABLE;
        };

        for (Map.Entry<String, Driver> driverObj : driversMap.entrySet()) {
            Driver driver = driverObj.getValue();
            if (driverPredicateLessThan5km.and(availableDrivers).test(driver)) {
                closestDrivers.add(driver.clone());
            }
        }
        return closestDrivers;
    }

    public void updateDriver(Driver driver) {
        driversMap.put(driver.getId(), driver.clone());
    }
}
