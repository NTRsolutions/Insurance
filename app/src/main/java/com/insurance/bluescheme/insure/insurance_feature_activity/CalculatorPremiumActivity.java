package com.insurance.bluescheme.insure.insurance_feature_activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.insurance.bluescheme.insure.R;

/**
 * Created by tonmoybarua on 28-Mar-17.
 */

public class CalculatorPremiumActivity extends AppCompatActivity {
    RadioButton mRadioButton;
    SeekBar mSeekBar;
    Button mButton;
    TextView seekBarTxv;
    int seekminValue, seekMaxValue= 2000, step;
    boolean radioButtonSelect = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calculate_premium_activity_layout);
        Toolbar myToolbar = (Toolbar) findViewById(R.id.tool_bar_in_calculate_premium_page);
        myToolbar.setTitle("Calculate Premium");
        setSupportActionBar(myToolbar);
        myToolbar.setTitleTextColor(getResources().getColor(com.insurance.bluescheme.insure.R.color.big_text_color));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        mRadioButton =(RadioButton)findViewById(R.id.radio_button_premium);
        mButton = (Button)findViewById(R.id.process_button_premimum_page);
        mSeekBar = (SeekBar)findViewById(R.id.amount_seek_bar_in_premium_page);
        seekBarTxv = (TextView)findViewById(R.id.amount_seek_bar_value);
        mSeekBar.setClickable(true);
        seekminValue = 2000/5;
        step = (seekMaxValue-seekminValue)/5;
        mSeekBar.incrementProgressBy(seekminValue);
        seekBarTxv.setText(String.valueOf(seekminValue));
        mSeekBar.setMax(seekMaxValue-seekminValue);
        mSeekBar.setProgress(seekminValue);
        mSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                Log.e("progress", String.valueOf(progress));
                    progress = progress / seekminValue;
                    progress = progress * seekminValue;
                    seekBarTxv.setText(String.valueOf(progress+seekminValue));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {}
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {}
        });

        mRadioButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                radioButtonSelect = mRadioButton.isChecked();
            }
        });
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    startActivity(new Intent(CalculatorPremiumActivity.this, CalCulateYearTermsActivity.class));
                }

        });
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}

