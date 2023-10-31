package com.example.geektrust.service;

import com.example.geektrust.model.Driver;
import com.example.geektrust.model.Location;
import com.example.geektrust.model.Rider;
import com.example.geektrust.repository.DriverRepository;
import com.example.geektrust.repository.RiderRepository;

import java.util.Collections;
import java.util.List;

public class RiderService {
    private static final RiderRepository riderRepository = new RiderRepository();
    private static final DriverRepository driverRepository = new DriverRepository();

    public void addRider(String[] inputs) {
        String riderId = inputs[1];
        double x = Double.parseDouble(inputs[2]);
        double y = Double.parseDouble(inputs[3]);
        Location location = new Location(x, y);
        Rider rider = new Rider(riderId, location);
        riderRepository.addRider(rider);
    }

    public void matchDriver(String[] inputs) {
        String riderId = inputs[1];
        Rider rider = riderRepository.getRider(riderId);

        List<Driver> closestDrivers = driverRepository.getClosestDriverWithin5KmToRider(rider);
        if (closestDrivers == null || closestDrivers.size() == 0) {
            System.out.println("NO_DRIVERS_AVAILABLE");
        } else {
            sortClosestDriversOnDistanceAndId(rider, closestDrivers);
            System.out.print("DRIVERS_MATCHED");
            printClosestDrivers(closestDrivers);
            System.out.println();
            riderRepository.updateRiderDriverMatches(riderId, closestDrivers);
        }
    }

    private void printClosestDrivers(List<Driver> closestDrivers) {
        for (int i = 0; i < 5 && i < (closestDrivers.size()); i++) {
            System.out.print(" " + closestDrivers.get(i).getId());
        }
    }

    private void sortClosestDriversOnDistanceAndId(Rider rider, List<Driver> closestDrivers) {
        Collections.sort(closestDrivers, (driver1, driver2) -> {
            Location riderOrigin = rider.getOrigin();
            double distanceDriver1 = riderOrigin.distanceBetween(driver1.getOrigin());
            double distanceDriver2 = riderOrigin.distanceBetween(driver2.getOrigin());
            if (distanceDriver1 == distanceDriver2) {
                return driver1.getId().compareTo(driver2.getId());
            }
            return distanceDriver1 < distanceDriver2 ? -1 : 1;
        });
    }
}
