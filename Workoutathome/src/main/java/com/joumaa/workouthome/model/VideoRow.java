package com.joumaa.workouthome.model;

import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.joumaa.workouthome.R;
import com.joumaa.workouthome.temporary.Video;

/**
 * Created by dany on 10/28/13.
 */
public class VideoRow {
    public static final int WORKOUT_DIFFICULTY_EASY = 1;
    public static final int WORKOUT_DIFFICULTY_MEDIUM = 2;
    public static final int WORKOUT_DIFFICULTY_HARD = 3;

    public boolean playButtonVisible;
    public float titleFontSize;
    public float subtitleFontSize;
    public int thumbnailHeight;

    public ImageView thumbnailView;
    public TextView titleView;
    public ImageButton playButton;
    public ImageView durationIcon;
    public TextView durationInfo;
    public ImageView difficultyIcon;
    public TextView difficultyInfo;
    public ImageView favoritesIcon;
    public TextView favoritesInfo;

    public static VideoRow newInstance(View view) {
        VideoRow videoRow = new VideoRow();
        videoRow.findViews(view);
        return videoRow;
    }

    private void findViews(View parentView) {
        thumbnailView = (ImageView) parentView.findViewById(R.id.imageView);
        titleView = (TextView) parentView.findViewById(R.id.title);
        playButton = (ImageButton) parentView.findViewById(R.id.playButton);
        durationIcon = (ImageView) parentView.findViewById(R.id.durationIcon);
        durationInfo = (TextView) parentView.findViewById(R.id.durationInfo);
        difficultyIcon = (ImageView) parentView.findViewById(R.id.intensityIcon);
        difficultyInfo = (TextView) parentView.findViewById(R.id.intensityInfo);
        favoritesIcon = (ImageView) parentView.findViewById(R.id.favoritesIcon);
        favoritesInfo = (TextView) parentView.findViewById(R.id.favoritesInfo);
    }

    public void configureWithVideo(Video video) {
        // Video thumbnail
        if (thumbnailHeight > 0) {
            thumbnailView.getLayoutParams().height = thumbnailHeight;
        }

        // Title
        titleView.setText(video.getTitle());
        if (titleFontSize > 0) {
            titleView.setTextSize(titleFontSize);
        }

        // Play button
        playButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // todo: play a video
            }
        });
        playButton.setVisibility(playButtonVisible ? View.VISIBLE : View.GONE);

        // Video duration
        int durationResourceId;
        if (video.getDuration() > 60 * 15) {
            durationResourceId = R.drawable.clock_red;
        }
        else if(video.getDuration() > 60 * 5) {
            durationResourceId = R.drawable.clock_yellow;
        }
        else {
            durationResourceId = R.drawable.clock_green;
        }
        durationIcon.setImageResource(durationResourceId);

        // Video difficulty
        int difficultyResourceId;
        String difficultyString;
        if (video.getDifficulty() == WORKOUT_DIFFICULTY_HARD) {
            difficultyResourceId = R.drawable.intensity_red;
            difficultyString = "Difficult";
        }
        else if(video.getDifficulty() == WORKOUT_DIFFICULTY_MEDIUM) {
            difficultyResourceId = R.drawable.intensity_yellow;
            difficultyString = "Medium difficulty";
        }
        else {
            difficultyResourceId = R.drawable.intensity_green;
            difficultyString = "Easy";
        }
        difficultyIcon.setImageResource(difficultyResourceId);
        difficultyInfo.setText(difficultyString);

        // Number of favorites
        // todo: make heart red if this user liked it
        favoritesInfo.setText(video.getFavorites());

        // Subtitle font sizes
        if (subtitleFontSize > 0) {
            durationInfo.setTextSize(subtitleFontSize);
            difficultyInfo.setTextSize(subtitleFontSize);
            favoritesInfo.setTextSize(subtitleFontSize);
        }
    }
}
