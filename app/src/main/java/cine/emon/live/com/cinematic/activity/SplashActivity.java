package cine.emon.live.com.cinematic.activity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.annotation.Nullable;
import android.widget.TextView;

import com.romainpiel.shimmer.Shimmer;
import com.romainpiel.shimmer.ShimmerTextView;

import cine.emon.live.com.cinematic.R;

public class SplashActivity extends Activity {

    private ShimmerTextView shimmertvAppName;
    private Shimmer shimmer;
    private TextView tvToolbarFont;
    private Typeface font;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        initView();
    }

    @Override
    protected void onResume() {
        super.onResume();
        toggleAnimation(shimmertvAppName);
    }

    @Override
    protected void onPause() {
        super.onPause();
        shimmer.cancel();
    }

    private void initView() {
        shimmertvAppName = (ShimmerTextView) findViewById(R.id.tv_app_name);
        font = Typeface.createFromAsset(getAssets(), "fonts/28 Days Later.ttf");
        shimmertvAppName.setTypeface(font);
        shimmertvAppName.setText(getString(R.string.app_name));

        new CountDownTimer(3000, 700) {

            @Override
            public void onFinish() {
                Intent intent = new Intent(getBaseContext(), RegistrationActivity.class);
                startActivity(intent);
                finish();
            }

            @Override
            public void onTick(long millisUntilFinished) {

            }
        }.start();
    }

    private void toggleAnimation(ShimmerTextView target) {
        if (shimmer != null && shimmer.isAnimating()) {
            shimmer.cancel();
        } else {
            shimmer = new Shimmer();
            shimmer.start(target);
            shimmer.setDuration(1000)
                    .setDirection(Shimmer.ANIMATION_DIRECTION_LTR);
        }
    }
}
