package cine.emon.live.com.cinematic.fragment;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.Objects;

import cine.emon.live.com.cinematic.R;
import cine.emon.live.com.cinematic.activity.MyWatchListActivity;

public class MoreFragment extends Fragment implements View.OnClickListener {

    private View view;

    public MoreFragment() {
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_more, container, false);
        initToolbar();
        initView();
        return view;
    }

    private void initToolbar() {
        Toolbar mToolbar =  view.findViewById(R.id.toolbar);
        mToolbar.setTitle(" ");
        if (mToolbar != null) {
            ((AppCompatActivity) Objects.requireNonNull(getActivity())).setSupportActionBar(mToolbar);
        }

        TextView tvToolbarFont =  view.findViewById(R.id.toolbarText);
        Typeface font = Typeface.createFromAsset(getActivity().getAssets(), "fonts/28 Days Later.ttf");
        tvToolbarFont.setText(getString(R.string.app_name));
        tvToolbarFont.setTypeface(font);
    }

    private void initView() {

        LinearLayout lytMyList = view.findViewById(R.id.lytMyList);
        lytMyList.setOnClickListener(this);
        TextView tvSignOut = view.findViewById(R.id.tv_sign_out);
        tvSignOut.setOnClickListener(this);
        TextView tvPrivacyPolicy = view.findViewById(R.id.tv_privacy_policy);
        tvPrivacyPolicy.setOnClickListener(this);
        TextView tvHelp = view.findViewById(R.id.tv_help);
        tvHelp.setOnClickListener(this);
        TextView tvAboutUs = view.findViewById(R.id.tv_about_us);
        tvAboutUs.setOnClickListener(this);

    }

    private void openDialog() {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(Objects.requireNonNull(getActivity()));
        alertDialogBuilder.setMessage("Sign out from this account?");
        alertDialogBuilder.setPositiveButton("SIGN OUT",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface arg0, int arg1) {

                    }
                });

        alertDialogBuilder.setNegativeButton("CANCEL",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface arg0, int arg1) {

                    }
                });

        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.tv_sign_out:
                openDialog();
                break;

            case R.id.lytMyList:
                startActivity(new Intent(getActivity(), MyWatchListActivity.class));
                break;
        }

    }
}
