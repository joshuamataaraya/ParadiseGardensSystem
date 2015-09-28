package com.technologylabs.paradisegardensapp;

import java.util.ArrayList;

public class Attraction extends Installation{

    public Attraction(String name, ArrayList<Schedule> schedule , String description) {
        super(name, schedule);

        this.description=description;
    }
    String description;


}
