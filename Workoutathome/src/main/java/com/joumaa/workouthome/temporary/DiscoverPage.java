package com.joumaa.workouthome.temporary;

import java.util.ArrayList;

/**
 * Created by dany on 10/28/13.
 */
public class DiscoverPage {
    public ArrayList<Section> sections;

    public static DiscoverPage buildTestDiscoverPage() {
        DiscoverPage discoverPage = new DiscoverPage();

        discoverPage.sections = new ArrayList<Section>();
        discoverPage.sections.add(Section.buildTestSection());
        discoverPage.sections.add(Section.buildTestSection());

        return discoverPage;
    }
}
