package com.technologylabs.paradiseapp;

import java.util.ArrayList;

public class Item extends Installation{
    public Item(String name, String price, String amount) {
        super(name, null);
        this.price=price;
        this.amount=amount;
    }
    String price;
    String amount;
}
