package com.insurance.bluescheme.insure.login;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;

import com.insurance.bluescheme.insure.R;
import com.insurance.bluescheme.insure.utils.ConstantData;
import com.insurance.bluescheme.insure.utils.SharedPreference;
import com.sloop.fonts.FontsManager;

/**
 * Created by tonmoybarua on 21-Mar-17.
 */

public class HelloThereActivity extends AppCompatActivity {
    Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        mContext = this;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hello_there_screen_asking_page);
        Fragment fr = new HelloThereFragment();
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.hello_there_fragment_container, fr);
        fragmentTransaction.commit();
     /*   FontsManager.initFormAssets(this, "fonts/demo_font.ttf");	//初始化
        FontsManager.changeFonts(this);*/
        FontsManager.initFormAssets(this, "fonts/April Flowers - TTF.ttf");		//initialization
        FontsManager.changeFonts(this);




    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        AlertDialog dialog = new AlertDialog.Builder(mContext)
                .setTitle("EXIT")
                .setMessage("Do U want to Exit")
                .setPositiveButton("Yes",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog,
                                                int which) {
                                // continue with delete
                                finish();

                            }
                        })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        // do nothing
                    }
                }).show();

    }
}

