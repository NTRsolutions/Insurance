package com.insurance.bluescheme.insure.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SwitchCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CompoundButton;

import com.insurance.bluescheme.insure.R;
import com.insurance.bluescheme.insure.adapter.AlertAdapter;
import com.insurance.bluescheme.insure.login.GetSmarterFragment;
import com.insurance.bluescheme.insure.model.PolicyCategory;
import com.sloop.fonts.FontsManager;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tonmoybarua on 10-May-17.
 */

public class AlertsActivity extends Fragment {
    RecyclerView recyclerView;
    Context mContext;
    List<PolicyCategory> policyList = new ArrayList<PolicyCategory>();
    String title, id;
    String apiUrl = "";
    AlertAdapter mAdapter;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.alerts_layout_activity, container, false);

        mContext = getActivity();
        recyclerView = (RecyclerView) view.findViewById(R.id.alert_recycler_view);
        prepareMovieData();
        mAdapter = new AlertAdapter(mContext, policyList, 0);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);
        return view;
    }

    private void prepareMovieData() {
        PolicyCategory policy = new PolicyCategory("New Feature found ", "22-04-2017 sunday 2:00 PM", R.mipmap.app_logo);
        policyList.add(policy);
        PolicyCategory p1 = new PolicyCategory("New Feature found ", "22-04-2017 sunday 2:00 PM", R.mipmap.app_logo);
        policyList.add(p1);
        PolicyCategory p2 = new PolicyCategory("New Feature found ", "22-04-2017 sunday 2:00 PM", R.mipmap.app_logo);
        policyList.add(p2);
        PolicyCategory p3 = new PolicyCategory("New Feature found ", "22-04-2017 sunday 2:00 PM", R.mipmap.app_logo);
        policyList.add(p3);
        PolicyCategory p4 = new PolicyCategory("New Feature found ", "22-04-2017 sunday 2:00 PM", R.mipmap.app_logo);
        policyList.add(p4);
        PolicyCategory p5 = new PolicyCategory("New Feature found ", "22-04-2017 sunday 2:00 PM", R.mipmap.app_logo);
        policyList.add(p5);

    }

}

