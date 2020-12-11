package com.example.easymenuplanner.cookbook;
import com.example.easymenuplanner.recipe.Recipe;
import com.example.easymenuplanner.recipe.Ingredient;
import java.util.ArrayList;
import java.util.List;

public class Cookbook {
    private List<Recipe> recipes;

    public Cookbook() {
        recipes = new ArrayList<>();
    }

    public void addRecipe(Recipe newRecipe) {
        recipes.add(newRecipe);
    }

    public Recipe getRecipe(int position) {
        return recipes.get(position);
    }

    public List<Recipe> getAllRecipes() {return recipes;}

    public int getSize() {
        return recipes.size();
    }
}
