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
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class CookbookFragment extends Fragment {
    private RecyclerView cookbookRecycler;
    FloatingActionButton add_recipe;
    //private int contentView;

    public CookbookFragment() {
        // Required empty public constructor
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.fragment_cookbook);


    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_cookbook, container, false);

        /*cookbookRecycler = view.findViewById(R.id.cookbook_recylcerview);
        cookbookRecycler.setLayoutManager(new LinearLayoutManager(view.getContext()));
        cookbookRecycler.setAdapter(new CookbookAdapter()); */

        //the add recipe button
        add_recipe = view.findViewById(R.id.add_recipe);
        add_recipe.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Navigation.findNavController(view).navigate(R.id.action_navigation_cookbook_to_addRecipeFragment);
            }
        });

        return view;
    }



}