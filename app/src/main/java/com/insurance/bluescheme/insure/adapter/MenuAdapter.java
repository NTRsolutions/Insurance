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
import com.insurance.bluescheme.insure.home_activity.BuyPolicyActivity;
import com.insurance.bluescheme.insure.home_activity.ClaimsActivity;
import com.insurance.bluescheme.insure.home_activity.MyPolicyActivity;
import com.insurance.bluescheme.insure.home_activity.NotificationActivity;
import com.insurance.bluescheme.insure.home_activity.PolicyRenewelActivity;
import com.insurance.bluescheme.insure.home_activity.ProfileActivity;
import com.insurance.bluescheme.insure.model.DrawerMenu;
import com.insurance.bluescheme.insure.model.PolicyCategory;
import com.insurance.bluescheme.insure.model.Year;

import java.util.List;

/**
 * Created by tonmoybarua on 11-Apr-17.
 */

public class MenuAdapter extends RecyclerView.Adapter<MenuAdapter.MyViewHolder> {

    private List<DrawerMenu> menuList;
    Context context;
    public interface OnItemClickListener {
        void onItemClick(DrawerMenu item);
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        RelativeLayout relativeLayout;
        TextView menu_title_name;
        ImageView policy_item_image;

        public MyViewHolder(View view) {
            super(view);
            menu_title_name = (TextView) view.findViewById(R.id.menu_title);
            policy_item_image = (ImageView) view.findViewById(R.id.menu_item_image);
            relativeLayout = (RelativeLayout) view.findViewById(R.id.menu_relative_layout);

        }
    }


    public MenuAdapter(Context mContext, List<DrawerMenu> moviesList) {
        context = mContext;
        this.menuList = moviesList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.menu_page_item_layout, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        holder.menu_title_name.setText(menuList.get(position).getMenu_title());
        holder.policy_item_image.setImageResource(menuList.get(position).getMenu_imageid());
        holder.relativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(position ==0) {
                    context.startActivity(new Intent(context, BuyPolicyActivity.class));
                }
                else if(position==1) {
                    context.startActivity(new Intent(context, PolicyRenewelActivity.class));

                }
                else if(position==2) {
                    context.startActivity(new Intent(context, MyPolicyActivity.class));

                }
                else if(position==3) {
                    context.startActivity(new Intent(context, NotificationActivity.class));

                }
                else if(position==4) {
                    context.startActivity(new Intent(context, ClaimsActivity.class));

                }
                else if(position==5) {
                    context.startActivity(new Intent(context, ProfileActivity.class));

                }
                else{
                    Log.e("nothing", "found nothing in area ");
                    //Toast.makeText(HomeActivity.this, "Nothing select", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return menuList.size();

    }
}
