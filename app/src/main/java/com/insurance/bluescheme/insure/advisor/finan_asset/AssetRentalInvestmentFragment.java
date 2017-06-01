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
import com.insurance.bluescheme.insure.advisor.finan_liabilities.AssestCPFFragment;

/**
 * Created by tonmoybarua on 07-May-17.
 */

public class AssetRentalInvestmentFragment extends Fragment implements View.OnClickListener {
    private Button undergdpButton, one_thousandButton, othreeButton,
            thfiveButton, feightPlusButton, etenButton, abovetenButton;
    private String value;


    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.financial_assets_rental_invest_fragment_layout, container, false);
        undergdpButton = (Button) view.findViewById(R.id.under_gdp_button);
        one_thousandButton = (Button) view.findViewById(R.id.one_thousand);
        othreeButton = (Button) view.findViewById(R.id.one_to_three_thousand_button);
        thfiveButton = (Button) view.findViewById(R.id.three_to_five_thousand_button);
        feightPlusButton = (Button) view.findViewById(R.id.five_to_eight_thousand_button);
        etenButton = (Button) view.findViewById(R.id.eight_to_ten_thousand_button);
        abovetenButton = (Button) view.findViewById(R.id.ten_thousand_plus_button);

        undergdpButton.setOnClickListener(this);
        one_thousandButton.setOnClickListener(this);
        othreeButton.setOnClickListener(this);
        thfiveButton.setOnClickListener(this);
        feightPlusButton.setOnClickListener(this);
        etenButton.setOnClickListener(this);
        abovetenButton.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.under_gdp_button:
                gotomaritualFragment("one");
                break;
            case R.id.one_thousand:
                gotomaritualFragment("two");
                break;
            case R.id.one_to_three_thousand_button:
                gotomaritualFragment("three");
                break;
            case R.id.three_to_five_thousand_button:
                gotomaritualFragment("four");
                break;
            case R.id.five_to_eight_thousand_button:
                gotomaritualFragment("five");
                break;
            case R.id.eight_to_ten_thousand_button:
                gotomaritualFragment("8-10");
                break;
            case R.id.ten_thousand_plus_button:
                gotomaritualFragment("10+");
                break;

        }

    }

    void gotomaritualFragment(String achieve_value) {
        value = achieve_value;
        if(value!=null){
            Fragment fr = new AssestCPFFragment();
            FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.fragment_container_landing_page, fr);
            fragmentTransaction.commit();
        }


    }
}
