package com.example.easymenuplanner.searchRecipe;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ApiRecipes {
    @SerializedName("hits")
    private String title;
    private String url;
    //private String picture;
    private List<String> ingredients;

    public String getTitle() { return title; }
    public String getUrl() { return url; }
    //public String getPicture() { return picture; }
    public List<String> getIngredients() { return ingredients; }
}
