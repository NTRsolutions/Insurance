package com.insurance.bluescheme.insure.appintrosfragment;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
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
import com.insurance.bluescheme.insure.model.ProfileData;
import com.insurance.bluescheme.insure.utils.ConstantData;
import com.insurance.bluescheme.insure.utils.UserDialog;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by tonmoybarua on 21-Mar-17.
 */

public class ApplicationManagerFragment extends Fragment {
    Context mContext;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_application_manager, container, false);
        mContext = getActivity();
        ImageView appManagerImageview = (ImageView) view.findViewById(R.id.app_manager_imageview);
        TextView titleAppManagerTxv = (TextView) view.findViewById(R.id.app_manager_title);
        TextView descriptionAppManagerTxv = (TextView) view.findViewById(R.id.app_manager_descrition);


        return view;
    }

}


