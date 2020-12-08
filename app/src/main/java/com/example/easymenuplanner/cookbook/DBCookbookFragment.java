package com.example.easymenuplanner.cookbook;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.easymenuplanner.R;
import com.example.easymenuplanner.addRecipe.RecipeListAdapter;
import com.example.easymenuplanner.db.CookbookDatabase;
import com.example.easymenuplanner.db.Recipedb;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

public class DBCookbookFragment extends Fragment {
    private RecyclerView dbCookbookRecycler;
    FloatingActionButton add_recipe;
    private RecipeListAdapter recipeListAdapter;

    public DBCookbookFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_d_b_cookbook, container, false);

        //the add recipe button - floating plus sign button
        add_recipe = view.findViewById(R.id.add_recipe_float);
        add_recipe.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                //Navigation.findNavController(view).navigate(R.id.action_navigation_cookbook_to_addRecipeFragment);
            }
        }); //end add recipe button

        dbCookbookRecycler = view.findViewById(R.id.db_cookbook_recyclerview);
        dbCookbookRecycler.setLayoutManager(new LinearLayoutManager(view.getContext()));
        recipeListAdapter = new RecipeListAdapter(getContext());
        //load from db all recipes
        loadRecipeList();
        dbCookbookRecycler.setAdapter(recipeListAdapter);



        // Inflate the layout for this fragment
        return view;
    }

    //display recipes from db
    private void loadRecipeList() {
        CookbookDatabase db = CookbookDatabase.getDbInstance(this.getContext());
        List<Recipedb> recipedbList = db.recipeDao().getAllRecipes();
        recipeListAdapter.setRecipedbList(recipedbList);
    }
}