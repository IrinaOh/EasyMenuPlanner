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

public class MenuViewHolder extends RecyclerView.ViewHolder {

    private Menudb menu;
    private TextView menuDate;
    private TextView dinnerRecipeName;
    private TextView menuDescription;
    private TextView menuIngredients;
    private Button addDinnerButton;
    private Button deleteDinnerButton;
    private CardView dinnerCV;
    private MenuDisplay menuDisplay;

    public MenuViewHolder(@NonNull View itemView) {
        super(itemView);
        menuDate = itemView.findViewById(R.id.tvMenuDate);
        dinnerRecipeName = itemView.findViewById(R.id.tvDinnerRecipeName);
        menuIngredients = itemView.findViewById(R.id.tvIngredients);
        menuDescription = itemView.findViewById(R.id.tvDescription);
        addDinnerButton = itemView.findViewById(R.id.btAddDinner);
        deleteDinnerButton = itemView.findViewById(R.id.btDeleteDinner);
        dinnerCV = itemView.findViewById(R.id.cvDinnerRecipe);

        //*************View Recipes Listeners on Cards ******

        dinnerCV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (dinnerRecipeName.getText().equals("")) {

                } else {
                    MenuFragmentDirections.ActionNavigationMenuToNavigationRecipe action =
                            MenuFragmentDirections.actionNavigationMenuToNavigationRecipe(menuDisplay.getRecipe().title, menuDisplay.getRecipe().ingredients,menuDisplay.getRecipe().directions);
                    Navigation.findNavController(v).navigate(action);
                }
            }
        });

        //*************Add Recipe Buttons ******


        addDinnerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MenuFragmentDirections.ActionNavigationMenuToNavigationCookbook action =
                        MenuFragmentDirections.actionNavigationMenuToNavigationCookbook(menuDisplay.getMenuID());
                Navigation.findNavController(v).navigate(action);
            }
        });

        //*************Delete Recipe Buttons ******

        deleteDinnerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dinnerRecipeName.setText("");
                menuDescription.setText("");
                menuIngredients.setText("");
            }
        });
    }

    public void bindData(MenuDisplay menu) {
        menuDisplay = menu;
        dinnerRecipeName.setText(menu.getRecipe().title);
        menuDescription.setText(menu.getRecipe().description);
        menuIngredients.setText(menu.getRecipe().ingredients);
        SimpleDateFormat formatter = new SimpleDateFormat("E, dd MMM yyyy");
        String strDate = formatter.format(menu.getDate().getTime());
        menuDate.setText(strDate);
    }
}
