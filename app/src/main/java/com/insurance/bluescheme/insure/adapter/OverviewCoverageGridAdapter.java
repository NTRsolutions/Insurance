package com.insurance.bluescheme.insure.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.insurance.bluescheme.insure.R;

/**
 * Created by tonmoybarua on 08-May-17.
 */

public class OverviewCoverageAdapter extends BaseAdapter {
    private Context mContext;
    private final String[] coverageName;
    private final String[] coverageAmount;

    public OverviewCoverageAdapter(Context c,String[]cName, String [] cAmount  ) {
        mContext = c;
        coverageName = cName;
        coverageAmount = cAmount;
    }

    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return coverageName.length;
    }

    @Override
    public Object getItem(int position) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // TODO Auto-generated method stub
        View grid;
        LayoutInflater inflater = (LayoutInflater) mContext
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        if (convertView == null) {


            grid = new View(mContext);
            grid = inflater.inflate(R.layout.coverage_item_list_coverage_layout, null);
            TextView textView = (TextView) grid.findViewById(R.id.grid_item_coverage_name);
            TextView textView1 = (TextView) grid.findViewById(R.id.grid_item_coverage_amount);
           /* CardView card = (CardView)grid.findViewById(R.id.cardView);
            card.setBackgroundResource((R.color.grid_item_color));*/
            textView.setText(coverageName[position].toUpperCase());
            textView1.setText(coverageAmount[position].toUpperCase());

        } else {
            grid = (View) convertView;
        }

        return grid;
    }
}
