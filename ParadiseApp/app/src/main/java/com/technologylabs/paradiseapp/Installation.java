package com.technologylabs.paradiseapp;

import java.util.ArrayList;
import java.util.Date;

public class Installation {
    public Installation(String name, String schedule) {
        this.name = name;
        this.schedule = schedule;
    }

    public String getSchedule() {
        return schedule;
    }

    public String getName() {
        return name;
    }

    String name;
    String schedule;
}
