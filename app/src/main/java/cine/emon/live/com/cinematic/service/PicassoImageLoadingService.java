package cine.emon.live.com.cinematic.service;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Point;
import android.graphics.drawable.Drawable;
import android.view.Display;
import android.view.WindowManager;
import android.widget.ImageView;

import com.squareup.picasso.NetworkPolicy;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;

import cine.emon.live.com.cinematic.R;
import ss.com.bannerslider.ImageLoadingService;

/**
 * @author S.Shahini
 * @since 4/7/18
 */

public class PicassoImageLoadingService implements ImageLoadingService {
    public Context context;

    public PicassoImageLoadingService(Context context) {
        this.context = context;
    }

    @Override
    public void loadImage(String url, ImageView imageView) {
        Picasso.with(context).load(url).into(imageView);
    }

    @Override
    public void loadImage(int resource, final ImageView imageView) {
        // Picasso.with(context).load(resource).into(imageView);

        WindowManager windowManager = (WindowManager) context
                .getSystemService(Context.WINDOW_SERVICE);

        assert windowManager != null;
        Display display = windowManager.getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        final int width = size.x;
        final int height = size.y;
        final double newHeight = height * 0.65;

        Picasso.with(context)
                .load(resource)
                .placeholder(R.drawable.slider0)
                .networkPolicy(NetworkPolicy.OFFLINE)
                .into(new Target() {

                    @Override
                    public void onBitmapLoaded(Bitmap bitmap, Picasso.LoadedFrom arg1) {
                        Bitmap bMapScaled = Bitmap.createScaledBitmap(bitmap, width, (int) newHeight, true);
                        imageView.setImageBitmap(bMapScaled);
                    }

                    @Override
                    public void onBitmapFailed(Drawable errorDrawable) {

                    }

                    @Override
                    public void onPrepareLoad(Drawable placeHolderDrawable) {
                        Bitmap icon = BitmapFactory.decodeResource(context.getResources(),
                                R.drawable.slider0);
                        imageView.setImageBitmap(icon);

                    }
                });
    }

    @Override
    public void loadImage(String url, int placeHolder, int errorDrawable, ImageView imageView) {
        Picasso.with(context).load(url).placeholder(placeHolder).error(errorDrawable).into(imageView);
    }
}
