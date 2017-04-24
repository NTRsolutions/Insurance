package com.insurance.bluescheme.insure.insurance_feature_activity;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.Button;

import com.insurance.bluescheme.insure.R;

/**
 * Created by tonmoybarua on 28-Mar-17.
 */

public class ContactSupportActivity extends AppCompatActivity {
    private FloatingActionButton floatingcallUsButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.contact_support_layout_activity);
        Toolbar myToolbar = (Toolbar) findViewById(R.id.toolbar_in_contact_page);
        myToolbar.setTitle("Contact & Supports");
        setSupportActionBar(myToolbar);
        myToolbar.setTitleTextColor(getResources().getColor(R.color.big_text_color));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        floatingcallUsButton = (FloatingActionButton) findViewById(R.id.call_us_floating_button);
        floatingcallUsButton.setColorFilter(getResources().getColor(R.color.cardview_light_background));

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

