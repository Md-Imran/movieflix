package cine.emon.live.com.cinematic.activity;


import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.TextView;

import cine.emon.live.com.cinematic.BuildConfig;
import cine.emon.live.com.cinematic.R;
import cine.emon.live.com.cinematic.fragment.ComingSoonFragment;
import cine.emon.live.com.cinematic.fragment.DownloadFragment;
import cine.emon.live.com.cinematic.fragment.HomeFragment;
import cine.emon.live.com.cinematic.fragment.MoreFragment;
import cine.emon.live.com.cinematic.fragment.SearchFragment;
import cine.emon.live.com.cinematic.fragment.TrailerFragment;
import cine.emon.live.com.cinematic.helper.BottomNavigationViewHelper;
import cine.emon.live.com.cinematic.utils.BottomNavigationBehavior;

public class MainActivity extends AppCompatActivity {


    private BottomNavigationView bottomNavigation;
    private Fragment fragment;
    private FragmentManager fragmentManager;

    private TextView tvToolbarFont;
    private Typeface font;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //  initToolbar();
        initView();
    }

    private void initToolbar() {
        Toolbar mToolbar = (Toolbar) findViewById(R.id.toolbar);
        mToolbar.setTitle(" ");
        if (mToolbar != null) {
            setSupportActionBar(mToolbar);
        }

        TextView tvToolbarFont = (TextView) findViewById(R.id.toolbarText);
        Typeface font = Typeface.createFromAsset(getAssets(), "fonts/28 Days Later.ttf");
        tvToolbarFont.setText(getString(R.string.app_name));
        tvToolbarFont.setTypeface(font);
    }

    private void initView() {
        bottomNavigation = (BottomNavigationView) findViewById(R.id.navigationView);
        BottomNavigationViewHelper.disableShiftMode(bottomNavigation);
        BottomNavigationViewHelper.changeBottomNavIcon(this, bottomNavigation);
        // attaching bottom sheet behaviour - hide / show on scroll
        CoordinatorLayout.LayoutParams layoutParams = (CoordinatorLayout.LayoutParams) bottomNavigation.getLayoutParams();
        layoutParams.setBehavior(new BottomNavigationBehavior());

        fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.container, new HomeFragment()).commit();

        bottomNavigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();
                switch (id) {
                    case R.id.navigation_home:
                        fragment = new HomeFragment();
                        break;
                    case R.id.navigation_search:
                        fragment = new SearchFragment();
                        break;
                    case R.id.navigation_comming_soon:
                        fragment = new ComingSoonFragment();
                        break;

                    case R.id.navigation_trailer:
                        fragment = new TrailerFragment();
                        break;

                    case R.id.navigation_more:
                        fragment = new MoreFragment();
                        break;
                }
                final FragmentTransaction transaction = fragmentManager.beginTransaction();
                transaction.replace(R.id.container, fragment).commit();
                transaction.addToBackStack(null);
                return true;
            }
        });
    }

}
