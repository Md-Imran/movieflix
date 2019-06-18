package cine.emon.live.com.cinematic.adapter;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import android.widget.ImageView;

import ss.com.bannerslider.SlideType;
import ss.com.bannerslider.adapters.SliderAdapter;
import ss.com.bannerslider.viewholder.ImageSlideViewHolder;

/**
 * @author S.Shahini
 * @since 2/12/18
 */

public class MainSliderAdapter extends SliderAdapter {

    private Context mContext;

    public MainSliderAdapter(Context context) {
        this.mContext = context;
    }

    @Override
    public int getItemCount() {
        return 5;
    }

    @Override
    public void onBindImageSlide(int position, ImageSlideViewHolder viewHolder) {

        switch (position) {
            case 0:
                viewHolder.bindImageSlide(mContext.getResources().getIdentifier("slider1", "drawable", mContext.getPackageName()));
                break;
            case 1:
                viewHolder.bindImageSlide(mContext.getResources().getIdentifier("slider2", "drawable", mContext.getPackageName()));
                break;
            case 2:
                viewHolder.bindImageSlide(mContext.getResources().getIdentifier("slider3", "drawable", mContext.getPackageName()));
                break;
            case 3:
                viewHolder.bindImageSlide(mContext.getResources().getIdentifier("slider4", "drawable", mContext.getPackageName()));
                break;
            case 4:
                viewHolder.bindImageSlide(mContext.getResources().getIdentifier("slider5", "drawable", mContext.getPackageName()));
                break;

        }
    }

}