package com.example.easymenuplanner.searchRecipe;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import com.example.easymenuplanner.R;
import com.example.easymenuplanner.menu.MenuFragmentDirections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class SearchRecipeFragment extends Fragment {

    private EditText et_searchItem;
    private ListView lv_recipesHits;
    private Button bt_searchButton;

    public SearchRecipeFragment() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_search_recipe, container, false);
        et_searchItem = view.findViewById(R.id.etSearchItem);
        lv_recipesHits = view.findViewById(R.id.lvRecipesHits);
        bt_searchButton = view.findViewById(R.id.btSearchButton);
        bt_searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ApiSearchTask task = new ApiSearchTask(et_searchItem.getText().toString());
                task.start();
            }
        });
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

    }


//    public void searchItem(View view) {
//        bt_searchButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                ApiSearchTask task = new ApiSearchTask(et_searchItem.getText().toString());
//                task.start();
//            }
//        });
//
//    }

    private void displayHits(ApiRecipeGroup hits) {


        List<ApiRecipe> allRecipes = new ArrayList<>();
        allRecipes = hits.getAllRecipes();

        for (ApiRecipe recipe:allRecipes) {
            System.out.println("title= " + recipe.getTitle());
            System.out.println("url= " + recipe.getUrl());
            System.out.println("ingredients= " + recipe.getIngredients());
        }


        /*
        Adapter adapter = new ArrayAdapter<ApiRecipe>(this, android.R.layout.simple_list_item_1, hits.iterator());
        lv_recipesHits.setAdapter((ListAdapter) adapter);
        */


    }
    private class ApiSearchTask extends Thread {

        private String searchItem;

        public ApiSearchTask(String searchItem) {
            this.searchItem = searchItem;
        }


        @Override
        public void run() {
            SearchRecipesApi newApiSearch = new SearchRecipesApi();
            final ApiRecipeGroup hits = newApiSearch.getRecipes(searchItem);
            getActivity().runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    displayHits(hits);
                }
            });



        }
    }


}
