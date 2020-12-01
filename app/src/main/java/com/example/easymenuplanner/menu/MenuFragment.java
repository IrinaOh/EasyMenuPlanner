package com.example.easymenuplanner.menu;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.easymenuplanner.R;

public class MenuFragment extends Fragment {

    private RecyclerView menuRecycler;

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

        menuRecycler = view.findViewById(R.id.menu_recyclerView);
        menuRecycler.setHasFixedSize(true);
        menuRecycler.setLayoutManager(new LinearLayoutManager(getContext()));
        menuRecycler.setAdapter(new MenuAdapter(new MenuViewModel()));

        return view;
    }
}