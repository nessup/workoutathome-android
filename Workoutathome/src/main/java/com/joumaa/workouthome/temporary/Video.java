package com.joumaa.workouthome.temporary;

/**
 * Created by dany on 10/27/13.
 */
public class Video {
    private String title;

    public static Video buildTestVideo() {
        Video video = new Video();
        video.title = "The Most Awesome Ab Workout Ever";
        return video;
    }

    public String getTitle() {
        return title;
    }
}
