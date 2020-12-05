package com.example.easymenuplanner.menu;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.example.easymenuplanner.R;
import com.example.easymenuplanner.cookbook.CookbookFragmentDirections;
import com.example.easymenuplanner.recipe.Recipe;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MenuViewHolder extends RecyclerView.ViewHolder {


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

        /*
        addRecipeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MenuFragmentDirections.ActionNavigationMenuToNavigationCookbook action = MenuFragmentDirections.actionNavigationMenuToNavigationCookbook(meal.getText().toString());
                // CookbookFragmentDirections.ActionNavCookbookToNavRecipe action =
                   //     CookbookFragmentDirections.actionNavCookbookToNavRecipe(recipe);

                Navigation.findNavController(v).navigate(action);
            }
        });

         */
    }

    public void bindData(Menu menu) {
        breakfastRecipeName.setText(menu.getRecipe(0).getRecipeName());
        lunchRecipeName.setText(menu.getRecipe(1).getRecipeName());
        dinnerRecipeName.setText(menu.getRecipe(2).getRecipeName());
        SimpleDateFormat formatter = new SimpleDateFormat("E, dd MMM yyyy");
        Date date = menu.getDate().getTime();
        String strDate = formatter.format(date);
        menuDate.setText(strDate);
    }
}
