package com.joumaa.workouthome;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.joumaa.workouthome.temporary.Section;
import com.joumaa.workouthome.temporary.Video;

/**
 * Created by dany on 10/29/13.
 */
public abstract class VideoListFragment extends WOAHFragment implements VideoListAdapter.OnVideoClickListener {
    private ListView listView;
    private LayoutInflater inflater;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        this.inflater = inflater;
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void findViews(View view) {
        super.findViews(view);
        listView = (ListView) view.findViewById(R.id.listView);
    }

    public void configureWithSection(Section section) {
        VideoListAdapter videoListAdapter = new VideoListAdapter(listView, inflater, section);
        videoListAdapter.setOnVideoClickListener(this);
        listView.setAdapter(videoListAdapter);
    }

    // On video click listener

    @Override
    public void onVideoClicked(int position, View rowView, Video video) {
        getFragmentManager()
                .beginTransaction()
                .replace(R.id.container, VideoInfoFragment.newInstance(Video.buildTestVideo()))
                .addToBackStack(null)
                .commit();
    }

    public ListView getListView() {
        return listView;
    }
}
