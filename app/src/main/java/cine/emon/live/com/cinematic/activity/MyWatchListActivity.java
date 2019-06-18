package cine.emon.live.com.cinematic.activity;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;


import java.util.ArrayList;
import java.util.List;

import cine.emon.live.com.cinematic.R;
import cine.emon.live.com.cinematic.adapter.WatchListAdapter;
import cine.emon.live.com.cinematic.model.WatchItem;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import timber.log.Timber;

public class MyWatchListActivity extends AppCompatActivity
        implements SwipeRefreshLayout.OnRefreshListener, View.OnClickListener {

    private WatchListAdapter watchListAdapter;
    private List<WatchItem> watchItems;
    private RecyclerView recyclerView;
    private SwipeRefreshLayout swipeRefresh;
    private ImageButton imgBtnBack;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_watch_list);
        initToolbar();
        initView();
    }

    private void initToolbar() {
        Toolbar mToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);

        TextView tvToolbarFont = (TextView) findViewById(R.id.toolbarText);
        /*Typeface font = Typeface.createFromAsset(getAssets(), "fonts/28 Days Later.ttf");
        tvToolbarFont.setTypeface(font);*/
        tvToolbarFont.setText(getString(R.string.my_list));
    }

    private void initView() {

        imgBtnBack = findViewById(R.id.img_btn_back);
        imgBtnBack.setOnClickListener(this);

        swipeRefresh = (SwipeRefreshLayout) findViewById(R.id.swipeRefresh);
        swipeRefresh.setOnRefreshListener(this);
        int myColor = Color.parseColor("#494848");
        swipeRefresh.setProgressBackgroundColorSchemeColor(myColor);
        swipeRefresh.setColorSchemeColors(Color.RED, Color.BLACK, Color.GRAY);

        watchItems = new ArrayList<>();
        loadData();
        recyclerView = findViewById(R.id.recyclerView);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 3);
        recyclerView.setLayoutManager(gridLayoutManager); // set LayoutManager to RecyclerView
        watchListAdapter = new WatchListAdapter(this, watchItems);
        recyclerView.setAdapter(watchListAdapter); // set the Adapter to RecyclerView
        watchListAdapter.notifyDataSetChanged();
    }

    private void loadData() {
        for (int i = 0; i < 30; i++) {
            WatchItem watchItem = new WatchItem();
            watchItem.setPortrait(loadImage(i));
            watchItems.add(watchItem);
        }
    }

    private String loadImage(int value) {
        List<String> imageList = new ArrayList<>();
        imageList.add("poster30");
        imageList.add("poster29");
        imageList.add("poster28");
        imageList.add("poster27");
        imageList.add("poster26");
        imageList.add("poster25");
        imageList.add("poster24");
        imageList.add("poster23");
        imageList.add("poster22");
        imageList.add("poster10");
        imageList.add("poster11");
        imageList.add("poster12");
        imageList.add("poster13");
        imageList.add("poster14");
        imageList.add("poster15");
        imageList.add("poster16");
        imageList.add("poster17");
        imageList.add("poster18");
        imageList.add("poster19");
        imageList.add("poster20");
        imageList.add("poster21");
        imageList.add("poster9");
        imageList.add("poster8");
        imageList.add("poster7");
        imageList.add("poster6");
        imageList.add("poster5");
        imageList.add("poster4");
        imageList.add("poster3");
        imageList.add("poster2");
        imageList.add("poster1");

        return imageList.get(value);
    }


    @Override
    protected void onResume() {
        super.onResume();

    }


    @Override
    public void onRefresh() {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.img_btn_back:
                onBackPressed();
                break;

            default:
                break;
        }
    }
}
