package com.insurance.bluescheme.insure.fragment;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.insurance.bluescheme.insure.R;



public class VaultFragment extends Fragment {
    FloatingActionButton addFloatingActionButton;


    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.vault_layout_activity, container, false);
        addFloatingActionButton = (FloatingActionButton)view.findViewById(R.id.add_policy_button_in_vault);
        addFloatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment fr = new WhosePolicyFragment();
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragment_container_landing_page, fr);
                fragmentTransaction.commit();
            }
        });
        return view;
    }

}