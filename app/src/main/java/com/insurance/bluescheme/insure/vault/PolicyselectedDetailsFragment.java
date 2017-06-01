package com.insurance.bluescheme.insure.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.insurance.bluescheme.insure.R;
import com.insurance.bluescheme.insure.adapter.PolicyItemListAdapter;
import com.insurance.bluescheme.insure.model.PolicyCategory;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tonmoybarua on 04-May-17.
 */

public class PolicyselectedDetailsFragment extends Fragment {
    RecyclerView recyclerView;
    Context mContext;
    List<PolicyCategory> policyList = new ArrayList<PolicyCategory>();
    String title, id;
    String apiUrl ="";
    PolicyItemListAdapter mAdapter;
    private FloatingActionButton filterButton;



    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mContext = getActivity();
        View view = inflater.inflate(R.layout.policy_item_selected_details_fragment, container, false);
        // getSupportActionBar().setDisplayShowHomeEnabled(true);
        recyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);
         prepareMovieData();

        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(mContext);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());;
        mAdapter = new PolicyItemListAdapter(mContext, policyList, title);
        recyclerView.setAdapter(mAdapter);
        recyclerView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
             /*   Fragment fr = new PolicyDetailsFragment();
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragment_container_landing_page, fr);
                fragmentTransaction.commit();*/



            }
        });
        return view;
    }
    private void prepareMovieData() {
        PolicyCategory policy = new PolicyCategory(" list 1 ", "$360/Annum", R.drawable.profile_img);
        policyList.add(policy);
        PolicyCategory p1 = new PolicyCategory("list 2", "$240/Anum",  R.drawable.profile_img);
        policyList.add(p1);
        PolicyCategory p2 = new PolicyCategory("list 3", "$540/Anum",  R.drawable.profile_img);
        policyList.add(p2);
        PolicyCategory p3 = new PolicyCategory(" list 4", "#460/Anum",  R.drawable.profile_img);
        policyList.add(p3);

    }
}
