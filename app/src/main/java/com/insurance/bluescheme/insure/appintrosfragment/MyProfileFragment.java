package com.insurance.bluescheme.insure.appintrosfragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.insurance.bluescheme.insure.R;

/**
 * Created by tonmoybarua on 21-Mar-17.
 */

public class MyProfileFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_my_profile,
                container, false);
        return view;
    }

}