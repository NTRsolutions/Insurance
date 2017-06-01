package com.insurance.bluescheme.insure.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.insurance.bluescheme.insure.R;
import com.insurance.bluescheme.insure.adapter.AlertAdapter;

/**
 * Created by tonmoybarua on 12-Apr-17.
 */

public class SettingsActivity extends Fragment {
    private RelativeLayout passLayout, notifiLayout;
    Context mContext;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.settings_layout, container, false);

        mContext = getActivity();
        passLayout = (RelativeLayout)view.findViewById(R.id.password_layout);
        notifiLayout = (RelativeLayout)view.findViewById(R.id.notifi_layout);
        passLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(mContext, ChangePasswordActivity.class));

            }
        });
        notifiLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(mContext, NotificationsActivity.class));
            }
        });
        return view;
    }
}
