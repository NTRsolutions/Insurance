package com.insurance.bluescheme.insure.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.insurance.bluescheme.insure.R;
import com.insurance.bluescheme.insure.adapter.HomePageAdapter;
import com.insurance.bluescheme.insure.insurance_feature_activity.CalculatorPremiumActivity;
import com.insurance.bluescheme.insure.insurance_feature_activity.ClaimsServiceActivity;
import com.insurance.bluescheme.insure.insurance_feature_activity.ContactSupportActivity;
import com.insurance.bluescheme.insure.insurance_feature_activity.FAQActivity;
import com.insurance.bluescheme.insure.insurance_feature_activity.PlanBruchureActivity;
import com.insurance.bluescheme.insure.insurance_feature_activity.RecomandedPlanActivity;
import com.insurance.bluescheme.insure.utils.ConstantData;
import com.squareup.picasso.Picasso;

import static android.R.attr.columnWidth;
import static android.view.Gravity.CENTER;

/**
 * Created by tonmoybarua on 28-Mar-17.
 */

public class PolicyDetailActivity extends AppCompatActivity {
    GridView gridView;
    String title, policy_title, policy_description, image_url;
    ImageView basic_imageView;
    TextView titleTxv, desTxv;
    private FloatingActionButton callFloatingButton;
    String[] item_name = {
            "Calculate Premium",
            "Plan Bruchure",
            "FAQ",
            "Claims & Service",
            "Recomended Plans",
            "Contact/ Support"

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
        setContentView(R.layout.policy_item_detail_layout);
        Toolbar myToolbar = (Toolbar) findViewById(R.id.toolbar_id_policy_item_detail_layout);
        titleTxv = (TextView) findViewById(R.id.basic_info_title);
        desTxv = (TextView) findViewById(R.id.basic_info_details);
        basic_imageView = (ImageView)findViewById(R.id.basic_imageView);

        if(getIntent().getStringExtra("title")!=null){
            title = getIntent().getStringExtra("title");
        }
        if(title!=null){
            myToolbar.setTitle(title);
        } else {
            myToolbar.setTitle("Car Insurance ");
        }
        if(getIntent().getStringExtra("name_of_item")!=null){
            policy_title = getIntent().getStringExtra("name_of_item");
        }
        if(getIntent().getStringExtra("des_of_item")!=null){
            policy_description = getIntent().getStringExtra("des_of_item");
        }
        if(getIntent().getStringExtra("image_url")!=null){
           image_url = getIntent().getStringExtra("image_url");
        }
        callFloatingButton = (FloatingActionButton)findViewById(R.id.floating_button_policy_detail_layout);
        callFloatingButton.setColorFilter(getResources().getColor(R.color.cardview_light_background));

        titleTxv.setText(policy_title);
        desTxv.setText(policy_description);
        Picasso.with(this)
                .load(ConstantData.BASE_URL+image_url)
                .placeholder(R.drawable.messenger_bubble_small_blue)
                .into(basic_imageView);

        setSupportActionBar(myToolbar);
        myToolbar.setTitleTextColor(getResources().getColor(R.color.big_text_color));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        // getSupportActionBar().setDisplayShowHomeEnabled(true);
        HomePageAdapter adapter = new HomePageAdapter(PolicyDetailActivity.this, item_name, image_id);
        gridView=(GridView)findViewById(R.id.grid);
        gridView.setColumnWidth(columnWidth);
        gridView.setAdapter(adapter);



        gridView.setGravity(CENTER);
        gridView.setOnItemClickListener(    new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                //Toast.makeText(PolicyDetailActivity.this, "You Clicked at " +item_name[+ position], Toast.LENGTH_SHORT).show();
                if(item_name[+position].equals("Calculate Premium")) {
                    startActivity(new Intent(PolicyDetailActivity.this, CalculatorPremiumActivity.class));
                }
                else if(item_name[+position].equals("Plan Bruchure")) {
                    startActivity(new Intent(PolicyDetailActivity.this, PlanBruchureActivity.class));

                }
                else if(item_name[+position].equals("FAQ")) {
                    startActivity(new Intent(PolicyDetailActivity.this, FAQActivity.class));

                }
                else if(item_name[+position].equals("Claims & Service")) {
                    startActivity(new Intent(PolicyDetailActivity.this, ClaimsServiceActivity.class));

                }
                else if(item_name[+position].equals("Recomended Plans")) {
                    startActivity(new Intent(PolicyDetailActivity.this, RecomandedPlanActivity.class));

                }
                else if(item_name[+position].equals("Contact/ Support")) {
                    startActivity(new Intent(PolicyDetailActivity.this, ContactSupportActivity.class));

                }
                else{
                    Toast.makeText(PolicyDetailActivity.this, "Nothing select", Toast.LENGTH_SHORT).show();
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
}
