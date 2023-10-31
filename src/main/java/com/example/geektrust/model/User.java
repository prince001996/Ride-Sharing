package com.example.geektrust.model;

public class User {
    protected final String id;
    protected final Location origin;

    public User(String id, Location origin) {
        this.id = id;
        this.origin = new Location(origin.getX(), origin.getY());
    }

    public String getId() {
        return id;
    }

    public Location getOrigin() {
        return new Location(origin.getX(), origin.getY());
    }

    public User clone(){
        return new User(this.getId(), this.getOrigin());
    }
}
