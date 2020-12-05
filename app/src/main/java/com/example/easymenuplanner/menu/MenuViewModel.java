package com.example.easymenuplanner.menu;

import com.example.easymenuplanner.recipe.Ingredient;
import com.example.easymenuplanner.recipe.Recipe;

import java.util.ArrayList;
import java.util.List;

public class MenuViewModel {
    private List<Recipe> recipes;

    public MenuViewModel() {
        recipes = new ArrayList<>();
        recipes.add(null);
        recipes.add(null);
        recipes.add(null);
    }

    public int getSize() {
        return recipes.size();
    }

    public Recipe getRecipe(int position) {
        return recipes.get(position);
    }

}
