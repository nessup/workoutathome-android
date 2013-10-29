package com.joumaa.workouthome.temporary;

/**
 * Created by dany on 10/28/13.
 */
public class FeaturedPage {
    public Section mainSection;

    public static FeaturedPage buildTestFeaturedPage() {
        FeaturedPage page = new FeaturedPage();
        page.mainSection = Section.buildTestSection();
        return page;
    }
}
