package com.example.easymenuplanner;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import java.util.ArrayList;

public class CardAdapter extends PagerAdapter {
    private Context context;
    private ArrayList<Card> cardArrayList;

    //constructor
    public CardAdapter(Context context, ArrayList<Card> cardArrayList) {
        this.context = context;
        this.cardArrayList = cardArrayList;
    }



    @Override
    public int getCount() {
        return cardArrayList.size(); //return number of items in the list
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view.equals(object);
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        //inflate layout card_item.xml
        View view = LayoutInflater.from(context).inflate(R.layout.card_item, container, false);

        //init uid views from card_item.xml
        ImageView bannerM = view.findViewById(R.id.bannerM);
        TextView dateM = view.findViewById(R.id.dateM);
        TextView descriptionM = view.findViewById(R.id.descriptionM);
        TextView tagM = view.findViewById(R.id.tagM);

        //get data
        Card card = cardArrayList.get(position);
        String date = card.getDate();
        String description = card.getDescription();
        String tag = card.getTag();
        int image = card.getImage();

        //set data
        bannerM.setImageResource(image);
        dateM.setText(date);
        descriptionM.setText(description);
        tagM.setText(tag);

        //handle card click
        view.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                Toast.makeText(context, "View recipes", Toast.LENGTH_SHORT).show();
            }
        });

        //add view to container
        container.addView(view, position);

        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View)object);
    }
}
