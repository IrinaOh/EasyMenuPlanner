package com.example.easymenuplanner.recipe;

import java.util.List;

public class GetRecipes {
    private String title;
    private String url;
    //private String picture;
    private List<String> ingredients;

    public String getTitle() { return title; }
    public String getUrl() { return url; }
    //public String getPicture() { return picture; }
    public List<String> getIngredients() { return ingredients; }
}
