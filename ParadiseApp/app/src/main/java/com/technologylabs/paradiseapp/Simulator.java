package com.technologylabs.paradiseapp;

import java.util.ArrayList;

public class Simulator extends Installation {

    public Simulator(String name, ArrayList<Schedule> schedule, String description,String state,
                     String timeToWait, String capacity) {
        super(name, schedule);

        this.description= description;
        this.state = state;
        this.timeToWait = timeToWait;
        this.capacity=capacity;
    }
    String description;
    String state;
    String timeToWait;
    String capacity;
}
