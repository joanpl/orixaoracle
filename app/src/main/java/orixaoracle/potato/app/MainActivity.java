package orixaoracle.potato.app;

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


public class MainActivity extends BaseOrixasActivity {





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initAddInterstitial();
        TextView commemoration =findViewById(R.id.commemorationday);
        commemoration.setText(getComemorationDay());
        commemoration.setGravity(Gravity.CENTER);
        addCommemorationOrixas();

        TextView week =findViewById(R.id.weekview);
        week.setText( getWeekDayOrixa () );


        Button button = (Button) findViewById(R.id.button_start);

        button.setText("Iniciar");
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToStartActivity();
            }
        } );


        button = (Button) findViewById(R.id.todosorixas);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToAllOrixas();
            }
        } );





    }

    public void addCommemorationOrixas() {
        Calendar calendar = Calendar.getInstance();
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        int month = calendar.get(Calendar.MONTH);

        ArrayList<String> results = Orixas.getCommemorationOrixas(day, month) ;
        if(results.isEmpty())
            return;

        LinearLayout cal = findViewById(R.id.orixasmain);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT, 1.0f);

        params.setMargins(10, 0, 10, 0);

        int size = results.size();

        if(size==0){

            //orixascommemoration
            LinearLayout comm=  findViewById(R.id.orixascommemoration);
           // cal.setVisibility(View.GONE);
            findViewById(R.id.commemorationday).setVisibility(View.GONE);

            comm.removeView(cal);
            // Changes the height and width to the specified *pixels*

            return;
        }


        else {
            ImageView buzio = findViewById( R.id.buziodate);
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
        ArrayList<String> results = Orixas.getCommemorationOrixas(day, month) ;
        if(results.isEmpty())
            return "";

        String orixas= "";
        for (String r : results) {
            if(orixas.isEmpty())
             orixas += r ;
            else
                orixas += ", " +r ;
        }

        return result + orixas;
    }


    public String getWeekDayOrixa () {


        Integer daysArray[] = { Calendar.MONDAY, Calendar.TUESDAY, Calendar.WEDNESDAY, Calendar.THURSDAY,
              Calendar.FRIDAY, Calendar.SATURDAY,Calendar.SUNDAY};

        Calendar calendar = Calendar.getInstance();

        Integer day = calendar.get(Calendar.DAY_OF_WEEK);
        //System.out.println("dia da semana " + day);
        String weekMessage = "";

        switch (day) {
            case Calendar.SUNDAY:
                weekMessage = getResources().getString(R.string.domingo);
                break;
            case Calendar.MONDAY:
                weekMessage = getResources().getString(R.string.segunda);
                break;
            case Calendar.TUESDAY:
                weekMessage = getResources().getString(R.string.terca);
                break;
            case Calendar.WEDNESDAY:
                weekMessage = getResources().getString(R.string.quarta);
                break;

            case Calendar.THURSDAY:
                weekMessage = getResources().getString(R.string.quinta);
                break;
            case Calendar.FRIDAY:
                weekMessage = getResources().getString(R.string.sexta);
                break;
            case Calendar.SATURDAY:
                weekMessage = getResources().getString(R.string.sabado);
                break;


        }

        return weekMessage;
    }






}
