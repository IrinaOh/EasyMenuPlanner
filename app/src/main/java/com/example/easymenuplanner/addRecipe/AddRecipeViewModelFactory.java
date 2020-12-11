package com.example.easymenuplanner.addRecipe;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.example.easymenuplanner.cookbook.CookbookViewModel;

public class AddRecipeViewModelFactory extends ViewModelProvider.AndroidViewModelFactory {
    private Application application;
    public AddRecipeViewModelFactory(@NonNull Application application) {
        super(application);
        this.application = application;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        return (T) new AddRecipeViewModel(application);

    }
}
