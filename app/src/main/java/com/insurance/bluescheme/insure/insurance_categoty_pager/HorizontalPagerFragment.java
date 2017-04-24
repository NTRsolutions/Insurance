package com.insurance.bluescheme.insure.insurance_categoty_pager;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.RetryPolicy;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.gigamole.infinitecycleviewpager.HorizontalInfiniteCycleViewPager;
import com.insurance.bluescheme.insure.R;
import com.insurance.bluescheme.insure.login.HelloThereActivity;
import com.insurance.bluescheme.insure.model.InsureCategory;
import com.insurance.bluescheme.insure.model.InsureCategory;
import com.insurance.bluescheme.insure.utils.CheckInternet;
import com.insurance.bluescheme.insure.utils.ConstantData;
import com.insurance.bluescheme.insure.utils.SharedPreference;
import com.insurance.bluescheme.insure.utils.UserDialog;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * Created by GIGAMOLE on 8/18/16.
 */
public class HorizontalPagerFragment extends Fragment {
    private List<InsureCategory> insureTypeList = new ArrayList<InsureCategory>();
    Context mContext;
    HorizontalInfiniteCycleViewPager horizontalInfiniteCycleViewPager;

    @Nullable
    @Override
    public View onCreateView(final LayoutInflater inflater, @Nullable final ViewGroup container, @Nullable final Bundle savedInstanceState) {
       View view = inflater.inflate(R.layout.fragment_horizontal, container, false);
        mContext = getActivity();


        horizontalInfiniteCycleViewPager =  (HorizontalInfiniteCycleViewPager) view.findViewById(R.id.hicvp);

        return view;
    }

    @Override
    public void onViewCreated(final View view, @Nullable final Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);



    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        insureTypeList = new ArrayList<InsureCategory>();
//        prepareMovieData();
        if(CheckInternet.isNetworkAvailable(mContext)){
            insuranceCategoryFromServer("category", ConstantData.LIST_OF_INSURANCE_TYPE_API_URL+SharedPreference.getStringValue(mContext, SharedPreference.API_TOKEN));
            Log.e("aappp", SharedPreference.getStringValue(mContext, SharedPreference.API_TOKEN));
        } else {
            UserDialog.showUserAlert(mContext, "Check Internet Connection");

        }


    }

   /* private void prepareMovieData() {
        InsureCategory policy = new InsureCategory("Car ", "this is dummy text1", R.mipmap.app_logo);
        insureTypeList.add(policy);
        InsureCategory p1 = new InsureCategory(" Mobile", "this is dummy text1", R.mipmap.app_logo);
        insureTypeList.add(p1);
        InsureCategory p2 = new InsureCategory("Home", "this is dummy text1", R.mipmap.app_logo);
        insureTypeList.add(p2);
        InsureCategory p3 = new InsureCategory("Rickshaw", "this is dummy text1", R.mipmap.app_logo);
        insureTypeList.add(p3);
        InsureCategory p4 = new InsureCategory("Health", "this is dummy text1", R.mipmap.app_logo);
        insureTypeList.add(p4);
        InsureCategory p5 = new InsureCategory("Mobile", "this is dummy text1", R.mipmap.app_logo);
        insureTypeList.add(p5);

    }*/
    private void insuranceCategoryFromServer(String tag, String url) {

        final ProgressDialog pDialog = new ProgressDialog(mContext);
        pDialog.setMessage("Loading! Please wait . . .");
        pDialog.show();
        RequestQueue mRequestQueue = Volley.newRequestQueue(mContext);

        final StringRequest postRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        System.out.println("response of isurance type list is:" + response);


                        try {
                            JSONObject jObj= new JSONObject(response);
                            JSONObject json = jObj.getJSONObject("data");

                            if (json.has("code")) {
                                String code = json.getString("code");
                                System.out.println("code : " + code);
                                JSONArray jsonArray = json.getJSONArray("type_of_insurances");
                                for(int i =0; i <jsonArray.length(); i++){
                                    JSONObject jsonObject = jsonArray.getJSONObject(i);
                                    InsureCategory insureCategory = new InsureCategory();
                                    insureCategory.setId(jsonObject.getString("id"));
                                    insureCategory.setDescription(jsonObject.getString("description"));
                                    insureCategory.setTitle(jsonObject.getString("title"));
                                    insureCategory.setPhoto(jsonObject.getString("photo"));
                                    insureTypeList.add(insureCategory);


                                }
                                horizontalInfiniteCycleViewPager.setAdapter(new HorizontalPagerAdapter(getContext(), false, insureTypeList));


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
