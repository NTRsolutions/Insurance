package com.insurance.bluescheme.insure.appintrosfragment;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.insurance.bluescheme.insure.R;
import com.insurance.bluescheme.insure.model.IntroData;
import com.insurance.bluescheme.insure.model.PolicyCategory;
import com.insurance.bluescheme.insure.utils.ConstantData;
import com.insurance.bluescheme.insure.utils.SharedPreference;
import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tonmoybarua on 21-Mar-17.
 */

public class EasyToManageFragment extends Fragment {
    Context mContext;
    List<IntroData> introList = new ArrayList<>();
    TextView titleTxv, desTxv;
    ImageView imageView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mContext = getActivity();
        introList = new ArrayList<IntroData>();
        getIntroData();
        View view = inflater.inflate(R.layout.fragment_easy_to_manage, container, false);
        titleTxv = (TextView)view.findViewById(R.id.easy_image_title);
        desTxv = (TextView)view.findViewById(R.id.app_manager_descrition);
        imageView = (ImageView)view.findViewById(R.id.easy_image_id);

        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    private void getIntroData() {

        String response = SharedPreference.getStringValue(mContext, SharedPreference.INTRO_DATA);
        System.out.println("response of logout api is:" + response);

        try {
            JSONObject jObj = new JSONObject(response);
            JSONObject json = jObj.getJSONObject("data");


            if (json.has("code")) {
                String code = json.getString("code");
                System.out.println("code : " + code);
                JSONArray jsonArray = json.getJSONArray("pages");
                for (int i = 0; i < jsonArray.length(); i++) {
                    JSONObject jsonObject = jsonArray.getJSONObject(i);
                    IntroData introData = new IntroData();
                    introData.setId(jsonObject.getString("id"));
                    introData.setDescription(jsonObject.getString("description"));
                    introData.setTitle(jsonObject.getString("title"));
                    introData.setImageUrl(jsonObject.getString("photo"));
                    introList.add(introData);


                }
                titleTxv.setText(introList.get(0).getTitle());
                desTxv.setText(introList.get(0).getDescription());
                Picasso.with(mContext)
                        .load(ConstantData.BASE_URL+introList.get(0).getImageUrl())
                        .placeholder(R.drawable.ic_fintech)
                        .into(imageView);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }
}
