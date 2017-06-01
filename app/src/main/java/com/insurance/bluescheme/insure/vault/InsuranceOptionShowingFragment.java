package com.insurance.bluescheme.insure.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;

import com.insurance.bluescheme.insure.R;
import com.insurance.bluescheme.insure.activity.HomeActivity;
import com.insurance.bluescheme.insure.adapter.HomePageAdapter;
import com.insurance.bluescheme.insure.adapter.InsuranceOptionListAdapter;
import com.insurance.bluescheme.insure.home_activity.BuyPolicyActivity;
import com.insurance.bluescheme.insure.home_activity.ClaimsActivity;
import com.insurance.bluescheme.insure.home_activity.MyPolicyActivity;
import com.insurance.bluescheme.insure.home_activity.NotificationActivity;
import com.insurance.bluescheme.insure.home_activity.PolicyRenewelActivity;
import com.insurance.bluescheme.insure.home_activity.ProfileActivity;

import static android.R.attr.columnWidth;
import static android.view.Gravity.CENTER;

/**
 * Created by tonmoybarua on 04-May-17.
 */

public class InsuranceOptionShowingFragment extends Fragment {
    InsuranceOptionListAdapter insuranceOptionListAdapter;
   GridView gridView;
    Context mContext;
    String[] item_name = {
            "Hospitalization",
            "Term Life",
            "Whole Life",
            "Personal Accident",
            "Auto",
            "Home",
            "Travel",
            "Others"

    } ;
    String selected_item;


    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.insurance_showing_option_fragment_layout, container, false);
        mContext = getActivity();
        insuranceOptionListAdapter = new InsuranceOptionListAdapter(mContext, item_name);
        gridView=(GridView)view.findViewById(R.id.grid_insurance_option);
        gridView.setColumnWidth(columnWidth);
        gridView.setAdapter(insuranceOptionListAdapter);
        gridView.setGravity(CENTER);
        gridView.setBackgroundResource(R.color.grid_layout_color);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                selected_item = item_name[+position];
                Fragment fr = new PolicyselectedDetailsFragment();
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragment_container_landing_page, fr);
                fragmentTransaction.commit();


            }
        });
        return view;
    }

}