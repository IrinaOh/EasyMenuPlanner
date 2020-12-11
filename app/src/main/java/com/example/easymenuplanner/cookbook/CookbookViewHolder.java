package com.example.easymenuplanner.cookbook;

import android.content.Context;
import android.media.Image;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.PopupMenu;
import androidx.cardview.widget.CardView;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.example.easymenuplanner.R;
import com.example.easymenuplanner.menu.MenuFragmentDirections;
import com.example.easymenuplanner.recipe.Recipe;
import com.example.easymenuplanner.recipe.Recipedb;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

public class CookbookViewHolder extends RecyclerView.ViewHolder {

    TextView recipeName_textView;
    TextView numServingValue_textView;
    TextView description_textView;
    ImageView menu_imageView;
    Recipedb recipe;
    CardView recipeCard;


    boolean addToMenu = false;

    public CookbookViewHolder(@NonNull View itemView) {
        super(itemView);
        recipeName_textView = itemView.findViewById(R.id.recipeName_textView);
        description_textView = itemView.findViewById(R.id.description_textView);
        numServingValue_textView = itemView.findViewById(R.id.numServingsValue_textView);
        menu_imageView = itemView.findViewById(R.id.ellipsis_menu);
        recipeCard = itemView.findViewById(R.id.cardView2);


        recipeCard.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) {

//                CookbookFragmentDirections.ActionNavCookbookToNavRecipe recipeAction =
//                        CookbookFragmentDirections.actionNavCookbookToNavRecipe(recipe);
//                Navigation.findNavController(v).navigate(recipeAction);
            }
        });

        menu_imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupMenu popup = new PopupMenu(menu_imageView.getContext(), itemView);
                popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
//                        switch (item.getItemId()) {
//                            case R.id.addToMenu:
//                                CookbookFragmentDirections.ActionNavCookbookToNavMenu menuAction =
//                                        CookbookFragmentDirections.actionNavCookbookToNavMenu(recipe, meal);
//                                Navigation.findNavController(v).navigate(menuAction);
//                                return true;
//                            default:
//                                return false;
//                        }
                        return false;
                    }
                });
                popup.inflate(R.menu.cookbook_card_menu);
                popup.setGravity(Gravity.RIGHT);
                popup.show();
            }
        });

    }

    public void bindData(Recipedb recipe) {
        this.recipe = recipe;
        recipeName_textView.setText(recipe.title);
        description_textView.setText(recipe.description);
        numServingValue_textView.setText(String.valueOf(recipe.numServings));

//        if (meal.isEmpty()) {
//            menu_imageView.setVisibility(View.INVISIBLE);
//        } else {
//            menu_imageView.setVisibility(View.VISIBLE);
//        }

    }


}
