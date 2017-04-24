package com.insurance.bluescheme.insure.adapter;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;


import com.insurance.bluescheme.insure.R;
import com.insurance.bluescheme.insure.activity.PolicyDetailActivity;
import com.insurance.bluescheme.insure.model.PolicyCategory;
import com.insurance.bluescheme.insure.utils.ConstantData;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by tonmoybarua on 28-Mar-17.
 */

public class PolicyItemListAdapter extends RecyclerView.Adapter<PolicyItemListAdapter.MyViewHolder> {

    private List<PolicyCategory> pList;
    Context context;
    String title;
    public PolicyItemListAdapter(Context mContext, List<PolicyCategory> moviesList, String title) {
        context = mContext;
        this.pList = moviesList;
        this.title = title;
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        RelativeLayout relativeLayout;
        TextView policy_title_name, policy_description;
        ImageView policy_item_image;

        public MyViewHolder(View view) {
            super(view);
            policy_title_name = (TextView) view.findViewById(R.id.policy__title_name_item);
            policy_description = (TextView) view.findViewById(R.id.policy_description_item);
            policy_item_image = (ImageView) view.findViewById(R.id.item_image_policy);
            relativeLayout = (RelativeLayout)view.findViewById(R.id.list_one_layout_item);

        }
    }




    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.policy_item_list, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        holder.policy_title_name.setText(pList.get(position).getPolicy_title());
        holder.policy_description.setText(pList.get(position).getPolicy_des());

        if(pList.get(position).getPhoto()==null) {
            holder.policy_item_image.setImageResource(pList.get(position).getImagid());

        } else {
            Picasso.with(context)
                    .load(ConstantData.BASE_URL + pList.get(position).getPhoto())
                    .placeholder(R.drawable.ic_fintech)
                    .into(holder.policy_item_image);
            Log.e("image url", pList.get(position).getPhoto());

        }

        holder.relativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(context, PolicyDetailActivity.class);
                in.putExtra("title", title);
                in.putExtra("name_of_item", pList.get(position).getPolicy_title());
                in.putExtra("des_of_item", pList.get(position).getPolicy_des());
                in.putExtra("image_url", pList.get(position).getPhoto());
                context.startActivity(in);
            }
        });
    }

    @Override
    public int getItemCount() {
        return pList.size();

    }
}