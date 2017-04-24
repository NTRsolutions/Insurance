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
import com.insurance.bluescheme.insure.adapter.FaqPageAdapter;
import com.insurance.bluescheme.insure.model.PolicyCategory;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tonmoybarua on 28-Mar-17.
 */

public class FAQActivity extends AppCompatActivity {
    private FloatingActionButton filterFloatingActionButton;
    RecyclerView recyclerView;
    Context mContext;
    List<PolicyCategory> faqList = new ArrayList<PolicyCategory>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = this;
        setContentView(com.insurance.bluescheme.insure.R.layout.faq_activity_layout);
        Toolbar myToolbar = (Toolbar) findViewById(com.insurance.bluescheme.insure.R.id.tool_bar_id_faq);
        myToolbar.setTitle("FAQ Info");
        setSupportActionBar(myToolbar);
        myToolbar.setTitleTextColor(getResources().getColor(com.insurance.bluescheme.insure.R.color.big_text_color));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        recyclerView = (RecyclerView) findViewById(R.id.faq_recycler_view);
        prepareData();
        FaqPageAdapter mAdapter = new FaqPageAdapter(mContext,faqList, 0);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);
        filterFloatingActionButton = (FloatingActionButton)findViewById(R.id.floating_filter_in_faq_activity);
        filterFloatingActionButton.setColorFilter(getResources().getColor(R.color.cardview_light_background));
    }
    private void prepareData() {
        PolicyCategory policy = new PolicyCategory("Dummy faq item 1  ", "Action & Adventure", R.mipmap.app_logo);
        faqList.add(policy);
        PolicyCategory p1 = new PolicyCategory("Dummy faq item 2 ", "Action & Adventure", R.mipmap.app_logo);
        faqList.add(p1);
        PolicyCategory p2 = new PolicyCategory("Dummy faq item 3", "Action & Adventure", R.mipmap.app_logo);
        faqList.add(p2);
        PolicyCategory p3 = new PolicyCategory("Dummy faq item 4", "Action & Adventure", R.mipmap.app_logo);
        faqList.add(p3);
        PolicyCategory p4 = new PolicyCategory("Dummy faq item 5", "Action & Adventure", R.mipmap.app_logo);
        faqList.add(p4);
        PolicyCategory p5 = new PolicyCategory("Dummy faq item 6", "Action & Adventure", R.mipmap.app_logo);
        faqList.add(p5);

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

