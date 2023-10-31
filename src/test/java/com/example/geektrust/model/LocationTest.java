package com.example.geektrust.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LocationTest {

    @Test
    void getX() {
        Location l1 = new Location(2, 3);
        double x = l1.getX();
        assertEquals(2, x);
    }

    @Test
    void getY() {
        Location l1 = new Location(2, 3);
        double y = l1.getY();
        assertEquals(3, y);
    }

    @Test
    void distanceBetweenOriginToAnotherPoint() {
        Location l1 = new Location(0, 0);
        Location l2 = new Location(4, 3);
        double distance = l1.distanceBetween(l2);
        assertEquals(5.00, distance);
    }

    @Test
    void distanceBetween() {
        Location l1 = new Location(4, 5);
        Location l2 = new Location(6, 11);
        double distance = l1.distanceBetween(l2);
        assertEquals(6.32, distance);
    }

}