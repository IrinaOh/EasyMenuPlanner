package com.example.easymenuplanner.addRecipe;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.easymenuplanner.R;
import com.example.easymenuplanner.db.CookbookDatabase;
import com.example.easymenuplanner.db.Recipedb;
import com.example.easymenuplanner.recipe.Recipe;


public class AddRecipeFragment extends Fragment {
    EditText recipe_title, recipe_desc, recipe_ingredients, recipe_instructions, recipe_servings, recipe_tag;
    Button save_recipe_button;

    public AddRecipeFragment() {
        // Required empty public constructor
    }


    @Override
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
        save_recipe_button = view.findViewById(R.id.save_recipe_button);
        save_recipe_button.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                saveNewRecipe(
                        recipe_title.getText().toString().trim(),
                        recipe_desc.getText().toString().trim(),
                        recipe_ingredients.getText().toString().trim(),
                        recipe_instructions.getText().toString().trim(),
                        Integer.valueOf(recipe_servings.getText().toString().trim()),
                        recipe_tag.getText().toString().trim()
                );
            }
        });
        return inflater.inflate(R.layout.fragment_add_recipe, container, false);
    }

    private void saveNewRecipe(String title, String desc, String ingredients, String instructions, int servings, String tag){
        CookbookDatabase db = CookbookDatabase.getDbInstance(this.getContext());

        Recipedb recipe = new Recipedb();
        recipe.title = title;
        recipe.description = desc;
        recipe.ingredients = ingredients;
        recipe.directions = instructions;
        recipe.numServings = servings;
        recipe.tag = tag;

        db.recipeDao().insertRecipe(recipe);

        getActivity().finish();
    }

}