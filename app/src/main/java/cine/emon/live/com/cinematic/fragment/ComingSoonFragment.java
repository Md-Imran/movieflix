package cine.emon.live.com.cinematic.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import cine.emon.live.com.cinematic.R;
import cine.emon.live.com.cinematic.adapter.MoviesAdapter;
import cine.emon.live.com.cinematic.adapter.UpComingMoviesAdapter;
import cine.emon.live.com.cinematic.adapter.VerticalRecyclerViewAdapter;
import cine.emon.live.com.cinematic.helper.MyDividerItemDecoration;
import cine.emon.live.com.cinematic.model.Movie;
import cine.emon.live.com.cinematic.model.UpComingMovie;
import cine.emon.live.com.cinematic.model.VerticalModel;

public class ComingSoonFragment extends Fragment {


    private List<UpComingMovie> movieList = new ArrayList<>();
    private RecyclerView recyclerView;
    private UpComingMoviesAdapter mAdapter;
    private View view;

    public ComingSoonFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_coming_soon, container, false);
        intiViw();
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        prepareMovieData();
    }

    private void intiViw() {
        recyclerView = (RecyclerView) view.findViewById(R.id.recy_view_coming_soon);

        mAdapter = new UpComingMoviesAdapter(getActivity(), movieList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.addItemDecoration(new MyDividerItemDecoration(2,
                Objects.requireNonNull(getActivity()).getResources().getColor(R.color.border_color)));
        recyclerView.setAdapter(mAdapter);

    }

    private void prepareMovieData() {
        UpComingMovie movie = new UpComingMovie("banner5", "justice  League", "Coming September 28");
        movieList.add(movie);
        UpComingMovie movie1 = new UpComingMovie("banner7", "Five Way 2", "Coming August 02");
        movieList.add(movie1);
        UpComingMovie movie2 = new UpComingMovie("banner2", "Captain America 3", "Coming August 02");
        movieList.add(movie2);
        UpComingMovie movie3 = new UpComingMovie("banner3", "Wonder Women 2", "Coming August 02");
        movieList.add(movie3);
        UpComingMovie movie4 = new UpComingMovie("banner4", "Pacific Rim 3", "Coming August 02");
        movieList.add(movie4);


        mAdapter.notifyDataSetChanged();
    }


}
