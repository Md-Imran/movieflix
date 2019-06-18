package cine.emon.live.com.cinematic.activity;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.res.Configuration;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.Toast;


import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.DefaultLoadControl;
import com.google.android.exoplayer2.DefaultRenderersFactory;
import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.ExoPlayerFactory;
import com.google.android.exoplayer2.PlaybackParameters;
import com.google.android.exoplayer2.Player;
import com.google.android.exoplayer2.SimpleExoPlayer;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.source.hls.HlsMediaSource;
import com.google.android.exoplayer2.trackselection.AdaptiveTrackSelection;
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector;
import com.google.android.exoplayer2.trackselection.MappingTrackSelector;
import com.google.android.exoplayer2.trackselection.TrackSelection;
import com.google.android.exoplayer2.trackselection.TrackSelectionArray;
import com.google.android.exoplayer2.ui.PlayerView;
import com.google.android.exoplayer2.ui.TrackSelectionView;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DefaultBandwidthMeter;
import com.google.android.exoplayer2.upstream.DefaultDataSourceFactory;
import com.google.android.exoplayer2.util.Util;
import cine.emon.live.com.cinematic.R;
import cine.emon.live.com.cinematic.utils.Constant;
import cine.emon.live.com.cinematic.utils.SharedPref;



public class PlayerActivity extends AppCompatActivity
        implements View.OnClickListener, Player.EventListener {
    private PlayerView playerView;
    private SimpleExoPlayer player;
    private ProgressBar progressBar;
    private int currentWindow;
    private long playbackPosition;
    private DefaultTrackSelector trackSelector;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_SECURE,
                WindowManager.LayoutParams.FLAG_SECURE);

        initViewAndExoPlayer();
    }


    private void initViewAndExoPlayer() {


        ImageView ivPlayButton = findViewById(R.id.exo_play);
        ImageView ivPauseButton = findViewById(R.id.exo_pause);
        ImageView ivFastForwardButton = findViewById(R.id.exo_ffwd);
        ImageView ivReWindButton = findViewById(R.id.exo_rew);
        ImageView ivSetting = findViewById(R.id.exo_setting);

        playerView = findViewById(R.id.player_view);

        progressBar = findViewById(R.id.progress_bar);

        ivPlayButton.setOnClickListener(this);
        ivPauseButton.setOnClickListener(this);
        ivFastForwardButton.setOnClickListener(this);
        ivReWindButton.setOnClickListener(this);
        ivSetting.setOnClickListener(this);


        player = ExoPlayerFactory.newSimpleInstance(
                new DefaultRenderersFactory(this),
                new DefaultTrackSelector(), new DefaultLoadControl());

    }

    private void initializePlayer() {

      /*  MediaSource mediaSource = new DashMediaSource.Factory(
                new DefaultDashChunkSource.Factory(dataSourceFactory),
                dataSourceFactory)
                .createMediaSource(uri);
*/

        TrackSelection.Factory videoTrackSelectionFactory =
                new AdaptiveTrackSelection.Factory(new DefaultBandwidthMeter());

        trackSelector = new DefaultTrackSelector(videoTrackSelectionFactory);

        player = ExoPlayerFactory.newSimpleInstance(this, trackSelector);

        playerView.setPlayer(player);
        player.addListener(this);

        player.setPlayWhenReady(true);


/*        MediaSource mediaSource = new HlsMediaSource(Uri.parse("https://mnmedias.api.telequebec.tv/m3u8/29880.m3u8"),
                mediaDataSourceFactory, mainHandler, null);*/

        DataSource.Factory dataSourceFactory = new DefaultDataSourceFactory(this, Util.getUserAgent(this, getPackageName()));

        MediaSource mediaSource = new HlsMediaSource(Uri.parse(Constant.CONTENT_URL),
                dataSourceFactory, null, null);
        player.prepare(mediaSource);


        /*TODO
         * ExtraMedia source code */

        /*MediaSource mediaSource = new ExtractorMediaSource.Factory(dataSourceFactory)
                .createMediaSource(uri);*/


        final boolean haveStartPosition = currentWindow != C.INDEX_UNSET;

        if (haveStartPosition) {
            playbackPosition = SharedPref.readLong(Constant.CURRENT_POSITION);
            currentWindow = SharedPref.readInt(Constant.CURRENT_WINDOW);
            player.seekTo(currentWindow, playbackPosition);
        }
        playerView.setPlayer(player);
        player.prepare(mediaSource, !haveStartPosition, false);
        player.setPlayWhenReady(true);
    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();
        playbackPosition = player.getCurrentPosition();
        currentWindow = player.getCurrentWindowIndex();
        SharedPref.write(Constant.CURRENT_POSITION, playbackPosition);
        SharedPref.write(Constant.CURRENT_WINDOW, currentWindow);

    }

    public void fastForward() {
        player.seekTo(
                Math.min(player.getCurrentPosition() + 15000, player.getDuration())
        );
    }

    public void fastRewind() {
        player.seekTo(
                Math.min(player.getCurrentPosition() - 15000, player.getDuration())
        );
    }


    @SuppressLint("InlinedApi")
    private void hideSystemUi() {
        playerView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LOW_PROFILE
                | View.SYSTEM_UI_FLAG_FULLSCREEN
                | View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION);
    }

    private void releasePlayer() {
        if (player != null) {
            playbackPosition = player.getCurrentPosition();
            currentWindow = player.getCurrentWindowIndex();
            SharedPref.write(Constant.CURRENT_POSITION, playbackPosition);
            SharedPref.write(Constant.CURRENT_WINDOW, currentWindow);
            player.release();
            player = null;
        }
    }


    @Override
    public void onResume() {
        super.onResume();
        hideSystemUi();
        if ((Util.SDK_INT <= 23 || player == null)) {
            initializePlayer();
        }
    }


    @Override
    public void onPause() {
        super.onPause();
        if (Util.SDK_INT <= 23) {
            releasePlayer();
        }
    }


    @Override
    public void onStart() {
        super.onStart();
        if (Util.SDK_INT > 23) {
            initializePlayer();
        }
    }

    @Override
    public void onStop() {
        super.onStop();
        if (Util.SDK_INT > 23) {
            releasePlayer();
        }
    }


    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);

        // Checking the orientation of the screen
        if (newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            //First Hide other objects (listview or recyclerview), better hide them using Gone.
            RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams) playerView.getLayoutParams();
            params.width = ViewGroup.LayoutParams.MATCH_PARENT;
            params.height = ViewGroup.LayoutParams.MATCH_PARENT;
            playerView.setLayoutParams(params);
        } else if (newConfig.orientation == Configuration.ORIENTATION_PORTRAIT) {
            //unhide your objects here.
            RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams) playerView.getLayoutParams();
            params.width = ViewGroup.LayoutParams.MATCH_PARENT;
            params.height = 600;
            playerView.setLayoutParams(params);
        }
    }


    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.exo_play:
                player.setPlayWhenReady(true);
                player.getPlaybackState();
                if (player.getPlaybackState() == Player.STATE_ENDED) player.seekTo(0);

                break;
            case R.id.exo_pause:
                player.setPlayWhenReady(false);
                player.getPlaybackState();
                break;
            case R.id.exo_ffwd:
                fastForward();
                break;
            case R.id.exo_rew:
                fastRewind();
                break;

            case R.id.exo_setting:
                trackerSelector();
                break;

        }

    }


    private void trackerSelector() {
        MappingTrackSelector.MappedTrackInfo mappedTrackInfo = trackSelector.getCurrentMappedTrackInfo();
        if (mappedTrackInfo != null) {
            int rendererType = mappedTrackInfo.getRendererType(0);
            boolean allowAdaptiveSelections =
                    rendererType == C.TRACK_TYPE_VIDEO
                            || (rendererType == C.TRACK_TYPE_AUDIO
                            && mappedTrackInfo.getTypeSupport(C.TRACK_TYPE_VIDEO)
                            == MappingTrackSelector.MappedTrackInfo.RENDERER_SUPPORT_NO_TRACKS);
            Pair<AlertDialog, TrackSelectionView> dialogPair =
                    TrackSelectionView.getDialog(this, "Video Quality", trackSelector, 0);
            dialogPair.first.setInverseBackgroundForced(true);
            dialogPair.second.setShowDisableOption(true);
            dialogPair.second.setAllowAdaptiveSelections(allowAdaptiveSelections);
            dialogPair.first.show();
        }
    }


    @Override
    public void onTimelineChanged(Timeline timeline, Object manifest, int reason) {

    }

    @Override
    public void onTracksChanged(TrackGroupArray trackGroups, TrackSelectionArray trackSelections) {

    }

    @Override
    public void onLoadingChanged(boolean isLoading) {

    }

    @Override
    public void onPlayerStateChanged(boolean playWhenReady, int playbackState) {
        switch (playbackState) {

            case Player.STATE_BUFFERING:
                // status = PlaybackStatus.LOADING;
                progressBar.setVisibility(View.VISIBLE);
                break;

            case Player.STATE_ENDED:
                break;

            case Player.STATE_IDLE:
                break;

            case Player.STATE_READY:
                progressBar.setVisibility(View.GONE);
                break;

            default:
                  break;

        }

    }

    @Override
    public void onRepeatModeChanged(int repeatMode) {

    }

    @Override
    public void onShuffleModeEnabledChanged(boolean shuffleModeEnabled) {

    }

    @Override
    public void onPlayerError(ExoPlaybackException error) {
        Toast.makeText(this, "Can not play facing problem Please try again"
                , Toast.LENGTH_LONG).show();
        progressBar.setVisibility(View.GONE);

    }

    @Override
    public void onPositionDiscontinuity(int reason) {

    }

    @Override
    public void onPlaybackParametersChanged(PlaybackParameters playbackParameters) {

    }

    @Override
    public void onSeekProcessed() {

    }

}
