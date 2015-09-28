package com.technologylabs.paradisegardensapp;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Joshua on 27/09/2015.
 */
public class RVAdapter extends RecyclerView.Adapter<RVAdapter.AttractionViewHolder >{

    List<Attraction> attractions;

    RVAdapter(List<Attraction> attractions){
        this.attractions = attractions;
    }
    @Override
    public AttractionViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.abc_action_bar_title_item, viewGroup, false);
        AttractionViewHolder pvh = new AttractionViewHolder(v);
        return pvh;
    }

    @Override
    public void onBindViewHolder(AttractionViewHolder attractionViewHolder, int i) {
        attractionViewHolder.name.setText(attractions.get(i).name);
        attractionViewHolder.description.setText(attractions.get(i).description);
        attractionViewHolder.photo.setImageResource(attractions.get(i).photoId);
    }

    @Override
    public int getItemCount() {
        return attractions.size();
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    public static class AttractionViewHolder extends RecyclerView.ViewHolder {
        CardView cv;
        TextView name;
        TextView description;
        ImageView photo;

        AttractionViewHolder (View itemView) {
            super(itemView);
            cv = (CardView)itemView.findViewById(R.id.rv);
            name = (TextView)itemView.findViewById(R.id.name);
            description = (TextView)itemView.findViewById(R.id.description);
            photo = (ImageView)itemView.findViewById(R.id.photo);
        }
    }

}
