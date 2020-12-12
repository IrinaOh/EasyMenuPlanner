package com.example.easymenuplanner.menu;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.example.easymenuplanner.recipe.Recipedb;
import com.example.easymenuplanner.repositories.CookbookRepository;

import java.beans.IndexedPropertyChangeEvent;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.security.auth.callback.Callback;

public class MenuViewModel extends AndroidViewModel {
    private CookbookRepository cookbookRepository;
    private List<Recipedb> cookbook;
    private MutableLiveData<List<MenuDisplay>> liveMenus;
    private List<Menudb> dbMenus;
    private List<MenuDisplay> menuDisp;
    Application application;
    private Menudb lastMenu;

    public MenuViewModel(Application application) {
        super(application);
        this.application = application;
    }


    public void init() {
        if (dbMenus != null) {
            return;
        }
        cookbookRepository =  cookbookRepository.getInstance(application);
        cookbook = cookbookRepository.getCookbook();
        dbMenus = cookbookRepository.getMenus();
        initializeMenuTable();
        dbMenus = cookbookRepository.getMenus();
        liveMenus = new MutableLiveData<>();
        createMenuDisplayList(dbMenus);
        liveMenus.setValue(menuDisp);
    }

    public MutableLiveData<List<MenuDisplay>> getMenus() {
        dbMenus = cookbookRepository.getMenus();
        createMenuDisplayList(dbMenus);
        liveMenus.setValue(menuDisp);
        return liveMenus;
        //readFromDatabase();
       // return liveMenus;
    }

//    private void readFromDatabase() {
//
//        dbMenus = cookbookRepository.getMenus();
//
//
//        liveMenus.setValue(menus);
//    }

    private void createMenuDisplayList(List<Menudb> dbMenus) {
        Recipedb recipe;
        menuDisp = new ArrayList<>();
        for (Menudb m: dbMenus) {
            recipe = cookbookRepository.getRecipeFromID(m.recipe_id);
            Calendar calDate = Calendar.getInstance();
            calDate.setTime(m.date);
            MenuDisplay tempMenu =  new MenuDisplay(recipe, calDate, m.id);
            menuDisp.add(tempMenu);
        }
    }

    private void initializeMenuTable() {

        if (dbMenus == null || dbMenus.size() == 0) {
            try {
                List<Recipedb> emptyList = cookbookRepository.findRecipe("");
                if (emptyList == null || emptyList.size() == 0) {
                    addBlankRecipe();
                }
            } catch (Exception e) {
                addBlankRecipe();
            }

            int blankID = cookbookRepository.getRecipeID("");
            Calendar date = Calendar.getInstance();
            date.setTime(new Date());

            for (int iDays = 0; iDays <= 9; iDays++) {
                Menudb tempMenu = new Menudb();
                tempMenu.recipe_id = blankID;
                tempMenu.date = date.getTime();
                cookbookRepository.addMenu(tempMenu);
                date.add(Calendar.DATE, 1);
            }
        } else {
            lastMenu = cookbookRepository.findLastMenu();
            Calendar lastMenuDate = Calendar.getInstance();
            lastMenuDate.setTime(lastMenu.date);
            long pastDays = TimeUnit.MILLISECONDS.toDays(Calendar.getInstance().getTimeInMillis() - lastMenuDate.getTimeInMillis());

            try {
                List<Recipedb> emptyList = cookbookRepository.findRecipe("");
                if (emptyList == null || emptyList.size() == 0) {
                    addBlankRecipe();
                }
            } catch (Exception e2) {
                addBlankRecipe();
            }

            int blankID = cookbookRepository.getRecipeID("");
            if (pastDays >= 1) {
                // Create a new list of menus for 10 days starting from today;
                // Add blank recipe to database
                Calendar date = Calendar.getInstance();
                date.setTime(new Date());


                for (int iDays = 0; iDays <= 9; iDays++) {
                    Menudb tempMenu = new Menudb();
                    tempMenu.recipe_id = blankID;
                    tempMenu.date = date.getTime();
                    date.add(Calendar.DATE, 1);
                    cookbookRepository.addMenu(tempMenu);
                }
            } else if (pastDays > - 5 && pastDays < 0) {
                // make sure we have 5 days into the future
                long addDays = pastDays + 5;
                Calendar date = Calendar.getInstance();
                date.setTime(lastMenuDate.getTime());

                for (int iDays = 0; iDays < addDays; iDays++) {
                    date.add(Calendar.DATE, 1);
                    Menudb tempMenu = new Menudb();
                    tempMenu.recipe_id = blankID;
                    tempMenu.date = date.getTime();
                    cookbookRepository.addMenu(tempMenu);
                }
            }
        }
    }

    public void addBlankRecipe() {
        Recipedb emptyRecipe = new Recipedb();
        emptyRecipe.title = "";
        emptyRecipe.numServings = 0;
        cookbookRepository.insertRecipe(emptyRecipe);
    }
}
