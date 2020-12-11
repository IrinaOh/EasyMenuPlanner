package com.example.easymenuplanner.cookbook;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

public class CookbookViewModelFactory extends ViewModelProvider.AndroidViewModelFactory {
    private Application application;

    public CookbookViewModelFactory(@NonNull Application application) {
        super(application);
        this.application = application;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        return (T) new CookbookViewModel(application);

    }
}
