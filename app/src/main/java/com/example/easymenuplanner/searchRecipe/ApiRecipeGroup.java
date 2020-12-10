package com.example.easymenuplanner.searchRecipe;

import java.util.List;

public class ApiRecipeGroup {
    private List<ApiRecipe> hits;

    public ApiRecipeGroup(List<ApiRecipe> hits) {
        this.hits = hits;
    }

    public List<ApiRecipe> getAllRecipes() {
        return hits;
    }
}
