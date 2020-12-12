package com.example.easymenuplanner.menu;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.easymenuplanner.R;

import java.util.List;

public class MenuAdapter extends RecyclerView.Adapter<MenuViewHolder> {

    //private List<Menudb> menus;
    private List<MenuDisplay> menuDisplayList;
//    private int menuKey;
//    private int recipeKey;

    public MenuAdapter(List<MenuDisplay> menus) {
       menuDisplayList = menus;
//       this.menuKey = menuKey;
//       this.recipeKey = recipeKey;
    }

    @Override
    public int getItemViewType(int position) {
        return R.layout.menu_item;
    }

    @NonNull
    @Override
    public MenuViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.menu_item, parent, false);
        return new MenuViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MenuViewHolder holder, int position) {
        holder.bindData(menuDisplayList.get(position));
    }

    @Override
    public int getItemCount() {
        return menuDisplayList.size();
    }
}
