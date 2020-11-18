package com.example.easymenuplanner;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    //actionbar
    private ActionBar actionBar;

    //UI views
    private ViewPager viewPager;

    private ArrayList<Card> cardArrayList;
    private CardAdapter cardAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

<<<<<<< HEAD
        //initialize actionBar
        actionBar = getSupportActionBar();

        //init UI views
        viewPager = findViewById(R.id.viewPager);
        loadCards();
        //set viewpager change listener
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                String date = cardArrayList.get(position).getDate();
                actionBar.setTitle(date);
            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    private void loadCards() {
        //init list
        cardArrayList = new ArrayList<>();

        //add items to list
        cardArrayList.add(new Card(
                "November 23, 2020",
                "You have no recipes selected",
                "Chicken",
                R.drawable.monday
        ));
        cardArrayList.add(new Card(
                "November 24, 2020",
                "You have no recipes selected",
                "Steak",
                R.drawable.tuesday
        ));
        cardArrayList.add(new Card(
                "November 25, 2020",
                "You have no recipes selected",
                "Fish",
                R.drawable.wednesday
        ));

        //setup adapter
        cardAdapter = new CardAdapter(this, cardArrayList);
        //set adapter to view pager
        viewPager.setAdapter(cardAdapter);
        //set default padding
        viewPager.setPadding(100, 0, 100, 0);
=======
>>>>>>> a213564... add Ingredient, Recipe, and Cookbook classes
    }
}