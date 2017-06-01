package com.insurance.bluescheme.insure.activity.drawer_item;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.insurance.bluescheme.insure.R;
import com.insurance.bluescheme.insure.adapter.FaqPageAdapter;
import com.insurance.bluescheme.insure.adapter.PrefferedAdvisorAdapter;
import com.insurance.bluescheme.insure.model.PolicyCategory;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tonmoybarua on 09-May-17.
 */

public class PrefferedAdvisorActivity extends AppCompatActivity {
    private FloatingActionButton filterFloatingActionButton;
    RecyclerView recyclerView;
    Context mContext;
    List<PolicyCategory> faqList = new ArrayList<PolicyCategory>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = this;
        setContentView(R.layout.prefered_advisor_list_activity);
        Toolbar myToolbar = (Toolbar) findViewById(R.id.toolbar_advisor_preffer_page);
        myToolbar.setTitle("Preffer Advisor");
        setSupportActionBar(myToolbar);
        myToolbar.setTitleTextColor(getResources().getColor(R.color.big_text_color));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        recyclerView = (RecyclerView)findViewById(R.id.faq_recycler_view);
        prepareData();
        PrefferedAdvisorAdapter mAdapter = new PrefferedAdvisorAdapter(mContext,faqList, "mypolicy");
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);

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



    private void prepareData() {
        PolicyCategory policy = new PolicyCategory("Dummy faq   ", "bonani dhaka", R.mipmap.app_logo);
        faqList.add(policy);
        PolicyCategory p1 = new PolicyCategory("Dummy faq  ", "bonani dhaka", R.mipmap.app_logo);
        faqList.add(p1);
        PolicyCategory p2 = new PolicyCategory("Dummy faq ", "bonani dhakae", R.mipmap.app_logo);
        faqList.add(p2);

    }


}


