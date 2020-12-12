package com.example.easymenuplanner.searchRecipe;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.easymenuplanner.cookbook.CookbookViewHolder;

import java.util.ArrayList;
import java.util.List;

public class SearchRecipeAdapter extends RecyclerView.Adapter<SearchRecipeViewHolder> {
    List<ApiRecipeTop> allRecipes = new ArrayList<>();

    public SearchRecipeAdapter(List<ApiRecipeTop> allRecipes) {
        this.allRecipes = allRecipes;
        if (allRecipes == null) {
            allRecipes = new ArrayList<>();
        }
    }

    @NonNull
    @Override
    public SearchRecipeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(viewType, parent, false);
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
