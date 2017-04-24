package com.insurance.bluescheme.insure.login;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.insurance.bluescheme.insure.R;
import com.sloop.fonts.FontsManager;

/**
 * Created by tonmoybarua on 21-Mar-17.
 */

public class NiceToMeetFragment extends Fragment {
    private Button sureButton;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_nice_to_meet_layout,
                container, false);
        sureButton = (Button)view.findViewById(R.id.sure_button_nice_page);
        sureButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment fr = new GreatLoginFragment();
                FragmentManager fragmentManager =getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.hello_there_fragment_container, fr);
                fragmentTransaction.commit();
            }
        });
        FontsManager.initFormAssets(getActivity(), "fonts/demo_font.ttf");	//初始化
        FontsManager.changeFonts(getActivity());

        return view;
    }
}
