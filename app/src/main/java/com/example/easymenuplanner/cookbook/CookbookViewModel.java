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
    private LiveData<List<Recipedb>> cookbook;
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
    }

    public LiveData<List<Recipedb>> getCookbook() {
        return cookbook;
    }

}
