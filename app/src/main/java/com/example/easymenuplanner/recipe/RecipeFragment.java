package com.example.easymenuplanner.recipe;

import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.easymenuplanner.R;


public class RecipeFragment extends Fragment {

    RecyclerView ingredientRecycler;
    RecyclerView instructionRecycler;
    Recipe r1;
    TextView recipeName;

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
            r1 = args.getRecipe();
        } catch (Exception e) {

        }


        View view = inflater.inflate(R.layout.fragment_recipe, container, false);
        ingredientRecycler = view.findViewById(R.id.ingredients_RecyclerView);
        ingredientRecycler.setLayoutManager(new LinearLayoutManager(view.getContext()));
        ingredientRecycler.setAdapter(new IngredientAdapter(r1));

        instructionRecycler = view.findViewById(R.id.instructions_RecyclerView);
        instructionRecycler.setLayoutManager(new LinearLayoutManager(view.getContext()));
        instructionRecycler.setAdapter(new InstructionAdapter(r1));

        recipeName = view.findViewById(R.id.recipeName_recipeView);
        recipeName.setText(r1.getRecipeName());


        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

    }
}