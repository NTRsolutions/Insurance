package com.insurance.bluescheme.insure.advisor;

import android.content.Context;
import android.content.Intent;
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

public class ChildrenFragment extends AppCompatActivity implements View.OnClickListener {
    private Button yesButton, noButton;
    private Context mContext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = this;
        setContentView(R.layout.children_fragment_layout);
        Toolbar myToolbar = (Toolbar) findViewById(R.id.toolbar_children_page);
        myToolbar.setTitle("Children");
        setSupportActionBar(myToolbar);
        myToolbar.setTitleTextColor(getResources().getColor(R.color.big_text_color));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        yesButton = (Button)findViewById(R.id.yes_children_button);
        noButton = (Button)findViewById(R.id.no_children_button);
        yesButton.setOnClickListener(this);
        noButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.yes_children_button :
                startActivity(new Intent(mContext, HowManyChildrenFragment.class));
                break;
            case R.id.no_children_button :
                break;
        }
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