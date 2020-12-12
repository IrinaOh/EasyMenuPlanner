package com.example.easymenuplanner.searchRecipe;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.easymenuplanner.R;


public class SearchRecipeViewHolder extends RecyclerView.ViewHolder {

    //private ImageView recipeImage;
    private TextView recipeLabel;
    private TextView recipeURL;

    public SearchRecipeViewHolder(@NonNull View itemView) {
        super(itemView);

        //recipeImage = itemView.findViewById(R.id.ivRecipeImage);
        recipeLabel = itemView.findViewById(R.id.tvRecipeLabel);
        recipeURL = itemView.findViewById(R.id.tvURL);

    }

    public void bindData(ApiRecipeTop recipeTop) {
        ApiRecipe recipe = recipeTop.getRecipe();
//        try {
//            URL imageURL = new URL(recipe.getImage());
//            Bitmap bmp = BitmapFactory.decodeStream(imageURL.openConnection().getInputStream());
//            recipeImage.setImageBitmap(bmp);
//        } catch (MalformedURLException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        recipeLabel.setText(recipe.getTitle());
        recipeURL.setText(recipe.getUrl());

    }

}
