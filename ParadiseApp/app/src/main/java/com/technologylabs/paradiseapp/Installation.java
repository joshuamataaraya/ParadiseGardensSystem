package com.technologylabs.paradiseapp;

import java.util.ArrayList;
import java.util.Date;

public class Installation {
    public Installation(String name, ArrayList<Schedule> schedule) {
        this.name = name;
        this.schedule = schedule;
        this.photoId = photoId;
    }

    public ArrayList<Schedule> getSchedule() {
        return schedule;
    }

    public String getName() {
        return name;
    }

    String name;
    ArrayList<Schedule> schedule;
    int photoId;
}
