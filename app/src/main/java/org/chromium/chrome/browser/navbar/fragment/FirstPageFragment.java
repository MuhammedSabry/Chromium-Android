package org.chromium.chrome.browser.navbar.fragment;

import android.annotation.SuppressLint;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;


import org.chromium.chrome.R;
import org.chromium.chrome.browser.navbar.adapter.ButtonAdapter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Fragment class to show gridview containing some buttons
 * it's supposed to be the first page in the ViewPager in the expandable navigation bar
 */
public class FirstPageFragment extends Fragment {

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @SuppressLint("InflateParams")
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.main_fragment_layout, null);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        //Buttons Labels
        List<String> buttonNames = new ArrayList<>(6);
        Collections.addAll(buttonNames
                , "History"
                , "Downloads"
                , "Full Screen"
                , "dummy"
                , "dummy"
                , "dummy");

        //Buttons Icons
        List<Drawable> buttonDrawables = new ArrayList<>(6);
        Collections.addAll(buttonDrawables
                , getResources().getDrawable(R.drawable.ic_history)
                , getResources().getDrawable(R.drawable.ic_downloads)
                , getResources().getDrawable(R.drawable.ic_fullscreen)
                , getResources().getDrawable(R.drawable.ic_dummy)
                , getResources().getDrawable(R.drawable.ic_dummy)
                , getResources().getDrawable(R.drawable.ic_dummy));

        //GridView Instantiation
        GridView gridView = view.findViewById(R.id.mainGridView);
        gridView.setAdapter(new ButtonAdapter(this.getContext(), buttonNames, buttonDrawables));

    }
}
