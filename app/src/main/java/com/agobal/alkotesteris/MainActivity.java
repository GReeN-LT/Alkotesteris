package com.agobal.alkotesteris;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.text.InputFilter;
import android.text.TextUtils;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {


    public RadioGroup radioSexGroup;
    public RadioButton radioSexButton;

    RadioButton radioVyras;
    RadioButton radioMoteris;

    Button skaiciuoti;
    ImageButton prideti;
    ImageButton prideti2;
    ImageButton delete;
    ImageButton delete2;

    double vyras = 0.66;
    double moteris = 0.73;

    double r;
    double BAC = 0;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        prideti2 = findViewById(R.id.plus2);
        delete = findViewById(R.id.minus);
        delete.setVisibility(View.GONE);
        delete2 = findViewById(R.id.minus2);
        delete2.setVisibility(View.GONE);
        prideti2.setVisibility(View.GONE);
        prideti = findViewById(R.id.plus);
        skaiciuoti = findViewById(R.id.skaiciuoti);
        radioVyras = findViewById(R.id.radioVyras);
        radioMoteris = findViewById(R.id.radioMoteris);

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        final EditText svoris = findViewById(R.id.svoris);
        final EditText mililitrai = findViewById(R.id.ml);
        final EditText laipsniai = findViewById(R.id.laipsniai);
        final EditText ml2 = findViewById(R.id.ml2);//
        final EditText laipsniai2 = findViewById(R.id.laipsniai2);//
        final EditText ml3 = findViewById(R.id.ml3);
        final EditText laipsniai3 = findViewById(R.id.laipsniai3);

        nulinimas();
        loadSavedPreferences();

        prideti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText ml2 = findViewById(R.id.ml2);
                EditText laipsniai2 = findViewById(R.id.laipsniai2);

                ml2.setVisibility(View.VISIBLE);
                laipsniai2.setVisibility(View.VISIBLE);
                prideti.setVisibility(View.GONE);
                delete.setVisibility(View.VISIBLE);
                prideti2.setVisibility(View.VISIBLE);
            }
        });

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ml2.setVisibility(View.GONE);
                laipsniai2.setVisibility(View.GONE);

                delete.setVisibility(View.GONE);
                prideti2.setVisibility(View.GONE);
                prideti.setVisibility(View.VISIBLE);
                ml2.setText("0");
                laipsniai2.setText("0");
                nulinimas();

            }
        });


        prideti2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ml3.setVisibility(View.VISIBLE);
                laipsniai3.setVisibility(View.VISIBLE);
                delete.setVisibility(View.GONE);
                delete2.setVisibility(View.VISIBLE);
                prideti2.setVisibility(View.GONE);


            }
        });

        delete2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                delete2.setVisibility(View.GONE);
                prideti2.setVisibility(View.VISIBLE);
                delete.setVisibility(View.VISIBLE);
                ml3.setVisibility(View.GONE);
                laipsniai3.setVisibility(View.GONE);

                ml3.setText("0");
                laipsniai3.setText("0");
                nulinimas();
            }
        });





        skaiciuoti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {

                if(TextUtils.isEmpty(svoris.getText()))
                {
                    Toast.makeText(getApplicationContext(), R.string.Enter_your_weight, Toast.LENGTH_SHORT).show();
                    return;
                }

                if(TextUtils.isEmpty(mililitrai.getText()))
                {
                    Toast.makeText(getApplicationContext(), R.string.Enter_ml, Toast.LENGTH_SHORT).show();
                    return;
                }

                if(TextUtils.isEmpty(laipsniai.getText()))
                {
                    Toast.makeText(getApplicationContext(), R.string.Enter_alco_vol, Toast.LENGTH_SHORT).show();
                    return;
                }



                if(Integer.parseInt(mililitrai.getText().toString()) > 10000 )
                {
                    Toast.makeText(getApplicationContext(), R.string.perdaugml, Toast.LENGTH_SHORT).show();
                    return;
                }

                if(Integer.parseInt(laipsniai.getText().toString()) > 100  )
                {
                    Toast.makeText(getApplicationContext(), R.string.perDaugLaipsniu, Toast.LENGTH_SHORT).show();
                    return;
                }


                if (radioVyras.isChecked()) {
                    r = vyras;
                }
                else if (radioMoteris.isChecked())
                    r = moteris;

                radioSexGroup = findViewById(R.id.RadioSex);
                int selectedId = radioSexGroup.getCheckedRadioButtonId();
                radioSexButton = findViewById(selectedId);


                String kg = svoris.getText().toString();
                double KG = Double.parseDouble(kg);


                String ml = mililitrai.getText().toString();
                String laispniai = laipsniai.getText().toString();

                if (ml.matches("") || laispniai.matches("")) {

                    laispniai = ("0");
                    ml = ("0");
                }

                String ml22 =  ml2.getText().toString();//
                String laipsniai22 = laipsniai2.getText().toString();//

                if (ml22.matches("") || laipsniai22.matches("")) {

                    laipsniai22 = ("0");
                    ml22 = ("0");
                }

                String ml33 = ml3.getText().toString();
                String laipsniai33= laipsniai3.getText().toString();

                if (ml33.matches("") || laipsniai33.matches("")) {

                    laipsniai33 = ("0"); // keist
                    ml33 = ("0"); // keist
                }

                double ML3 = Double.parseDouble(ml33);
                double ML2 = Double.parseDouble(ml22);
                double ML = Double.parseDouble(ml);

                double PROM = Double.parseDouble(laispniai);
                double PROM2 = Double.parseDouble(laipsniai22);//
                double PROM3 = Double.parseDouble(laipsniai33);

                double StandGerimas = ML * PROM * 0.789 / 1000;
                double StandGerimas2 = ML2 * PROM2 * 0.789 /1000;//
                double StandGerimas3 = ML3 * PROM3 * 0.789 /1000;

                double alcoGramai = StandGerimas * 14;
                double alcoGramai2 = StandGerimas2 * 14;//
                double alcoGramai3 = StandGerimas3 * 14;

                double Lbs = KG * 2.2046;

                double alcoGramOz = alcoGramai * 0.0338;
                double alcoGramOz2 = alcoGramai2 * 0.0338;//
                double alcoGramOz3 = alcoGramai3 * 0.0338;

                BAC =  ((alcoGramOz * 5.14 / Lbs * r) *10 ) ;
                BAC = Math.round(BAC*100.0)/100.0;

                double BAC2 = (alcoGramOz2 * 5.14 / Lbs * r) * 10 ;//
                BAC2 = Math.round(BAC2*100.0) / 100.0;//


                double BAC3 = (alcoGramOz3 * 5.14 / Lbs * r) * 10 ;//
                BAC3 = Math.round(BAC3*100.0) / 100.0;//

                BAC = BAC + BAC2 + BAC3;
                String BAC1 = String.valueOf(BAC);

                savePreferences("storedName", svoris.getText().toString());

                Intent intent = new Intent(MainActivity.this, rezultatai.class);
                intent.putExtra("bac",BAC1);
                startActivity(intent);
            }
        });

    }

    private void loadSavedPreferences() {

        SharedPreferences sharedPreferences = PreferenceManager

                .getDefaultSharedPreferences(this);

        String svoris = sharedPreferences.getString("storedName", "");
        EditText Svoris = findViewById(R.id.svoris);
        Svoris.setText(svoris);
    }

    private void savePreferences(String key, String value) {

        SharedPreferences sharedPreferences = PreferenceManager

                .getDefaultSharedPreferences(this);

        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(key, value);
        editor.apply();
    }

    void nulinimas ()
    {

        final EditText ml2 = findViewById(R.id.ml2);//
        final EditText laipsniai2 = findViewById(R.id.laipsniai2);//
        final EditText ml3 = findViewById(R.id.ml3);
        final EditText laipsniai3 = findViewById(R.id.laipsniai3);

        if(Objects.equals(ml2.getText().toString(), "0"))
        {
            ml2.setText("");
        } if(Objects.equals(laipsniai2.getText().toString(), "0"))
    {
        laipsniai2.setText("");
    } if(Objects.equals(ml3.getText().toString(), "0"))
    {
        ml3.setText("");
    } if(Objects.equals(laipsniai3.getText().toString(), "0"))
    {
        laipsniai3.setText("");
    }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();
        if(id == R.id.paremimas)
        {
            Intent intent = new Intent(MainActivity.this, Donate.class);
            startActivity(intent);
        }

        return super.onOptionsItemSelected(item);
    }
}
