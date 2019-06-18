package cine.emon.live.com.cinematic.fragment;

import android.content.Context;
import android.net.Uri;
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
import cine.emon.live.com.cinematic.adapter.MovieTrailerAdapter;
import cine.emon.live.com.cinematic.adapter.UpComingMoviesAdapter;
import cine.emon.live.com.cinematic.helper.MyDividerItemDecoration;
import cine.emon.live.com.cinematic.model.UpComingMovie;


public class TrailerFragment extends Fragment {

    private List<UpComingMovie> movieList = new ArrayList<>();
    private RecyclerView recyclerView;
    private MovieTrailerAdapter mAdapter;
    private View view;

    public TrailerFragment() {
        // Required empty public constructor
    }

    public static TrailerFragment newInstance(String param1, String param2) {
        TrailerFragment fragment = new TrailerFragment();
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
        view = inflater.inflate(R.layout.fragment_trailer, container, false);
        intiViw();
        prepareMovieData();
        return view;

    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }


    private void intiViw() {
        recyclerView = (RecyclerView) view.findViewById(R.id.recy_view_coming_soon);

        mAdapter = new MovieTrailerAdapter(getActivity(), movieList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.addItemDecoration(new MyDividerItemDecoration(2,
                Objects.requireNonNull(getActivity()).getResources().getColor(R.color.border_color)));
        recyclerView.setAdapter(mAdapter);

    }

    private void prepareMovieData() {
        UpComingMovie movie = new UpComingMovie("trailer1", "How To Train Your Dragon 3", "Director : Dean DeBlois");
        movieList.add(movie);
        UpComingMovie movie1 = new UpComingMovie("trailer2", "The Grinch Stole Christmas", "Director : Ron Howard");
        movieList.add(movie1);
        UpComingMovie movie2 = new UpComingMovie("trailer3", "The House with a Clock", "Director : Eli Roth");
        movieList.add(movie2);
        UpComingMovie movie3 = new UpComingMovie("trailer4", "Predator 3 ", "Director : Nimród Antal");
        movieList.add(movie3);
        UpComingMovie movie4 = new UpComingMovie("trailer5", "Robot 2", "Director : Shankar Shanmugam");
        movieList.add(movie4);

        mAdapter.notifyDataSetChanged();
    }
}
