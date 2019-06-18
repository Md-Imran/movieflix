package cine.emon.live.com.cinematic.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


import com.bumptech.glide.Glide;

import java.util.ArrayList;

import cine.emon.live.com.cinematic.R;
import cine.emon.live.com.cinematic.activity.DetailActivity;
import cine.emon.live.com.cinematic.model.HorizontalModel;


public class HorizontalRecyclerViewAdapter extends
        RecyclerView.Adapter<HorizontalRecyclerViewAdapter.HorizontalViewHolder> {

    private Context mContext;
    private ArrayList<HorizontalModel> mArrayList;

    public HorizontalRecyclerViewAdapter(Context mContext,
                                         ArrayList<HorizontalModel> mArrayList) {
        this.mContext = mContext;
        this.mArrayList = mArrayList;
    }

    public int getImage(String imageName) {

        int drawableResourceId = mContext.getResources().getIdentifier(imageName, "drawable", mContext.getPackageName());

        return drawableResourceId;
    }

    @Override
    public HorizontalViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_horizontal, parent, false);
        return new HorizontalViewHolder(view);
    }

    @Override
    public void onBindViewHolder(HorizontalViewHolder holder, int position) {
        final HorizontalModel current = mArrayList.get(position);
        // holder.txtTitle.setText(current.getName());

      /*  GlideApp.with(mContext)
                .load(current.getImagePath())
                .into(holder.imageView);
*/
        Glide.with(mContext)
                .load(getImage(current.getImagePath()))
                .into(holder.imageView);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext, current.getName(), Toast.LENGTH_SHORT).show();
            }
        });


    }

    @Override
    public int getItemCount() {
        return mArrayList.size();
    }

    class HorizontalViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        // TextView txtTitle;
        private ImageView imageView;

        public HorizontalViewHolder(View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.ivThumb);
            imageView.setOnClickListener(this);
            // itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {

            Intent intent = new Intent(mContext, DetailActivity.class);
            mContext.startActivity(intent);
        }
    }
}
