package com.joumaa.workouthome;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;

import com.joumaa.workouthome.model.SectionHeaderRow;
import com.joumaa.workouthome.model.VideoRow;
import com.joumaa.workouthome.temporary.Section;
import com.joumaa.workouthome.temporary.Video;

/**
 * Created by dany on 10/29/13.
 */
class VideoListAdapter extends BaseAdapter {
    public interface OnVideoClickListener {
        void onVideoClicked(int position, View rowView, Video video);
    };

    private ListView listView;
    private LayoutInflater inflater;
    private Section section;
    private OnVideoClickListener onVideoClickListener;

    public VideoListAdapter(ListView listView, LayoutInflater inflater, Section section) {
        this.listView = listView;
        this.inflater = inflater;
        this.section = section;

        // Section header
        if (section.title != null && !section.title.isEmpty()) {
            View headerView = inflater.inflate(R.layout.list_view_header, listView, false);
            SectionHeaderRow headerRow = SectionHeaderRow.newInstance(headerView);
            headerRow.configureViewWithSection(section);
            listView.addHeaderView(headerView, null, false);
        }

        listView.setAdapter(this);
    }

    public void setOnVideoClickListener(OnVideoClickListener onVideoClickListener) {
        this.onVideoClickListener = onVideoClickListener;
    }

    @Override
    public int getCount() {
        return section.videos.size();
    }

    @Override
    public Video getItem(int i) {
        return section.videos.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(final int i, View view, ViewGroup parentViewGroup) {
        VideoRow videoRow;
        final Video video = getItem(i);
        if (view == null) {
            view = inflater.inflate(R.layout.video_row, parentViewGroup, false);
            videoRow = VideoRow.newInstance(view);
            videoRow.playButtonVisible = true;
            videoRow.thumbnailHeight = listView.getResources().getDimensionPixelSize(R.dimen.featured_thumbnail_height);
            view.setTag(videoRow);

            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (onVideoClickListener != null) {
                        onVideoClickListener.onVideoClicked(i, view, video);
                    }
                }
            });
        }
        else {
            videoRow = (VideoRow) view.getTag();
        }

        videoRow.configureWithVideo(video);

        return view;
    }
}
