package com.example.geektrust.controller;

public class GlobalController {
    private static final DriverController driverController = new DriverController();
    private static final RiderController riderController = new RiderController();
    private static final RideController rideController = new RideController();

    public void route(String line) {
        String[] inputs = line.split(" ");

        if (line.contains("ADD_DRIVER")) {
            driverController.addDriver(inputs);
        } else if (line.contains("ADD_RIDER")) {
            riderController.addRider(inputs);
        } else if (line.contains("MATCH")) {
            riderController.matchDriver(inputs);
        } else if (line.contains("START_RIDE")) {
            rideController.startRide(inputs);
        } else if (line.contains("STOP_RIDE")) {
            rideController.stopRide(inputs);
        } else if (line.contains("BILL")) {
            rideController.getBill(inputs);
        }
    }
}
