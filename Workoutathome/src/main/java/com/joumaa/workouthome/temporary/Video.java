package com.joumaa.workouthome.temporary;

import com.joumaa.workouthome.model.VideoRow;

import java.util.ArrayList;

/**
 * Created by dany on 10/27/13.
 */
public class Video {

    private String title;
    private int duration;
    private int difficulty;
    private String favorites;
    private ArrayList<String> workoutSteps;

    public static Video buildTestVideo() {
        Video video = new Video();
        video.title = "The Most Awesome Ab Workout Ever";
        video.duration = 60 * 5;
        video.difficulty = VideoRow.WORKOUT_DIFFICULTY_MEDIUM;
        video.favorites = "5";

        video.workoutSteps = new ArrayList<String>();
        video.workoutSteps.add("Crunches");
        video.workoutSteps.add("Pull ups");
        video.workoutSteps.add("Sit ups");
        video.workoutSteps.add("V ups");
        video.workoutSteps.add("Mountain climber");
        video.workoutSteps.add("Push ups");
        video.workoutSteps.add("Downward dog");

        return video;
    }

    public String getTitle() {
        return title;
    }

    public int getDuration() {
        return duration;
    }

    public int getDifficulty() {
        return difficulty;
    }

    public String getFavorites() {
        return favorites;
    }

    public ArrayList<String> getWorkoutSteps() {
        return workoutSteps;
    }
}
