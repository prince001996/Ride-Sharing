package com.example.geektrust.model;

import org.apache.maven.surefire.shade.org.apache.commons.lang3.builder.EqualsBuilder;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RiderTest {

    @Test
    void getId() {
        String expectedRiderId = "R1";
        Location origin = new Location(3, 4);
        Rider rider = new Rider(expectedRiderId, origin);
        String actuaRiderId = rider.getId();
        assertEquals(expectedRiderId, actuaRiderId);
    }

    @Test
    void getOrigin() {
        String riderId = "R1";
        Location expectedOrigin = new Location(3, 4);
        Rider rider = new Rider(riderId, expectedOrigin);
        Location actualOrigin = rider.getOrigin();
        assertNotSame(expectedOrigin, actualOrigin);
        assertTrue(EqualsBuilder.reflectionEquals(expectedOrigin, actualOrigin));
    }
}