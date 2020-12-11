package com.example.easymenuplanner.searchRecipe;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class ApiIngredient {
    private String text;
    private Float quantity;
    private String measure;
    private String food;

    public ApiIngredient(String text, Float quantity, String measure, String food){
        this.text = text;
        this.quantity = quantity;
        this.measure = measure;
        this.food = food;
    }

}
