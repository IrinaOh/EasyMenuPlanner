package com.example.easymenuplanner.home;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;
import com.example.easymenuplanner.R;
import androidx.navigation.Navigation;

public class CardViewHolder extends RecyclerView.ViewHolder {

    ImageView bannerM;
    TextView dateM;
    TextView descriptionM;
    TextView tagM;

    CardViewHolder(View itemView) {
        super(itemView);
        bannerM = itemView.findViewById(R.id.bannerM);
        dateM = itemView.findViewById(R.id.dateM);
        descriptionM = itemView.findViewById(R.id.descriptionM);
        tagM = itemView.findViewById(R.id.tagM);


    }

    public ImageView getBannerView() {
        return bannerM;
    }

    public TextView getDateView() {
        return dateM;
    }

    public TextView getDescriptionView() {
        return descriptionM;
    }

    public TextView getTagView() {
        return tagM;
    }

}