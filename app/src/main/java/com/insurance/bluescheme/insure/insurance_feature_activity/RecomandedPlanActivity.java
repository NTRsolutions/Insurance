package com.insurance.bluescheme.insure.insurance_feature_activity;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.RelativeLayout;

import com.insurance.bluescheme.insure.R;
import com.insurance.bluescheme.insure.adapter.RecomandPageAdapter;
import com.insurance.bluescheme.insure.model.PolicyCategory;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tonmoybarua on 28-Mar-17.
 */

public class RecomandedPlanActivity  extends AppCompatActivity {
    private FloatingActionButton filterFloatingActionButton;
    RecyclerView recyclerView;
    Context mContext;
    List<PolicyCategory> policyList = new ArrayList<PolicyCategory>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.policy_item_category_list_activity);
        mContext = this;
        Toolbar myToolbar = (Toolbar) findViewById(R.id.some_id_if_needed);
        myToolbar.setTitle("Recommend Policy");
        setSupportActionBar(myToolbar);
        myToolbar.setTitleTextColor(getResources().getColor(R.color.big_text_color));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        // getSupportActionBar().setDisplayShowHomeEnabled(true);
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        prepareMovieData();
        RecomandPageAdapter mAdapter = new RecomandPageAdapter(mContext, policyList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);
        filterFloatingActionButton = (FloatingActionButton)findViewById(R.id.floating_recomended_item_layout_page);
        filterFloatingActionButton.setColorFilter(getResources().getColor(R.color.cardview_light_background));

    }
    private void prepareMovieData() {
        PolicyCategory policy = new PolicyCategory("Recommen insurance list 1 ", "this is dummy text1", R.mipmap.app_logo);
        policyList.add(policy);
        PolicyCategory p1 = new PolicyCategory(" Recommend Car insurance list 2", "this is dummy text1", R.mipmap.app_logo);
        policyList.add(p1);
        PolicyCategory p2 = new PolicyCategory("Recommend Car insurance list3", "this is dummy text1", R.mipmap.app_logo);
        policyList.add(p2);
        PolicyCategory p3 = new PolicyCategory("Recommend Car insurance list4", "this is dummy text1", R.mipmap.app_logo);
        policyList.add(p3);
        PolicyCategory p4 = new PolicyCategory("Recommend Car insurance list 5", "this is dummy text1", R.mipmap.app_logo);
        policyList.add(p4);
        PolicyCategory p5 = new PolicyCategory("Recommend Car insurance list 6", "this is dummy text1", R.mipmap.app_logo);
        policyList.add(p5);

    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
