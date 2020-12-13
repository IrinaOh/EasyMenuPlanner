package com.example.easymenuplanner.searchRecipe;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.example.easymenuplanner.R;

import java.util.List;

public class SearchRecipeFragment extends Fragment {

    private EditText et_searchItem;

    //private ListView lv_recipesHits;
    private RecyclerView recyclerView_recipeHits;
    private Button bt_searchButton;
    private List<ApiRecipeTop> allRecipes;
    //private SearchRecipeViewModel searchViewModel;
    //private MutableLiveData<List<ApiRecipeTop>> allRecipes;
    private SearchRecipeAdapter searchAdapter;

    public SearchRecipeFragment() {
        //allRecipes = new MutableLiveData<>();

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
        //recyclerView_recipeHits = view.findViewById(R.id.rv_recipeHits);
        bt_searchButton = view.findViewById(R.id.btSearchButton);
        bt_searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ApiSearchTask task = new ApiSearchTask(et_searchItem.getText().toString());
                task.start();
            }
        });

//        allRecipes.observe(getViewLifecycleOwner(), new Observer<List<ApiRecipeTop>>() {
//            @Override
//            public void onChanged(List<ApiRecipeTop> apiRecipeTops) {
//                searchAdapter.notifyDataSetChanged();
//            }
//        });


        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //searchViewModel = new SearchRecipeViewModel(getActivity());
//        recyclerView_recipeHits.setLayoutManager(new LinearLayoutManager(view.getContext()));
//        searchAdapter = new SearchRecipeAdapter(allRecipes.getValue());
//        recyclerView_recipeHits.setAdapter(searchAdapter);

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);



    }


    public void searchItem(View view) {
        bt_searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ApiSearchTask task = new ApiSearchTask(et_searchItem.getText().toString());
                task.start();
            }
        });

    }

    private void displayHits(ApiRecipeGroup hits) {
        List<ApiRecipeTop> hitRecipes = hits.getAllRecipes();
        //allRecipes.setValue(hitRecipes);
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
