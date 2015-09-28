package com.technologylabs.paradisegardensapp;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by Joshua on 27/09/2015.
 */
public class Installation {
    public Installation(String name, ArrayList<Schedule> schedule, int photoId) {
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
