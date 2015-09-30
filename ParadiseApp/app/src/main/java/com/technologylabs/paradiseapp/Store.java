package com.technologylabs.paradiseapp;

import java.util.ArrayList;

public class Store extends Installation {

    public Store(String name, String schedule, String id) {
        super(name, schedule);
        this.id=id;
    }
    String id;
}
