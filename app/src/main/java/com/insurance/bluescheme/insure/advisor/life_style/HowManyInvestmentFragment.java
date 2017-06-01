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

public class HowManyInvestmentFragment extends Fragment implements View.OnClickListener {
    private Button oneButton, twoButton, threeButton, fourButton, fivePlusButton, finishButton;
    private String value;


    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.how_many_investment_fragment, container, false);
        oneButton = (Button) view.findViewById(R.id.one_button);
        twoButton = (Button) view.findViewById(R.id.two_button);
        threeButton = (Button) view.findViewById(R.id.three_button);
        fourButton = (Button) view.findViewById(R.id.four_button);
        fivePlusButton = (Button) view.findViewById(R.id.five_plus_button);
        finishButton = (Button) view.findViewById(R.id.finish_button);

        oneButton.setOnClickListener(this);
        twoButton.setOnClickListener(this);
        threeButton.setOnClickListener(this);
        fourButton.setOnClickListener(this);
        fivePlusButton.setOnClickListener(this);
        finishButton.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.one_button:
                gotomaritualFragment("one");
                break;
            case R.id.two_button:
                gotomaritualFragment("two");
                break;
            case R.id.three_button:
                gotomaritualFragment("three");
                break;
            case R.id.four_button:
                gotomaritualFragment("four");
                break;
            case R.id.five_plus_button:
                gotomaritualFragment("five");
                break;
            case R.id.finish_button:
                if (value != null) {
                    Fragment fr = new OwnReleaseFragment();
                    FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                    fragmentTransaction.replace(R.id.fragment_container_landing_page, fr);
                    fragmentTransaction.commit();
                }

        }

    }

    void gotomaritualFragment(String achieve_value) {
        value = achieve_value;


    }
}
