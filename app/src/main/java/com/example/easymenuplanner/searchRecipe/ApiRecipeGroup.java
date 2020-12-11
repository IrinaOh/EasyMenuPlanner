package com.example.easymenuplanner.searchRecipe;

import java.util.List;

public class ApiRecipeGroup {

    private List<ApiRecipeTop> hits;



    public List<ApiRecipeTop> getAllRecipes() {
        return this.hits;
    }
}
