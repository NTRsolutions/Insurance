package com.insurance.bluescheme.insure.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.RelativeLayout;

import com.insurance.bluescheme.insure.R;

/**
 * Created by tonmoybarua on 09-May-17.
 */

public class NotificationsActivity extends AppCompatActivity {
    Context mContext;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = this;
        setContentView(R.layout.notification_layout_activity);

    }

}
