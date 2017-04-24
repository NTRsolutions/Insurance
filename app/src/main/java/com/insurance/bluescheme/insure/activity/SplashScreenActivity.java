package com.insurance.bluescheme.insure.activity;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.RetryPolicy;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.insurance.bluescheme.insure.R;
import com.insurance.bluescheme.insure.adapter.PolicyItemListAdapter;
import com.insurance.bluescheme.insure.login.HelloThereActivity;
import com.insurance.bluescheme.insure.model.PolicyCategory;
import com.insurance.bluescheme.insure.utils.CheckInternet;
import com.insurance.bluescheme.insure.utils.ConstantData;
import com.insurance.bluescheme.insure.utils.SharedPreference;
import com.insurance.bluescheme.insure.utils.UserDialog;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by tonmoybarua on 19-Apr-17.
 */

public class SplashScreenActivity  extends AppCompatActivity {
    Context mContext;
    private String appIntroUrl = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = this;
        appIntroUrl = ConstantData.APP_INTRO_URL;
        /*if ((CheckInternet.isNetworkAvailable(mContext))) {
            getAppIntroDataFromServer("appintro", appIntroUrl);
        }*/
        setContentView(R.layout.spash_layout_activity);
        if(!SharedPreference.getBooleanValue(mContext, SharedPreference.SplashCheck)) {
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                        Intent i = new Intent(SplashScreenActivity.this, AppIntroActivity.class);
                        startActivity(i);
                        finish();
                }
            }, 4000);

            } else {
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    if (SharedPreference.getBooleanValue(mContext, SharedPreference.LOG_IN_STATUS)) {

                        Intent i = new Intent(SplashScreenActivity.this, HomeActivity.class);
                        startActivity(i);
                        finish();
                    } else {
                        Intent i = new Intent(SplashScreenActivity.this, HelloThereActivity.class);
                        startActivity(i);
                        finish();
                    }
                }
            }, 4000);

            }

    }

    private void getAppIntroDataFromServer(String tag, String url) {

        final ProgressDialog pDialog = new ProgressDialog(mContext);
        pDialog.setMessage("Loading! Please wait . . .");
        pDialog.show();
        RequestQueue mRequestQueue = Volley.newRequestQueue(mContext);

        final StringRequest postRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        System.out.println("response of app introdata:" + response);
                        SharedPreference.setStringValue(mContext, SharedPreference.INTRO_DATA, response);
                        pDialog.dismiss();
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                // UserDialog.showUserAlert(mContext, String.valueOf(error));

                pDialog.dismiss();
                UserDialog.showUserAlert(mContext, "Unauthorized");
            }

        });


        int socketTimeout = ConstantData.socketTimeout;//30 seconds - change to what you want
        RetryPolicy policy = new DefaultRetryPolicy(socketTimeout, DefaultRetryPolicy.DEFAULT_MAX_RETRIES, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT);
        postRequest.setRetryPolicy(policy);
        mRequestQueue.add(postRequest);
    }

}
