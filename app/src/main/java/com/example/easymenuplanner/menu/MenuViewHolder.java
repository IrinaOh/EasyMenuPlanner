package com.example.easymenuplanner.menu;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.example.easymenuplanner.R;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MenuViewHolder extends RecyclerView.ViewHolder {

    private Menu menu;
    private TextView menuDate;
    private TextView breakfastRecipeName;
    private TextView lunchRecipeName;
    private TextView dinnerRecipeName;
    private Button addBreakfastButton;
    private Button deleteBreakfastButton;
    private Button addLunchButton;
    private Button deleteLunchButton;
    private Button addDinnerButton;
    private Button deleteDinnerButton;
    private CardView breakfastCV;
    private CardView lunchCV;
    private CardView dinnerCV;

    public MenuViewHolder(@NonNull View itemView) {
        super(itemView);

        menuDate = itemView.findViewById(R.id.tvMenuDate);
        breakfastRecipeName = itemView.findViewById(R.id.tvBreakfastRecipeName);
        lunchRecipeName = itemView.findViewById(R.id.tvLunchRecipeName);
        dinnerRecipeName = itemView.findViewById(R.id.tvDinnerRecipeName);
        addBreakfastButton = itemView.findViewById(R.id.btAddBreakfast);
        deleteBreakfastButton = itemView.findViewById(R.id.btDeleteBreakfast);
        addLunchButton = itemView.findViewById(R.id.btAddLunch);
        deleteLunchButton = itemView.findViewById(R.id.btDeleteLunch);
        addDinnerButton = itemView.findViewById(R.id.btAddDinner);
        deleteDinnerButton = itemView.findViewById(R.id.btDeleteDinner);
        breakfastCV = itemView.findViewById(R.id.cvBreakfastRecipe);
        lunchCV = itemView.findViewById(R.id.cvLunchRecipe);
        dinnerCV = itemView.findViewById(R.id.cvDinnerRecipe);


        //*************View Recipes Listeners on Cards ******
        breakfastCV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (breakfastRecipeName.getText().equals("")) {

                } else {
                    MenuFragmentDirections.ActionNavigationMenuToNavigationRecipe action =
                            MenuFragmentDirections.actionNavigationMenuToNavigationRecipe(menu.getRecipe(0));
                    Navigation.findNavController(v).navigate(action);
                }
            }
        });

       lunchCV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (lunchRecipeName.getText().equals("")) {

                } else {
                    MenuFragmentDirections.ActionNavigationMenuToNavigationRecipe action =
                            MenuFragmentDirections.actionNavigationMenuToNavigationRecipe(menu.getRecipe(1));
                    Navigation.findNavController(v).navigate(action);
                }
            }
        });

        dinnerCV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (dinnerRecipeName.getText().equals("")) {

                } else {
                    MenuFragmentDirections.ActionNavigationMenuToNavigationRecipe action =
                            MenuFragmentDirections.actionNavigationMenuToNavigationRecipe(menu.getRecipe(2));
                    Navigation.findNavController(v).navigate(action);
                }
            }
        });

        //*************Add Recipe Buttons ******
        addBreakfastButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MenuFragmentDirections.ActionNavigationMenuToNavigationCookbook action =
                        MenuFragmentDirections.actionNavigationMenuToNavigationCookbook("Breakfast");
                Navigation.findNavController(v).navigate(action);
            }
        });

        addLunchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MenuFragmentDirections.ActionNavigationMenuToNavigationCookbook action =
                        MenuFragmentDirections.actionNavigationMenuToNavigationCookbook("Lunch");
                Navigation.findNavController(v).navigate(action);
            }
        });

        addDinnerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MenuFragmentDirections.ActionNavigationMenuToNavigationCookbook action =
                        MenuFragmentDirections.actionNavigationMenuToNavigationCookbook("Dinner");
                Navigation.findNavController(v).navigate(action);
            }
        });

        //*************Delete Recipe Buttons ******
        deleteBreakfastButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (breakfastRecipeName.getText().equals("")) {
                    
                } else {
                    menu.deleteRecipe("breakfast");
                    breakfastRecipeName.setText("");
                }
            }
        });

        deleteLunchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (lunchRecipeName.getText().equals("")) {

                } else {
                    menu.deleteRecipe("lunch");
                    lunchRecipeName.setText("");
                }
            }
        });

        deleteDinnerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (dinnerRecipeName.getText().equals("")) {

                } else {
                    menu.deleteRecipe("dinner");
                    dinnerRecipeName.setText("");
                }
            }
        });
    }

    public void bindData(Menu menu) {
        this.menu = menu;
        breakfastRecipeName.setText(menu.getRecipe(0).getRecipeName());
        lunchRecipeName.setText(menu.getRecipe(1).getRecipeName());
        dinnerRecipeName.setText(menu.getRecipe(2).getRecipeName());

        SimpleDateFormat formatter = new SimpleDateFormat("E, dd MMM yyyy");
        Date date = menu.getDate().getTime();
        String strDate = formatter.format(date);
        menuDate.setText(strDate);
    }
}
