package com.technologylabs.paradiseapp;

import java.util.ArrayList;

public class Restaurant extends Installation {

    public Restaurant(String name, String schedule, String id) {
        super(name, schedule);
        this.id=id;
    }
    String id;
}
