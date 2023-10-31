package com.example.geektrust.model;

public class Rider extends User {

    public Rider(String id, Location origin) {
        super(id, origin);
    }

    public Rider clone(){
        Rider rider = new Rider(this.getId(), this.getOrigin());
        return rider;
    }

}
