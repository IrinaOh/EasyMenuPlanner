package com.example.easymenuplanner.home;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.CompositePageTransformer;
import androidx.viewpager2.widget.MarginPageTransformer;
import androidx.viewpager2.widget.ViewPager2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.easymenuplanner.R;

public class HomeFragment extends Fragment {

    private ViewPager2 pagerView;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_home, container, false);
        pagerView = view.findViewById(R.id.pagerView);
        pagerView.setAdapter(new CardAdapter());

        pagerView.setClipToPadding(false);
        pagerView.setClipChildren(false);
        pagerView.setOffscreenPageLimit(3);
        pagerView.getChildAt(0).setOverScrollMode(RecyclerView.OVER_SCROLL_NEVER);

        CompositePageTransformer compositePageTransformer = new CompositePageTransformer();
        compositePageTransformer.addTransformer(new MarginPageTransformer(40));
        compositePageTransformer.addTransformer(new ViewPager2.PageTransformer() {
            @Override
            public void transformPage(@NonNull View page, float position) {
                float r = 1 - Math.abs(position);
                page.setScaleY(0.9f + r*0.05f);
            }
        });
        pagerView.setPageTransformer(compositePageTransformer);

        return view;
    }


}