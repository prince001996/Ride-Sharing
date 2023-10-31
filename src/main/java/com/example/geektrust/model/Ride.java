package com.example.geektrust.model;

import java.text.DecimalFormat;

public class Ride {

    private static final double BASE_FARE = 50;
    private static final double FARE_PER_KM = 6.50;
    private static final double FARE_PER_MINUTE = 2;
    private static final double SERVICE_TAX_PERCENTAGE = .20;
    private static final String DECIMAL_PATTERN = "#.##";


    private final String id;
    private final Location origin;
    private Location destination;
    private double duration;
    private String driverId;
    private RideStatus rideStatus;

    public Ride(String id, Location origin) {
        this.id = id;
        this.origin = origin;
        this.rideStatus = RideStatus.STARTED;
    }

    public String getId() {
        return id;
    }

    public Location getOrigin() {
        return new Location(origin.getX(), origin.getY());
    }

    public void setDestination(Location destination) {
        this.destination = new Location(destination.getX(), destination.getY());
    }

    public Location getDestination() {
        return new Location(destination.getX(), destination.getY());
    }

    public double getDuration() {
        return duration;
    }

    public void setDuration(double duration) {
        this.duration = duration;
    }

    public String getDriverId() {
        return driverId;
    }

    public void setDriverId(String driverId) {
        this.driverId = driverId;
    }

    public RideStatus getRideStatus() {
        return rideStatus;
    }

    public void setRideStatus(RideStatus rideStatus) {
        this.rideStatus = rideStatus;
    }

    public double calculateBill() {
        DecimalFormat decimalFormat = new DecimalFormat(DECIMAL_PATTERN);
        double totalBill = BASE_FARE;
        double timeCharge = (this.getDuration() * FARE_PER_MINUTE);
        double distance = this.getOrigin().distanceBetween(this.getDestination());
        double distanceCharge = (distance * FARE_PER_KM);
        totalBill += timeCharge + distanceCharge;
        double serviceCharge = totalBill * SERVICE_TAX_PERCENTAGE;
        totalBill += Double.parseDouble(decimalFormat.format(serviceCharge));
        return Double.parseDouble(decimalFormat.format(totalBill));
    }
}
