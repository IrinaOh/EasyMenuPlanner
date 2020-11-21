package com.example.easymenuplanner.cookbook;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.easymenuplanner.R;

public class CookbookFragment extends Fragment {
    private RecyclerView cookbookRecycler;
    public CookbookFragment() {
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
        View view = inflater.inflate(R.layout.fragment_cookbook, container, false);
        cookbookRecycler = view.findViewById(R.id.cookbook_recylcerview);
        cookbookRecycler.setLayoutManager(new LinearLayoutManager(view.getContext()));
        cookbookRecycler.setAdapter(new CookbookAdapter());
        return view;
    }
}