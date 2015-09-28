package com.technologylabs.paradisegardensapp;

import java.util.ArrayList;

/**
 * Created by Joshua on 27/09/2015.
 */
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
        Attraction att= new Attraction("Montanna Rusa 1",schd,"Nice try",1);
        ArrayList<Attraction> atracciones= new ArrayList<>();
        atracciones.add(att);
        return atracciones;
    }

    private static WebServiceConnection ourInstance = new WebServiceConnection();
}
