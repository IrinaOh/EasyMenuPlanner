package com.example.easymenuplanner.cookbook;

import android.os.Bundle;
import android.view.View;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.recyclerview.widget.RecyclerView;

import com.example.easymenuplanner.R;
import com.example.easymenuplanner.recipe.Recipe;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

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
}
