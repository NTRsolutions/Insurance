package com.insurance.bluescheme.insure.home_activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.insurance.bluescheme.insure.R;
import com.insurance.bluescheme.insure.insurance_feature_activity.FAQActivity;

/**
 * Created by tonmoybarua on 21-Mar-17.
 */

public class ClaimsActivity extends AppCompatActivity {
    RelativeLayout checkRelativeLayout, faqRelativeLayout;
    Context mContext;
    private FloatingActionButton callFloatingActionButton;

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
        callFloatingActionButton = (FloatingActionButton)findViewById(R.id.floating_claim_service_layout);
        callFloatingActionButton.setColorFilter(getResources().getColor(R.color.cardview_light_background));

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
