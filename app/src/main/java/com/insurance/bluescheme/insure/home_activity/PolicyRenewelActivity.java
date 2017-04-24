package com.insurance.bluescheme.insure.home_activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.insurance.bluescheme.insure.R;

/**
 * Created by tonmoybarua on 21-Mar-17.
 */

public class PolicyRenewelActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.policy_renewel_activity_layout);
        Toolbar myToolbar = (Toolbar) findViewById(R.id.policy_renewel_toolbar);
        myToolbar.setTitle("Policy Renewel Details");
        setSupportActionBar(myToolbar);
        myToolbar.setTitleTextColor(getResources().getColor(R.color.big_text_color));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
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




