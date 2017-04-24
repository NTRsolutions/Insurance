package com.insurance.bluescheme.insure.login;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.SwitchCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;

import com.insurance.bluescheme.insure.activity.HomeActivity;
import com.insurance.bluescheme.insure.R;
import com.sloop.fonts.FontsManager;

/**
 * Created by tonmoybarua on 22-Mar-17.
 */

public class AlmostDoneFragment  extends Fragment{
    Context mContext;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.almost_done_layout, container, false);
        mContext = getActivity();
        FontsManager.initFormAssets(getActivity(), "fonts/demo_font.ttf");    //初始化
        FontsManager.changeFonts(getActivity());
        final SwitchCompat switchCompat2 = (SwitchCompat)view.findViewById(R.id.done_switch_id);
        switchCompat2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    startActivity(new Intent(mContext, HomeActivity.class));

                }

            }
        });
        return view;
    }



}