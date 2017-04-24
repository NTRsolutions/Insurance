package com.insurance.bluescheme.insure.insurance_feature_activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.SeekBar;
import android.widget.TextView;

import com.insurance.bluescheme.insure.R;
import com.insurance.bluescheme.insure.adapter.PremiumYearTermAdapter;
import com.insurance.bluescheme.insure.model.Year;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tonmoybarua on 29-Mar-17.
 */

public class CalCulateYearTermsActivity extends AppCompatActivity {
    RadioButton mRadioButton;
    SeekBar mSeekBar;
    Button mButton;
    TextView textView;
    RecyclerView mRecyclerView;
    RecyclerView payRecyclerView;
    List<Year> yearList = new ArrayList();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calculate_premium_year_layout);
        Toolbar myToolbar = (Toolbar) findViewById(R.id.tool_bar_in_calculate_premium_year_page);
        myToolbar.setTitle("Calculate Premium");
        setSupportActionBar(myToolbar);
        myToolbar.setTitleTextColor(getResources().getColor(com.insurance.bluescheme.insure.R.color.big_text_color));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        mButton = (Button)findViewById(R.id.process_button_premium_year_layout);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(CalCulateYearTermsActivity.this, CalculatePremiumProfileActivity.class));
            }
        });
        prepareYearData();
        LinearLayoutManager layoutManager= new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL, false);
        mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view_term_list);
        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.setAdapter(new PremiumYearTermAdapter(yearList, 0, new PremiumYearTermAdapter.OnItemClickListener() {
            @Override public void onItemClick(Year item) {
                //Toast.makeText(getApplicationContext(), item.getPolicy_year(), Toast.LENGTH_LONG).show();

            }
        }));

        LinearLayoutManager lManager= new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL, false);
        payRecyclerView = (RecyclerView)findViewById(R.id.recycler_view_payment_term);
        payRecyclerView.setLayoutManager(lManager);
        payRecyclerView.setAdapter(new PremiumYearTermAdapter(yearList, 1, new PremiumYearTermAdapter.OnItemClickListener() {
            @Override public void onItemClick(Year item) {
              //  Toast.makeText(getApplicationContext(), item.getPolicy_term(), Toast.LENGTH_LONG).show();
            }
        }));


    }
    private void prepareYearData() {
        Year y1 = new Year("5 years ", " One Time");
        yearList.add(y1);
        Year y2 = new Year("10 years ", " One Time");
        yearList.add(y2);
        Year y3 = new Year("20 years ", " One Time");
        yearList.add(y3);
        Year y4 = new Year("Other Years ", "Other Terms");
        yearList.add(y4);


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

