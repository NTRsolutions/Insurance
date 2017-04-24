package com.insurance.bluescheme.insure.activity;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
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
import com.insurance.bluescheme.insure.utils.ConstantData;
import com.insurance.bluescheme.insure.utils.SharedPreference;
import com.insurance.bluescheme.insure.utils.UserDialog;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by tonmoybarua on 12-Apr-17.
 */

public class ChangePasswordActivity extends AppCompatActivity {


    EditText oldPassword, newPassword, confirmPassword;
    Button sendButton;
    Context mContext;
    String oldPass, newPass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = this;
        setContentView(R.layout.change_password_activity_layout);
        Toolbar myToolbar = (Toolbar) findViewById(R.id.toolbar_id_change_password_layout);
        myToolbar.setTitle("Change Password");
        setSupportActionBar(myToolbar);
        myToolbar.setTitleTextColor(getResources().getColor(R.color.big_text_color));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        oldPassword = (EditText)findViewById(R.id.old_password);
        newPassword = (EditText)findViewById(R.id.new_password);
        confirmPassword = (EditText)findViewById(R.id.confirm_password);
        sendButton = (Button)findViewById(R.id.change_password_send_button);
        sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!newPassword.getText().toString().equals(confirmPassword.getText().toString())) {
                    confirmPassword.setError("password mis match !!!");
                } else {
                    oldPass = oldPassword.getText().toString();
                    newPass = confirmPassword.getText().toString();
                    sendDataToChangePasswordApi("change Password", ConstantData.CHANGE_PASSWORD_URL+ SharedPreference.getStringValue(mContext,SharedPreference.API_TOKEN));
                }


            }
        });

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

    private void  sendDataToChangePasswordApi(String tag, String url) {

        final ProgressDialog pDialog = new ProgressDialog(mContext);
        pDialog.setMessage("Loading! Please wait . . .");
        pDialog.show();
        RequestQueue mRequestQueue = Volley.newRequestQueue(mContext);

        final StringRequest postRequest = new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        System.out.println("response of Change password api:" + response);


                        try {
                            JSONObject jObj = new JSONObject(response);
                            JSONObject json = jObj.getJSONObject("data");

                            if (json.has("code")) {
                                String code = json.getString("code");
                                System.out.println("code : " + code);
                                String message = json.getString("message");
                                System.out.println("message : " + message);
                                if (code.equalsIgnoreCase("200")) {

                                    UserDialog.showUserAlert(mContext, message);
                                    // getActivity().finish();

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
                try {
                    parseError(error.networkResponse.data);
                } catch (Exception e) {
                    Log.e("parse error", String.valueOf(e));
                }
                pDialog.dismiss();
            }

        })

        {
            @Override
            protected Map<String, String> getParams() {
                Map<String, String> params = new HashMap<>();

                // params.put("first_name", signUpData.getFirst_name());
                //  params.put("last_name", signUpData.getLast_name());
                // params.put("user_type", userType);
                params.put("old_password", oldPass);
                params.put("password", newPass);
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

    private void parseError(byte[] errorData) {
        JSONObject jObject;
        try {
            jObject = new JSONObject(new String(errorData));

            String title = "";
            JSONObject jObj = jObject.getJSONObject("data");
            if (jObj.has("message") && !jObj.isNull("message")) {
                String message = jObj.getString("message");
                System.out.println("message : " + message);
                UserDialog.showUserAlert(mContext, message);
            } else {
                UserDialog.showUserAlert(mContext, "Server Error");

            }


        } catch (JSONException e) {
            e.printStackTrace();
            Log.e("p error", String.valueOf(e));
        }

    }
}

