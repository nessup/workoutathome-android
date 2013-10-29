package com.joumaa.workouthome.model;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.joumaa.workouthome.R;
import com.joumaa.workouthome.temporary.Section;

/**
 * Created by dany on 10/28/13.
 */
public class SectionHeaderRow {
    public TextView titleView;
    public TextView seeMoreText;
    public ImageView seeMoreImage;

    public static SectionHeaderRow newInstance(View view) {
        SectionHeaderRow sectionHeaderRow = new SectionHeaderRow();
        sectionHeaderRow.findViews(view);
        return sectionHeaderRow;
    }

    private void findViews(View view) {
        titleView = (TextView) view.findViewById(R.id.headerTitle);
        seeMoreText = (TextView) view.findViewById(R.id.seeAllText);
        seeMoreImage = (ImageView) view.findViewById(R.id.seeAllIcon);
    }

    public void configureViewWithSection(Section section) {
        titleView.setText(section.title);

        int seeMoreVisibility = section.hasMore ? View.VISIBLE : View.GONE;
        seeMoreText.setVisibility(seeMoreVisibility);
        seeMoreImage.setVisibility(seeMoreVisibility);
    }
}
