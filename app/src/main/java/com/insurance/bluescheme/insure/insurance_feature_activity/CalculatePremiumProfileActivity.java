package com.insurance.bluescheme.insure.insurance_feature_activity;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.SeekBar;
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
import com.insurance.bluescheme.insure.login.HelloThereActivity;
import com.insurance.bluescheme.insure.model.ProfileData;
import com.insurance.bluescheme.insure.utils.ConstantData;
import com.insurance.bluescheme.insure.utils.SharedPreference;
import com.insurance.bluescheme.insure.utils.UserDialog;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by tonmoybarua on 29-Mar-17.
 */

public class CalculatePremiumProfileActivity extends AppCompatActivity {
    RadioButton mRadioButton;
    SeekBar mSeekBar;
    Button mButton;
    TextView textView;
    Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = this;
        setContentView(R.layout.calculate_premium_personal_detail_activity);
        Toolbar myToolbar = (Toolbar) findViewById(R.id.tool_bar_in_calculate_premium_profile_detail_page);
        myToolbar.setTitle("Calculate Premium");
        setSupportActionBar(myToolbar);
        myToolbar.setTitleTextColor(getResources().getColor(com.insurance.bluescheme.insure.R.color.big_text_color));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        String profileUrl = ConstantData.USER_PROFILE_URL+"api_token="+SharedPreference.getStringValue(mContext, SharedPreference.API_TOKEN);
        getProfileData("profile", profileUrl);

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
    private void getProfileData(String tag, String url) {

        final ProgressDialog pDialog = new ProgressDialog(mContext);
        pDialog.setMessage("Loading! Please wait . . .");
        pDialog.show();
        RequestQueue mRequestQueue = Volley.newRequestQueue(mContext);

        final StringRequest postRequest = new StringRequest(Request.Method.GET, url,
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
                                JSONObject userJson = json.getJSONObject("user");
                                ProfileData profileData = new ProfileData();
                                profileData.setId("id");
                                profileData.setfName("username");
                                profileData.setEmail("email");
                                profileData.setMobileNumber("phone");
                                profileData.setGender("gender");
                                profileData.setProfile_image_url("photo");
                                profileData.setDateOfBirth("date_of_birth");
                                profileData.setAddress("address");
                                profileData.setMaritualStatus("status");

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

        });



        int socketTimeout = ConstantData.socketTimeout;//30 seconds - change to what you want
        RetryPolicy policy = new DefaultRetryPolicy(socketTimeout, DefaultRetryPolicy.DEFAULT_MAX_RETRIES, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT);
        postRequest.setRetryPolicy(policy);
        mRequestQueue.add(postRequest);
    }

}

