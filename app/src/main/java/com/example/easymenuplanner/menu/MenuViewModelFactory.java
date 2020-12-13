package com.example.easymenuplanner.menu;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.example.easymenuplanner.cookbook.CookbookViewModel;

public class MenuViewModelFactory extends ViewModelProvider.AndroidViewModelFactory {

    private Application application;

    public MenuViewModelFactory(@NonNull Application application) {
        super(application);
        this.application = application;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        super.create(modelClass);
        return (T) new MenuViewModel(application);
    }
}
