package com.insurance.bluescheme.insure.advisor;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.insurance.bluescheme.insure.R;

/**
 * Created by tonmoybarua on 07-May-17.
 */

public class HowManyChildrenFragment extends AppCompatActivity implements View.OnClickListener {
    private Button oneButton, twoButton, threeButton, fourButton, fivePlusButton, finishButton;
    private String value;

    private Context mContext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = this;
        setContentView(R.layout.how_many_children_fragment);
        Toolbar myToolbar = (Toolbar) findViewById(R.id.toolbar_how_many_children_page);
        myToolbar.setTitle("How many children");
        setSupportActionBar(myToolbar);
        myToolbar.setTitleTextColor(getResources().getColor(R.color.big_text_color));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        oneButton = (Button) findViewById(R.id.one_button);
        twoButton = (Button) findViewById(R.id.two_button);
        threeButton = (Button) findViewById(R.id.three_button);
        fourButton = (Button) findViewById(R.id.four_button);
        fivePlusButton = (Button) findViewById(R.id.five_plus_button);
        finishButton = (Button) findViewById(R.id.finish_button);
        oneButton.setOnClickListener(this);
        twoButton.setOnClickListener(this);
        threeButton.setOnClickListener(this);
        fourButton.setOnClickListener(this);
        fivePlusButton.setOnClickListener(this);
        finishButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.one_button:
                gotomaritualFragment("one");
                break;
            case R.id.two_button:
                gotomaritualFragment("two");
                break;
            case R.id.three_button:
                gotomaritualFragment("three");
                break;
            case R.id.four_button:
                gotomaritualFragment("four");
                break;
            case R.id.five_plus_button:
                gotomaritualFragment("five");
                break;
            case R.id.finish_button :
                if(value!=null){
                  finish();
                } else {
                    finish();
                }

        }

    }

    void gotomaritualFragment(String achieve_value) {
        value = achieve_value;

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