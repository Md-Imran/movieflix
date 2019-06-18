package cine.emon.live.com.cinematic.adapter;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import cine.emon.live.com.cinematic.R;
import cine.emon.live.com.cinematic.model.Movie;

public class MoviesAdapter extends RecyclerView.Adapter<MoviesAdapter.MyViewHolder> {

    private List<Movie> moviesList;
    private Context mContext;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView title, duration, genre;
        ImageView ivMovieThumb;

        public MyViewHolder(View view) {
            super(view);
            title = (TextView) view.findViewById(R.id.title);
            genre = (TextView) view.findViewById(R.id.tv_genre);
            duration = (TextView) view.findViewById(R.id.tv_duration);
            ivMovieThumb = (ImageView) view.findViewById(R.id.iv_movie);
        }
    }


    public MoviesAdapter(Context context, List<Movie> moviesList) {
        this.mContext = context;
        this.moviesList = moviesList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_movie_list, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Movie movie = moviesList.get(position);
        holder.title.setText(movie.getTitle());
        holder.genre.setText(movie.getGenre());
        holder.duration.setText(movie.getYear());

        Glide.with(mContext)
                .load(getImage(movie.getImagePath()))
                .into(holder.ivMovieThumb);
    }

    @Override
    public int getItemCount() {
        return moviesList.size();
    }

    public int getImage(String imageName) {

        int drawableResourceId = mContext.getResources().getIdentifier(imageName, "drawable", mContext.getPackageName());

        return drawableResourceId;
    }
}
