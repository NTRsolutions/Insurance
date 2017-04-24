package com.insurance.bluescheme.insure.home_activity;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.insurance.bluescheme.insure.R;
import com.insurance.bluescheme.insure.insurance_categoty_pager.PageAdapter;

/**
 * Created by tonmoybarua on 21-Mar-17.
 */

public class BuyPolicyActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.insurance_category_activity);
        Toolbar myToolbar = (Toolbar) findViewById(R.id.buy_page_toolbar);
        myToolbar.setTitle("Buy Policy");
        setSupportActionBar(myToolbar);
        myToolbar.setTitleTextColor(getResources().getColor(R.color.big_text_color));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        final ViewPager viewPager = (ViewPager) findViewById(R.id.vp_main);
        viewPager.setAdapter(new PageAdapter(getSupportFragmentManager()));
        viewPager.setOffscreenPageLimit(2);

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
