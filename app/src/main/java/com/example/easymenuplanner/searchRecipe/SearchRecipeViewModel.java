package com.example.easymenuplanner.searchRecipe;

import android.app.Activity;

import androidx.lifecycle.ViewModel;

import java.lang.ref.WeakReference;
import java.util.List;

public class SearchRecipeViewModel extends ViewModel {

    private Activity activity;

    public SearchRecipeViewModel(Activity activity) {
        this.activity = activity;
    }



}
