package com.insurance.bluescheme.insure.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.insurance.bluescheme.insure.R;
import com.insurance.bluescheme.insure.model.PolicyCategory;

import java.util.List;

/**
 * Created by tonmoybarua on 28-Mar-17.
 */

public class RecomandPageAdapter extends RecyclerView.Adapter<RecomandPageAdapter.MyViewHolder> {

    private List<PolicyCategory> pList;
    Context context;

    public class MyViewHolder extends RecyclerView.ViewHolder {

        RelativeLayout relativeLayout;
        TextView policy_title_name, policy_description;
       // ImageView policy_item_image;

        public MyViewHolder(View view) {
            super(view);
            policy_title_name = (TextView) view.findViewById(R.id.policy__title_name_item);
            policy_description = (TextView) view.findViewById(R.id.policy_description_item);
           // policy_item_image = (ImageView) view.findViewById(R.id.item_image_policy);
            relativeLayout = (RelativeLayout)view.findViewById(R.id.list_one_layout_item);
            relativeLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                   // context.startActivity(new Intent(context, PolicyDetailActivity.class));
                }
            });
        }
    }


    public RecomandPageAdapter(Context mContext, List<PolicyCategory> moviesList) {
        context = mContext;
        this.pList = moviesList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recommend_item_list, parent, false);

        return new RecomandPageAdapter.MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.policy_title_name.setText(pList.get(position).getPolicy_title());
        holder.policy_description.setText(pList.get(position).getPolicy_des());
       // holder.policy_item_image.setImageResource(pList.get(position).getImagid());
    }

    @Override
    public int getItemCount() {
        return pList.size();

    }
}