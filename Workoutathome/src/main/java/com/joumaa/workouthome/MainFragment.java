package com.joumaa.workouthome;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.joumaa.workouthome.temporary.FeaturedPage;

/**
 * Created by dany on 10/27/13.
 */
public class MainFragment extends VideoListFragment {
    private FeaturedPage featuredPage;

    @Override
    protected View createView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.main_fragment, container, false);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = super.onCreateView(inflater, container, savedInstanceState);
        featuredPage = FeaturedPage.buildTestFeaturedPage();
        configureWithSection(featuredPage.mainSection);
        return view;
    }
}