package com.insurance.bluescheme.insure.insurance_categoty_pager;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

/**
 * Created by tonmoybarua on 27-Mar-17.
 */

public class PageAdapter  extends FragmentStatePagerAdapter {

    private final static int COUNT = 3;

    private final static int HORIZONTAL = 0;
    private final static int TWO_WAY = 1;

    public PageAdapter(final FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(final int position) {
                return new HorizontalPagerFragment();

    }

    @Override
    public int getCount() {
        return COUNT;
    }
}

