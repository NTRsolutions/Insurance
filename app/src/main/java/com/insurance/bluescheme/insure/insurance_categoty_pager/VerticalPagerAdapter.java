package com.insurance.bluescheme.insure.insurance_categoty_pager;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.insurance.bluescheme.insure.R;

import static com.insurance.bluescheme.insure.insurance_categoty_pager.Utils.setupItem;


/**
 * Created by GIGAMOLE on 7/27/16.
 */
public class VerticalPagerAdapter extends PagerAdapter {

    private final Utils.LibraryObject[] TWO_WAY_LIBRARIES = new Utils.LibraryObject[]{
            new Utils.LibraryObject(
                    R.drawable.ic_fintech,
                    "Factory Industry",
                    "this is car insurance"
            ),
            new Utils.LibraryObject(
                    R.drawable.ic_delivery,
                    "Man Power",
                    "Bank bima insurance"
            ),
            new Utils.LibraryObject(
                    R.drawable.ic_social,
                    "Social network",
                    "Electric devices Insurances"
            ),
            new Utils.LibraryObject(
                    R.drawable.ic_ecommerce,
                    "Mobile",
                    "other insurances"
            ),
            new Utils.LibraryObject(
                    R.drawable.ic_wearable,
                    "Home",
                    "Home insurances"
            ),
            new Utils.LibraryObject(
                    R.drawable.ic_internet,
                    "Internet of things",
                    "this is very helpful for us"
            )
    };

    private LayoutInflater mLayoutInflater;

    public VerticalPagerAdapter(final Context context) {
        mLayoutInflater = LayoutInflater.from(context);
    }


    @Override
    public int getCount() {
        return TWO_WAY_LIBRARIES.length;
    }

    @Override
    public int getItemPosition(final Object object) {
        return POSITION_NONE;
    }

    @Override
    public Object instantiateItem(final ViewGroup container, final int position) {
        final View view = mLayoutInflater.inflate(R.layout.fragment_catery_item_layout, container, false);

       // setupItem(view, TWO_WAY_LIBRARIES[position]);

        container.addView(view);
        return view;
    }

    @Override
    public boolean isViewFromObject(final View view, final Object object) {
        return view.equals(object);
    }

    @Override
    public void destroyItem(final ViewGroup container, final int position, final Object object) {
        container.removeView((View) object);
    }
}
