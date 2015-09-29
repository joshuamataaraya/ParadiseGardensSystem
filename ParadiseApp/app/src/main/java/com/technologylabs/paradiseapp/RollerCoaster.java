package com.technologylabs.paradiseapp;

import java.util.ArrayList;

public class RollerCoaster extends Installation{

    public RollerCoaster(String name, ArrayList<Schedule> schedule, String description, String state, String timeToWait) {
        super(name, schedule);

        this.description=description;
        this.state=state;
        this.timeToWait=timeToWait;
    }
    String timeToWait;
    String state;
    String description;


}
