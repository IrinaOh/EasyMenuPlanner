package com.example.easymenuplanner.searchRecipe;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ApiRecipe {
    //@SerializedName("recipe")
    private String label;
    private String url;
    //private String picture;
    private List<ApiIngredient> ingredients;
    private Float calories;

    public ApiRecipe(String label, String url, List<ApiIngredient> ingredients, Float calories) {
        this.label = label;
        this.url = url;
        this.ingredients = ingredients;
        this.calories = calories;

    }

    public String getTitle() { return label; }
    public String getUrl() { return url; }
    //public String getPicture() { return picture; }
    public List<ApiIngredient> getIngredients() { return ingredients; }
}
