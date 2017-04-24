package com.insurance.bluescheme.insure.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;

import com.insurance.bluescheme.insure.R;
import com.insurance.bluescheme.insure.adapter.HomePageAdapter;
import com.insurance.bluescheme.insure.home_activity.BuyPolicyActivity;
import com.insurance.bluescheme.insure.home_activity.ClaimsActivity;
import com.insurance.bluescheme.insure.home_activity.MyPolicyActivity;
import com.insurance.bluescheme.insure.home_activity.NotificationActivity;
import com.insurance.bluescheme.insure.home_activity.PolicyRenewelActivity;
import com.insurance.bluescheme.insure.home_activity.ProfileActivity;

import static android.R.attr.columnWidth;
import static android.view.Gravity.CENTER;

/**
 * Created by tonmoybarua on 19-Mar-17.
 */

public class HomeActivity extends AppCompatActivity {
    SearchView searchView;
    Context mContext;
    private ImageView homeMenuImageView;

        GridView gridView;
        String[] item_name = {
                "Buy A Policy",
                "Policy Renewel",
                "My Policy",
                "Notifications",
                "Claims",
                "My Profile"

        } ;
        int[] image_id = {
                R.drawable.buy_policy,
                R.drawable.renewel_policy,
                R.drawable.mypolicy,
                R.drawable.notification,
                R.drawable.claims,
                R.drawable.profile_home

        };

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            mContext = this;
            setContentView(R.layout.activity_home_layout);
            HomePageAdapter adapter = new HomePageAdapter(HomeActivity.this, item_name, image_id);
            gridView=(GridView)findViewById(R.id.grid);
            gridView.setColumnWidth(columnWidth);
            gridView.setAdapter(adapter);
            gridView.setGravity(CENTER);
            gridView.setBackgroundResource(R.color.grid_layout_color);
            homeMenuImageView = (ImageView)findViewById(R.id.home_menu_button);
            homeMenuImageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    startActivity(new Intent(mContext, HomeMenuActivity.class));
                }
            });
            gridView.setOnItemClickListener(    new AdapterView.OnItemClickListener() {

                @Override
                public void onItemClick(AdapterView<?> parent, View view,
                                        int position, long id) {
                   // Toast.makeText(HomeActivity.this, "You Clicked at " +item_name[+ position], Toast.LENGTH_SHORT).show();
                    if(item_name[+position].equals("Buy A Policy")) {
                        startActivity(new Intent(HomeActivity.this, BuyPolicyActivity.class));
                    }
                    else if(item_name[+position].equals("Policy Renewel")) {
                        startActivity(new Intent(HomeActivity.this, PolicyRenewelActivity.class));

                    }
                    else if(item_name[+position].equals("My Policy")) {
                        startActivity(new Intent(HomeActivity.this, MyPolicyActivity.class));

                    }
                    else if(item_name[+position].equals("Notifications")) {
                        startActivity(new Intent(HomeActivity.this, NotificationActivity.class));

                    }
                    else if(item_name[+position].equals("Claims")) {
                        startActivity(new Intent(HomeActivity.this, ClaimsActivity.class));

                    }
                    else if(item_name[+position].equals("My Profile")) {
                        startActivity(new Intent(HomeActivity.this, ProfileActivity.class));

                    }
                    else{
                        Log.e("nothing", "found nothing in area ");
                        //Toast.makeText(HomeActivity.this, "Nothing select", Toast.LENGTH_SHORT).show();
                    }

                }
            });
           // SearchView search = (SearchView) findViewById(R.id.search_bar_home_page);
           // search.setGravity(Gravity.RIGHT);

        }

    }
