package com.agobal.alkotesteris;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class rezultatai extends AppCompatActivity {


    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rezultatai);

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        String BAC = getIntent().getStringExtra("bac");
        Double BAC0h = Double.parseDouble(BAC);

        TextView textView = findViewById(R.id.TextBac);
        textView.setText(BAC + " ‰");

        TextView textView1h = findViewById(R.id.textView1h);
        TextView textView2h = findViewById(R.id.textView2h);
        TextView textView4h = findViewById(R.id.textView4h);
        TextView textView8h = findViewById(R.id.textView8h);

        TextView textViewprom1 = findViewById(R.id.textViewNow5);
        TextView textViewprom2 = findViewById(R.id.textViewNow4);
        TextView textViewprom3 = findViewById(R.id.textViewNow3);

        TextView textView2ht = findViewById(R.id.textView2ht);
        TextView textView4ht = findViewById(R.id.textView4ht);
        TextView textView8ht = findViewById(R.id.textView8ht);

        TextView textViewNow = findViewById(R.id.textViewNow);

        double BACh = Double.parseDouble(BAC);
        BACh = BACh - 0.15 * 1;

        BACh = Math.round(BACh * 100.0) / 100.0;

        if (BACh <= 0) {
            textView1h.setText(String.valueOf(0));
        }

        else
        {
            String BAC1h = String.valueOf(BACh);
            textView1h.setText(BAC1h);
        }

        //---------------------------

        double BAC2h = Double.parseDouble(BAC);
        BAC2h = BAC2h - 0.15 * 2;

        BAC2h = Math.round(BAC2h * 100.0) / 100.0;

        if (BAC2h <= 0) {
            textView2h.setText(String.valueOf(0));
        }
        else
        {
            String BAC22h = String.valueOf(BAC2h);
            textView2h.setText(BAC22h);
        }

        if(BACh <= 0 && BAC2h <=0)
        {
            textView2h.setVisibility(View.GONE);
            textView2ht.setVisibility(View.GONE);
            textViewprom1.setVisibility(View.GONE);


        }
//-----------------------------------------
        double BAC4h = Double.parseDouble(BAC);
        BAC4h = BAC4h - 0.15 * 4;

        BAC4h = Math.round(BAC4h * 100.0) / 100.0;
        if (BAC4h <= 0)
        {
            textView4h.setText(String.valueOf(0));
        }

        else
        {
            String BAC44h = String.valueOf(BAC4h);
            textView4h.setText(BAC44h);
        }

        if(BAC2h <= 0 && BAC4h <=0)
        {
            textView4h.setVisibility(View.GONE);
            textView4ht.setVisibility(View.GONE);
            textViewprom2.setVisibility(View.GONE);
        }
//-------------------------------
        double BAC8h = Double.parseDouble(BAC);
        BAC8h = BAC8h - 0.15 * 8;
        BAC8h = Math.round(BAC8h * 100.0) / 100.0;

        if (BAC8h <= 0) {
            textView8h.setText(String.valueOf(0));
        }

        else
        {
            String BAC88h = String.valueOf(BAC8h);
            textView8h.setText(BAC88h);
        }

        if(BAC4h <= 0 && BAC8h <=0)
        {
            textView8h.setVisibility(View.GONE);
            textView8ht.setVisibility(View.GONE);
            textViewprom3.setVisibility(View.GONE);
        }
        //---------------


        int bac0h = 0;
        while(BAC0h > 0)
        {
            BAC0h = BAC0h - 0.15;
            bac0h++;
        }
        String bacNow = String.valueOf(bac0h);

        textViewNow.setText (String.valueOf(bacNow));
    }
}
