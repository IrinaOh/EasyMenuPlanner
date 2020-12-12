package com.example.easymenuplanner.searchRecipe;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.easymenuplanner.R;
import com.example.easymenuplanner.recipe.Recipedb;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;


public class SearchRecipeViewHolder extends RecyclerView.ViewHolder {

    private ImageView recipeImage;
    private TextView recipeLabel;
    private TextView recipeURL;

    public SearchRecipeViewHolder(@NonNull View itemView) {
        super(itemView);

        recipeImage = itemView.findViewById(R.id.ivRecipeImage);
        recipeLabel = itemView.findViewById(R.id.tvRecipeLabel);
        recipeURL = itemView.findViewById(R.id.tvURL);

    }

    public void bindData(ApiRecipeTop recipeTop) {
        ApiRecipe recipe = recipeTop.getRecipe();
        try {
            URL imageURL = new URL(recipe.getImage());
            Bitmap bmp = BitmapFactory.decodeStream(imageURL.openConnection().getInputStream());
            recipeImage.setImageBitmap(bmp);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        recipeLabel.setText(recipe.getTitle());
        recipeURL.setText(recipe.getUrl());

    }

}
