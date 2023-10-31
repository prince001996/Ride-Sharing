package com.example.geektrust.service;

import com.example.geektrust.model.*;
import com.example.geektrust.repository.DriverRepository;
import com.example.geektrust.repository.RideRepository;
import com.example.geektrust.repository.RiderRepository;

import java.util.List;

public class RideService {
    private static final RideRepository rideRepository = new RideRepository();
    private static final RiderRepository riderRepository = new RiderRepository();
    private static final DriverRepository driverRepository = new DriverRepository();

    public void startRide(String[] inputs) {
        String rideId = inputs[1];
        int driverNumber = Integer.parseInt(inputs[2]);
        String riderId = inputs[3];
        Rider rider = riderRepository.getRider(riderId);

        List<Driver> closestDrivers = riderRepository.getCLosestDriverToRider(riderId);
        if (closestDrivers == null || closestDrivers.size() < driverNumber) {
            System.out.println("INVALID_RIDE");
            return;
        }

        Driver driver = closestDrivers.get(driverNumber - 1);
        if (rideRepository.exists(rideId)) {
            System.out.println("INVALID_RIDE");
            return;
        }
        if (driver.getDriverStatus() == DriverStatus.UNAVAILABLE) {
            System.out.println("INVALID_RIDE");
            return;
        }

        driver.setDriverStatus(DriverStatus.UNAVAILABLE);
        driverRepository.updateDriver(driver);
        Ride ride = createRide(rideId, rider, driver);

        rideRepository.save(ride);
        System.out.printf("RIDE_STARTED %s\n", rideId);
    }

    private Ride createRide(String rideId, Rider rider, Driver driver) {
        Ride ride = new Ride(rideId, rider.getOrigin());
        ride.setDriverId(driver.getId());
        return ride;
    }

    public void stopRide(String[] inputs) {
        String rideId = inputs[1];
        double x = Double.parseDouble(inputs[2]);
        double y = Double.parseDouble(inputs[3]);
        double duration = Double.parseDouble(inputs[4]);

        if (!rideRepository.exists(rideId)) {
            System.out.println("INVALID_RIDE");
            return;
        }

        Ride ride = rideRepository.getRide(rideId);
        Location destination = new Location(x, y);
        if (ride.getRideStatus() == RideStatus.STOPPED) {
            System.out.println("INVALID_RIDE");
            return;
        }

        ride.setRideStatus(RideStatus.STOPPED);
        ride.setDestination(destination);
        ride.setDuration(duration);
        Driver driver = driverRepository.getDriver(ride.getDriverId());
        driver.setDriverStatus(DriverStatus.AVAILABLE);
        driverRepository.updateDriver(driver);
        System.out.printf("RIDE_STOPPED %s\n", rideId);
    }

    public void getBill(String[] inputs) {
        String rideId = inputs[1];
        if (rideRepository.exists(rideId)) {
            Ride ride = rideRepository.getRide(rideId);
            if (ride.getRideStatus() != RideStatus.STOPPED) {
                System.out.println("RIDE_NOT_COMPLETED");
                return;
            }

            double bill = ride.calculateBill();
            System.out.printf("BILL %s %s %.2f\n", ride.getId(), ride.getDriverId(), bill);
            return;
        }
        System.out.println("INVALID_RIDE");
    }
}
