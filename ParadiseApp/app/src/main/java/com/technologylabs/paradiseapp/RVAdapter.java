package com.technologylabs.paradiseapp;

import android.content.Intent;
import android.os.Bundle;
import android.provider.DocumentsContract;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

import static android.support.v4.app.ActivityCompat.startActivity;

public class RVAdapter extends RecyclerView.Adapter<RVAdapter.AttractionViewHolder >{

    static List<Installation> installations;
    static int selection;
    static boolean isSearch;
    public static class AttractionViewHolder extends RecyclerView.ViewHolder {
        public CardView cv;
        public TextView name;
        public TextView description;
        public TextView schedule;
        public TextView price;
        public TextView state;
        public TextView timeToWait;
        public TextView capacity;
        public TextView place;
        public TextView amount;
        public TextView num;
        public TextView employment;
        public Button btn;
        public MainWindowController windowController;


        AttractionViewHolder (View itemView) {
            super(itemView);
            cv = (CardView)itemView.findViewById(R.id.rv);

            switch (selection){
                case 1: //show attractions
                    showAttractions();
                    break;
                case 2: //show simulators
                    showSimulators();
                    break;

                case 3: //show restaurant
                    showRestaurats();
                    break;
                case 4: //show food
                    showFood();
                    break;
                case 5: //show shows
                    showShows();
                    break;
                case 6: //show stores
                    showStores();
                    break;
                case 7: //show items
                    showItems();
                    break;
                case 8:
                    showContacts();
                    break;
                case 9:
                    showSearchResults();
            }
        }
        public void showAttractions(){
            name = (TextView)itemView.findViewById(R.id.name);
            description = (TextView)itemView.findViewById(R.id.description);
            schedule = (TextView)itemView.findViewById(R.id.schedule);
            state = (TextView)itemView.findViewById(R.id.state);
            timeToWait = (TextView)itemView.findViewById(R.id.timeToWait);
        }
        public void showSimulators(){
            name = (TextView)itemView.findViewById(R.id.name);
            description = (TextView)itemView.findViewById(R.id.description);
            schedule = (TextView)itemView.findViewById(R.id.schedule);
            state = (TextView)itemView.findViewById(R.id.state);
            capacity = (TextView)itemView.findViewById(R.id.capacity);
            timeToWait = (TextView)itemView.findViewById(R.id.timeToWait);
        }
        public void showRestaurats(){
            name = (TextView)itemView.findViewById(R.id.name);
            schedule = (TextView)itemView.findViewById(R.id.schedule);
            CardView cardView = (CardView)itemView.findViewById(R.id.cv);
            this.btn= (Button)itemView.findViewById(R.id.btn);
        }
        public void showFood(){
            name = (TextView)itemView.findViewById(R.id.name);
            description = (TextView)itemView.findViewById(R.id.description);
        }
        public void showShows(){
            name = (TextView)itemView.findViewById(R.id.name);
            schedule = (TextView)itemView.findViewById(R.id.schedule);
            place =(TextView)itemView.findViewById(R.id.place);
            description = (TextView)itemView.findViewById(R.id.description);
        }
        public void showStores(){
            name = (TextView)itemView.findViewById(R.id.name);
            schedule = (TextView)itemView.findViewById(R.id.schedule);
            this.btn= (Button)itemView.findViewById(R.id.btn);
        }
        public void showItems(){
            name = (TextView)itemView.findViewById(R.id.name);
            price = (TextView)itemView.findViewById(R.id.price);
            amount = (TextView)itemView.findViewById(R.id.amount);
        }
        public void showContacts(){
            name = (TextView)itemView.findViewById(R.id.name);
            num= (TextView)itemView.findViewById(R.id.num);
            employment= (TextView)itemView.findViewById(R.id.employment);
        }
        public void showSearchResults(){
           if (installations!=null && installations.get(0) instanceof RollerCoaster){
               showAttractions();
           }
            if (installations!=null && installations.get(0) instanceof Simulator){
                showSimulators();
            }
            if (installations!=null && installations.get(0) instanceof Store){
                showStores();
            }
            if (installations!=null && installations.get(0) instanceof Restaurant){
                showRestaurats();
            }
            if (installations!=null && installations.get(0) instanceof Show){
                showShows();
            }
            if (installations!=null && installations.get(0) instanceof Contact){
                showContacts();
            }
        }
    }
    RVAdapter(List<Installation> installations, int pSelection){
        this.installations =  installations;
        selection=pSelection;
    }

