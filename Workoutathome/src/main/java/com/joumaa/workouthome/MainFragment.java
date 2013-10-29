package com.joumaa.workouthome;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;

import com.joumaa.workouthome.model.SectionHeaderRow;
import com.joumaa.workouthome.model.VideoRow;
import com.joumaa.workouthome.temporary.FeaturedPage;
import com.joumaa.workouthome.temporary.Video;

/**
 * Created by dany on 10/27/13.
 */
public class MainFragment extends Fragment {
    private FeaturedPage featuredPage;

    private ListView listView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        featuredPage = FeaturedPage.buildTestFeaturedPage();

        View view = inflater.inflate(R.layout.main_fragment, container, false);

        listView = (ListView) view.findViewById(R.id.listView);

        View headerView = inflater.inflate(R.layout.list_view_header, listView, false);
        SectionHeaderRow headerRow = SectionHeaderRow.newInstance(headerView);
        headerRow.configureViewWithSection(featuredPage.mainSection);
        listView.addHeaderView(headerView, null, false);

        VideoListAdapter videoListAdapter = new VideoListAdapter(inflater);
        listView.setAdapter(videoListAdapter);

        return view;
    }

    private void didSelectRowAtIndexPath(int index, View row) {
        getFragmentManager()
                .beginTransaction()
                .replace(R.id.container, VideoInfoFragment.newInstance(Video.buildTestVideo()))
                .addToBackStack(null)
                .commit();
    }

    private class VideoListAdapter extends BaseAdapter {
        LayoutInflater inflater;

        private VideoListAdapter(LayoutInflater inflater) {
            this.inflater = inflater;
        }

        @Override
        public int getCount() {
            return featuredPage.mainSection.videos.size();
        }

        @Override
        public Video getItem(int i) {
            return featuredPage.mainSection.videos.get(i);
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(final int i, View view, ViewGroup parentViewGroup) {
            VideoRow videoRow;
            if (view == null) {
                view = inflater.inflate(R.layout.video_row, parentViewGroup, false);
                videoRow = VideoRow.newInstance(view);
                videoRow.playButtonVisible = true;
                videoRow.thumbnailHeight = getResources().getDimensionPixelSize(R.dimen.featured_thumbnail_height);
                view.setTag(videoRow);

                view.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        MainFragment.this.didSelectRowAtIndexPath(i, view);
                    }
                });
            }
            else {
                videoRow = (VideoRow) view.getTag();
            }

            videoRow.configureWithVideo(getItem(i));

            return view;
        }
    }
}