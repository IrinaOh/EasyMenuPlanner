package com.example.easymenuplanner.searchRecipe;

import android.net.Uri;

import com.google.gson.annotations.SerializedName;

import java.net.URI;
import java.util.List;

public class ApiRecipe {
    //@SerializedName("recipe")
    private String label;
    private String url;
    //private String picture;
    private List<ApiIngredient> ingredients;
    private Float calories;
    private String image;

    public ApiRecipe(String label, String url, List<ApiIngredient> ingredients, Float calories, String image) {
        this.label = label;
        this.url = url;
        this.ingredients = ingredients;
        this.calories = calories;
        this.image = image;

    }

    public String getTitle() { return label; }
    public String getUrl() { return url; }
    public String getImage() {return image; };
    public List<ApiIngredient> getIngredients() { return ingredients; }
}
