package cine.emon.live.com.cinematic.adapter;


import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import cine.emon.live.com.cinematic.R;
import cine.emon.live.com.cinematic.model.UpComingMovie;

public class UpComingMoviesAdapter extends RecyclerView.Adapter<UpComingMoviesAdapter.MyViewHolder> {

    private List<UpComingMovie> moviesList;
    private Context mContext;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView title, date, description;
        ImageView ivUpcomingMovieThumb;

        MyViewHolder(View view) {
            super(view);
            title = (TextView) view.findViewById(R.id.tv_upcoming_movie_title);
            // description = (TextView) view.findViewById(R.id.genre);
            date = (TextView) view.findViewById(R.id.tv_date);
            ivUpcomingMovieThumb = (ImageView) view.findViewById(R.id.imv_upcoming_movie);
        }
    }


    public UpComingMoviesAdapter(Context context, List<UpComingMovie> moviesList) {
        this.mContext = context;
        this.moviesList = moviesList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_coming_soon, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        UpComingMovie movie = moviesList.get(position);
        holder.title.setText(movie.getTitle());
        // holder.description.setText(movie.getGenre());
        holder.date.setText(movie.getDate());

        Glide.with(mContext)
                .load(getImage(movie.getImagePath()))
                .into(holder.ivUpcomingMovieThumb);
    }

    @Override
    public int getItemCount() {
        return moviesList.size();
    }

    private int getImage(String imageName) {

        return mContext.getResources().getIdentifier(imageName, "drawable", mContext.getPackageName());
    }
}
