package com.insurance.bluescheme.insure.home_activity;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.RelativeLayout;

import com.insurance.bluescheme.insure.R;
import com.insurance.bluescheme.insure.adapter.FaqPageAdapter;
import com.insurance.bluescheme.insure.adapter.MyPolicyItemListAdapter;
import com.insurance.bluescheme.insure.adapter.PolicyItemListAdapter;
import com.insurance.bluescheme.insure.model.PolicyCategory;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tonmoybarua on 21-Mar-17.
 */

public class MyPolicyActivity extends AppCompatActivity {
    RelativeLayout relativeLayout;
    RecyclerView recyclerView;
    Context mContext;
    List<PolicyCategory> mpList = new ArrayList<PolicyCategory>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = this;
        setContentView(R.layout.my_policy_layout_activity);
        Toolbar myToolbar = (Toolbar) findViewById(R.id.tool_bar_id_my_policy);
        myToolbar.setTitle("My Policy");
        setSupportActionBar(myToolbar);
        myToolbar.setTitleTextColor(getResources().getColor(com.insurance.bluescheme.insure.R.color.big_text_color));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        recyclerView = (RecyclerView) findViewById(R.id.my_policy_recycler_view);
        prepareData();
        MyPolicyItemListAdapter mAdapter = new MyPolicyItemListAdapter(mContext,mpList, "My Policy");
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);
    }
    private void prepareData() {
        PolicyCategory policy = new PolicyCategory("My Car Policy  ", "Action & Adventure", R.mipmap.app_logo);
        mpList.add(policy);
        PolicyCategory p1 = new PolicyCategory("My Home policy  ", "Action & Adventure", R.mipmap.app_logo);
        mpList.add(p1);
        PolicyCategory p2 = new PolicyCategory("My Home Policy ", "Action & Adventure", R.mipmap.app_logo);
        mpList.add(p2);
        PolicyCategory p3 = new PolicyCategory("My Body Policy", "Action & Adventure", R.mipmap.app_logo);
        mpList.add(p3);
        PolicyCategory p4 = new PolicyCategory("My Mobile Policy", "Action & Adventure", R.mipmap.app_logo);
        mpList.add(p4);
        PolicyCategory p5 = new PolicyCategory("Medical help assistance policy", "Action & Adventure", R.mipmap.app_logo);
        mpList.add(p5);
        PolicyCategory p6 = new PolicyCategory("My Mobile Policy", "Action & Adventure", R.mipmap.app_logo);
        mpList.add(p6);
        PolicyCategory p7 = new PolicyCategory("Medical help assistance policy", "Action & Adventure", R.mipmap.app_logo);
        mpList.add(p7);

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

