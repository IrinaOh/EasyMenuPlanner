package com.example.easymenuplanner.menu;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.easymenuplanner.recipe.Recipe;
import com.example.easymenuplanner.R;
import java.util.ArrayList;
import java.util.List;

public class MenuAdapter extends RecyclerView.Adapter<MenuViewHolder> {

    //private List<Recipe> recipes;
    private MenuViewModel mMenu;

    public MenuAdapter(MenuViewModel mMenu) {
       this.mMenu = mMenu;
    }


    @Override
    public int getItemViewType(int position) {
        return R.layout.menu_item;
    }


    @NonNull
    @Override
    public MenuViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(viewType, parent, false);
        return new MenuViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MenuViewHolder holder, int position) {
        holder.bindData(mMenu.getRecipe(position));
    }

    @Override
    public int getItemCount() {
        return mMenu.getSize();
    }
}
