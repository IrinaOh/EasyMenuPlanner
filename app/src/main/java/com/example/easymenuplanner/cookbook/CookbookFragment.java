package com.example.easymenuplanner.cookbook;

import android.content.ComponentName;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.navigation.Navigation;

import com.example.easymenuplanner.R;
import com.example.easymenuplanner.home.HomeFragment;
import com.example.easymenuplanner.recipe.Ingredient;
import com.example.easymenuplanner.recipe.Recipe;
import com.example.easymenuplanner.recipe.Recipedb;
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class CookbookFragment extends Fragment {
    private RecyclerView cookbookRecycler;
    private CookbookViewModel cookbookViewModel;
    private CookbookAdapter cookbookAdapter;
    private FloatingActionButton addRecipe_fab;
    private EditText searchRecipe;
    private String searchString;

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

//        try {
//            CookbookFragmentArgs args = CookbookFragmentArgs.fromBundle(getArguments());
//            meal = args.getMeal();
//        } catch (Exception e) {
//            meal = "";
//        }

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        searchRecipe = view.findViewById(R.id.etSearchCookbook);
//        searchRecipe.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                cookbookViewModel.sendString(searchRecipe.getText().toString().trim());
//                //cookbookViewModel.findRecipe(searchRecipe.getText().toString().trim());
//            }
//    });



//    v -> {
//        cookbookViewModel.findRecipe(searchRecipe.getText().toString().trim());


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
        cookbookAdapter = new CookbookAdapter(cookbookViewModel.getCookbook().getValue());
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