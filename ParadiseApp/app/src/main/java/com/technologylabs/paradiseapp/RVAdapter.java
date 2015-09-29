package com.technologylabs.paradiseapp;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class RVAdapter extends RecyclerView.Adapter<RVAdapter.AttractionViewHolder >{

    List<Installation> installations;
    static int selection;
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
            //PENDING TO ADD BUTTONS OF FOODS
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
            //PENDING TO ADD BUTTONS OF ITEMS
        }
        public void showItems(){
            name = (TextView)itemView.findViewById(R.id.name);
            price = (TextView)itemView.findViewById(R.id.price);
            amount = (TextView)itemView.findViewById(R.id.amount);
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
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.card_attraction, viewGroup, false);
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
        attractionViewHolder.timeToWait.setText(simulator.timeToWait);
        attractionViewHolder.capacity.setText(simulator.capacity);
    }
    public void fillRestaurants(AttractionViewHolder attractionViewHolder, int i){
        Restaurant restaurant=(Restaurant)installations.get(i);

        attractionViewHolder.name.setText(restaurant.name);
        attractionViewHolder.schedule.setText(restaurant.getSchedule());
        //PENDING TO ADD THE BUTTONS OF FOOD
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
        Store store=(Store)installations.get(i);

        attractionViewHolder.name.setText(store.name);
        attractionViewHolder.schedule.setText(store.getSchedule());
        //PENDING TO ADD THE BUTTONS OF FOOD

    }
    public void fillItems(AttractionViewHolder attractionViewHolder, int i){
        Item item=(Item)installations.get(i);

        attractionViewHolder.name.setText(item.name);
        attractionViewHolder.price.setText(item.price);
        attractionViewHolder.amount.setText(item.amount);
    }


    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

}
