package com.example.easymenuplanner.recipe;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.easymenuplanner.R;

public class IngredientViewHolder extends RecyclerView.ViewHolder {
    private TextView ingredient_textView;
    public IngredientViewHolder(@NonNull View itemView) {
        super(itemView);
        ingredient_textView = itemView.findViewById(R.id.tvIngredient);
    }

    public void bindData(Ingredient ing) {
        ingredient_textView.setText(ing.toString());

    }
}
