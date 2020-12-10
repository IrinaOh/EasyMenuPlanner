package com.example.easymenuplanner.addRecipe;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.easymenuplanner.recipe.Recipedb;
import com.example.easymenuplanner.repositories.CookbookRepository;

import java.util.List;

public class AddRecipeViewModel extends AndroidViewModel {
    private CookbookRepository cookbookRepository;
    private LiveData<List<Recipedb>> cookbook;
    Application application;
    private Recipedb recipe;
    private String recipeTitle, recipeDescription, recipeIngredients, recipeInstructions, recipeTag;
    private float recipeNumServings;



    public AddRecipeViewModel(Application application) {
        super(application);
        this.application = application;
    }

    public void init() {
        if (cookbook != null) {
            return;
        }
        cookbookRepository =  cookbookRepository.getInstance(application);
        cookbook = cookbookRepository.getCookbook();
    }

    public LiveData<List<Recipedb>> getCookbook() {
        return cookbook;
    }

    public void addRecipe(String title, String desc, String ingr, String instr, String tag, int numServ) {
        Recipedb recipe = new Recipedb();
        recipe.title = title;
        recipe.description = desc;
        recipe.ingredients = ingr;
        recipe.directions = instr;
        recipe.tag = tag;
        recipe.numServings = numServ;
        cookbookRepository.insertRecipe(recipe);
    }

}
