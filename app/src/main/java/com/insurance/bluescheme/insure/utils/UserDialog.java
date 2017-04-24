package com.insurance.bluescheme.insure.utils;


import android.app.AlertDialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

import com.insurance.bluescheme.insure.R;

public class UserDialog {
	
	public static void showUserAlert(Context context, String message) {
		System.out.println("inside User com.nevadasoft.ask4wifi.dialog :..." +message);
		LayoutInflater layout_inflater = LayoutInflater.from(context);
		View view = layout_inflater.inflate(R.layout.user_alert_dialog, null);

		AlertDialog.Builder alert_builder = new AlertDialog.Builder(context);
		alert_builder.setView(view);
		final AlertDialog alert = alert_builder.create();

		TextView tvTitle = (TextView) view.findViewById(R.id.idDialogHeader);
		tvTitle.setText("Insure");

		
		TextView tvMessage = (TextView) view.findViewById(R.id.idAlertMessage);
		tvMessage.setText(message);
		
		Button btnConfirm = (Button) view.findViewById(R.id.idConfirm);
		btnConfirm.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				alert.cancel();
			}
		});

		alert.show();

	}

}
