package com.example.easymenuplanner.menu;

import com.example.easymenuplanner.recipe.Recipe;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Menu {
    private List<Recipe> todaysMenu;
    private Calendar date;

    public Menu(Calendar date){
        todaysMenu = new ArrayList<>();
        todaysMenu.add( new Recipe("Lasagna", "I feel like I'm in Italy", 6));
        todaysMenu.add(new Recipe());
        todaysMenu.add( new Recipe("Spaghetti", "Awesome sauce.", 6));
        todaysMenu.add(new Recipe("Fried Chicken", "Best Southern Fried Chicken ever.", 12));

        this.date = date;
    }

    public Recipe getRecipe(int position) {
        return todaysMenu.get(position);
    }

    public List<Recipe> getAllRecipes() {
        return todaysMenu;
    }

    public Calendar getDate() {
        return date;
    }

    public void addRecipe(Recipe recipe, String meal) {

        if (meal.equals("Breakfast")) {
            todaysMenu.add(0, recipe);
        } else if (meal.equals("Lunch")) {
            todaysMenu.add(1, recipe);
        } else {
            todaysMenu.add(2, recipe);
        }
    }

    public void deleteRecipe(String meal) {
        if (meal.equals("Breakfast")) {
            todaysMenu.add(0, null);
        } else if (meal.equals("Lunch")) {
            todaysMenu.add(1, null);
        } else {
            todaysMenu.add(2, null);
        }
    }

}
