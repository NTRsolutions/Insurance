package com.insurance.bluescheme.insure.advisor;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
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
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Switch;

import com.insurance.bluescheme.insure.R;
import com.insurance.bluescheme.insure.activity.HomeActivity;
import com.insurance.bluescheme.insure.activity.HomeMenuActivity;
import com.insurance.bluescheme.insure.adapter.HomePageAdapter;
import com.insurance.bluescheme.insure.vault.WhosePolicyFragment;

import static android.R.attr.columnWidth;
import static android.view.Gravity.CENTER;

/**
 * Created by tonmoybarua on 07-May-17.
 */

public class GeneralFragment extends AppCompatActivity implements View.OnClickListener {
    private Button eButton, seButton, shButton, sButton,rButton, unButton;
    Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = this;
        setContentView(R.layout.general_fragment_layout);
        Toolbar myToolbar = (Toolbar) findViewById(R.id.toolbar_general_page);
        myToolbar.setTitle("General");
        setSupportActionBar(myToolbar);
        myToolbar.setTitleTextColor(getResources().getColor(R.color.big_text_color));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        eButton = (Button)findViewById(R.id.employed_button);
        seButton = (Button)findViewById(R.id.self_employed_button);
        shButton = (Button)findViewById(R.id.stay_at_home_button);
        sButton = (Button)findViewById(R.id.student_buttonn);
        rButton = (Button)findViewById(R.id.retire_button);
        unButton = (Button)findViewById(R.id.unemployed_button);
        eButton.setOnClickListener(this);
        seButton.setOnClickListener(this);
        shButton.setOnClickListener(this);
        sButton.setOnClickListener(this);
        rButton.setOnClickListener(this);
        unButton.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.employed_button:
                gotomaritualFragment("employed");
                break;
            case R.id.self_employed_button:
                gotomaritualFragment("self employed");
                break;
            case R.id.stay_at_home_button:
                gotomaritualFragment("stay at home");
                break;
            case R.id.student_buttonn:
                gotomaritualFragment("student");
                break;
            case R.id.retire_button:
                gotomaritualFragment("retire");
                break;
            case R.id.unemployed_button:
                gotomaritualFragment("unemployed");
                break;
        }

    }
    void gotomaritualFragment(String value) {
        startActivity(new Intent(mContext, MaritualStatusFragment.class));
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