package com.insurance.bluescheme.insure.login;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.insurance.bluescheme.insure.R;


/**
 * Created by tonmoybarua on 21-Mar-17.
 */

public class HelloThereFragment extends Fragment {
    private Button yes_button, not_yet_button;
    private TextView heelTxv, meetTxv;

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragmen_hellow_there, container, false);
        yes_button = (Button) view.findViewById(R.id.yes_hello_page);
        not_yet_button = (Button) view.findViewById(R.id.not_yet_in_hellow_page);
        yes_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment fr = new LoginFragment();
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.hello_there_fragment_container, fr);
                fragmentTransaction.commit();
            }
        });
        not_yet_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment fr = new NiceToMeetFragment();
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.hello_there_fragment_container, fr);
                fragmentTransaction.commit();
            }
        });
    /*heelTxv = (TextView)view.findViewById(R.id.hello_there);
    Typeface face= Typeface.createFromAsset(getActivity().getAssets(),"fonts/April Flowers - TTF.ttf");
    heelTxv.setTypeface(face);*/
        //FontsManager.initFormAssets(getActivity(), "fonts/April Flowers - TTF.ttf");	//初始化
        //FontsManager.changeFonts(view);
        return view;
    }

}