package com.technologylabs.paradiseapp;

import java.util.ArrayList;

public class Show extends Installation{
    public Show(String name, String schedule, String place, String description) {
        super(name, schedule);

        this.place=place;
        this.description=description;
    }
    String place;
    String description;
}
