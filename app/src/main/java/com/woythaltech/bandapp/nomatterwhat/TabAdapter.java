package com.woythaltech.bandapp.nomatterwhat;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class TabAdapter extends FragmentPagerAdapter {

    private MusicFragment musicFragment;
    private PicturesFragment picturesFragment;
    private VideosFragment videosFragment;
    private ShowsFragment showsFragment;
    private MerchFragment merchFragment;
    private VIPFragment vipFragment;


    TabAdapter (FragmentManager fm) {
        super(fm, FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
    }


    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                if (musicFragment == null) {
                    musicFragment = MusicFragment.newInstance();
                }
                return musicFragment;
            case 1:
                if (picturesFragment == null) {
                    picturesFragment = PicturesFragment.newInstance();
                }
                return picturesFragment;
            case 2:
                if (videosFragment == null) {
                    videosFragment = VideosFragment.newInstance();
                }
                return videosFragment;
            case 3:
                if (showsFragment == null) {
                    showsFragment = ShowsFragment.newInstance();
                }
                return showsFragment;
            case 4:
                if (merchFragment == null) {
                    merchFragment = MerchFragment.newInstance();
                }
                return merchFragment;
            case 5:
            default:
                if (vipFragment == null) {
                    vipFragment = VIPFragment.newInstance();
                }
                return vipFragment;
        }
    }

    @NonNull
    @Override
    public int getCount() {
        return 6;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {

        switch (position) {
            case 0:
                return "Music";
            case 1:
                return "Pics";
            case 2:
                return "Videos";
            case 3:
                return "Shows";
            case 4:
                return "Merch";
            case 5:
                return "VIP";
            default:
                return "";
        }
    }
}
