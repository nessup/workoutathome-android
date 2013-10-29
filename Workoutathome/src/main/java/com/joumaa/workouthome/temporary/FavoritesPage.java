package com.joumaa.workouthome.temporary;

/**
 * Created by dany on 10/29/13.
 */
public class FavoritesPage {
    public Section section;

    public static FavoritesPage buildTestFavoritesPage() {
        FavoritesPage favoritesPage = new FavoritesPage();
        favoritesPage.section = Section.buildTestSection();
        return favoritesPage;
    }
}
