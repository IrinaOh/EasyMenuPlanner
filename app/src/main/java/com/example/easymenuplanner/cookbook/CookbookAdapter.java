package com.example.easymenuplanner.cookbook;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.appcompat.widget.PopupMenu;
import androidx.recyclerview.widget.RecyclerView;
import com.example.easymenuplanner.R;
import com.example.easymenuplanner.recipe.Recipe;
import com.example.easymenuplanner.recipe.Recipedb;

import java.util.ArrayList;
import java.util.List;


public class CookbookAdapter extends RecyclerView.Adapter<CookbookViewHolder> {

    private List<Recipedb> cookbook;
    private Integer menuKey;

    public CookbookAdapter(List<Recipedb> cookbook, Integer menuKey) {
        this.cookbook = cookbook;
        this.menuKey = menuKey;
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
        holder.bindData(cookbook.get(position), menuKey);
    }

    @Override
    public int getItemCount() {
        return cookbook.size();
    }

}
