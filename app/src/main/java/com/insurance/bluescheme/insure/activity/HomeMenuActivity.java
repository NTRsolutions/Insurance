package com.insurance.bluescheme.insure.activity;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.RetryPolicy;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.insurance.bluescheme.insure.R;
import com.insurance.bluescheme.insure.adapter.MenuAdapter;
import com.insurance.bluescheme.insure.adapter.PolicyItemListAdapter;
import com.insurance.bluescheme.insure.insurance_feature_activity.CalculatePremiumProfileActivity;
import com.insurance.bluescheme.insure.login.HelloThereActivity;
import com.insurance.bluescheme.insure.model.DrawerMenu;
import com.insurance.bluescheme.insure.model.PolicyCategory;
import com.insurance.bluescheme.insure.utils.ConstantData;
import com.insurance.bluescheme.insure.utils.SharedPreference;
import com.insurance.bluescheme.insure.utils.UserDialog;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by tonmoybarua on 11-Apr-17.
 */

public class HomeMenuActivity extends AppCompatActivity {
    RelativeLayout relativeLayout;
    RecyclerView recyclerView;
    Context mContext;
    ImageView dropDownImage;
    Button logoutButton, editProfileButton;
    TextView updateMobileNumberTxv, changePasswordTxv, notificationSettingTxv;
    List<DrawerMenu> menuList = new ArrayList<DrawerMenu>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_menu_layout_in_home_page);
        mContext = this;
       // Toolbar myToolbar = (Toolbar) findViewById(R.id.some_id_if_needed);
        //myToolbar.setTitle("Menu");

        //setSupportActionBar(myToolbar);
       // myToolbar.setTitleTextColor(getResources().getColor(R.color.big_text_color));
       // getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        // getSupportActionBar().setDisplayShowHomeEnabled(true);
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view_menu_page);
        dropDownImage = (ImageView)findViewById(R.id.drop_down_menu_image) ;
        logoutButton = (Button)findViewById(R.id.logout_button_in_menu_page);
        updateMobileNumberTxv = (TextView)findViewById(R.id.change_mobile_number_in_menu);
        changePasswordTxv = (TextView)findViewById(R.id.change_password_in_menu);
        notificationSettingTxv = (TextView)findViewById(R.id.notification_settings_in_menu);
        editProfileButton = (Button)findViewById(R.id.edit_profile_button_menu_page);
        prepareMovieData();
        MenuAdapter mAdapter = new MenuAdapter(mContext, menuList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);
        dropDownImage.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               finish();
           }
       });
        logoutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goLogout();
            }
        });
        changePasswordTxv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(mContext, ChangePasswordActivity.class));
            }
        });
        updateMobileNumberTxv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(mContext, ChangeMobileNumberActivity.class));

            }
        });
        notificationSettingTxv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(mContext, NotificationSettingsActivity.class));
            }
        });
        editProfileButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(mContext, UpdateProfileActivity.class));
            }
        });


    }
    private void goLogout() {

        AlertDialog dialog = new AlertDialog.Builder(mContext)
                .setTitle("Log out")
                .setMessage("Are you sure to logout")
                .setPositiveButton("Yes",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog,
                                                int which) {
                                // continue with delete

                                logoutApi("logout", ConstantData.LOGOUT_API_URL+SharedPreference.getStringValue(mContext,SharedPreference.API_TOKEN));


                            }
                        })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        // do nothing
                    }
                }).show();

    }
    private void prepareMovieData() {

        DrawerMenu p1 = new DrawerMenu("Buy A Policy", R.drawable.buy_policy);
        menuList.add(p1);
        DrawerMenu p2= new DrawerMenu("Policy Renewel", R.drawable.renewel_policy);
        menuList.add(p2);
        DrawerMenu p3 = new DrawerMenu("My Policy", R.drawable.mypolicy);
        menuList.add(p3);
        DrawerMenu p4 = new DrawerMenu("Notifications", R.drawable.notification);
        menuList.add(p4);
        DrawerMenu p5 = new DrawerMenu("Claims ", R.drawable.claims);
        menuList.add(p5);
        DrawerMenu p6 = new DrawerMenu("My Profile", R.drawable.profile_home);
        menuList.add(p6);

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
    private void logoutApi(String tag, String url) {

        final ProgressDialog pDialog = new ProgressDialog(mContext);
        pDialog.setMessage("Loading! Please wait . . .");
        pDialog.show();
        RequestQueue mRequestQueue = Volley.newRequestQueue(mContext);

        final StringRequest postRequest = new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        System.out.println("response of logout api is:" + response);


                        try {
                            JSONObject jObj= new JSONObject(response);
                            JSONObject json = jObj.getJSONObject("data");

                            if (json.has("code")) {
                                String code = json.getString("code");
                                System.out.println("code : " + code);
                                String message = json.getString("message");
                                System.out.println("message : " + message);
                                if (code.equalsIgnoreCase("200")) {
                                    SharedPreference.setBooleanValue(mContext, SharedPreference.LOG_IN_STATUS, false);
                                    SharedPreference.setBooleanValue(mContext, SharedPreference.SplashCheck, false);
                                    startActivity(new Intent(mContext, HelloThereActivity.class));
                                    finish();

                                }
                            }
                        } catch (JSONException e) {
                            // TODO Auto-generated catch block
                            e.printStackTrace();
                        }

                        pDialog.dismiss();
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                // UserDialog.showUserAlert(mContext, String.valueOf(error));

                pDialog.dismiss();
                UserDialog.showUserAlert(mContext, "Unauthorized");
            }

        })

        {
            @Override
            protected Map<String, String> getParams() {
                Map<String, String> params = new HashMap<>();

                // params.put("first_name", signUpData.getFirst_name());
                //  params.put("last_name", signUpData.getLast_name());
                // params.put("user_type", userType);
                Log.e("token", SharedPreference.getStringValue(mContext, SharedPreference.API_TOKEN));
                params.put("api_token", SharedPreference.getStringValue(mContext, SharedPreference.API_TOKEN));
                // params.put("os", ConstantData.OS);
                //params.put("photo", image);
                return params;
            }
        };

        int socketTimeout = ConstantData.socketTimeout;//30 seconds - change to what you want
        RetryPolicy policy = new DefaultRetryPolicy(socketTimeout, DefaultRetryPolicy.DEFAULT_MAX_RETRIES, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT);
        postRequest.setRetryPolicy(policy);
        mRequestQueue.add(postRequest);
    }
    private void getAppintroData()
    {

    }


}
