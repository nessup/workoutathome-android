package com.joumaa.workouthome;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;

import com.joumaa.workouthome.model.VideoRow;
import com.joumaa.workouthome.temporary.Video;

/**
 * Created by dany on 10/27/13.
 */
public class MainFragment extends Fragment {
    private ListView listView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.main_fragment, container, false);

        listView = (ListView) view.findViewById(R.id.listView);

        View headerView = inflater.inflate(R.layout.list_view_header, listView, false);
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
            return 5;
        }

        @Override
        public Video getItem(int i) {
            return Video.buildTestVideo();
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