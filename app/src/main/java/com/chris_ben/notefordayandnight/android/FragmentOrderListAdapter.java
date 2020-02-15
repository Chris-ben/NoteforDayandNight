package com.chris_ben.notefordayandnight.android;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;


    public class FragmentOrderListAdapter extends FragmentPagerAdapter {
        private List<Fragment> list;
        private String[] titles;
        private Context context;
        public FragmentOrderListAdapter(FragmentManager mFragmentManager,
                                        List fragmentList, String[] title) {
            super(mFragmentManager);
            list = fragmentList;
            titles=title;
        }
        @Override
        public Fragment getItem(int i) {
            Fragment fragment = null;
            if (i < list.size()) {
                fragment = list.get(i);
            } else {
                fragment = list.get(0);
            }
            return fragment;
        }

        @Override
        public int getCount() {
            return list.size();
        }
        @Override
        public CharSequence getPageTitle(int position) {
            if (titles != null && titles.length > 0)
                return titles[position];
            return null;
        }
    }

