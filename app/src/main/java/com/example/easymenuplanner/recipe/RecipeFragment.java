package com.example.easymenuplanner.recipe;

import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.easymenuplanner.R;


public class RecipeFragment extends Fragment {

    TextView tv_recipeName;
    TextView tv_ingredients;
    TextView tv_instructions;
    String recipeName;
    String ingredients;
    String instructions;


    public RecipeFragment() {
        // Required empty public constructor
        /*
        r1 = new Recipe("Colonel Sanders Chicken", "Best Southern Fried Chicken ever.", 12);
        r1.addIngredient(new Ingredient("Chicken Breasts", 12.0f, null));
        r1.addIngredient(new Ingredient("Flour", 1f, "cup"));
        r1.addIngredient(new Ingredient("Salt", 1f, "tsp"));
        r1.addIngredient(new Ingredient("Pepper", 1f, "tsp"));
        r1.addIngredient(new Ingredient("Paprika", 1f, "tsp"));
        r1.addIngredient(new Ingredient("eggs", 3f, null));
        r1.addInstruction("Combine dry ingredients in a 1 gallon bag");
        r1.addInstruction("Place chicken in bag one at a time and shake, coating with flour mixture.  This is going to be great.  I really hope you like this.");

         */

    }

    public interface OnFragmentInteractionListener {
        void onFragmentInteraction(Uri uri);
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        try {
            RecipeFragmentArgs args = RecipeFragmentArgs.fromBundle(getArguments());
            recipeName = args.getRecipeName();
            ingredients = args.getIngredients();
            instructions = args.getInstructions();

        } catch (Exception e) {
            recipeName = "No recipe";
            ingredients = "";
            instructions = "";

        }

        View view = inflater.inflate(R.layout.fragment_recipe, container, false);

        tv_recipeName = view.findViewById(R.id.tvRecipeNameDb);
        tv_recipeName.setText(recipeName);

        tv_ingredients = view.findViewById(R.id.tvIngredientsDb);
        tv_ingredients.setText(ingredients);

        tv_instructions = view.findViewById(R.id.tvInstructionsDb);
        tv_instructions.setText(instructions);

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

    }
}