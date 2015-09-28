package com.technologylabs.paradiseapp;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class RVAdapter extends RecyclerView.Adapter<RVAdapter.AttractionViewHolder >{

    List<Attraction> attractions;

    public static class AttractionViewHolder extends RecyclerView.ViewHolder {
        public CardView cv;
        public TextView name;
        public TextView description;

        AttractionViewHolder (View itemView) {
            super(itemView);
            cv = (CardView)itemView.findViewById(R.id.rv);
            name = (TextView)itemView.findViewById(R.id.name);
            description = (TextView)itemView.findViewById(R.id.description);
        }
    }
    RVAdapter(List<Attraction> attractions){
        this.attractions = attractions;
    }

    @Override
    public int getItemCount() {
        return attractions.size();
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
        attractionViewHolder.name.setText(attractions.get(i).name);
        attractionViewHolder.description.setText(attractions.get(i).description);
    }


    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

}
