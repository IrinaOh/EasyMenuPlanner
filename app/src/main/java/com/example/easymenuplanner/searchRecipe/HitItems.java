package com.example.easymenuplanner.searchRecipe;

import java.util.List;

public class HitItems {
    List<ApiRecipe> recipe;
    public HitItems (List<ApiRecipe> recipe) {
        this.recipe= recipe;
    }

    public List<ApiRecipe> getAllRecipes() {
        return recipe;
    }
}


