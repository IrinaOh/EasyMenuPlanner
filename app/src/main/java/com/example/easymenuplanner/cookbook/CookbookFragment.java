package com.example.easymenuplanner.cookbook;

import android.content.ComponentName;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import androidx.navigation.Navigation;

import com.example.easymenuplanner.MainActivity;
import com.example.easymenuplanner.R;
import com.example.easymenuplanner.addRecipe.AddRecipeFragment;
import com.example.easymenuplanner.addRecipe.RecipeListAdapter;
import com.example.easymenuplanner.db.CookbookDatabase;
import com.example.easymenuplanner.db.Recipedb;
import com.example.easymenuplanner.home.HomeFragment;
import com.example.easymenuplanner.recipe.Ingredient;
import com.example.easymenuplanner.recipe.Recipe;
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

public class CookbookFragment extends Fragment {
    private RecyclerView cookbookRecycler;
    private RecyclerView dbCookbookRecycler;
    private Cookbook cookbook = new Cookbook();
    private boolean isAddRecipe = false;
    private String meal;
    FloatingActionButton add_recipe;
    private RecipeListAdapter recipeListAdapter;

    public CookbookFragment() {
        // Required empty public constructor
        Recipe r1 = new Recipe("Fried Chicken", "Best Southern Fried Chicken ever.", 12);
        r1.addIngredient(new Ingredient("Chicken", 12.0f, null));
        r1.addIngredient(new Ingredient("Flour", 1f, "cup"));
        r1.addIngredient(new Ingredient("Salt", 1f, "tsp"));
        r1.addIngredient(new Ingredient("Pepper", 1f, "tsp"));
        r1.addIngredient(new Ingredient("Paprika", 1f, "tsp"));
        r1.addIngredient(new Ingredient("eggs", 3f, null));
        r1.addInstruction("Combine dry ingredients in a 1 gallon bag");
        r1.addInstruction("Place chicken in bag one at a time and shake, coating with flour mixture.  This is going to be great.  I really hope you like this.");
        cookbook.addRecipe(r1);
        Recipe r2 = new Recipe("Hamburgers", "Move over In-N-Out", 4);
        r2.addIngredient(new Ingredient("Ground Beef", 1, "lb"));
        r2.addIngredient(new Ingredient("A1 Steak Sauce", 1, "Tbsp"));
        r2.addIngredient(new Ingredient("Ketchup", 3, "Tbsp"));
        r2.addIngredient(new Ingredient("Hamburger Buns", 1, "Package"));
        r2.addInstruction("Mix ground beef and A1 sauce");
        r2.addInstruction("Create four patties");
        r2.addInstruction("Cook on grill");
        cookbook.addRecipe(r2);
        cookbook.addRecipe(new Recipe("Lasagna", "I feel like I'm in Italy", 6));
        cookbook.addRecipe(new Recipe("Spaghetti", "Awesome sauce.", 6));
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_cookbook, container, false);




        //the add recipe button - floating plus sign button
        add_recipe = view.findViewById(R.id.add_recipe_float);
        add_recipe.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Navigation.findNavController(view).navigate(R.id.action_navigation_cookbook_to_addRecipeFragment);
            }
        }); //end add recipe button

        try {
            CookbookFragmentArgs args = CookbookFragmentArgs.fromBundle(getArguments());
            meal = args.getMeal();
        } catch (Exception e) {
            meal = "Dinner";
        }


//        cookbookRecycler = view.findViewById(R.id.cookbook_recylcerview);
//        cookbookRecycler.setLayoutManager(new LinearLayoutManager(view.getContext()));
//        cookbookRecycler.setAdapter(new CookbookAdapter(cookbook, meal));

        //initRecyclerView();
        //display recipes from db recycler view
        dbCookbookRecycler = view.findViewById(R.id.db_cookbook_recyclerview);
        dbCookbookRecycler.setLayoutManager(new LinearLayoutManager(view.getContext()));
//        DividerItemDecoration decor = new DividerItemDecoration(getContext(), DividerItemDecoration.VERTICAL);
//        dbCookbookRecycler.addItemDecoration(decor);
        recipeListAdapter = new RecipeListAdapter(getContext());
        dbCookbookRecycler.setAdapter(recipeListAdapter);

        //load from db all recipes
        loadRecipeList();

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    public interface onFragmentInteractionListener {
        void onFragmentInteraction(Uri uri);
    }

    //display recipes from db
    private void loadRecipeList() {
        CookbookDatabase db = CookbookDatabase.getDbInstance(this.getContext());
        List<Recipedb> recipedbList = db.recipeDao().getAllRecipes();
        recipeListAdapter.setRecipedbList(recipedbList);
    }

}