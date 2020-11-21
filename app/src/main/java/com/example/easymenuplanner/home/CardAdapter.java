package com.example.easymenuplanner.home;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.easymenuplanner.R;
import java.util.ArrayList;
import java.util.List;

public class CardAdapter extends RecyclerView.Adapter<CardViewHolder> {

    private List<Card> dayCards = new ArrayList<>();

    /*
    private String[] descriptions = {"You have no recipes selected",
            "You have no recipes selected",
            "You have no recipes selected"};

    private String[] tags = {"Chicken", "Steak", "Fish"};

    private String[] dates = {"November 23, 2020",
            "November 24, 2020",
            "November 25, 2020"};

    private int[] images = {R.drawable.monday, R.drawable.tuesday, R.drawable.wednesday};
    */

    public CardAdapter() {
        dayCards.add(new Card("November 23, 2020", "You have no recipes selected","Chicken", R.drawable.monday));
        dayCards.add(new Card("November 24, 2020", "You have no recipes selected","Chicken", R.drawable.tuesday));
        dayCards.add(new Card("November 25, 2020", "You have no recipes selected","Chicken", R.drawable.wednesday));
    }

    @Override
    public int getItemViewType(int position) {
        return R.layout.card_item;
    }

    @NonNull
    @Override
    public CardViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(viewType, parent, false);
        return new CardViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CardViewHolder holder, int position) {
        holder.getBannerView().setImageResource(dayCards.get(position).image);
        holder.getDateView().setText(dayCards.get(position).date);
        holder.getDescriptionView().setText(dayCards.get(position).description);
        holder.getDateView().setText(dayCards.get(position).date);
    }

    @Override
    public int getItemCount() {
        return 3;
    }

}