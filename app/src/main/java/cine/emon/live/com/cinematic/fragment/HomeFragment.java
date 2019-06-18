package cine.emon.live.com.cinematic.fragment;


import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomSheetBehavior;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import cine.emon.live.com.cinematic.R;
import cine.emon.live.com.cinematic.adapter.MainSliderAdapter;
import cine.emon.live.com.cinematic.adapter.VerticalRecyclerViewAdapter;
import cine.emon.live.com.cinematic.model.HorizontalModel;
import cine.emon.live.com.cinematic.model.Item;
import cine.emon.live.com.cinematic.model.ItemResponse;
import cine.emon.live.com.cinematic.model.VerticalModel;
import cine.emon.live.com.cinematic.network.ApiClient;
import cine.emon.live.com.cinematic.network.ApiInterface;
import cine.emon.live.com.cinematic.service.PicassoImageLoadingService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import ss.com.bannerslider.Slider;

import static android.support.constraint.Constraints.TAG;

public class HomeFragment extends Fragment {

    // SliderLayout sliderLayout;
    private View view;
    private RecyclerView recyclerView;
    private ArrayList<VerticalModel> mArrayList = new ArrayList<>();

    private VerticalRecyclerViewAdapter mAdapter;
    private Slider slider;
    private LinearLayout layoutBottomSheet;
    private BottomSheetBehavior sheetBehavior;


    public HomeFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_home, container, false);
        initToolbar();
        initView();
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onResume() {
        super.onResume();
        //loadSliderImage();
        //loadData();
        setDataOnVerticalRecyclerView();
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

    @Override
    public void onStop() {
        // To prevent a memory leak on rotation, make sure to call stopAutoCycle() on the slider before activity or fragment is destroyed
        //sliderLayout.stopAutoCycle();
        super.onStop();
    }


    private void setDataOnVerticalRecyclerView() {
        for (int i = 1; i <= 9; i++) {

            VerticalModel mVerticalModel = new VerticalModel();

            mVerticalModel.setTitle(dummyCategory(i));

            ArrayList<HorizontalModel> arrayList = new ArrayList<>();

            for (int j = 1; j <= 10; j++) {
                HorizontalModel mHorizontalModel = new HorizontalModel();
                mHorizontalModel.setDescription("Description : " + j);
                mHorizontalModel.setName("Xmen : " + j);
                if (i == 1) {
                    mHorizontalModel.setImagePath(loadImage(j - 1));
                }

                if (i == 2) {
                    mHorizontalModel.setImagePath(loadImage(j + 10 - 1));
                }

                if (i == 3) {
                    mHorizontalModel.setImagePath(loadImage(j + 20 - 1));
                }
                if (i == 4) {
                    mHorizontalModel.setImagePath(loadImage(j - 1));
                }

                if (i == 5) {
                    mHorizontalModel.setImagePath(loadImage(j + 10 - 1));
                }

                if (i == 6) {
                    mHorizontalModel.setImagePath(loadImage(j + 20 - 1));
                }

                if (i == 7) {
                    mHorizontalModel.setImagePath(loadImage(j - 1));
                }

                if (i == 8) {
                    mHorizontalModel.setImagePath(loadImage(j + 10 - 1));
                }
                if (i == 9) {
                    mHorizontalModel.setImagePath(loadImage(j + 20 - 1));
                }
                if (i == 10) {
                    mHorizontalModel.setImagePath(loadImage(j - 1));
                }

                arrayList.add(mHorizontalModel);
            }

            mVerticalModel.setArrayList(arrayList);

            mArrayList.add(mVerticalModel);

        }
        mAdapter.notifyDataSetChanged();
    }

    private String dummyCategory(int value) {
        List<String> movieCategory = new ArrayList<>();
        movieCategory.add("Action Movies");
        movieCategory.add("Adventure Movies");
        movieCategory.add("Horror Movies");
        movieCategory.add("Romantic Movies");
        movieCategory.add("Fantasy Movies");
        movieCategory.add("Comedy Movies");
        movieCategory.add("Thriller Movies");
        movieCategory.add("Sifi Movies");
        movieCategory.add("Bio Movies");
        movieCategory.add("Animation Movies");
        return movieCategory.get(value);
    }

    private void initView() {

        layoutBottomSheet = (LinearLayout) view.findViewById(R.id.bottom_sheet);
        sheetBehavior = BottomSheetBehavior.from(layoutBottomSheet);
        sheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED);

        Slider.init(new PicassoImageLoadingService(getActivity()));
        slider = view.findViewById(R.id.slider);
        // slider.setLoopSlides(true);
        slider.setInterval(8000);
        slider.setAnimateIndicators(false);
        slider.setAdapter(new MainSliderAdapter(getActivity()));
        slider.setSelectedSlide(0);


        /**
         * bottom sheet state change listener
         * we are changing button text when sheet changed state
         * */
        sheetBehavior.setBottomSheetCallback(new BottomSheetBehavior.BottomSheetCallback() {
            @Override
            public void onStateChanged(@NonNull View bottomSheet, int newState) {
                switch (newState) {
                    case BottomSheetBehavior.STATE_HIDDEN:
                        sheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED);

                        break;
                    case BottomSheetBehavior.STATE_EXPANDED: {

                    }
                    break;
                    case BottomSheetBehavior.STATE_COLLAPSED: {

                    }
                    break;
                    case BottomSheetBehavior.STATE_DRAGGING:
                        break;
                    case BottomSheetBehavior.STATE_SETTLING:
                        break;
                }
            }

            @Override
            public void onSlide(@NonNull View bottomSheet, float slideOffset) {
            }
        });
        //delay for testing empty view functionality
      /*  slider.postDelayed(new Runnable() {
            @Override
            public void run() {
                slider.setAdapter(new MainSliderAdapter(getActivity()));
                slider.setSelectedSlide(0);
            }
        }, 1500);*/

        recyclerView = view.findViewById(R.id.recyclerView);
        recyclerView.setNestedScrollingEnabled(true);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
        mAdapter = new VerticalRecyclerViewAdapter(getActivity(), mArrayList);
        recyclerView.setAdapter(mAdapter);


    }

    private String loadImage(int value) {
        List<String> imageList = new ArrayList<>();
        imageList.add("poster1");
        imageList.add("poster2");
        imageList.add("poster3");
        imageList.add("poster4");
        imageList.add("poster5");
        imageList.add("poster6");
        imageList.add("poster7");
        imageList.add("poster8");
        imageList.add("poster9");
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
        imageList.add("poster22");
        imageList.add("poster23");
        imageList.add("poster24");
        imageList.add("poster25");
        imageList.add("poster26");
        imageList.add("poster27");
        imageList.add("poster28");
        imageList.add("poster29");
        imageList.add("poster30");

        return imageList.get(value);
    }


    private void loadData() {
        ApiInterface apiService =
                ApiClient.getClient().create(ApiInterface.class);

        Call<ItemResponse> call = apiService.getItems();
        call.enqueue(new Callback<ItemResponse>() {
            @Override
            public void onResponse(@NonNull Call<ItemResponse> call, Response<ItemResponse> response) {
                assert response.body() != null;
                List<Item> movies = response.body().getItems();

                //Log.d(TAG, "Number of Item Recived: " + movies.size());
            }

            @Override
            public void onFailure(Call<ItemResponse> call, Throwable t) {
                // Log error here since request failed
               // Timber.e(t.toString());
            }
        });
    }


}
