package com.example.easymenuplanner.menu;

import com.example.easymenuplanner.recipe.Recipedb;

import java.util.Calendar;

public class MenuDisplay {

    private Recipedb recipe;
    private Calendar date;
    private int menuID;

    public MenuDisplay(Recipedb recipe, Calendar date, int menuID) {
        this.recipe = recipe;
        this.date = date;
        this.menuID = menuID;
    }

    public Recipedb getRecipe() {
        return recipe;
    }

    public void setRecipe(Recipedb recipe) {
        this.recipe = recipe;
    }

    public Calendar getDate() {
        return date;
    }

    public void setDate(Calendar date) {
        this.date = date;
    }
}
