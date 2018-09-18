package com.example.dell.movies.Utils;

import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.View;
import android.view.ViewGroup;

import com.example.dell.movies.View.InTheater;
import com.example.dell.movies.View.Popular;
import com.example.dell.movies.View.TopRated;
import com.example.dell.movies.View.UpComing;

public class SectionsPagerAdapter extends FragmentPagerAdapter {
    public SectionsPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                InTheater inTheater = new InTheater();
                return inTheater;
            case 1:
                UpComing upComing = new UpComing();
                return upComing;
            case 2:
                Popular popular = new Popular();
                return popular;
            case 3:
                TopRated topRated = new TopRated();
                return topRated;
            default:
                return null;
        }
    }


    @Override
    public int getCount() {
        return 4;
    }
}
