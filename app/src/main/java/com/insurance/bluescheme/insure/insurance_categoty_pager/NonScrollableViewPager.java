package com.insurance.bluescheme.insure.insurance_categoty_pager;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;

/**
 * Created by tonmoybarua on 27-Mar-17.
 */

public class NonScrollableViewPager  extends ViewPager{
    public NonScrollableViewPager(Context context) {
        super(context);
    }


    public NonScrollableViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        return false;
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        return false;
    }
}
