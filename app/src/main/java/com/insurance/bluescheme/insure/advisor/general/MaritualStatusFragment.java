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

public class MaritualStatusFragment extends AppCompatActivity implements View.OnClickListener {
   private Button singleButton, marriedButton;
    private Context mContext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = this;
        setContentView(R.layout.maritual_status_fragment_layout);
        Toolbar myToolbar = (Toolbar) findViewById(R.id.toolbar_maritual_page);
        myToolbar.setTitle("Maritual Status");
        setSupportActionBar(myToolbar);
        myToolbar.setTitleTextColor(getResources().getColor(R.color.big_text_color));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        singleButton = (Button)findViewById(R.id.single_button);
        marriedButton = (Button)findViewById(R.id.married_button);
        singleButton.setOnClickListener(this);
        marriedButton.setOnClickListener(this);
    }



    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.single_button :
                startActivity(new Intent(mContext, ChildrenFragment.class));
                break;
            case R.id.married_button :
                startActivity(new Intent(mContext, ChildrenFragment.class));
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