package com.example.easymenuplanner.searchRecipe;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.easymenuplanner.R;
import com.example.easymenuplanner.cookbook.CookbookViewHolder;

import java.util.ArrayList;
import java.util.List;

public class SearchRecipeAdapter extends RecyclerView.Adapter<SearchRecipeViewHolder> {
    List<ApiRecipeTop> allRecipes = new ArrayList<>();
    Context context;

    public SearchRecipeAdapter(Context context, List<ApiRecipeTop> allRecipes) {
        this.context = context;
        this.allRecipes = allRecipes;
        if (allRecipes == null) {
            allRecipes = new ArrayList<>();
        }
    }

    @Override
    public int getItemViewType(int position) {
        return R.layout.search_recipe_item;
    }

    @NonNull
    @Override
    public SearchRecipeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(viewType, parent, false);
        return new SearchRecipeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SearchRecipeViewHolder holder, int position) {
        holder.bindData(allRecipes.get(position));
    }

    @Override
    public int getItemCount() {
        return allRecipes.size();
    }
}
