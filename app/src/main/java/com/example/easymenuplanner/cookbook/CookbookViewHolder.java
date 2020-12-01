package com.example.easymenuplanner.cookbook;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.example.easymenuplanner.R;
import com.example.easymenuplanner.recipe.Recipe;
import com.google.android.material.snackbar.Snackbar;

public class CookbookViewHolder extends RecyclerView.ViewHolder {

    TextView recipeName_textView;
    TextView numServingValue_textView;
    TextView description_textView;
    Recipe recipe;
    boolean addToMenu = false;

    public CookbookViewHolder(@NonNull View itemView) {
        super(itemView);
        recipeName_textView = itemView.findViewById(R.id.recipeName_textView);
        description_textView = itemView.findViewById(R.id.description_textView);
        numServingValue_textView = itemView.findViewById(R.id.numServingsValue_textView);

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) {
                // if addToMenu == true

                // else
                CookbookFragmentDirections.ActionNavCookbookToNavRecipe action =
                        CookbookFragmentDirections.actionNavCookbookToNavRecipe(recipe);

                Navigation.findNavController(v).navigate(action);
            }
        });

    }

    public void bindData(Recipe recipe) {
        this.recipe = recipe;
        recipeName_textView.setText(recipe.getRecipeName());
        description_textView.setText(recipe.getDescription());
        numServingValue_textView.setText(String.valueOf(recipe.getNumServings()));
    }


}
