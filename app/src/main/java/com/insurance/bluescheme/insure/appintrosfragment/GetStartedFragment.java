package com.insurance.bluescheme.insure.appintrosfragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.insurance.bluescheme.insure.R;
import com.insurance.bluescheme.insure.login.HelloThereActivity;

/**
 * Created by tonmoybarua on 21-Mar-17.
 */

public class GetStartedFragment extends Fragment {
    Button start_button;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_getting_start,
                container, false);
        start_button = (Button) view.findViewById(R.id.ready_button);
        start_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(getActivity(), "Button Clicked", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getActivity(), HelloThereActivity.class);
                startActivity(intent);
            }
        });
        return view;
    }
}

