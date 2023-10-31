package com.example.geektrust.model;

import org.apache.maven.surefire.shade.org.apache.commons.lang3.builder.EqualsBuilder;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class DriverTest {

    @Test
    void getId() {
        String expectedDriverId = "D1";
        Location origin = new Location(0, 0);
        Driver driver = new Driver(expectedDriverId, origin);
        String actualDriverId = driver.getId();
        assertEquals(expectedDriverId, actualDriverId);
    }

    @Test
    void getOrigin() {
        String driverId = "D1";
        Location expectedOrigin = new Location(0, 0);
        Driver driver = new Driver(driverId, expectedOrigin);
        Location actualOrigin = driver.getOrigin();
        assertTrue(EqualsBuilder.reflectionEquals(expectedOrigin, actualOrigin));
    }

    @Test
    void getDriverStatus() {
        String driverId = "D1";
        Location origin = new Location(0, 0);
        Driver driver = new Driver(driverId, origin);
        DriverStatus actualDriverStatus = driver.getDriverStatus();
        assertEquals(DriverStatus.AVAILABLE, actualDriverStatus);
    }

    @Test
    void setDriverStatus() {
        String driverId = "D1";
        Location origin = new Location(0, 0);
        Driver driver = new Driver(driverId, origin);
        driver.setDriverStatus(DriverStatus.UNAVAILABLE);
        DriverStatus actualDriverStatus = driver.getDriverStatus();
        assertEquals(DriverStatus.UNAVAILABLE, actualDriverStatus);
    }
}