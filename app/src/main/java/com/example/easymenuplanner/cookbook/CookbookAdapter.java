package com.example.easymenuplanner.cookbook;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.easymenuplanner.R;
import com.example.easymenuplanner.Recipe;
import com.example.easymenuplanner.home.CardViewHolder;

import java.util.ArrayList;
import java.util.List;

public class CookbookAdapter extends RecyclerView.Adapter<CookbookViewHolder> {

    private List<Recipe> recipes = new ArrayList<>();

    public CookbookAdapter() {
        recipes.add(new Recipe("Fried Chicken", "Best Southern Fried Chicken ever.", 12));
        recipes.add(new Recipe("Spaghetti", "Awesome sauce.", 6));
        recipes.add(new Recipe("Hamburgers", "Move over In-N-Out", 4));
    }

    @Override
    public int getItemViewType(int position) {
        return R.layout.cookbook_item;
    }

    @NonNull
    @Override
    public CookbookViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(viewType, parent, false);
        return new CookbookViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CookbookViewHolder holder, int position) {
        holder.getRecipeName_textView().setText(recipes.get(position).getRecipeName());
        holder.getNumServingValue_textView().setText(String.valueOf(recipes.get(position).getNumServings()));
    }

    @Override
    public int getItemCount() {
        return 3;
    }
}
