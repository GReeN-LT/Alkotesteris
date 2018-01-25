package com.agobal.alkotesteris;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;



public class rezultatai extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rezultatai);

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);



        String BAC = getIntent().getStringExtra("bac");


        TextView textView = findViewById(R.id.TextBac);

        textView.setText(BAC+ " ‰");

       // Log.d("bacRez", BAC);


    }
}
