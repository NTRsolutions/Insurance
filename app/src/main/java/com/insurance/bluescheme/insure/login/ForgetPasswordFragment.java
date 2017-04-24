package com.insurance.bluescheme.insure.login;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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
import com.insurance.bluescheme.insure.activity.HomeActivity;
import com.insurance.bluescheme.insure.utils.ConstantData;
import com.insurance.bluescheme.insure.utils.EmailFormatValidator;
import com.insurance.bluescheme.insure.utils.UserDialog;
import com.sloop.fonts.FontsManager;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by tonmoybarua on 11-Apr-17.
 */

public class ForgetPasswordFragment  extends Fragment {
    private Button forgetSendButton;
    private EditText emailForgetEdit;
    String email;
    Context mContext;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_forget_password, container, false);
        mContext = getActivity();
        emailForgetEdit = (EditText) view.findViewById(R.id.email_id_forget_password);
        forgetSendButton = (Button) view.findViewById(R.id.forget_send_button);
        forgetSendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (inputValidation()) {
                    email = emailForgetEdit.getText().toString().trim();
                    String registerUrl = ConstantData.FORGET_PASSWORD_URL;
                    System.out.println("forgetpassword url is :" + registerUrl);
                    forgetPasswordApi("registration", registerUrl, email);
                }


            }
        });
        return view;
    }

    private boolean inputValidation() {
        EmailFormatValidator emailFormatValidator = new EmailFormatValidator();
        if (!emailFormatValidator.validate(emailForgetEdit.getText().toString().trim())) {
            emailForgetEdit.setError("Invalid email address");
            return false;
        } else if (emailForgetEdit.getText() == null) {
            emailForgetEdit.setError("email required !");
        }
        return true;

    }

    private void forgetPasswordApi(String tag, String url, final String email) {

        final ProgressDialog pDialog = new ProgressDialog(mContext);
        pDialog.setMessage("Loading! Please wait . . .");
        pDialog.show();
        RequestQueue mRequestQueue = Volley.newRequestQueue(mContext);

        final StringRequest postRequest = new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        System.out.println("response of forget api:" + response);


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
                Log.e("getemail", email);
                params.put("email", email);
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
