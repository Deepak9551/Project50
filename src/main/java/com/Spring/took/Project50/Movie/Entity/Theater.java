package com.Spring.took.Project50.Movie.Entity;

import java.util.UUID;

public class Theatre {
    private UUID theatreId;
    private String name;
    private  String location;

    public UUID getTheatreId() {
        return theatreId;
    }

    public void setTheatreId(UUID theatreId) {
        this.theatreId = theatreId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Theatre(UUID theatreId, String name, String location) {
        this.theatreId = theatreId;
        this.name = name;
        this.location = location;
    }
}
