package com.agobal.alkotesteris;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public RadioGroup radioSexGroup;
    public RadioButton radioSexButton;
    //private Button btnDisplay;

    RadioButton radioVyras;
    RadioButton radioMoteris;



    double vyras = 0.73;
    double moteris = 0.66;

    double r;




    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        radioVyras = (RadioButton) findViewById(R.id.radioVyras);
        radioMoteris = (RadioButton) findViewById(R.id.radioMoteris);

        if(radioVyras.isChecked())
        {
            r = vyras;
        }

        else
            r = moteris;

        radioSexGroup = findViewById(R.id.RadioSex);
        //btnDisplay = findViewById(R.id.prideti);



                // get selected radio button from radioGroup
                int selectedId = radioSexGroup.getCheckedRadioButtonId();


                // find the radiobutton by returned id

                radioSexButton = findViewById(selectedId);

        Log.d("ADebugTag", "Value: " + r);

        }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
