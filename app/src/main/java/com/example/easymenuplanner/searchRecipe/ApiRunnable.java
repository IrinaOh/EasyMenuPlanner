package com.example.easymenuplanner.searchRecipe;

import android.app.Activity;
import android.content.Context;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.easymenuplanner.R;
import com.google.gson.Gson;

import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.Locale;

public class ApiRunnable implements Runnable {

    private WeakReference<Activity> activity;
    private Context context;
    private String query;

    public ApiRunnable(Activity activity, Context context, String searchItem) {
        this.activity = new WeakReference<>(activity);
        this.context = context;

      final String app_id = "661c2e42";
      final String api_key = "f2af3a7c771087f4a37bfadb93a34d97";
      final String baseUrl = "https://www.edamam.com/search";

      this.query = baseUrl +
                "?q=" + searchItem +
                "&app_id" + app_id +
                "&api_key=" + api_key;

    }

    @Override
    public void run() {
        try {
            final ApiRecipeGroup results = getRecipes();
            activity.get().runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    SearchRecipeAdapter searchAdapter = new SearchRecipeAdapter(context, results.getAllRecipes());
                    RecyclerView recycle = activity.get().findViewById(R.id.rv_recipeHits);
                    recycle.setLayoutManager(new LinearLayoutManager(context));
                    recycle.setAdapter(searchAdapter);
                }
            });
        } catch (IOException e) {
            final String altMessage = "Recipes not found";
            activity.get().runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    Toast.makeText(activity.get(), altMessage, Toast.LENGTH_LONG).show();
                }
            });
        }
    }

    private ApiRecipeGroup getRecipes() throws IOException{
            String recipes;
            try {
                recipes = HTTPGet.read(query);
            } catch (IOException e) {
                recipes = null;
            }

            Gson gson = new Gson();
            ApiRecipeGroup group = gson.fromJson(recipes, ApiRecipeGroup.class);
            return group;
    }
}
