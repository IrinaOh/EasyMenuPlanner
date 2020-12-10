package com.example.easymenuplanner.searchRecipe;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ApiRecipe {
    //@SerializedName("recipe")
    private String label;
    private String url;
    //private String picture;
    private ApiAllIngredients ingredients;

    public ApiRecipe(String label, String url, ApiAllIngredients ingredients) {
        this.label = label;
        this.url = url;
        this.ingredients = ingredients;
    }

    public String getTitle() { return label; }
    public String getUrl() { return url; }
    //public String getPicture() { return picture; }
    public ApiAllIngredients getIngredients() { return ingredients; }
}
