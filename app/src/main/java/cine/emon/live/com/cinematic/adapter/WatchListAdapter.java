package cine.emon.live.com.cinematic.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;


import com.bumptech.glide.Glide;

import java.util.List;

import cine.emon.live.com.cinematic.R;
import cine.emon.live.com.cinematic.activity.DetailActivity;
import cine.emon.live.com.cinematic.model.WatchItem;
import cine.emon.live.com.cinematic.utils.Glider;

public class WatchListAdapter extends RecyclerView.Adapter<WatchListAdapter.MyViewHolder> {
    private List<WatchItem> itemResponses;
    private Context context;
    private Activity activity;

    public WatchListAdapter(Context context, List<WatchItem> itemResponses) {
        this.context = context;
        this.activity = activity;
        this.itemResponses = itemResponses;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // infalte the item Layout
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_watch_list, parent, false);
        // set the view's size, margins, paddings and layout parameters
        MyViewHolder vh = new MyViewHolder(v); // pass the view to View Holder
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        // set the data in items
        WatchItem item = itemResponses.get(position);
        holder.lytMain.setTag(item);
        Glide.with(context)
                .load(getImage(item.getPortrait()))
                .into(holder.imageViewPoster);
    }

    public void clear() {
        final int size = itemResponses.size();
        if (size > 0) {
            for (int i = 0; i < size; i++) {
                itemResponses.remove(0);
            }
            notifyItemRangeRemoved(0, size);
        }
    }

    public void addItem(WatchItem watchItem) {
        if (!itemResponses.contains(watchItem)) {
            itemResponses.add(watchItem);
            notifyDataSetChanged();
        }
    }


    @Override
    public int getItemCount() {
        return itemResponses.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder
            implements View.OnClickListener {
        // init the item view's
        ImageView imageViewPoster;
        RelativeLayout lytMain;


        public MyViewHolder(View itemView) {
            super(itemView);
            // get the reference of item view's
            imageViewPoster = itemView.findViewById(R.id.iv_poster);
            lytMain = itemView.findViewById(R.id.lyt_main);
            lytMain.setOnClickListener(this);

        }

        @Override
        public void onClick(View v) {

            Intent intent = new Intent(context, DetailActivity.class);
            context.startActivity(intent);

            /*ItemResponse category = (ItemResponse) v.getTag();
            Intent intent = new Intent(context, DetailActivity.class);
            intent.putExtra(AppConstant.CATEGORY, category.getCategoryTile());
            context.startActivity(intent);*/
        }
    }

    private int getImage(String imageName) {

        return context.getResources().getIdentifier(imageName, "drawable", context.getPackageName());
    }

}
