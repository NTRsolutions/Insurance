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
import com.insurance.bluescheme.insure.adapter.NotificationAdapter;
import com.insurance.bluescheme.insure.model.PolicyCategory;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tonmoybarua on 21-Mar-17.
 */

public class NotificationActivity  extends AppCompatActivity {
    RelativeLayout relativeLayout;
    RecyclerView recyclerView;
    Context mContext;
    List<PolicyCategory> notificationList = new ArrayList<PolicyCategory>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = this;
        setContentView(R.layout.notification_layout_activity);
        Toolbar myToolbar = (Toolbar) findViewById(R.id.tool_bar_id_notification);
        myToolbar.setTitle("Notification");
        setSupportActionBar(myToolbar);
        myToolbar.setTitleTextColor(getResources().getColor(com.insurance.bluescheme.insure.R.color.big_text_color));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        recyclerView = (RecyclerView) findViewById(R.id.notification_recycler_view);
        prepareData();
       NotificationAdapter mAdapter = new NotificationAdapter(mContext,notificationList, 1);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);
    }
    private void prepareData() {
        PolicyCategory policy = new PolicyCategory("Notification 1  ", "Action & Adventure", R.mipmap.app_logo);
        notificationList.add(policy);
        PolicyCategory p1 = new PolicyCategory("Notification 2 ", "Action & Adventure", R.mipmap.app_logo);
        notificationList.add(p1);
        PolicyCategory p2 = new PolicyCategory("Notification 3", "Action & Adventure", R.mipmap.app_logo);
        notificationList.add(p2);
        PolicyCategory p3 = new PolicyCategory("Notification 4", "Action & Adventure", R.mipmap.app_logo);
        notificationList.add(p3);
        PolicyCategory p4 = new PolicyCategory("Notification 5", "Action & Adventure", R.mipmap.app_logo);
        notificationList.add(p4);
        PolicyCategory p5 = new PolicyCategory("Notification  6", "Action & Adventure", R.mipmap.app_logo);
        notificationList.add(p5);

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

