package com.joumaa.workouthome;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends FragmentActivity {

    public static final int MAIN_FRAGMENT = 0;
    public static final int DISCOVER_FRAGMENT = 1;
    public static final int FAVORITES_FRAGMENT = 2;

    private ViewGroup navigationItemContainer = null;
    private int currentFragmentIndex = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);

        setupNavigationItems();

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, new MainFragment())
                    .commit();
            getNavigationItemAtIndex(0).setSelected(true);
        }
    }

    private ViewGroup getNavigationItemAtIndex(int index) {
        return (ViewGroup) navigationItemContainer.getChildAt(index);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        // TODO: save currentFragmentIndex and navigationItemContainer
    }

    private void setupNavigationItems() {
        int [] images = {R.drawable.home, R.drawable.discover, R.drawable.favorites};
        String[] strings = {"Home", "Discover", "Favorites"};

        navigationItemContainer = (ViewGroup) findViewById(R.id.navigationContainer);
        ViewGroup navigationItem = null;
        for (int i = 0; i < navigationItemContainer.getChildCount(); i++) {
            navigationItem = (ViewGroup) navigationItemContainer.getChildAt(i);
            navigationItem.setTag(new Integer(i));
            navigationItem.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    navigationItemClicked(view);
                }
            });

            ImageView imageView = (ImageView) navigationItem.findViewById(R.id.imageView);
            imageView.setImageResource(images[i]);

            TextView textView = (TextView) navigationItem.findViewById(R.id.textView);
            textView.setText(strings[i]);
        }
    }

    private void navigationItemClicked(View view) {
        int index = (Integer) view.getTag();
        Fragment fragment = null;
        switch (index) {
            case MAIN_FRAGMENT:
                fragment = new MainFragment();
                break;

            case DISCOVER_FRAGMENT:
                fragment = new DiscoverFragment();
                break;

            case FAVORITES_FRAGMENT:
                fragment = new FavoritesFragment();
                break;
        }

        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.container, fragment)
                .addToBackStack(null)
                .commit();

        getNavigationItemAtIndex(currentFragmentIndex).setSelected(false);
        currentFragmentIndex = index;
        view.setSelected(true);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        switch (item.getItemId()) {
            case R.id.action_settings:
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
