package com.insurance.bluescheme.insure.advisor;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.insurance.bluescheme.insure.R;

/**
 * Created by tonmoybarua on 07-May-17.
 */

public class LifeStyleFragment extends Fragment implements View.OnClickListener {
    private Button zeroButton, otButton, tfButton, fivePlusButton;


    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.life_style_fragment_layout, container, false);
        zeroButton = (Button) view.findViewById(R.id.zero_button);
        otButton = (Button) view.findViewById(R.id.one_to_two_button);
        tfButton = (Button) view.findViewById(R.id.three_to_five_button);
        fivePlusButton = (Button) view.findViewById(R.id.five_plus_trevel_button);

        zeroButton.setOnClickListener(this);
        otButton.setOnClickListener(this);
        tfButton.setOnClickListener(this);
        fivePlusButton.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.zero_button:
                gotomaritualFragment("0");
                break;
            case R.id.one_to_two_button:
                gotomaritualFragment("1-2");
                break;
            case R.id.three_to_five_button:
                gotomaritualFragment("3-5");
                break;
            case R.id.five_plus_trevel_button:
                gotomaritualFragment(" 5+");
                break;
        }

    }

    void gotomaritualFragment(String value) {
        Fragment fr = new InvestmentFragment();
        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container_landing_page, fr);
        fragmentTransaction.commit();
    }
}