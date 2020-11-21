package com.example.easymenuplanner;

import java.util.ArrayList;
import java.util.List;

public class Recipe {
    private String recipeName;
    private String description;
    private List<Ingredient> ingredients;
    private List<String> instructions;
    private int numServings;
    private int cookTime;
    private int prepTime;


    public Recipe() {
        ingredients = new ArrayList<>();
        instructions = new ArrayList<>();
        recipeName="";
    }

    public Recipe(String recipeName, String description, int numServings) {
        this.recipeName = recipeName;
        this.description = description;
        this.numServings = numServings;
        ingredients = new ArrayList<>();
        instructions = new ArrayList<>();
        int cookTime = 20;
        int prepTime = 20;
    }

    public void addIngredient(Ingredient newIngredient) {
        ingredients.add(newIngredient);
    }

    public void addInstruction(String newInstruction) {
        instructions.add(newInstruction);
    }

    public void setRecipeName(String recipeName) {
        this.recipeName = recipeName;
    }

    public String getRecipeName() {
        return recipeName;
    }

    public int getNumServings() {
        return numServings;
    }

    public String getDescription() {
        return description;
    }
}
