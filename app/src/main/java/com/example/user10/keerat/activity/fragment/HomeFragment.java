package com.example.user10.keerat.activity.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.user10.keerat.R;
import com.example.user10.keerat.activity.adaptor.ViewPagerAdapter;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {

    Toolbar toolbar;
    ViewPager viewPager;
    PagerAdapter adapter;
    int[] image;




   /* public HomeFragment() {
        // Required empty public constructor
    }*/


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_home, container, false);

         toolbar = (Toolbar) v.findViewById(R.id.toolbarhome);
        /*toolbar.setTitle(Html.fromHtml("<b>Keerat</b>"));
        toolbar.setTitleTextAppearance(getActivity(),android.R.style.TextAppearance_Large);
        toolbar.setTitleTextColor(Color.parseColor("#fe7a47"));
        setSupportActionBar(toolbar);*/

        if (toolbar != null) {
            ((AppCompatActivity) getActivity()).setSupportActionBar(toolbar);
            ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle(Html.fromHtml("<b>Home</b>"));
        }



        image = new int[] { R.drawable.grid, R.mipmap.ic_launcher,
                R.drawable.grid, R.mipmap.ic_launcher,
                R.drawable.grid, R.mipmap.ic_launcher };

        viewPager = (ViewPager)v.findViewById(R.id.pager);


       ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getActivity(), image);
        viewPager.setAdapter(viewPagerAdapter);


    return v;

    }

}
