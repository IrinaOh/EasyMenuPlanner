package com.example.easymenuplanner.addRecipe;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.easymenuplanner.R;
import com.example.easymenuplanner.cookbook.CookbookViewModel;
import com.example.easymenuplanner.cookbook.CookbookViewModelFactory;
import com.example.easymenuplanner.recipe.Recipedb;


public class AddRecipeFragment extends Fragment {
    EditText recipe_title, recipe_desc, recipe_ingredients, recipe_instructions, recipe_servings, recipe_tag;
    Button save_recipe_button;
    private AddRecipeViewModel addRecipeViewModel;
    private int recipeKey;
    private Recipedb editRecipe;

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
        return inflater.inflate(R.layout.fragment_add_recipe, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        recipe_title = view.findViewById(R.id.recipe_title);
        recipe_desc = view.findViewById(R.id.recipe_desc);
        recipe_ingredients = view.findViewById(R.id.recipe_ingredients);
        recipe_instructions = view.findViewById(R.id.recipe_instructions);
        recipe_servings = view.findViewById(R.id.recipe_servings);
        recipe_tag = view.findViewById(R.id.recipe_tag);
        save_recipe_button = view.findViewById(R.id.save_recipe_button);
        save_recipe_button.setOnClickListener(v -> {

            if (recipeKey == -999) {
                addRecipeViewModel.addRecipe(recipe_title.getText().toString().trim(),
                        recipe_desc.getText().toString().trim(),
                        recipe_ingredients.getText().toString().trim(),
                        recipe_instructions.getText().toString().trim(),
                        recipe_tag.getText().toString().trim(),
                        Integer.valueOf(recipe_servings.getText().toString().trim()));
            } else {
                editRecipe.title = recipe_title.getText().toString().trim();
                editRecipe.description = recipe_desc.getText().toString().trim();
                editRecipe.ingredients = recipe_ingredients.getText().toString().trim();
                editRecipe.directions = recipe_instructions.getText().toString().trim();
                editRecipe.tag = recipe_tag.getText().toString().trim();
                addRecipeViewModel.replaceRecipe(editRecipe);
            }

            Navigation.findNavController(v).navigate(R.id.action_addRecipeFrag_to_Cookbook);

           });


        addRecipeViewModel = new ViewModelProvider(getActivity(), new AddRecipeViewModelFactory(getActivity().getApplication())).get(AddRecipeViewModel.class);
        addRecipeViewModel.init();

        try {
            AddRecipeFragmentArgs args = AddRecipeFragmentArgs.fromBundle(getArguments());
            recipeKey = args.getRecipeKey();
            editRecipe = addRecipeViewModel.getRecipeByID(recipeKey);

            recipe_title.setText(editRecipe.title);
            recipe_desc.setText(editRecipe.description);
            recipe_ingredients.setText(editRecipe.ingredients);
            recipe_instructions.setText(editRecipe.directions);
            Integer numServings = (Integer) editRecipe.numServings;
            recipe_servings.setText(numServings.toString());
            recipe_tag.setText(editRecipe.tag);

        } catch (Exception e) {
            recipeKey = -999;
        }

    }
}