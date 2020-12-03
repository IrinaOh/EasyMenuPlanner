package com.example.easymenuplanner.menu;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.easymenuplanner.R;
import com.example.easymenuplanner.cookbook.CookbookFragmentArgs;

public class MenuFragment extends Fragment {

    private RecyclerView menuRecycler;
    String meal;

    public MenuFragment() {
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
        View view = inflater.inflate(R.layout.fragment_menu, container, false);

        try {
            MenuFragmentArgs args = MenuFragmentArgs.fromBundle(getArguments());
            meal = args.getMeal();
        } catch (Exception e) {

        }

        menuRecycler = view.findViewById(R.id.menu_recyclerView);
        menuRecycler.setHasFixedSize(true);
        menuRecycler.setLayoutManager(new LinearLayoutManager(getContext()));
        menuRecycler.setAdapter(new MenuAdapter(new MenuViewModel()));

        return view;
    }
}