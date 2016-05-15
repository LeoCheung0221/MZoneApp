package com.leo.mzoneapp.ui.activities;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.view.MenuItem;

import com.leo.mzoneapp.R;
import com.leo.mzoneapp.ui.fragments.FragmentAbout;
import com.leo.mzoneapp.ui.fragments.FragmentHistory;
import com.leo.mzoneapp.ui.fragments.FragmentMap;
import com.leo.mzoneapp.ui.fragments.FragmentMzoneInfo;

public class ActivityMain extends ActivityBase
        implements NavigationView.OnNavigationItemSelectedListener {
    private static final String TAG_MZONE_INFO = "MZONE_INFO";
    private static final String TAG_HISTORY = "TAG_HISTORY";
    private static final String TAG_MAP = "TAG_MAP";
    private static final String TAG_ABOUT = "TAG_ABOUT";

    DrawerLayout drawer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        /*ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
            this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();*/

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        onNavigationItemSelected(navigationView.getMenu().getItem(0));
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        int id = item.getItemId();
        String TAG = null;
        Fragment f = null;
        switch (id) {
            case R.id.nav_mzone_info:
                TAG = TAG_MZONE_INFO;
                f = getSupportFragmentManager().findFragmentByTag(TAG);
                if (f == null)
                    f = new FragmentMzoneInfo();
                break;
            case R.id.nav_song_order:
                ActivitySongs.display(this);
                return true;
            case R.id.nav_song_chart:
                ActivitySongsCharts.display(this);
                return true;
            case R.id.nav_orders_history:
                TAG = TAG_HISTORY;
                f = getSupportFragmentManager().findFragmentByTag(TAG);
                if (f == null)
                    f = new FragmentHistory();
                break;
            case R.id.nav_map:
                TAG = TAG_MAP;
                f = getSupportFragmentManager().findFragmentByTag(TAG);
                if (f == null)
                    f = new FragmentMap();
                break;
            case R.id.nav_info:
                TAG = TAG_ABOUT;
                f = getSupportFragmentManager().findFragmentByTag(TAG);
                if (f == null)
                    f = new FragmentAbout();
                break;
            case R.id.nav_phone:
                //todo implement
                break;
            case R.id.nav_feedback:
                //todo implement
                break;
            default:
                return false;
        }

        if (!TextUtils.isEmpty(TAG)
                && f != null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.flContainer, f, TAG)
                    .commit();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
