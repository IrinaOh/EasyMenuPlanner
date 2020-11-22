package com.example.easymenuplanner.cookbook;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.easymenuplanner.R;

public class CookbookViewHolder extends RecyclerView.ViewHolder {

    ImageView recipeImage;
    TextView recipeName_textView;
    TextView numServingLabel_textView;
    TextView numServingValue_textView;
    TextView description_textView;

    public CookbookViewHolder(@NonNull View itemView) {
        super(itemView);
        recipeName_textView = itemView.findViewById(R.id.recipeName_textView);
        description_textView = itemView.findViewById(R.id.description_textView);
        numServingLabel_textView = itemView.findViewById(R.id.numServingsLabel_textView);
        numServingValue_textView = itemView.findViewById(R.id.numServingsValue_textView);
    }

    public ImageView getRecipeImage() {
        return recipeImage;
    }

    public TextView getDescription_textView() {
        return description_textView;
    }

    public TextView getRecipeName_textView() {
        return recipeName_textView;
    }

    public TextView getNumServingLabel_textView() {
        return numServingLabel_textView;
    }

    public TextView getNumServingValue_textView() {
        return numServingValue_textView;
    }
}
