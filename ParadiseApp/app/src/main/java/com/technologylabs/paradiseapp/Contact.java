package com.technologylabs.paradiseapp;

/**
 * Created by Joshua on 29/09/2015.
 */
public class Contact extends Installation {
    public Contact(String name, String employment, String num) {
        super(name, null);

        this.employment=employment;
        this.num=num;
    }
    String employment;
    String num;
}
