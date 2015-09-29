package com.technologylabs.paradiseapp;

import java.util.ArrayList;
import java.util.Date;

public class Installation {
    public Installation(String name, ArrayList<Schedule> schedule) {
        this.name = name;
        this.schedule = schedule;
        this.photoId = photoId;
    }

    public String getSchedule() {
        return schedule.toString();
    }

    public String getName() {
        return name;
    }

    String name;
    ArrayList<Schedule> schedule;
    int photoId;
}
