package com.joumaa.workouthome;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by dany on 10/27/13.
 */
public abstract class WOAHFragment extends Fragment {
    private TextView titleView;
    private ImageView backButton;

    abstract protected View createView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState);

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = createView(inflater, container, savedInstanceState);

        this.titleView = (TextView) view.findViewById(R.id.navigationTitleView);

        this.backButton = (ImageView) view.findViewById(R.id.navigationBackButton);
        this.backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                WOAHFragment.this.onBackPressed();
            }
        });

        return view;
    }

    public TextView getTitleView() {
        return titleView;
    }

    private void onBackPressed() {
        getActivity().onBackPressed();
    }
}
