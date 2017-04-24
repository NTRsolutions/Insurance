package com.insurance.bluescheme.insure.insurance_categoty_pager;

import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.insurance.bluescheme.insure.R;
import com.insurance.bluescheme.insure.model.InsureCategory;
import com.insurance.bluescheme.insure.model.PolicyCategory;
import com.insurance.bluescheme.insure.utils.ConstantData;
import com.squareup.picasso.Picasso;

import java.util.List;


/**
 * Created by tonmoybarua on 27-Mar-17.
 */

public class Utils {
    public static void setupItem(final View view, final List<InsureCategory> insureTypeList, int position, Context context) {
        final TextView txt = (TextView) view.findViewById(R.id.policy_name);
        txt.setText(insureTypeList.get(position).getTitle());

        final ImageView img = (ImageView) view.findViewById(R.id.policy_image);
        final TextView destext = (TextView) view.findViewById(R.id.policy_dsescription);
        final Button viewButton = (Button) view.findViewById(R.id.view_policy_button);
       /* if(insureTypeList.get(position).getPhoto()!=null) {*/
            Picasso.with(context)
                    .load(ConstantData.BASE_URL+insureTypeList.get(position).getPhoto())
                    .placeholder(R.drawable.ic_fintech)
                    .into(img);
       /* }
        else {
            img.setImageResource(R.drawable.ic_fintech);

        }*/


        destext.setText(insureTypeList.get(position).getDescription());

    }

    public static class LibraryObject {

        private String mTitle;
        private int mRes;
        private String des;

        public String getDes() {
            return des;
        }

        public void setDes(String des) {
            this.des = des;
        }

        public LibraryObject(final int res, final String title, final String description) {
            mRes = res;
            mTitle = title;
            des = description;
        }

        public String getTitle() {
            return mTitle;
        }

        public void setTitle(final String title) {
            mTitle = title;
        }

        public int getRes() {
            return mRes;
        }

        public void setRes(final int res) {
            mRes = res;
        }

    }
}
