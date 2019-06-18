package cine.emon.live.com.cinematic.adapter;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;



import java.util.ArrayList;

import cine.emon.live.com.cinematic.R;
import cine.emon.live.com.cinematic.model.HorizontalModel;
import cine.emon.live.com.cinematic.model.VerticalModel;



public class VerticalRecyclerViewAdapter extends
        RecyclerView.Adapter<VerticalRecyclerViewAdapter.VerticalRecyclerViewHolder> {

    private Context mContext;
    private ArrayList<VerticalModel> mArrayList = new ArrayList<>();

    public VerticalRecyclerViewAdapter(Context mContext, ArrayList<VerticalModel> mArrayList) {
        this.mContext = mContext;
        this.mArrayList = mArrayList;
    }

    @Override
    public VerticalRecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_vertical, parent, false);
        return new VerticalRecyclerViewHolder(view);
    }

    public void setList(ArrayList<VerticalModel> mArrayList){
        this.mArrayList.addAll(mArrayList);
        notifyDataSetChanged();
    }

    @Override
    public void onBindViewHolder(VerticalRecyclerViewHolder holder, int position) {

        final VerticalModel current = mArrayList.get(position);

        final String strTitle = current.getTitle();

        ArrayList<HorizontalModel> singleSectionItems = current.getArrayList();

        holder.tvTitle.setText(strTitle);

        HorizontalRecyclerViewAdapter itemListDataAdapter =
                new HorizontalRecyclerViewAdapter(mContext, singleSectionItems);

        holder.rvHorizontal.setHasFixedSize(true);
        holder.rvHorizontal.setLayoutManager(new LinearLayoutManager(mContext,
                LinearLayoutManager.HORIZONTAL, false));
        holder.rvHorizontal.setAdapter(itemListDataAdapter);

        holder.rvHorizontal.setNestedScrollingEnabled(false);
    }

    @Override
    public int getItemCount() {
        return mArrayList.size();
    }

    class VerticalRecyclerViewHolder extends RecyclerView.ViewHolder {

        TextView tvTitle;
        RecyclerView rvHorizontal;

        public VerticalRecyclerViewHolder(View itemView) {
            super(itemView);
            tvTitle = itemView.findViewById(R.id.tvTitle);
            rvHorizontal = itemView.findViewById(R.id.rvHorizontal);

        }
    }
}
