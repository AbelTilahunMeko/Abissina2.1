package com.example.abissina20;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

/**
 * Created by BelA on 6/28/2017.
 */

public class viewPagerAdapter extends FragmentPagerAdapter{
     ArrayList<Fragment> fragments = new ArrayList<>();
    ArrayList<String> tabTittle = new ArrayList<>();

    public void addFramgents(Fragment fragments, String tittle ){
        this.fragments.add(fragments);
        this.tabTittle.add(tittle);
    }

    public viewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {

        return fragments.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return tabTittle.get(position);
    }
}
