package com.example.easymenuplanner.cookbook;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.easymenuplanner.recipe.Recipedb;
import com.example.easymenuplanner.repositories.CookbookRepository;

import java.util.List;

public class CookbookViewModel extends AndroidViewModel {

    private CookbookRepository cookbookRepository;
    private MutableLiveData<List<Recipedb>> liveCookbook;
    private List<Recipedb> cookbook;
    Application application;

    public CookbookViewModel(Application application) {
        super(application);
        this.application = application;
    }

    public void init() {
        if (cookbook != null) {
            return;
        }
        cookbookRepository =  cookbookRepository.getInstance(application);
        cookbook = cookbookRepository.getCookbook();
        liveCookbook = new MutableLiveData<>();
        liveCookbook.setValue(cookbook);
    }

    public MutableLiveData<List<Recipedb>> getCookbook() {
        readFromDatabase();
        return liveCookbook;
    }

    private void readFromDatabase() {
        cookbook = cookbookRepository.getCookbook();
        liveCookbook.setValue(cookbook);
    }

}
