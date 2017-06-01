package com.insurance.bluescheme.insure.activity;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.facebook.login.LoginFragment;
import com.insurance.bluescheme.insure.R;
import com.insurance.bluescheme.insure.alertfragment.AgentFragment;
import com.insurance.bluescheme.insure.appintrosfragment.MyProfileFragment;
import com.insurance.bluescheme.insure.login.BirthdaySelectFragment;
import com.insurance.bluescheme.insure.login.ChangeTappingFragment;
import com.insurance.bluescheme.insure.login.EnterNameFragment;
import com.insurance.bluescheme.insure.shop.HospitalizationFragment;
import com.insurance.bluescheme.insure.shop.ShopHomeFragment;

/**
 * Created by tonmoybarua on 16-May-17.
 */

public class DrawerActivity extends AppCompatActivity {
    private DrawerLayout drawerLayout;
    private Toolbar toolbar;
    Context mContext;
    TextView titleTv;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = this;
        setContentView(R.layout.drawer_actvity);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setTitleTextColor(Color.WHITE);
        titleTv = (TextView)toolbar.findViewById(R.id.title_tv);
        Fragment fragment;
        fragment = new ShopHomeFragment();
        FragmentManager fragmentManager =  getSupportFragmentManager();
        android.support.v4.app.FragmentTransaction fragmentTransaction;
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.r, fragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
        initNavigationDrawer();
    }
    public void initNavigationDrawer() {

        NavigationView navigationView = (NavigationView) findViewById(R.id.navigation_view);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem menuItem) {
                int id = menuItem.getItemId();
                menuItem.setCheckable(true);
                Fragment fragment;
                FragmentManager fragmentManager = getSupportFragmentManager();
                android.support.v4.app.FragmentTransaction fragmentTransaction;
                switch (id) {
                    case R.id.profile:
                        fragment = new MyProfileFragment();
                        fragmentTransaction = fragmentManager.beginTransaction();
                        fragmentTransaction.replace(R.id.r, fragment);
                        fragmentTransaction.addToBackStack(null);
                        fragmentTransaction.commit();
                        titleTv.setText("Profile");
                        drawerLayout.closeDrawers();
                        break;

                    case R.id.settings:
                        fragment = new SettingsActivity();
                        fragmentTransaction = fragmentManager.beginTransaction();
                        fragmentTransaction.replace(R.id.r, fragment);
                        fragmentTransaction.addToBackStack(null);
                        fragmentTransaction.commit();
                        titleTv.setText("SETTINGS");
                        drawerLayout.closeDrawers();
                        break;
                    case R.id.alerts:
                        fragment = new AlertsActivity();
                        fragmentTransaction = fragmentManager.beginTransaction();
                        fragmentTransaction.replace(R.id.r, fragment);
                        fragmentTransaction.addToBackStack(null);
                        fragmentTransaction.commit();
                        titleTv.setText("ALERTS");
                        drawerLayout.closeDrawers();
                        break;
                    case R.id.activity:
                        fragment = new EnterNameFragment();
                        fragmentTransaction = fragmentManager.beginTransaction();
                        fragmentTransaction.replace(R.id.r, fragment);
                        fragmentTransaction.addToBackStack(null);
                        fragmentTransaction.commit();
                        titleTv.setText("Activity");
                        drawerLayout.closeDrawers();
                        break;
                    case R.id.preffered_advisor:
                        fragment = new PrefferedAdvisorActivity();
                        fragmentTransaction = fragmentManager.beginTransaction();
                        fragmentTransaction.replace(R.id.r, fragment);
                        fragmentTransaction.addToBackStack(null);
                        fragmentTransaction.commit();
                        titleTv.setText("Preffered Advisor");
                        drawerLayout.closeDrawers();
                        break;
                    case R.id.invite_friends:
                        fragment = new HospitalizationFragment();
                        fragmentTransaction = fragmentManager.beginTransaction();
                        fragmentTransaction.replace(R.id.r, fragment);
                        fragmentTransaction.addToBackStack(null);
                        fragmentTransaction.commit();
                        titleTv.setText("Invite Friends");
                        drawerLayout.closeDrawers();
                        break;
                    case R.id.suports:
                        fragment = new HospitalizationFragment();
                        fragmentTransaction = fragmentManager.beginTransaction();
                        fragmentTransaction.replace(R.id.r, fragment);
                        fragmentTransaction.addToBackStack(null);
                        fragmentTransaction.commit();
                        titleTv.setText("Invite Friends");
                        drawerLayout.closeDrawers();
                    case R.id.term_policy:
                        fragment = new HospitalizationFragment();
                        fragmentTransaction = fragmentManager.beginTransaction();
                        fragmentTransaction.replace(R.id.r, fragment);
                        fragmentTransaction.addToBackStack(null);
                        fragmentTransaction.commit();
                        titleTv.setText("Invite Friends");
                        drawerLayout.closeDrawers();
                }
                return true;
            }
        });
        View header = navigationView.getHeaderView(10);
        /*TextView tv_email = (TextView) header.findViewById(R.id.tv_email);
        ImageView profileImage = (ImageView) header.findViewById(R.id.header_profile_image);
        *//*String imgUrl = SharedPreference.getStringValue(mContext,SharedPreference.IMAGE_URL);
        Picasso.with(mContext)
                .load(imgUrl)
                .placeholder(R.drawable.profile)
                .transform(new CircleTransform())
                .into(profileImage);*//*
        //tv_email.setText(SharedPreference.getStringValue(mContext, SharedPreference.USER_EMAIL));*/
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer);

        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.drawer_open, R.string.drawer_close) {

            @Override
            public void onDrawerClosed(View v) {
                super.onDrawerClosed(v);
            }

            @Override
            public void onDrawerOpened(View v) {
                super.onDrawerOpened(v);
            }
        };
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();
    }
    /*  private void hideItem()
      {
          NavigationView navigationView = (NavigationView) findViewById(R.id.navigation_view);
          Menu nav_Menu = navigationView.getMenu();
          nav_Menu.findItem(R.id.add_wifi).setVisible(false);
          nav_Menu.findItem(R.id.pending_wifi_list).setVisible(false);


      }*/


}
