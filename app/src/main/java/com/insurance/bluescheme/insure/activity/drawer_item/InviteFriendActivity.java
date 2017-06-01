package com.insurance.bluescheme.insure.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;

import com.insurance.bluescheme.insure.R;
import com.insurance.bluescheme.insure.adapter.PrefferedAdvisorAdapter;

/**
 * Created by tonmoybarua on 09-May-17.
 */

public class InviteFriendActivity extends Fragment {
    private Button shareButton;
    Context mContext;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.invite_friend_layout_activity, container, false);
        mContext = getActivity();
        shareButton = (Button)view.findViewById(R.id.share_button);
        shareButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(mContext, ShareFriendSubmitActivity.class));
            }
        });

        return view;
    }

}
