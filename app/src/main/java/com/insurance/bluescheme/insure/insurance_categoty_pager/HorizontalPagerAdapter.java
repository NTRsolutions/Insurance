package com.insurance.bluescheme.insure.insurance_categoty_pager;
import android.content.Context;
import android.content.Intent;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import com.gigamole.infinitecycleviewpager.VerticalInfiniteCycleViewPager;
import com.insurance.bluescheme.insure.R;
import com.insurance.bluescheme.insure.activity.InsuranceListTypeActivity;
import com.insurance.bluescheme.insure.model.InsureCategory;
import com.insurance.bluescheme.insure.model.PolicyCategory;

import java.util.ArrayList;
import java.util.List;

import static com.insurance.bluescheme.insure.insurance_categoty_pager.Utils.setupItem;

/**
 * Created by GIGAMOLE on 7/27/16.
 */
public class HorizontalPagerAdapter extends PagerAdapter {

   /* private final Utils.LibraryObject[] LIBRARIES = new Utils.LibraryObject[]{*/
          /*  new Utils.LibraryObject(
                    R.drawable.ic_fintech,
                    "Car Insurance",
                    "this is car insurance"
            ),
            new Utils.LibraryObject(
                    R.drawable.ic_delivery,
                    "Industry Insurance",
                    "Bank bima insurance"
            ),
            new Utils.LibraryObject(
                    R.drawable.ic_social,
                    "Mobile Insurance",
                    "Electric devices Insurances"
            ),
            new Utils.LibraryObject(
                    R.drawable.ic_ecommerce,
                    "Life Insurance",
                    "other insurances"
            ),
            new Utils.LibraryObject(
                    R.drawable.ic_wearable,
                    "Home Insurance",
                    "Home insurances"
            ),
            new Utils.LibraryObject(
                    R.drawable.ic_internet,
                    "Internet of things",
                    "this is very helpful for us"
            )
    };*/

    private Context mContext;
    private LayoutInflater mLayoutInflater;
    private boolean mIsTwoWay;
    private List<InsureCategory> insureTypeList = new ArrayList<InsureCategory>();

    public HorizontalPagerAdapter(final Context context, final boolean isTwoWay, List<InsureCategory> insureTypeList) {
        mContext = context;
        mLayoutInflater = LayoutInflater.from(context);
        mIsTwoWay = isTwoWay;
        this.insureTypeList = insureTypeList;
    }

    @Override
    public int getCount() {
        return mIsTwoWay ? 6 : insureTypeList.size();
    }

    @Override
    public int getItemPosition(final Object object) {
        return POSITION_NONE;
    }

    @Override
    public Object instantiateItem(final ViewGroup container, final int position) {
        final View view;
       /* if (mIsTwoWay) {
            view = mLayoutInflater.inflate(R.layout.two_way_item, container, false);

            final VerticalInfiniteCycleViewPager verticalInfiniteCycleViewPager =
                    (VerticalInfiniteCycleViewPager) view.findViewById(R.id.vicvp);
            verticalInfiniteCycleViewPager.setAdapter(
                    new VerticalPagerAdapter(mContext)
            );
            verticalInfiniteCycleViewPager.setCurrentItem(position);
        } */
        view = mLayoutInflater.inflate(R.layout.fragment_catery_item_layout, container, false);
        setupItem(view, insureTypeList, position, mContext);
        Button b = (Button) view.findViewById(R.id.view_policy_button);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent insuranceType = new Intent(mContext, InsuranceListTypeActivity.class);
                insuranceType.putExtra("category_name", insureTypeList.get(position).getTitle());
                insuranceType.putExtra("id",insureTypeList.get(position).getId());
                mContext.startActivity(insuranceType);
            }
        });


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
