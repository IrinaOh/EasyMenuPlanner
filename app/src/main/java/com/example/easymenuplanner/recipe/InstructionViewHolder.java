package com.example.easymenuplanner.recipe;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.easymenuplanner.R;

public class InstructionViewHolder extends RecyclerView.ViewHolder {
    private TextView instruction_textView;
    private TextView itemNumber_textView;

    public InstructionViewHolder(@NonNull View itemView) {
        super(itemView);
        instruction_textView = itemView.findViewById(R.id.tvInstruction);
        itemNumber_textView = itemView.findViewById(R.id.tvItemNumber);
    }

    public void bindData(String instruct, int position) {
        itemNumber_textView.setText(String.valueOf(position + 1) + ".");
        instruction_textView.setText(instruct);
    }
}
