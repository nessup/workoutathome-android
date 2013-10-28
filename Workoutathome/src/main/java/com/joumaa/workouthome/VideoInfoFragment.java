package com.joumaa.workouthome;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.joumaa.workouthome.temporary.Video;

/**
 * Created by dany on 10/27/13.
 */
public class VideoInfoFragment extends WOAHFragment {
    private Video video;

    public static VideoInfoFragment newInstance(Video video) {
        VideoInfoFragment myFragment = new VideoInfoFragment();

        // TODO: use bundles to pass argument to the fragment

        myFragment.video = video;

        return myFragment;
    }

    @Override
    protected View createView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.video_info_fragment, container, false);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = super.onCreateView(inflater, container, savedInstanceState);

        getTitleView().setText("Video Info");

        return view;
    }
}
