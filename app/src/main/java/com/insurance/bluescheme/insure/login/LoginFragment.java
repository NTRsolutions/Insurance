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
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.RetryPolicy;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;
import com.insurance.bluescheme.insure.activity.HomeActivity;
import com.insurance.bluescheme.insure.R;
import com.insurance.bluescheme.insure.model.LoginData;
import com.insurance.bluescheme.insure.utils.CheckInternet;
import com.insurance.bluescheme.insure.utils.ConstantData;
import com.insurance.bluescheme.insure.utils.EmailFormatValidator;
import com.insurance.bluescheme.insure.utils.SharedPreference;
import com.insurance.bluescheme.insure.utils.UserDialog;
import com.sloop.fonts.FontsManager;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by tonmoybarua on 21-Mar-17.
 */

public class LoginFragment extends Fragment {
    private Button lButton, forget_button ;
    private EditText emailEditText, passwordEditText;
    Context mContext;
    LoginData loginData;
    private LoginButton facebook_loginButton;
    private CallbackManager callbackManager;
    private String email_facebbok;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mContext = getActivity();
        FacebookSdk.sdkInitialize(getActivity());
        callbackManager = CallbackManager.Factory.create();
        View view = inflater.inflate(R.layout.fragment_login_page_layout,
                container, false);


        // Other app specific specialization
        FontsManager.initFormAssets(getActivity(), "fonts/demo_font.ttf");	//初始化
        FontsManager.changeFonts(getActivity());
        emailEditText = (EditText)view.findViewById(R.id.email_id_login);
        passwordEditText = (EditText)view.findViewById(R.id.password_login);
        forget_button  = (Button)view.findViewById(R.id.forget_button);
        forget_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Fragment fr = new ForgetPasswordFragment();
                FragmentManager fragmentManager =getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.hello_there_fragment_container, fr);
                fragmentTransaction.commit();
            }
        });
        lButton = (Button)view.findViewById(R.id.login_button);
        lButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (inputValidation()) {
                    getUserData();
                    String registerUrl = ConstantData.LOG_IN_URL;
                    System.out.println("sign up url is :" + registerUrl);
                    if(CheckInternet.isNetworkAvailable(mContext)){
                        loginApiForUser("registration", registerUrl);
                    } else {
                        UserDialog.showUserAlert(mContext, "Check Internet Connection");

                    }

                }

            }
        });
        facebook_loginButton= (LoginButton)view.findViewById(R.id.facebok_login_button);
        facebook_loginButton.setReadPermissions("email");
        // If using in a fragment
        facebook_loginButton.setFragment(this);
        facebook_loginButton.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {
                Log.e("User ID: ", loginResult.getAccessToken().getUserId());
                Log.e( "Auth Token: ", loginResult.getAccessToken().getToken());
                if(AccessToken.getCurrentAccessToken() != null) {
                    startActivity(new Intent(mContext, HomeActivity.class));
                }
                GraphRequest request = GraphRequest.newMeRequest(
                        loginResult.getAccessToken(),
                        new GraphRequest.GraphJSONObjectCallback() {
                            @Override
                            public void onCompleted(JSONObject object, GraphResponse response) {
                                Log.v("LoginActivity", response.toString());

                                // Application code
                                try {
                                   email_facebbok = object.getString("email");
                                    Log.e("facebook mail", email_facebbok);
                                    loginApiForFaceBookLogin("facebook_login", ConstantData.FACEBOOK_LOGIN_URL);
                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }

                            }
                        });
                Bundle parameters = new Bundle();
                parameters.putString("fields", "id,name,email,gender,birthday");
                request.setParameters(parameters);
                request.executeAsync();
            }

            @Override
            public void onCancel() {
                Log.e("faceboo login cancel", "Login attempt canceled.");

            }

            @Override
            public void onError(FacebookException e) {
               Log.e("facebook Login", "Login attempt failed.");

            }
        });



        AccessToken token = AccessToken.getCurrentAccessToken();
        if (token != null) {
            Toast.makeText(mContext, "token found", Toast.LENGTH_SHORT).show();
        }
        return view;
    }
    
    private void getUserData() {
        loginData = new LoginData();
        loginData.setEmail(emailEditText.getText().toString().trim());
        loginData.setPassword(passwordEditText.getText().toString().trim());
        Log.e("email", emailEditText.getText().toString().trim());
        Log.e("pass", passwordEditText.getText().toString().trim());
    }


    private boolean inputValidation() {
        EmailFormatValidator emailFormatValidator = new EmailFormatValidator();
        if (!emailFormatValidator.validate(emailEditText.getText().toString().trim())) {
            emailEditText.setError("Invalid email address");
            return false;
        } else if (emailEditText.getText()==null) {
            emailEditText.setError("email required !");
        }else if (passwordEditText.getText().toString().trim().isEmpty()) {
            passwordEditText.setError("password required");
            return false;
        }
        return true;

    }
    private void  loginApiForUser(String tag, String url) {

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
                                String api_token = json.getString("api_token");
                                Log.e("api token before",api_token);
                                if (code.equalsIgnoreCase("200")) {
                                    JSONObject userJson = json.getJSONObject("user");


                                    //String userId = json.getString("user_id");
                                    SharedPreference.setBooleanValue(mContext, SharedPreference.LOG_IN_STATUS, true);
                                    SharedPreference.setStringValue(mContext, SharedPreference.API_TOKEN, api_token);
                                    Log.e("api token now",SharedPreference.getStringValue(mContext, SharedPreference.API_TOKEN));
                                    // Toast.makeText(mContext, "signup successfully completed..", Toast.LENGTH_SHORT).show();
                                    startActivity(new Intent(mContext, HomeActivity.class));
                                   // UserDialog.showUserAlert(mContext, "Login Success");
                                    getActivity().finish();

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
                Log.e("getemail", loginData.getEmail());
                Log.e("getpassword", loginData.getPassword());
                params.put("email", loginData.getEmail());
                params.put("password", loginData.getPassword());
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
    private void  loginApiForFaceBookLogin(String tag, String url) {

        final ProgressDialog pDialog = new ProgressDialog(mContext);
        pDialog.setMessage("Loading! Please wait . . .");
        pDialog.show();
        RequestQueue mRequestQueue = Volley.newRequestQueue(mContext);

        final StringRequest postRequest = new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        System.out.println("response of facebook login is:" + response);


                        try {
                            JSONObject jObj= new JSONObject(response);
                            JSONObject json = jObj.getJSONObject("data");

                            if (json.has("code")) {
                                String code = json.getString("code");
                                System.out.println("code : " + code);
                                String message = json.getString("message");
                                System.out.println("message : " + message);
                                if (code.equalsIgnoreCase("200")) {
                                    JSONObject userJson = json.getJSONObject("user");


                                    //String userId = json.getString("user_id");
                                    SharedPreference.setBooleanValue(mContext, SharedPreference.LOG_IN_STATUS, true);
                                    // Toast.makeText(mContext, "signup successfully completed..", Toast.LENGTH_SHORT).show();
                                    startActivity(new Intent(mContext, HomeActivity.class));
                                    // UserDialog.showUserAlert(mContext, "Login Success");
                                    getActivity().finish();

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

                params.put("email", email_facebbok);
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
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        callbackManager.onActivityResult(requestCode, resultCode, data);
    }

}


