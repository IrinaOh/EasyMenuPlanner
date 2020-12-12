package com.example.easymenuplanner.repositories;

import android.app.Application;

import com.example.easymenuplanner.database.MenuDao;
import com.example.easymenuplanner.database.RecipeDao;
import com.example.easymenuplanner.database.CookbookDatabase;
import com.example.easymenuplanner.menu.Menudb;
import com.example.easymenuplanner.recipe.Recipedb;

import java.util.Date;
import java.util.List;

public class CookbookRepository {
    private static CookbookRepository instance;
    private RecipeDao recipeDao;
    private List<Recipedb> cookbook;
    private MenuDao menuDao;
    private List<Menudb> menus;
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

    public List<Recipedb> getCookbook() {
        CookbookDatabase db = CookbookDatabase.getDbInstance(application);
        recipeDao = db.cookbookDao();
        cookbook = recipeDao.getAllRecipes();
        return cookbook;
    }

    public List<Recipedb> findRecipe(String recipeName) {
        CookbookDatabase db = CookbookDatabase.getDbInstance(application);
        recipeDao = db.cookbookDao();
        cookbook = recipeDao.findRecipe(recipeName);
        return cookbook;
    }

    public List<Menudb> getMenus() {
        CookbookDatabase db = CookbookDatabase.getDbInstance(application);
        menuDao = db.menuDao();
        menus = menuDao.getAllMenus();
        return menus;
    }

    public void addMenu(Menudb menu) {
        CookbookDatabase db = CookbookDatabase.getDbInstance(application);
        menuDao = db.menuDao();
        menuDao.insertMenu(menu);
    }

    public Recipedb getRecipeFromID(int recipeID) {
        CookbookDatabase db = CookbookDatabase.getDbInstance(application);
        recipeDao = db.cookbookDao();
        Recipedb recipe = recipeDao.getRecipeFromID(recipeID);
        return recipe;
    }

    public int getRecipeID(String recipeName) {
        CookbookDatabase db = CookbookDatabase.getDbInstance(application);
        recipeDao = db.cookbookDao();
        int id = recipeDao.getRecipeID(recipeName);
        return id;
    }
//    public Menudb findRecipeByID(int id) {
//
//    }

    public Menudb findLastMenu() {
        CookbookDatabase db = CookbookDatabase.getDbInstance(application);
        menuDao = db.menuDao();
        Menudb menu = menuDao.findLastMenu();
        return menu;
    }

    public void insertRecipe(Recipedb recipe) {
        recipeDao.insertRecipe(recipe);
    }

    public void deleteRecipe(Recipedb recipe) {
        recipeDao.delete(recipe);
    }

}
