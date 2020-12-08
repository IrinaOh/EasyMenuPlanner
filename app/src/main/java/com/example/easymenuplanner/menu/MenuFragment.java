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
import com.example.easymenuplanner.recipe.Recipe;
import com.example.easymenuplanner.recipe.RecipeFragmentArgs;

public class MenuFragment extends Fragment {

    private Recipe newRecipe;
    private ViewPager2 pagerView;
    String meal;
    //private MenuCalendar myMenus;

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
            newRecipe = args.getRecipe();
            meal = args.getMeal();
        } catch (Exception e) {

        }


        pagerView = view.findViewById(R.id.vp2Menu);
        pagerView.setAdapter(new MenuAdapter(new MenuCalendar()));

        pagerView.setClipToPadding(false);
        pagerView.setClipChildren(false);
        pagerView.setOffscreenPageLimit(3);
        pagerView.getChildAt(0).setOverScrollMode(RecyclerView.OVER_SCROLL_NEVER);


        CompositePageTransformer compositePageTransformer = new CompositePageTransformer();
        compositePageTransformer.addTransformer(new MarginPageTransformer(10));
        compositePageTransformer.addTransformer(new ViewPager2.PageTransformer() {
            @Override
            public void transformPage(@NonNull View page, float position) {
                float r = 1 - Math.abs(position);
                page.setScaleY(1.0f + r*0.05f);
            }
        });
        pagerView.setPageTransformer(compositePageTransformer);

        return view;
    }


}