package com.joumaa.workouthome.temporary;

import java.util.ArrayList;

/**
 * Created by dany on 10/28/13.
 */
public class Section {
    public String title;
    public ArrayList<Video> videos;
    public boolean hasMore;

    public static Section buildTestSection() {
        Section section = new Section();
        section.title = "Most awesome workouts";

        section.videos = new ArrayList<Video>();
        section.videos.add(Video.buildTestVideo());
        section.videos.add(Video.buildTestVideo());
        section.videos.add(Video.buildTestVideo());

        section.hasMore = true;

        return section;
    }
}
