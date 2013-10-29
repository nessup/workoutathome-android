package com.joumaa.workouthome;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.joumaa.workouthome.model.VideoRow;
import com.joumaa.workouthome.temporary.Video;

import java.util.ArrayList;

/**
 * Created by dany on 10/27/13.
 */
public class VideoInfoFragment extends WOAHFragment {
    private LayoutInflater layoutInflater;
    private Video video;
    private VideoRow videoRow;
    private ViewGroup playButton;
    private ViewGroup myFavoritesButton;
    private LinearLayout workoutStepsContainer;

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
        layoutInflater = inflater;

        View view = super.onCreateView(inflater, container, savedInstanceState);
        findViews(view);
        configureUI();

        return view;
    }

    private void findViews(View view) {
        videoRow = VideoRow.newInstance(view);
        playButton = (ViewGroup) view.findViewById(R.id.playContainer);
        myFavoritesButton = (ViewGroup) view.findViewById(R.id.myFavoriteContainer);
        workoutStepsContainer = (LinearLayout) view.findViewById(R.id.workoutStepsContainer);
    }

    private void configureUI() {
        // Set fragment title text
        getTitleView().setText(video.getTitle());

        // Configure the video row
        videoRow.configureWithVideo(video);

        // No play button in the VideoRow; it's visible elsewhere.
        videoRow.playButton.setVisibility(View.GONE);

        ArrayList<String> workoutSteps = video.getWorkoutSteps();
        int i = 0;
        for (String workoutStep : workoutSteps) {
            TextView stepRow = (TextView) layoutInflater.inflate(R.layout.workout_step_row, workoutStepsContainer, false);

            stepRow.setText(workoutStep);

            // Background alternation
            if (i % 2 == 1) {
                stepRow.setBackgroundResource(R.color.alt_row_background);
            }
            else {
                stepRow.setBackgroundResource(R.color.row_background);
            }

            workoutStepsContainer.addView(stepRow);
            i++;
        }
    }

}
