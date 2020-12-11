package com.example.easymenuplanner.addRecipe;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.easymenuplanner.R;
import com.example.easymenuplanner.db.Recipedb;

import java.util.List;

public class RecipeListAdapter extends RecyclerView.Adapter<RecipeListAdapter.RecipeViewHolder> {
    private Context context;
    private List<Recipedb> recipedbList;
    public RecipeListAdapter(Context context) {
        this.context = context;
    }

    public void setRecipedbList(List<Recipedb> recipedbList) {
        this.recipedbList = recipedbList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public RecipeListAdapter.RecipeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view  = LayoutInflater.from(context).inflate(R.layout.db_recipe_item, parent, false);

        return new RecipeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecipeListAdapter.RecipeViewHolder holder, int position) {
        holder.tv_recipe_title.setText(this.recipedbList.get(position).title);
        holder.tv_recipe_desc.setText(this.recipedbList.get(position).description);
        holder.tv_recipe_servings.setText(String.valueOf(this.recipedbList.get(position).numServings));

    }

    //returns the list size
    @Override
    public int getItemCount() {
        return this.recipedbList.size();
    }

    public class RecipeViewHolder extends RecyclerView.ViewHolder {
        TextView tv_recipe_title;
        TextView tv_recipe_desc;
        TextView tv_recipe_servings;

        public RecipeViewHolder(View view) {
            super(view);
            tv_recipe_title = view.findViewById(R.id.recipe_title);
            tv_recipe_desc = view.findViewById(R.id.recipe_desc);
            tv_recipe_servings = view.findViewById(R.id.recipe_servings);

        }
    }
}
