package com.example.easymenuplanner.searchRecipe;

import java.util.List;

public class ApiRecipeGroup {
    private List<ApiRecipeTop> hits;

    public ApiRecipeGroup(List<ApiRecipeTop> hits) {
        this.hits = hits;
    }

    public List<ApiRecipeTop> getAllRecipes() {
        return hits;
    }
}
