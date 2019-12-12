package orixaoracle.potato.app.activities;

import android.content.Intent;

import android.os.Bundle;

import android.view.Gravity;

import android.view.View;

import android.widget.Button;

import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;


import java.util.ArrayList;
import java.util.Calendar;

import orixaoracle.potato.app.Orixas;
import orixaoracle.potato.app.R;


public class MainActivity extends BaseOrixasActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initAddInterstitial();
        TextView commemoration = findViewById(R.id.commemorationday);
        commemoration.setText(getComemorationDay());
        commemoration.setGravity(Gravity.CENTER);
        addCommemorationOrixas();

        TextView week = findViewById(R.id.weekview);
        week.setText(getWeekDayOrixa());


        Button button = findViewById(R.id.button_start);

        button.setText(getString(R.string.startText));
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToStartActivity();
            }
        });


        button = findViewById(R.id.todosorixas);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToAllOrixas();
            }
        });


    }

    public void addCommemorationOrixas() {
        Calendar calendar = Calendar.getInstance();
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        int month = calendar.get(Calendar.MONTH);

        ArrayList<String> results = Orixas.getCommemorationOrixas(day, month);
        if (results.isEmpty())
            return;

        LinearLayout cal = findViewById(R.id.orixasmain);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT, 1.0f);

        params.setMargins(10, 0, 10, 0);

        int size = results.size();

        if (size == 0) {

            //orixascommemoration
            LinearLayout comm = findViewById(R.id.orixascommemoration);
            // cal.setVisibility(View.GONE);
            findViewById(R.id.commemorationday).setVisibility(View.GONE);

            comm.removeView(cal);
            // Changes the height and width to the specified *pixels*

        } else {
            ImageView buzio = findViewById(R.id.buziodate);
            cal.removeView(buzio);
            for (String r : results) {
                //Create two columns to add as table data
                // Create a TextView to add date
                ImageView labelOrixa = new ImageView(this);

                labelOrixa.setId(r.hashCode());

                int id = getBaseContext().getResources().getIdentifier(r.toLowerCase(), "drawable", getBaseContext().getPackageName());
                labelOrixa.setImageResource(id);

                params.gravity = Gravity.CENTER;
                params.width = 350;
                params.height = 350;

                labelOrixa.setLayoutParams(params);
                labelOrixa.setContentDescription(r);


                //Open activity for the Orixa


                labelOrixa.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v) {
                        Intent intent = getClassOrixa(((TextView) v).getText().toString());
                        startActivity(intent);
                    }
                });
                labelOrixa.setOnClickListener(
                        new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Intent intent = getClassOrixa(v.getContentDescription().toString());
                                startActivity(intent);
                            }
                        }
                );
                cal.addView(labelOrixa);

            }

        }

    }

    public String getComemorationDay() {
        Calendar calendar = Calendar.getInstance();
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        int month = calendar.get(Calendar.MONTH);
        String result = getResources().getString(R.string.comemoration);
//
        ArrayList<String> results = Orixas.getCommemorationOrixas(day, month);
        if (results.isEmpty())
            return "";

        StringBuilder orixas = new StringBuilder();
        for (String r : results) {
            if (orixas.length() == 0)
                orixas.append(r);
            else
                orixas.append(", ").append(r);
        }

        return result + orixas;
    }


    public String getWeekDayOrixa() {


        Calendar calendar = Calendar.getInstance();

        int day = calendar.get(Calendar.DAY_OF_WEEK);
        //System.out.println("dia da semana " + day);

        switch (day) {
            case Calendar.SUNDAY:
                return getResources().getString(R.string.domingo);
            case Calendar.MONDAY:
                return getResources().getString(R.string.segunda);
            case Calendar.TUESDAY:
                return getResources().getString(R.string.terca);
            case Calendar.WEDNESDAY:
                return getResources().getString(R.string.quarta);

            case Calendar.THURSDAY:
                return getResources().getString(R.string.quinta);
            case Calendar.FRIDAY:
                return getResources().getString(R.string.sexta);
            case Calendar.SATURDAY:
                return getResources().getString(R.string.sabado);
        }

        return "";
    }


}
