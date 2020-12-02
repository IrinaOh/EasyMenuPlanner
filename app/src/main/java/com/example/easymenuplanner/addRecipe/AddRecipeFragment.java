package com.example.easymenuplanner.addRecipe;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.easymenuplanner.DataBaseHelper;
import com.example.easymenuplanner.R;


public class AddRecipeFragment extends Fragment {
    EditText recipe_title, recipe_desc, recipe_ingredients, recipe_instructions, recipe_servings, recipe_tag;
    Button add_recipe_button;

    public AddRecipeFragment() {
        // Required empty public constructor
    }

    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_add_recipe, container, false);

        recipe_title = view.findViewById(R.id.recipe_title);
        recipe_desc = view.findViewById(R.id.recipe_desc);
        recipe_ingredients = view.findViewById(R.id.recipe_ingredients);
        recipe_instructions = view.findViewById(R.id.recipe_instructions);
        recipe_servings = view.findViewById(R.id.recipe_servings);
        recipe_tag = view.findViewById(R.id.recipe_tag);
        add_recipe_button = view.findViewById(R.id.add_recipe_button);
        add_recipe_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DataBaseHelper myDB = new DataBaseHelper(AddRecipeFragment.this.getContext());
                myDB.addRecipe(recipe_title.getText().toString().trim(),
                        recipe_desc.getText().toString().trim(),
                        recipe_ingredients.getText().toString().trim(),
                        recipe_instructions.getText().toString().trim(),
                        Integer.valueOf(recipe_servings.getText().toString().trim()),
                        recipe_tag.getText().toString().trim());
            }
        });

        return inflater.inflate(R.layout.fragment_add_recipe, container, false);
    }
}