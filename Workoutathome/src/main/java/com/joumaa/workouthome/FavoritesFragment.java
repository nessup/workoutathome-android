package com.joumaa.workouthome;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.joumaa.workouthome.temporary.FavoritesPage;

/**
 * Created by dany on 10/27/13.
 */
public class FavoritesFragment extends VideoListFragment {
    private FavoritesPage page;

    @Override
    protected View createView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.favorites_fragment, container, false);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = super.onCreateView(inflater, container, savedInstanceState);

        page = FavoritesPage.buildTestFavoritesPage();
        int noFavoritesVisibility = View.VISIBLE;
        if (page.section.videos.size() > 0) {
            configureWithSection(page.section);
            noFavoritesVisibility = View.GONE;
        }


        return view;
    }
}