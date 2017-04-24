package com.insurance.bluescheme.insure.insurance_feature_activity;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.insurance.bluescheme.insure.R;

/**
 * Created by tonmoybarua on 28-Mar-17.
 */

public class FaqDetailsActivity extends AppCompatActivity {
    private FloatingActionButton callFloatingActionButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.faq_details_layout_activity);
        Toolbar myToolbar = (Toolbar) findViewById(R.id.toolbar_id_faq_details_page);
        myToolbar.setTitle("FAQ Details");
        setSupportActionBar(myToolbar);
        myToolbar.setTitleTextColor(getResources().getColor(R.color.big_text_color));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        callFloatingActionButton = (FloatingActionButton)findViewById(R.id.floating_button_in_faq_details_page);
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

