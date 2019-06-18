package cine.emon.live.com.cinematic.utils;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import cine.emon.live.com.cinematic.R;


public class Glider {
    static Context thisContext;

    public static void init(Context context) {
        thisContext = context;
    }

   /* public static void circleShow(String location, ImageView imageView) {
        try {
            if (location != null && !location.isEmpty() && imageView != null && thisContext != null) {
                Glide.with(thisContext)
                        .load(location).
                        apply(RequestOptions.circleCropTransform())
                        .into(imageView);
            }
        } catch (Exception e) {
        }
    }*/

    public static void showCircular(ImageView imageView, Object location) {
        if (location != null && imageView != null && thisContext != null) {

            Glide.with(thisContext)
                    .load(location)
                    .into(imageView);
        }
    }

    public static void showWithPlaceholder(ImageView imageView, String location) {
        if (location != null && imageView != null && thisContext != null) {
            Glide.with(thisContext)
                    .load(location)
                    .into(imageView);

        }
    }

   /* public static void loadUserAvatar(String path, ImageView imageView) {
        if (imageView == null) return;
        Glide.with(thisContext.getApplicationContext())
                .load(path)   //passing your url to load image.
                .override(18, 18)  //just set override like this
                .error(R.drawable.photo_male_8)
                .centerCrop()
                .into(imageView);
    }*/

    public static void loadImage(ImageView imageView, String location) {

        Glide.with(thisContext)
                .load(location)
                .into(imageView);
    }

    public static void loadBannerImage(ImageView imageView, String location) {

        Glide.with(thisContext)
                .load(location)
                .into(imageView);
    }

    public static void loadTopContentImage(ImageView imageView, String location) {

        Glide.with(thisContext)
                .load(location)
                .into(imageView);
    }
}
