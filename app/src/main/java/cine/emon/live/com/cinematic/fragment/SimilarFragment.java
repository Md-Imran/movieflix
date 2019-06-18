package cine.emon.live.com.cinematic.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import cine.emon.live.com.cinematic.R;
import cine.emon.live.com.cinematic.adapter.MoviesAdapter;
import cine.emon.live.com.cinematic.helper.MyDividerItemDecoration;
import cine.emon.live.com.cinematic.model.Movie;

public class SimilarFragment extends Fragment {

    private List<Movie> movieList = new ArrayList<>();
    private RecyclerView recyclerView;
    private MoviesAdapter mAdapter;
    private View view;

    public SimilarFragment() {
        // Required empty public constructor
    }

    public static SimilarFragment newInstance(String param1, String param2) {
        SimilarFragment fragment = new SimilarFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_similar, container, false);
        initView();
        return view;
    }

    private void initView() {

        recyclerView = (RecyclerView) view.findViewById(R.id.recy_view_more_like);

        mAdapter = new MoviesAdapter(getActivity(), movieList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(mLayoutManager);
        // recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.addItemDecoration(new MyDividerItemDecoration(2,
                getActivity().getResources().getColor(R.color.border_color)));

        recyclerView.setAdapter(mAdapter);
        recyclerView.setFocusable(false);
        prepareMovieData();
    }

    private void prepareMovieData() {
        Movie movie = new Movie("movie1", "Mad Max: Fury Road", "Action & Adventure", "02H:50M:10S");
        movieList.add(movie);

        movie = new Movie("movie2", "Inside Out", "Animation, Kids & Family", "01H:55M:10S");
        movieList.add(movie);

        movie = new Movie("movie3", "Star Wars: The Force Awakens", "Action", "03H:10M:10S");
        movieList.add(movie);

        movie = new Movie("movie4", "Shaun the Sheep", "Animation", "03H:50M:10S");
        movieList.add(movie);

        movie = new Movie("movie5", "The Martian", "Science Fiction & Fantasy", "04H:20M:10S");
        movieList.add(movie);

        movie = new Movie("movie6", "Impossible Rogue Nation", "Action", "01H:50M:10S");
        movieList.add(movie);

        movie = new Movie("movie1", "Up", "Animation", "02H:40M:10S");
        movieList.add(movie);

        movie = new Movie("movie2", "Star Trek", "Science Fiction", "01H:50M:10S");
        movieList.add(movie);

        movie = new Movie("movie3", "The LEGO Movie", "Animation", "02H:20M:10S");
        movieList.add(movie);

        movie = new Movie("movie4", "Iron Man", "Action & Adventure", "01H:30M:10S");
        movieList.add(movie);

        movie = new Movie("movie5", "Aliens", "Science Fiction", "01H:30M:10S");
        movieList.add(movie);

        movie = new Movie("movie6", "Chicken Run", "Animation", "03H:20M:10S");
        movieList.add(movie);

        movie = new Movie("movie1", "Back to the Future", "Science Fiction", "03H:20M:10S");
        movieList.add(movie);

        movie = new Movie("movie2", "Raiders of the Lost Ark", "Action & Adventure", "02H:35M:10S");
        movieList.add(movie);

        movie = new Movie("movie3", "Goldfinger", "Action & Adventure", "01H:55M:10S");
        movieList.add(movie);

        movie = new Movie("movie4", "Guardians of the Galaxy", "Science Fiction & Fantasy", "02H:45M:10S");
        movieList.add(movie);

        mAdapter.notifyDataSetChanged();
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }


}
