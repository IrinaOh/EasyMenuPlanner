package com.example.easymenuplanner.recipe;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.easymenuplanner.recipe.IngredientViewHolder;
import com.example.easymenuplanner.R;

import java.util.ArrayList;
import java.util.List;

public class IngredientAdapter extends RecyclerView.Adapter<IngredientViewHolder> {
    private Recipe recipe;
    private List<Ingredient> ingredients = new ArrayList<>();

    public IngredientAdapter(Recipe recipe) {
        this.recipe = recipe;
    }

    @Override
    public int getItemViewType(int position) {
        return R.layout.ingredient_item;
    }

    @NonNull
    @Override
    public IngredientViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(viewType, parent, false);
        return new IngredientViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull IngredientViewHolder holder, int position) {
        holder.bindData(recipe.getIngredients().get(position));

    }

    @Override
    public int getItemCount() {
        return recipe.getIngredients().size();
    }
}
