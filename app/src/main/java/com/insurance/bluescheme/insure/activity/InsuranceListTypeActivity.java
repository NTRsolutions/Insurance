package com.insurance.bluescheme.insure.activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.RelativeLayout;

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
import com.insurance.bluescheme.insure.insurance_categoty_pager.HorizontalPagerAdapter;
import com.insurance.bluescheme.insure.model.InsureCategory;
import com.insurance.bluescheme.insure.model.PolicyCategory;
import com.insurance.bluescheme.insure.utils.CheckInternet;
import com.insurance.bluescheme.insure.utils.ConstantData;
import com.insurance.bluescheme.insure.utils.SharedPreference;
import com.insurance.bluescheme.insure.utils.UserDialog;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tonmoybarua on 27-Mar-17.
 */

public class InsuranceListTypeActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    Context mContext;
    List<PolicyCategory> policyList = new ArrayList<PolicyCategory>();
    String title, id;
    String apiUrl ="";
    PolicyItemListAdapter mAdapter;
    private FloatingActionButton filterButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.policy_item_category_list_activity);
        mContext = this;
        title = getIntent().getStringExtra("category_name");
        if(getIntent().getStringExtra("id")!=null){
            id = getIntent().getStringExtra("id");
        }

        Toolbar myToolbar = (Toolbar) findViewById(R.id.some_id_if_needed);
        if(title!=null){
            myToolbar.setTitle(title);
        } else {
            myToolbar.setTitle("Policy Category");
        }
        apiUrl = ConstantData.LIST_OF_POLICY_INFORMATION+id+"?"+"api_token="+SharedPreference.getStringValue(mContext, SharedPreference.API_TOKEN);
        setSupportActionBar(myToolbar);
        myToolbar.setTitleTextColor(getResources().getColor(R.color.big_text_color));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
       // getSupportActionBar().setDisplayShowHomeEnabled(true);
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
       // prepareMovieData();

        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        if(CheckInternet.isNetworkAvailable(mContext)){
            listOfPolicyInformationFromServer("policy_list", apiUrl);
        } else {
            UserDialog.showUserAlert(mContext, "Check Internet Connection");

        }
        filterButton = (FloatingActionButton)findViewById(R.id.floating_recomended_item_layout_page);
        filterButton.setColorFilter(getResources().getColor(R.color.cardview_light_background));


    }
    private void prepareMovieData() {
        PolicyCategory policy = new PolicyCategory("Car insurance list 1 ", "Action & Adventure", R.mipmap.app_logo);
        policyList.add(policy);
        PolicyCategory p1 = new PolicyCategory("Car insurance list 2", "Action & Adventure", R.mipmap.app_logo);
        policyList.add(p1);
        PolicyCategory p2 = new PolicyCategory("Car insurance list3", "Action & Adventure", R.mipmap.app_logo);
        policyList.add(p2);
        PolicyCategory p3 = new PolicyCategory("Car insurance list4", "Action & Adventure", R.mipmap.app_logo);
        policyList.add(p3);
        PolicyCategory p4 = new PolicyCategory("Car insurance list 5", "Action & Adventure", R.mipmap.app_logo);
        policyList.add(p4);
        PolicyCategory p5 = new PolicyCategory("Car insurance list 6", "Action & Adventure", R.mipmap.app_logo);
        policyList.add(p5);

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

    private void listOfPolicyInformationFromServer(String tag, String url) {

        final ProgressDialog pDialog = new ProgressDialog(mContext);
        pDialog.setMessage("Loading! Please wait . . .");
        pDialog.show();
        RequestQueue mRequestQueue = Volley.newRequestQueue(mContext);

        final StringRequest postRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        System.out.println("response of policy type list is:" + response);


                        try {
                            JSONObject jObj= new JSONObject(response);
                            JSONObject json = jObj.getJSONObject("data");

                            if (json.has("code")) {
                                String code = json.getString("code");
                                System.out.println("code : " + code);
                                JSONArray jsonArray = json.getJSONArray("policy_information");
                                for(int i =0; i <jsonArray.length(); i++){
                                    JSONObject jsonObject = jsonArray.getJSONObject(i).getJSONObject("type_of_insurance");
                                    PolicyCategory policyCategory = new PolicyCategory();
                                    policyCategory.setId(jsonObject.getString("id"));
                                    policyCategory.setPolicy_des(jsonObject.getString("description"));
                                    policyCategory.setPolicy_title(jsonObject.getString("title"));
                                    policyCategory.setPhoto(jsonObject.getString("photo"));
                                    policyList.add(policyCategory);


                                }
                                mAdapter = new PolicyItemListAdapter(mContext, policyList, title);
                                recyclerView.setAdapter(mAdapter);


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

