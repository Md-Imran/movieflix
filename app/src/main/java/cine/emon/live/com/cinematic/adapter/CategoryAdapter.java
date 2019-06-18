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
import cine.emon.live.com.cinematic.model.Category;
import cine.emon.live.com.cinematic.model.Movie;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.MyViewHolder> {

    private List<Category> categoryList;
    private Context mContext;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView categoryTitle;

        public MyViewHolder(View view) {
            super(view);
            categoryTitle = (TextView) view.findViewById(R.id.tv_category_title);
        }
    }


    public CategoryAdapter(Context context, List<Category> categoryList) {
        this.mContext = context;
        this.categoryList = categoryList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_category_list, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Category category = categoryList.get(position);
        holder.categoryTitle.setText(category.getCategoryTitle());

    }

    @Override
    public int getItemCount() {
        return categoryList.size();
    }

}
