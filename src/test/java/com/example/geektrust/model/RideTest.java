package com.example.geektrust.model;

import org.apache.maven.surefire.shade.org.apache.commons.lang3.builder.EqualsBuilder;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class RideTest {

    @Test
    void getId() {
        Location expectedOrigin = new Location(2, 3);
        String expectedRideId = "ride-001";
        Ride ride = new Ride(expectedRideId, expectedOrigin);
        String actualRideId = ride.getId();
        assertEquals(expectedRideId, actualRideId);
    }

    @Test
    void getOrigin() {
        Location expectedOrigin = new Location(2, 3);
        Ride ride = new Ride("ride-001", expectedOrigin);
        Location actualOrigin = ride.getOrigin();
        assertTrue(EqualsBuilder.reflectionEquals(expectedOrigin, actualOrigin));
    }

    @Test
    void setDestination() {
        Location origin = new Location(2, 3);
        Ride ride = new Ride("ride-001", origin);
        Location expectedDestination = new Location(6, 6);
        ride.setDestination(expectedDestination);
        Location actualDestination = ride.getDestination();
        assertTrue(EqualsBuilder.reflectionEquals(expectedDestination, actualDestination));
    }

    @Test
    void getDestination() {
        Location origin = new Location(2, 3);
        Ride ride = new Ride("ride-001", origin);
        Location expectedDestination = new Location(6, 6);
        ride.setDestination(expectedDestination);
        Location actualDestination = ride.getDestination();
        assertTrue(EqualsBuilder.reflectionEquals(expectedDestination, actualDestination));
    }

    @Test
    void getDuration() {
        Location origin = new Location(2, 3);
        Ride ride = new Ride("ride-001", origin);
        Location expectedDestination = new Location(6, 6);
        ride.setDuration(20);
        assertEquals(20, ride.getDuration());
    }

    @Test
    void setDuration() {
        Location origin = new Location(2, 3);
        Ride ride = new Ride("ride-001", origin);
        Location expectedDestination = new Location(6, 6);
        ride.setDuration(20);
        assertEquals(20, ride.getDuration());
    }

    @Test
    void getDriverId() {
        Location expectedOrigin = new Location(2, 3);
        String rideId = "ride-001";
        Ride ride = new Ride(rideId, expectedOrigin);
        String expectedDriverId = "D1";
        ride.setDriverId(expectedDriverId);
        String actualDriver = ride.getDriverId();
        assertEquals(expectedDriverId, actualDriver);
    }

    @Test
    void setDriverId() {
        Location expectedOrigin = new Location(2, 3);
        String rideId = "ride-001";
        Ride ride = new Ride(rideId, expectedOrigin);
        String expectedDriverId = "D1";
        ride.setDriverId(expectedDriverId);
        String actualDriver = ride.getDriverId();
        assertEquals(expectedDriverId, actualDriver);
    }

    @Test
    void getRideStatus() {
        Location origin = new Location(2, 3);
        Ride ride = new Ride("ride-001", origin);
        assertEquals(RideStatus.STARTED, ride.getRideStatus());
    }

    @Test
    void setRideStatus() {
        Location origin = new Location(2, 3);
        Ride ride = new Ride("ride-001", origin);
        ride.setRideStatus(RideStatus.STOPPED);
        assertEquals(RideStatus.STOPPED, ride.getRideStatus());
    }

    @Test
    void calculateBill() {
        Location origin = new Location(2, 3);
        Ride ride = new Ride("ride-001", origin);
        ride.setDuration(20);
        Location destination = new Location(6, 6);
        ride.setDestination(destination);
        double bill = ride.calculateBill();
        assertEquals(147, bill);
    }
}