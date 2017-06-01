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

public class InvestmentFragment extends Fragment implements View.OnClickListener {
    private Button yesButton, noButton;


    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.rental_investment_fragment_layout, container, false);
        yesButton = (Button)view.findViewById(R.id.yes_investment_button);
        noButton = (Button)view.findViewById(R.id.no_investment_button);
        yesButton.setOnClickListener(this);
        noButton.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.yes_investment_button :
                Fragment fr = new HowManyInvestmentFragment();
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragment_container_landing_page, fr);
                fragmentTransaction.commit();
                break;
            case R.id.no_investment_button :
                break;
        }
    }
}