package com.example.easymenuplanner.menu;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.example.easymenuplanner.recipe.Recipedb;
import com.example.easymenuplanner.repositories.CookbookRepository;

import java.util.List;

public class MenuViewModel extends AndroidViewModel {
    private CookbookRepository cookbookRepository;
    private MutableLiveData<List<Menudb>> liveMenus;
    private List<Menudb> menus;
    Application application;

    public MenuViewModel(Application application) {
        super(application);
    }


    public void init() {
        if (menus != null) {
            return;
        }
        cookbookRepository =  cookbookRepository.getInstance(application);
        menus = cookbookRepository.getMenus();
        liveMenus = new MutableLiveData<>();
        liveMenus.setValue(menus);
    }

    public MutableLiveData<List<Menudb>> getMenus() {
        readFromDatabase();
        return liveMenus;
    }

    private void readFromDatabase() {
        menus = cookbookRepository.getMenus();
        liveMenus.setValue(menus);
    }
}