    @Override
    public int getItemCount() {
        return installations.size();
    }

    @Override
    public AttractionViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View v=null;
        switch (selection){
            case 1: //show attractions
                v = LayoutInflater.from(viewGroup.getContext())
                        .inflate(R.layout.card_attraction, viewGroup, false);
                break;
            case 2: //show simulators
                v = LayoutInflater.from(viewGroup.getContext())
                        .inflate(R.layout.card_simulator, viewGroup, false);
                break;

            case 3: //show restaurant
                v = LayoutInflater.from(viewGroup.getContext())
                        .inflate(R.layout.card_restaurant, viewGroup, false);

                break;
            case 4: //show food
                v = LayoutInflater.from(viewGroup.getContext())
                        .inflate(R.layout.card_food, viewGroup, false);
                break;
            case 5: //show shows
                v = LayoutInflater.from(viewGroup.getContext())
                        .inflate(R.layout.card_show, viewGroup, false);
                break;
            case 6: //show stores
                v = LayoutInflater.from(viewGroup.getContext())
                        .inflate(R.layout.card_store, viewGroup, false);
                break;
            case 7: //show items
                v = LayoutInflater.from(viewGroup.getContext())
                        .inflate(R.layout.card_item, viewGroup, false);
                break;
            case 8: //show contact
                v = LayoutInflater.from(viewGroup.getContext())
                        .inflate(R.layout.card_contact, viewGroup, false);
                break;
            case 9:
                if (installations!=null && installations.get(0) instanceof RollerCoaster){
                    v = LayoutInflater.from(viewGroup.getContext())
                            .inflate(R.layout.card_attraction, viewGroup, false);
                }
                if (installations!=null && installations.get(0) instanceof Simulator){
                    v = LayoutInflater.from(viewGroup.getContext())
                            .inflate(R.layout.card_simulator, viewGroup, false);
                }
                if (installations!=null && installations.get(0) instanceof Store){
                    v = LayoutInflater.from(viewGroup.getContext())
                            .inflate(R.layout.card_store, viewGroup, false);
                }
                if (installations!=null && installations.get(0) instanceof Restaurant){
                    v = LayoutInflater.from(viewGroup.getContext())
                            .inflate(R.layout.card_restaurant, viewGroup, false);
                }
                if (installations!=null && installations.get(0) instanceof Show){
                    v = LayoutInflater.from(viewGroup.getContext())
                            .inflate(R.layout.card_show, viewGroup, false);
                }
                if (installations!=null && installations.get(0) instanceof Contact){
                    v = LayoutInflater.from(viewGroup.getContext())
                            .inflate(R.layout.card_contact, viewGroup, false);
                }
                break;
        }
        AttractionViewHolder pvh = new AttractionViewHolder(v);
        return pvh;
    }

    @Override
    public void onBindViewHolder(AttractionViewHolder attractionViewHolder, int i) {

        switch (selection){
            case 1: //show attractions
                fillAttractions(attractionViewHolder,i);
                break;
            case 2: //show simulators
                fillSimulators(attractionViewHolder,i);
                break;

            case 3: //show restaurant
                fillRestaurants(attractionViewHolder,i);
                break;
            case 4: //show food
                fillFood(attractionViewHolder,i);
                break;
            case 5: //show shows
                fillShows(attractionViewHolder,i);
                break;
            case 6: //show stores
                fillStores(attractionViewHolder,i);
                break;
            case 7: //show items
                fillItems(attractionViewHolder,i);
                break;
            case 8:
                fillContacts(attractionViewHolder, i);
                break;
            case 9:
                if (installations!=null && installations.get(0) instanceof RollerCoaster){
                    fillAttractions(attractionViewHolder, i);
                }
                if (installations!=null && installations.get(0) instanceof Simulator){
                    fillSimulators(attractionViewHolder, i);
                }
                if (installations!=null && installations.get(0) instanceof Store){
                    fillStores(attractionViewHolder, i);
                }
                if (installations!=null && installations.get(0) instanceof Restaurant){
                    fillRestaurants(attractionViewHolder, i);
                }
                if (installations!=null && installations.get(0) instanceof Show){
                    fillShows(attractionViewHolder, i);
                }
                if (installations!=null && installations.get(0) instanceof Contact){
                    fillContacts(attractionViewHolder, i);
                }
        }
    }
    public void fillAttractions(AttractionViewHolder attractionViewHolder, int i){
        RollerCoaster rollerCoaster =(RollerCoaster)installations.get(i);

        attractionViewHolder.name.setText(rollerCoaster.name);
        attractionViewHolder.description.setText(rollerCoaster.description);
        attractionViewHolder.schedule.setText(rollerCoaster.getSchedule());
        attractionViewHolder.state.setText(rollerCoaster.state);
        attractionViewHolder.timeToWait.setText(rollerCoaster.timeToWait);

    }
    public void fillSimulators(AttractionViewHolder attractionViewHolder, int i){
        Simulator simulator=(Simulator)installations.get(i);

        attractionViewHolder.name.setText(simulator.name);
        attractionViewHolder.description.setText(simulator.description);
        attractionViewHolder.schedule.setText(simulator.getSchedule());
        attractionViewHolder.state.setText(simulator.state);
        attractionViewHolder.capacity.setText(simulator.capacity);
        attractionViewHolder.timeToWait.setText(simulator.timeToWait);
    }
    public void fillRestaurants(AttractionViewHolder attractionViewHolder, int i){
        final Restaurant restaurant=(Restaurant)installations.get(i);

        attractionViewHolder.name.setText(restaurant.name);
        attractionViewHolder.schedule.setText(restaurant.getSchedule());


        attractionViewHolder.btn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Perform action on click
                Intent intent = new Intent(v.getContext(),ShowInfoController.class);
                Bundle b = new Bundle();
                b.putInt("Selection", 4);
                b.putString("Id", restaurant.id);
                intent.putExtras(b);
                v.getContext().startActivity(intent);
            }
        });

    }
    public void fillFood(AttractionViewHolder attractionViewHolder, int i){
        Food food=(Food)installations.get(i);

        attractionViewHolder.name.setText(food.name);
        attractionViewHolder.description.setText(food.description);
    }
    public void fillShows(AttractionViewHolder attractionViewHolder, int i){
        Show show=(Show)installations.get(i);

        attractionViewHolder.name.setText(show.name);
        attractionViewHolder.schedule.setText(show.getSchedule());
        attractionViewHolder.place.setText(show.place);
        attractionViewHolder.description.setText(show.description);
    }
    public void fillStores(AttractionViewHolder attractionViewHolder, int i){
        final Store store=(Store)installations.get(i);

        attractionViewHolder.name.setText(store.name);
        attractionViewHolder.schedule.setText(store.getSchedule());

        attractionViewHolder.btn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Perform action on click
                Intent intent = new Intent(v.getContext(),ShowInfoController.class);
                Bundle b = new Bundle();
                b.putInt("Selection", 7);
                b.putString("Id", store.id);
                intent.putExtras(b);
                v.getContext().startActivity(intent);
            }
        });

    }
    public void fillItems(AttractionViewHolder attractionViewHolder, int i){
        Item item=(Item)installations.get(i);

        attractionViewHolder.name.setText(item.name);
        attractionViewHolder.price.setText(item.price);
        attractionViewHolder.amount.setText(item.amount);
    }
    public void fillContacts(AttractionViewHolder attractionViewHolder, int i){
        Contact contact=(Contact)installations.get(i);

        attractionViewHolder.name.setText(contact.name);
        attractionViewHolder.employment.setText(contact.employment);
        attractionViewHolder.num.setText(contact.num);
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

}
