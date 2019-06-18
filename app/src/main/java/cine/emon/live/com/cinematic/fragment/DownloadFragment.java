package cine.emon.live.com.cinematic.fragment;


import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import cine.emon.live.com.cinematic.R;
import cine.emon.live.com.cinematic.adapter.MainSliderAdapter;
import cine.emon.live.com.cinematic.adapter.VerticalRecyclerViewAdapter;
import cine.emon.live.com.cinematic.model.HorizontalModel;
import cine.emon.live.com.cinematic.model.VerticalModel;
import cine.emon.live.com.cinematic.service.PicassoImageLoadingService;
import ss.com.bannerslider.Slider;

public class DownloadFragment extends Fragment {

    // SliderLayout sliderLayout;
    private View view;


    public DownloadFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_download, container, false);
        initToolbar();
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    private void initToolbar() {
        Toolbar mToolbar = (Toolbar) view.findViewById(R.id.toolbar);
        mToolbar.setTitle(" ");
        if (mToolbar != null) {
            ((AppCompatActivity) getActivity()).setSupportActionBar(mToolbar);
        }

        TextView tvToolbarFont = (TextView) view.findViewById(R.id.toolbarText);
        Typeface font = Typeface.createFromAsset(getActivity().getAssets(), "fonts/28 Days Later.ttf");
        tvToolbarFont.setText(getString(R.string.app_name));
        tvToolbarFont.setTypeface(font);
    }
}
