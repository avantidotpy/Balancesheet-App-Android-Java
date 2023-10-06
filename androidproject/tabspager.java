package com.example.gayatri.androidproject;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.view.View;

public class tabspager extends FragmentStatePagerAdapter {

    String[] titles=new String[]{"DashBoard","Filter","Statement"};
    Integer tabnumber=3;
    public tabspager(FragmentManager fm) {
        super(fm);
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return titles[position];
    }

    @Override
    public Fragment getItem(int position) {

        switch (position)
        {
            case 0:
                DashBoard dashBoard=new DashBoard();
                return dashBoard;
            case 1:
                Filter filter=new Filter();
                return filter;
            case 2:
                Statement statement=new Statement();
                return statement;
        }
        return null;
    }

    @Override
    public int getCount() {
        return tabnumber;
    }
}
