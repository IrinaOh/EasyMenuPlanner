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

public class MenuViewHolder extends RecyclerView.ViewHolder {

    private TextView recipeName;
    private Recipe recipe;
    private boolean isAddRecipe;
    private TextView meal;
    private Button addRecipeButton;

    public MenuViewHolder(@NonNull View itemView) {
        super(itemView);
        recipeName = itemView.findViewById(R.id.tvRecipeName);
        meal = itemView.findViewById(R.id.tvMeal);
        addRecipeButton = itemView.findViewById(R.id.addRecipebButton);

        addRecipeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MenuFragmentDirections.ActionNavigationMenuToNavigationCookbook action = MenuFragmentDirections.actionNavigationMenuToNavigationCookbook(meal.getText().toString());
                // CookbookFragmentDirections.ActionNavCookbookToNavRecipe action =
                   //     CookbookFragmentDirections.actionNavCookbookToNavRecipe(recipe);

                Navigation.findNavController(v).navigate(action);
            }
        });
    }

    public void bindData(Recipe recipe, int position) {
        this.recipe = recipe;
        if (recipe == null) {
            recipeName.setText("");
        } else {
            recipeName.setText(recipe.getRecipeName());
        }
        if (position == 0) {
            meal.setText("Breakfast");
        } else if (position == 1) {
            meal.setText("Lunch");
        } else {
            meal.setText("Dinner");
        }

    }
}
