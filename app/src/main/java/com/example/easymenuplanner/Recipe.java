package com.example.easymenuplanner;

import java.util.ArrayList;
import java.util.List;

public class Recipe {
    private List<Ingredient> ingredients;
    private List<String> instructions;

    public Recipe() {
        ingredients = new ArrayList<>();
        instructions = new ArrayList<>();
    }

    public void addIngredient(Ingredient newIngredient) {
        ingredients.add(newIngredient);
    }

    public void addInstruction(String newInstruction) {
        instructions.add(newInstruction);
    }

}
