package com.example.easymenuplanner.cookbook;

import com.example.easymenuplanner.Recipe;

import java.util.ArrayList;
import java.util.List;

public class Cookbook {
    private List<Recipe> recipes;

    public Cookbook() {
        recipes = new ArrayList<>();
    }

    public void addRecipe(Recipe newRecipe) {
        recipes.add(newRecipe);
    }
}
