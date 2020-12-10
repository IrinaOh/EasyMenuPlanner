package com.example.easymenuplanner.repositories;

import android.app.Application;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.easymenuplanner.cookbook.Cookbook;
import com.example.easymenuplanner.database.CookbookDao;
import com.example.easymenuplanner.database.CookbookDatabase;
import com.example.easymenuplanner.recipe.Recipedb;

import java.util.List;

public class CookbookRepository {
    private static CookbookRepository instance;
    private CookbookDao cookbookDao;
    private LiveData<List<Recipedb>> cookbook;
    private Application application;

    private CookbookRepository(Application application) {
        this.application = application;
    }

    public static CookbookRepository getInstance(Application application) {
        if (instance == null) {
            instance = new CookbookRepository(application);
        }
        return instance;
    }

    public LiveData<List<Recipedb>> getCookbook() {
        CookbookDatabase db = CookbookDatabase.getDbInstance(application);
        cookbookDao = db.cookbookDao();
        cookbook = cookbookDao.getAllRecipes();
        return cookbook;
    }

    public void insertRecipe(Recipedb recipe) {
        cookbookDao.insertRecipe(recipe);
    }

    public void deleteRecipe(Recipedb recipe) {
        cookbookDao.delete(recipe);
    }

}
