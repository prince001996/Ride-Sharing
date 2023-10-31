package com.example.geektrust.model;

import java.text.DecimalFormat;

public class Location {
    private static final double SQUARE_POWER = 2;
    private static final String DECIMAL_PATTERN = "#.##";
    private final double x;
    private final double y;

    public Location(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double distanceBetween(Location l2) {
        Location l1 = this;
        double xDiff = l2.getX() - l1.getX();
        double yDiff = l2.getY() - l1.getY();
        double distance = Math.sqrt(Math.pow(xDiff, SQUARE_POWER) + Math.pow(yDiff, SQUARE_POWER));
        DecimalFormat decimalFormat = new DecimalFormat(DECIMAL_PATTERN);
        return Double.parseDouble(decimalFormat.format(distance));
    }
}
