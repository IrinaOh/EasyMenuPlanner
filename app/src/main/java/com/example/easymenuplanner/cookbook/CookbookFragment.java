package com.example.easymenuplanner.cookbook;

import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.easymenuplanner.R;
import com.example.easymenuplanner.recipe.RecipeFragmentArgs;
import com.example.easymenuplanner.recipe.Recipedb;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

public class CookbookFragment extends Fragment {
    private RecyclerView cookbookRecycler;
    private CookbookViewModel cookbookViewModel;
    private CookbookAdapter cookbookAdapter;
    private FloatingActionButton addRecipe_fab;
    private EditText searchRecipe;
    private String searchString;
    private Integer menuKey;
    private Integer recipeKey;
    private Button searchButton;

    public CookbookFragment() {

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


        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        searchRecipe = view.findViewById(R.id.etSearchCookbook);
        searchButton = view.findViewById(R.id.cookbookSearchButton);
        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //cookbookViewModel.sendString(searchRecipe.getText().toString().trim());
                cookbookViewModel.findRecipe(searchRecipe.getText().toString().trim());
            }
    });
//    v -> {
//        cookbookViewModel.findRecipe(searchRecipe.getText().toString().trim());

        try {
            CookbookFragmentArgs args = CookbookFragmentArgs.fromBundle(getArguments());
            menuKey = args.getMenuKey();
        } catch (Exception e) {
            menuKey = -999;
        }

        addRecipe_fab = view.findViewById(R.id.fabAddRecipe);
        addRecipe_fab.setOnClickListener( v -> {
            Navigation.findNavController(v).navigate(R.id.action_nav_cookbook_to_addRecipeFragment);
        });

        cookbookRecycler = view.findViewById(R.id.cookbook_recylcerview);
        cookbookViewModel = new ViewModelProvider(getActivity(), new CookbookViewModelFactory(getActivity().getApplication())).get(CookbookViewModel.class);
        cookbookViewModel.init();

        cookbookViewModel.getCookbook().observe(getViewLifecycleOwner(), new Observer<List<Recipedb>>() {
            @Override
            public void onChanged(List<Recipedb> recipedbs) {
                cookbookAdapter.notifyDataSetChanged();
            }
        });


//        cookbookViewModel.findRecipe().observe(getViewLifecycleOwner(), new Observer<List<Recipedb>>() {
//            @Override
//            public void onChanged(List<Recipedb> recipedbs) {
//                cookbookAdapter.notifyDataSetChanged();
//            }
//        });

        cookbookRecycler.setLayoutManager(new LinearLayoutManager(view.getContext()));
        cookbookAdapter = new CookbookAdapter(cookbookViewModel.getCookbook().getValue(), menuKey);
        cookbookRecycler.setAdapter(cookbookAdapter);
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    public interface onFragmentInteractionListener {
        void onFragmentInteraction(Uri uri);
    }
}