package com.insurance.bluescheme.insure.adapter;

import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.insurance.bluescheme.insure.R;
import com.insurance.bluescheme.insure.model.Year;

import java.util.List;

/**
 * Created by tonmoybarua on 30-Mar-17.
 */

public class PremiumYearTermAdapter extends RecyclerView.Adapter<PremiumYearTermAdapter.ViewHolder> {

    public interface OnItemClickListener {
        void onItemClick(Year item);
    }
    private int mSelectedPosition = 0;


    private final List<Year> items;
    private final OnItemClickListener listener;
    private int value =0;

    public PremiumYearTermAdapter(List<Year> items,int flag, OnItemClickListener listener) {
        this.items = items;
        this.listener = listener;
        value = flag;
    }

    @Override public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.calculate_premium_policy_item_list, parent, false);
        return new ViewHolder(v);
    }

    @Override public void onBindViewHolder(ViewHolder holder, int position) {
        position = position %4;
        holder.bind(items.get(position), listener, position);

    }

    @Override public int getItemCount() {
       return items.size();
        //return Integer.MAX_VALUE;
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        private TextView name;
        ViewHolder(View itemView) {
            super(itemView);
            name = (TextView) itemView.findViewById(R.id.year_text_id);

        }

        void bind(final Year item, final OnItemClickListener listener, final int position) {
            if(value==0) {
                name.setText(item.getPolicy_year());
            } else {
                name.setText(item.getPolicy_term());
            }
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override public void onClick(View v) {
                    listener.onItemClick(item);
                    mSelectedPosition =position;
                    notifyDataSetChanged();

                }
            });
            if(mSelectedPosition==position){
                name.setBackgroundResource(R.drawable.circle_shape_blue);
                name.setTextColor(Color.WHITE);
            }
            else {
                name.setBackgroundResource(R.drawable.circle_shape);
                name.setTextColor(Color.BLUE);
            }


        }
    }
}