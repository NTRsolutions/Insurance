package com.insurance.bluescheme.insure.login;

import android.app.ProgressDialog;
import android.content.Context;
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
import com.insurance.bluescheme.insure.model.SignUpData;
import com.insurance.bluescheme.insure.utils.CheckInternet;
import com.insurance.bluescheme.insure.utils.ConstantData;
import com.insurance.bluescheme.insure.utils.EmailFormatValidator;
import com.insurance.bluescheme.insure.utils.UserDialog;
import com.sloop.fonts.FontsManager;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by tonmoybarua on 21-Mar-17.
 */

public class GreatLoginFragment extends Fragment {
    private Button done_button;
    private EditText emailEditText, passEditText;
    Context mContext;
    SignUpData signUpData;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_great_start_than_layout, container, false);
        mContext = getActivity();
        FontsManager.initFormAssets(getActivity(), "fonts/demo_font.ttf");	//初始化
        FontsManager.changeFonts(getActivity());
        done_button   = (Button)view.findViewById(R.id.great_done_button);
        emailEditText = (EditText)view.findViewById(R.id.email_id_sign_up);
        passEditText  = (EditText)view.findViewById(R.id.password_sign_up);
        done_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                    if (inputValidation()) {
                        getUserData();
                        String registerUrl = ConstantData.SIGN_UP_URL;
                        System.out.println("sign up url is :" + registerUrl);

                        if(CheckInternet.isNetworkAvailable(mContext)){
                            signUpApiForUserUp("registration", registerUrl);
                        } else {
                            UserDialog.showUserAlert(mContext, "Check Internet Connection");

                        }
                    }

            }
        });
        return view;
    }
    private void getUserData() {
        signUpData = new SignUpData();
        signUpData.setEmail(emailEditText.getText().toString().trim());
        signUpData.setPassword(passEditText.getText().toString().trim());
        Log.e("email", emailEditText.getText().toString().trim());
        Log.e("pass", passEditText.getText().toString().trim());
    }


    private boolean inputValidation() {
        EmailFormatValidator emailFormatValidator = new EmailFormatValidator();
        if (!emailFormatValidator.validate(emailEditText.getText().toString().trim())) {
            emailEditText.setError("Invalid email address");
            return false;
        } else if (emailEditText.getText()==null) {
            emailEditText.setError("email required !");
        }else if (passEditText.getText().toString().trim().isEmpty()) {
            passEditText.setError("password required");
            return false;
        }
        return true;

    }
    private void signUpApiForUserUp(String tag, String url) {

        final ProgressDialog pDialog = new ProgressDialog(mContext);
        pDialog.setMessage("Loading! Please wait . . .");
        pDialog.show();
        RequestQueue mRequestQueue = Volley.newRequestQueue(mContext);

        final StringRequest postRequest = new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        System.out.println("response of sign up is:" + response);


                        try {
                            JSONObject jObj= new JSONObject(response);
                            JSONObject json = jObj.getJSONObject("data");

                            if (json.has("code")) {
                                String code = json.getString("code");
                                System.out.println("code : " + code);
                                String message = json.getString("message");
                                System.out.println("message : " + message);
                                if (code.equalsIgnoreCase("200")) {

                                    //String userId = json.getString("user_id");
                                   // SharedPreference.setBooleanValue(mContext, SharedPreference.STAY_LOG_IN, true);
                                   // Toast.makeText(mContext, "signup successfully completed..", Toast.LENGTH_SHORT).show();
                                    Fragment fr = new AlmostDoneFragment();
                                    FragmentManager fragmentManager =getActivity().getSupportFragmentManager();
                                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                                    fragmentTransaction.replace(R.id.hello_there_fragment_container, fr);
                                    fragmentTransaction.commit();
                                   // UserDialog.showUserAlert(mContext, "Sign Up Success");

                                    //Intent i = new Intent(SignUpActivity.this, LogInActivity.class);
                                    //startActivity(i);
                                    //finish();
                                } /*else if(code.equalsIgnoreCase("400")) {
                                    UserDialog.showUserAlert(mContext, "Sorry failed to sign up ! Please Try Again.");
                                } else {
                                    UserDialog.showUserAlert(mContext, "Server Error");

                                }*/
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
                Log.e("getemail", signUpData.getEmail());
                Log.e("getpassword", signUpData.getPassword());
                params.put("email", signUpData.getEmail());
                params.put("password", signUpData.getPassword());
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
                JSONObject  json = jObj.getJSONObject("errors");
                JSONArray jsonArray = json.getJSONArray("email");
                    String message = jsonArray.get(0).toString();
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
