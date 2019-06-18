package cine.emon.live.com.cinematic.activity;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;


import cine.emon.live.com.cinematic.R;
import cine.emon.live.com.cinematic.adapter.ViewPagerAdapter;

public class DetailActivity extends AppCompatActivity
        implements View.OnClickListener {

    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        initToolbar();
        initView();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                // todo: goto back activity from here
                item.setIcon(R.drawable.ic_left_arrow);
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }


    private void initToolbar() {
        Toolbar mToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayShowTitleEnabled(false);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

       /* TextView tvToolbarFont = (TextView) findViewById(R.id.toolbarText);
        Typeface font = Typeface.createFromAsset(getAssets(), "fonts/28 Days Later.ttf");
        tvToolbarFont.setTypeface(font);
        tvToolbarFont.setText(getString(R.string.app_name));*/
    }


    private void initView() {
        viewPager = (ViewPager) findViewById(R.id.viewpager);
        // Create an adapter that knows which fragment should be shown on each page
        ViewPagerAdapter adapter = new ViewPagerAdapter(this, getSupportFragmentManager());
        // Set the adapter onto the view pager
        viewPager.setAdapter(adapter);
        // Give the TabLayout the ViewPager
        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);

        ImageView ivPlayButton = findViewById(R.id.image_button_play);
        ivPlayButton.setOnClickListener(this);

    }


    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.image_button_play:
                goToPlayerActivity();
        }

    }

    private void goToPlayerActivity() {
        Intent intent = new Intent(this, PlayerActivity.class);
        startActivity(intent);
    }

}
