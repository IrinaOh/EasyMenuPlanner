package com.example.easymenuplanner.recipe;

import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class IngredientAdapter extends RecyclerView.Adapter<IngredientViewHolder> {

    private List<Ingredient> ingredients = new ArrayList<>();

    public IngredientAdapter() {
        ingredients.add(new Ingredient("cup", 0.5f));
    }

    @NonNull
    @Override
    public IngredientViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull IngredientViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }
}
