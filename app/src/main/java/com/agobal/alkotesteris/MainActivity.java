package com.agobal.alkotesteris;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    // TODO: vyr moter kofai blogai rodo

    public RadioGroup radioSexGroup;
    public RadioButton radioSexButton;
    //private Button btnDisplay;

    RadioButton radioVyras;
    RadioButton radioMoteris;

    Button skaiciuoti;
    Button prideti;


    double vyras = 0.66;
    double moteris = 0.73;
    double r;
    double BAC = 0;

   // public static final String BAC1= "BAC";
   // private static final int REQUEST_RESPONSE = 1;


    int valandos;






    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //viskas buttone


        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);



        prideti = findViewById(R.id.prideti);
        prideti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText ml2 = findViewById(R.id.ml2);
                EditText laipsniai2 = findViewById(R.id.laipsniai2);

                ml2.setVisibility(View.VISIBLE);
                laipsniai2.setVisibility(View.VISIBLE);

                prideti.setVisibility(View.GONE);
            }
        });


        skaiciuoti = findViewById(R.id.skaiciuoti);
        skaiciuoti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {

                radioVyras = findViewById(R.id.radioVyras);
                radioMoteris = findViewById(R.id.radioMoteris);

                if (radioVyras.isChecked()) {
                    r = vyras;
                } else if (radioMoteris.isChecked())
                    r = moteris;

                radioSexGroup = findViewById(R.id.RadioSex);

                // get selected radio button from radioGroup
                int selectedId = radioSexGroup.getCheckedRadioButtonId();
                // find the radiobutton by returned id
                radioSexButton = findViewById(selectedId);




                EditText svoris = findViewById(R.id.svoris);
                String kg = svoris.getText().toString();

                double KG = Double.parseDouble(kg);

                Log.d("svoris" , String.valueOf(KG));


                EditText mililitrai = findViewById(R.id.ml);
                String ml = mililitrai.getText().toString();


                EditText ml2 = findViewById(R.id.ml2);//
                String ml22 =  ml2.getText().toString();//

                double ML2 = Double.parseDouble(ml22);  // militrai 2


                double ML = Double.parseDouble(ml);

                Log.d("ML" , String.valueOf(ML));

                EditText laipsniai = findViewById(R.id.laipsniai);

                String laispniai = laipsniai.getText().toString();

                EditText laipsniai2 = findViewById(R.id.laipsniai2);//
                String laipsniai22 = laipsniai2.getText().toString();//


                double PROM = Double.parseDouble(laispniai);
                double PROM2 = Double.parseDouble(laipsniai22);//

                Log.d("PROM" , String.valueOf(PROM));



                double StandGerimas = ML * PROM * 0.789 / 1000;
                double StandGerimas2 = ML2 * PROM2 * 0.789 /1000;//

                Log.d("sG", String.valueOf(StandGerimas));


                double alcoGramai = StandGerimas * 14;
                double alcoGramai2 = StandGerimas2 * 14;//

                //konvertavimas

                double Lbs = KG * 2.2046;

                double alcoGramOz = alcoGramai * 0.0338;
                double alcoGramOz2 = alcoGramai2 * 0.0338;//




                BAC =  (alcoGramOz * 5.14 / Lbs * r) *10 ;
                BAC = Math.round(BAC*100.0)/100.0;

                double BAC2 = (alcoGramOz2 * 5.14 / Lbs * r) * 10 ;//
                BAC2 = Math.round(BAC2*100.0) / 100.0;//

                BAC = BAC2 + BAC;
                String BAC1 = String.valueOf(BAC);



        //        Log.d("bac", String.valueOf(BAC));


                Intent intent = new Intent(MainActivity.this, rezultatai.class);

                intent.putExtra("bac",BAC1);
                startActivity(intent);
            }
        });










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
