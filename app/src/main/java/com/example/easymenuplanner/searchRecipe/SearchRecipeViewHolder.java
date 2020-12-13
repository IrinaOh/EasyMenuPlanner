package com.example.easymenuplanner.searchRecipe;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.text.method.MovementMethod;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.easymenuplanner.R;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;


public class SearchRecipeViewHolder extends RecyclerView.ViewHolder {

    
    private TextView recipeLabel;
    private TextView recipeURL;
    private String hyperlink;

    public SearchRecipeViewHolder(@NonNull View itemView) {
        super(itemView);

        recipeLabel = itemView.findViewById(R.id.tvRecipeLabel);
        recipeURL = itemView.findViewById(R.id.tvURL);
        Resources res = itemView.getResources();
        hyperlink = res.getString(R.string.hyperlink);

    }

    public void bindData(ApiRecipeTop recipeTop) {
        ApiRecipe recipe = recipeTop.getRecipe();
//        try {
//            //URL imageURL = new URL(recipe.getImage());
//
//            Drawable foodImage = LoadImage(recipe.getImage());
//            //Bitmap bmp = BitmapFactory.decodeStream((InputStream) imageURL.getContent());
//            recipeImage.setImageDrawable(foodImage);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }


        recipeLabel.setClickable(true);
        recipeLabel.setMovementMethod(LinkMovementMethod.getInstance());
        String s1 = "<a href='";
        String s2 = recipe.getUrl();
        String s3 = "'> ";
        String s4 = recipe.getTitle();
        String s5 = " </a>";
        String s6 = s1.concat(s2).concat(s3).concat(s4).concat(s5);

        recipeLabel.setText(Html.fromHtml(s6));
        recipeURL.setText(recipe.getUrl());
    }

//    public static Drawable LoadImage(String url) {
//        try {
//            InputStream is = (InputStream) new URL(url).getContent();
//            Drawable d = Drawable.createFromStream(is, "src name");
//            return d;
//        } catch (Exception e) {
//            return null;
//        }
//    }




}
