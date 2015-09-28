package com.technologylabs.paradisegardensapp;

import java.util.ArrayList;

/**
 * Created by Joshua on 27/09/2015.
 */
public class Attraction extends Installation{

    public Attraction(String name, ArrayList<Schedule> schedule , String description, int photoId) {
        super(name, schedule,photoId);

        this.description=description;
    }
    String description;
}
