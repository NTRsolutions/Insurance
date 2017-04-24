

/**
 * Created by tonmoybarua on 23-Apr-17.
 */
package com.insurance.bluescheme.insure.adapter;

        import android.content.Context;
        import android.content.Intent;
        import android.graphics.Color;
        import android.support.v7.widget.RecyclerView;
        import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;
        import android.widget.RelativeLayout;
        import android.widget.TextView;

        import com.insurance.bluescheme.insure.R;
        import com.insurance.bluescheme.insure.insurance_feature_activity.FaqDetailsActivity;
        import com.insurance.bluescheme.insure.model.PolicyCategory;

        import java.util.List;

public class NotificationAdapter extends RecyclerView.Adapter<NotificationAdapter.MyViewHolder> {

        private List<PolicyCategory> pList;
        private Context context;
        private int value;

        class MyViewHolder extends RecyclerView.ViewHolder {

            RelativeLayout relativeLayout;
            TextView faq_title_name, faq_description;

            MyViewHolder(View view) {
                super(view);
                faq_title_name = (TextView) view.findViewById(R.id.faq_title_name_text);
                faq_description = (TextView)view.findViewById(R.id.faq_description_name_text);
                relativeLayout = (RelativeLayout) view.findViewById(R.id.faq_item_layout);
                faq_title_name.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        context.startActivity(new Intent(context, FaqDetailsActivity.class));

                    }
                });
            }
        }


        public NotificationAdapter(Context mContext, List<PolicyCategory> moviesList, int flag) {
            context = mContext;
            this.pList = moviesList;
            value = flag;
        }

        @Override
        public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View itemView = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.faq_list_item, parent, false);

            return new MyViewHolder(itemView);
        }

        @Override
        public void onBindViewHolder(MyViewHolder holder, int position) {
            if(value==2) {
                holder.faq_title_name.setTextColor(Color.BLUE);
            }
            holder.faq_title_name.setText(pList.get(position).getPolicy_title());
            holder.faq_description.setText("1 Hour ago");

        }

        @Override
        public int getItemCount() {
            return pList.size();

        }
    }


