package com.joumaa.workouthome;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.joumaa.workouthome.model.SectionHeaderRow;
import com.joumaa.workouthome.model.VideoRow;
import com.joumaa.workouthome.temporary.DiscoverPage;
import com.joumaa.workouthome.temporary.Section;
import com.joumaa.workouthome.temporary.Video;

import java.util.ArrayList;

/**
 * Created by dany on 10/27/13.
 */
public class DiscoverFragment extends Fragment {
    private DiscoverPage discoverPage;

    private LayoutInflater layoutInflater;
    private ViewGroup view;
    private ArrayList<ViewGroup> columns;

    public static DiscoverFragment newInstance(DiscoverPage discoverPage) {
        DiscoverFragment fragment = new DiscoverFragment();
        fragment.discoverPage = discoverPage;
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        layoutInflater = inflater;

        View view = inflater.inflate(R.layout.discover_fragment, container, false);

        findViews(view);
        configureUI();

        return view;
    }

    private void findViews(View view) {
        this.view = (ViewGroup) view;

        ViewGroup columnsContainer = (ViewGroup) this.view.findViewById(R.id.columnsContainer);
        columns = new ArrayList<ViewGroup>();
        for (int i = 0; i < columnsContainer.getChildCount(); i++) {
            columns.add((ViewGroup) columnsContainer.getChildAt(i));
        }
    }

    private void configureUI() {
        int i = 0;
        ViewGroup parentContainer = null;
        for (Section section : discoverPage.sections) {
            parentContainer = columns.get(i % columns.size());

            View headerView = layoutInflater.inflate(R.layout.list_view_header, parentContainer, false);
            SectionHeaderRow headerRow = SectionHeaderRow.newInstance(headerView);
            headerRow.configureViewWithSection(section);
            parentContainer.addView(headerView);

            for (Video video : section.videos) {
                View videoView = layoutInflater.inflate(R.layout.video_row, parentContainer, false);
                VideoRow videoRow = VideoRow.newInstance(videoView);
                videoRow.titleFontSize = getResources().getDimension(R.dimen.small_title);
                videoRow.subtitleFontSize = getResources().getDimension(R.dimen.small_subtitle);
                videoRow.configureWithVideo(video);
                parentContainer.addView(videoView);
            }

            i++;
        }
    }
}