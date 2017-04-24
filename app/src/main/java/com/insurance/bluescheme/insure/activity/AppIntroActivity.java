package com.insurance.bluescheme.insure.activity;

import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.RetryPolicy;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.github.paolorotolo.appintro.AppIntro;
import com.insurance.bluescheme.insure.appintrosfragment.ApplicationManagerFragment;
import com.insurance.bluescheme.insure.appintrosfragment.EasyToManageFragment;
import com.insurance.bluescheme.insure.appintrosfragment.GetStartedFragment;
import com.insurance.bluescheme.insure.appintrosfragment.MyProfileFragment;
import com.insurance.bluescheme.insure.model.PolicyCategory;
import com.insurance.bluescheme.insure.model.ProfileData;
import com.insurance.bluescheme.insure.utils.ConstantData;
import com.insurance.bluescheme.insure.utils.SharedPreference;
import com.insurance.bluescheme.insure.utils.UserDialog;
import com.sloop.fonts.FontsManager;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


/**
 * Created by tonmoybarua on 21-Mar-17.
 */

public class AppIntroActivity extends AppIntro {
    Context mContext;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mContext = this;
        SharedPreference.setBooleanValue(mContext, SharedPreference.SplashCheck, true);
        // Note here that we DO NOT use setContentView();

        // Add your slide fragments here.
        // AppIntro will automatically generate the dots indicator and buttons.
        addSlide(new EasyToManageFragment());
        addSlide(new MyProfileFragment());
        addSlide(new ApplicationManagerFragment());
        addSlide(new GetStartedFragment());
        FontsManager.initFormAssets(this, "fonts/April Flowers - TTF.ttf");        //initialization
        FontsManager.changeFonts(this);

        // Instead of fragments, you can also use our default slide
        // Just set a title, description, background and image. AppIntro will do the rest.
        //addSlide(AppIntroFragment.newInstance("title", "description", R.drawable, "#ffffff"));

        // OPTIONAL METHODS
        // Override bar/separator color.
        setBarColor(Color.parseColor("#3F51B5"));
        setSeparatorColor(Color.parseColor("#2196F3"));


        // Turn vibration on and set intensity
        // NOTE: you will probably need to ask VIBRATE permisssion in Manifest
        setVibrate(true);
        setVibrateIntensity(30);

        // Animations -- use only one of the below. Using both could cause errors.
        //setFadeAnimation(); // OR
        //setZoomAnimation(); // OR
        // setFlowAnimation(); // OR
        // setSlideOverAnimation(); // OR
        setDepthAnimation(); // OR
        showDoneButton(true);
        showSkipButton(true);
        setProgressButtonEnabled(false);

        //FontsManager.initFormAssets(this, "fonts/demo_font.ttf");	//初始化
        // FontsManager.changeFonts(this);
    }

    @Override
    public void onSkipPressed(Fragment currentFragment) {
        super.onSkipPressed(currentFragment);
        // Do something when users tap on Skip button.
    }

    @Override
    public void onDonePressed(Fragment currentFragment) {
        super.onDonePressed(currentFragment);
        // Do something when users tap on Done button.
    }

    @Override
    public void onSlideChanged(@Nullable Fragment oldFragment, @Nullable Fragment newFragment) {
        super.onSlideChanged(oldFragment, newFragment);
        // Do something when the slide changes.
    }

}