package cine.emon.live.com.cinematic.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import cine.emon.live.com.cinematic.fragment.SimilarFragment;
import cine.emon.live.com.cinematic.fragment.TrailerFragment;

public class ViewPagerAdapter extends FragmentPagerAdapter {

    private Context mContext;

    public ViewPagerAdapter(Context context, FragmentManager fm) {
        super(fm);
        mContext = context;
    }

    // This determines the fragment for each tab
    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            return new SimilarFragment();
        } else {
            return new TrailerFragment();
        }
    }

    // This determines the number of tabs
    @Override
    public int getCount() {
        return 2;
    }

    // This determines the title for each tab
    @Override
    public CharSequence getPageTitle(int position) {
        // Generate title based on item position
        switch (position) {
            case 0:
                return "MORE LIKE THIS";
            case 1:
                return "MOVIE TRAILER";
            default:
                return null;
        }
    }

}