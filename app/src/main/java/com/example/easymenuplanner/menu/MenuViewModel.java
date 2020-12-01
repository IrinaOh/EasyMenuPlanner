package com.example.easymenuplanner.menu;

import com.example.easymenuplanner.recipe.Ingredient;
import com.example.easymenuplanner.recipe.Recipe;

import java.util.ArrayList;
import java.util.List;

public class MenuViewModel {
    private List<Recipe> recipes;

    public MenuViewModel() {
        recipes = new ArrayList<>();
        Recipe r1 = new Recipe("Fried Chicken", "Best Southern Fried Chicken ever.", 12);
        r1.addIngredient(new Ingredient("Chicken", 12.0f, null));
        r1.addIngredient(new Ingredient("Flour", 1f, "cup"));
        r1.addIngredient(new Ingredient("Salt", 1f, "tsp"));
        r1.addIngredient(new Ingredient("Pepper", 1f, "tsp"));
        r1.addIngredient(new Ingredient("Paprika", 1f, "tsp"));
        r1.addIngredient(new Ingredient("eggs", 3f, null));
        r1.addInstruction("Combine dry ingredients in a 1 gallon bag");
        r1.addInstruction("Place chicken in bag one at a time and shake, coating with flour mixture.  This is going to be great.  I really hope you like this.");
        recipes.add(r1);

        Recipe r2 = new Recipe("Hamburgers", "Move over In-N-Out", 4);
        r2.addIngredient(new Ingredient("Ground Beef", 1, "lb"));
        r2.addIngredient(new Ingredient("A1 Steak Sauce", 1, "Tbsp"));
        r2.addIngredient(new Ingredient("Ketchup", 3, "Tbsp"));
        r2.addIngredient(new Ingredient("Hamburger Buns", 1, "Package"));
        r2.addInstruction("Mix ground beef and A1 sauce");
        r2.addInstruction("Create four patties");
        r2.addInstruction("Cook on grill");
        recipes.add(r2);

        recipes.add(null);
    }

    public int getSize() {
        return recipes.size();
    }

    public Recipe getRecipe(int position) {
        return recipes.get(position);
    }

}
