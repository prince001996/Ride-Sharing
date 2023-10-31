package com.example.geektrust.model;

public class Driver extends User{
    private DriverStatus driverStatus;

    public Driver(String id, Location origin) {
        super(id, origin);
        this.driverStatus = DriverStatus.AVAILABLE;
    }
    public DriverStatus getDriverStatus() {
        return driverStatus;
    }

    public void setDriverStatus(DriverStatus driverStatus) {
        this.driverStatus = driverStatus;
    }

    public Driver clone(){
        Driver driver = new Driver(this.getId(), this.getOrigin());
        driver.setDriverStatus(this.getDriverStatus());
        return driver;
    }

}
