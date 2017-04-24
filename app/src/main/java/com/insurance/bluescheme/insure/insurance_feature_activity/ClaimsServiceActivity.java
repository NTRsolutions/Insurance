package com.insurance.bluescheme.insure.insurance_feature_activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.RelativeLayout;

import com.insurance.bluescheme.insure.R;
import com.insurance.bluescheme.insure.home_activity.CheckListActivity;

/**
 * Created by tonmoybarua on 28-Mar-17.
 */

public class ClaimsServiceActivity extends AppCompatActivity {
    RelativeLayout checkRelativeLayout, faqRelativeLayout;
    Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = this;
        setContentView(R.layout.claims_service_activity);
        final Toolbar myToolbar = (Toolbar) findViewById(R.id.toolbar_id_claim_page);
        myToolbar.setTitle("Claims & Services");
        setSupportActionBar(myToolbar);
        myToolbar.setTitleTextColor(getResources().getColor(R.color.big_text_color));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        checkRelativeLayout = (RelativeLayout)findViewById(R.id.check_relative_layout);
        faqRelativeLayout = (RelativeLayout)findViewById(R.id.faq_claims_relative_layout);
        checkRelativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(mContext, CheckListActivity.class));
            }
        });
        faqRelativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(mContext, FAQActivity.class));
            }
        });

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

