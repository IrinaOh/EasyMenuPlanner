package com.example.easymenuplanner.recipe;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.easymenuplanner.R;

public class InstructionAdapter extends RecyclerView.Adapter<InstructionViewHolder> {

    Recipe recipe;
    public InstructionAdapter(Recipe recipe) {
        this.recipe = recipe;
    }

    @Override
    public int getItemViewType(int position) {
        return R.layout.instruction_item;
    }

    @NonNull
    @Override
    public InstructionViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(viewType, parent, false);
        return new InstructionViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull InstructionViewHolder holder, int position) {
        holder.bindData(recipe.getInstructions().get(position), position);
    }

    @Override
    public int getItemCount() {
        return recipe.getInstructions().size();
    }
}
