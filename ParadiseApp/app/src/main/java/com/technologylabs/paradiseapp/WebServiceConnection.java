package com.technologylabs.paradiseapp;

import java.util.ArrayList;

public class WebServiceConnection {
    public static WebServiceConnection getInstance() {
        return ourInstance;
    }

    private WebServiceConnection() {
    }

    public ArrayList<Attraction> getAtracciones(){
        Schedule sc= new Schedule("5pm");
        ArrayList<Schedule> schd= new ArrayList<>();
        schd.add(sc);
        Attraction att= new Attraction("Montanna Rusa 1",schd,"Nice try");
        Attraction att2= new Attraction("Montanna Rusa 2",schd,"Nice try 2");
        ArrayList<Attraction> atracciones= new ArrayList<>();
        atracciones.add(att);
        atracciones.add(att2);
        return atracciones;
    }

    private static WebServiceConnection ourInstance = new WebServiceConnection();
}
