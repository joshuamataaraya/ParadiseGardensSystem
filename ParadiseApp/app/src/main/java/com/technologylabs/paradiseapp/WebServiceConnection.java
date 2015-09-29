package com.technologylabs.paradiseapp;

import java.util.ArrayList;

public class WebServiceConnection {
    public static WebServiceConnection getInstance() {
        return ourInstance;
    }

    private WebServiceConnection() {
    }

    public ArrayList<Installation> getAttractions(){
        Schedule sc= new Schedule("5pm");
        ArrayList<Schedule> schd= new ArrayList<>();
        schd.add(sc);
        RollerCoaster att= new RollerCoaster("Montanna Rusa 1",schd,"Nice try","Reparacion","3 mins");
        RollerCoaster att2= new RollerCoaster("Montanna Rusa 2",schd,"Nice try 2","Reparacion","3 mins");
        ArrayList<Installation> atracciones= new ArrayList<>();
        atracciones.add(att);
        atracciones.add(att2);
        return atracciones;
    }
    public ArrayList<Installation> getSimulators(){
        ArrayList<Installation> simulators = new ArrayList<>();
        return simulators;
    }

    public ArrayList<Installation> getRestaurants(){
        ArrayList<Installation> restaurants = new ArrayList<>();
        return restaurants;
    }

    public ArrayList<Installation> getFoods(){
        ArrayList<Installation> foods = new ArrayList<>();
        return foods;
    }

    public ArrayList<Installation> getShows(){
        ArrayList<Installation> shows = new ArrayList<>();
        return shows;
    }

    public ArrayList<Installation> getStores(){
        ArrayList<Installation> stores= new ArrayList<>();
        return stores;
    }

    public ArrayList<Installation> getItems(){
        ArrayList<Installation> items= new ArrayList<>();
        return items;
    }
    private static WebServiceConnection ourInstance = new WebServiceConnection();
}
