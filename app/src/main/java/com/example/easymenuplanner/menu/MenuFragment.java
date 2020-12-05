package com.example.easymenuplanner.menu;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.CompositePageTransformer;
import androidx.viewpager2.widget.MarginPageTransformer;
import androidx.viewpager2.widget.ViewPager2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.easymenuplanner.R;
import com.example.easymenuplanner.cookbook.CookbookFragmentArgs;
import com.example.easymenuplanner.home.CardAdapter;

public class MenuFragment extends Fragment {

    //private RecyclerView menuRecycler;
    private ViewPager2 pagerView;
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

        pagerView = view.findViewById(R.id.vp2Menu);
        pagerView.setAdapter(new MenuAdapter(new MenuCalendar()));
        pagerView.getChildAt(0).setOverScrollMode(RecyclerView.OVER_SCROLL_NEVER);
        
        return view;
    }


}