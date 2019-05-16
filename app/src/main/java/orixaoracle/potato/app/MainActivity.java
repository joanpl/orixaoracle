package orixaoracle.potato.app;

import android.content.Intent;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.util.Log;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import android.widget.CalendarView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.util.ArrayList;
import java.util.Calendar;


public class MainActivity extends BaseOrixasActivity {





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView commemoration =findViewById(R.id.commemorationday);
        commemoration.setText(getComemorationDay());
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

        initAddInterstitial();



    }

    public void addCommemorationOrixas() {
        Calendar calendar = Calendar.getInstance();
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        int month = calendar.get(Calendar.MONTH);
       // String result = getResources().getString(R.string.comemoration);

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
            cal.setVisibility(View.GONE);
            findViewById(R.id.commemorationday).setVisibility(View.GONE);

            comm.removeView(cal);
// Changes the height and width to the specified *pixels*

            return;
        }



        for (String r : results) {
            //Create two columns to add as table data
            // Create a TextView to add date
            ImageView labelOrixa = new ImageView(this);

            labelOrixa.setId(r.hashCode());

            int id = getBaseContext().getResources().getIdentifier(r.toLowerCase(), "drawable", getBaseContext().getPackageName());
            labelOrixa.setImageResource(id);

            params.gravity = Gravity.CENTER;
            labelOrixa.setLayoutParams(params);
            labelOrixa.setContentDescription(r);

            labelOrixa.setMaxHeight(cal.getHeight());


            //Open activity for the Orixa


            labelOrixa.setOnClickListener(new View.OnClickListener(){
                public void onClick(View v){
                    Intent intent = getClassOrixa(((TextView)v).getText().toString());
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

    public String getComemorationDay() {
        Calendar calendar = Calendar.getInstance();
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        int month = calendar.get(Calendar.MONTH);
        String result = getResources().getString(R.string.comemoration);
//
//        ArrayList<String> results = Orixas.getCommemorationOrixas(day, month) ;
//        if(results.isEmpty())
//            return "";
//
//        for (String r : results) {
//            result += r + "\n";
//
//        }
//
        return result;
    }


    public String getWeekDayOrixa () {


        String daysArray[] = { "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday","Sunday"};

        Calendar calendar = Calendar.getInstance();
        calendar.setFirstDayOfWeek(Calendar.MONDAY);
        int day = calendar.get(Calendar.DAY_OF_WEEK);
        String weekMessage = "";

        switch (daysArray[day-1]) {
            case "Sunday":
                weekMessage = getResources().getString(R.string.domingo);
                break;
            case "Monday":
                weekMessage = getResources().getString(R.string.segunda);
                break;
            case "Tuesday":
                weekMessage = getResources().getString(R.string.terca);
                break;
            case "Wednesday":
                weekMessage = getResources().getString(R.string.quarta);
                break;

            case "Thursday":
                weekMessage = getResources().getString(R.string.quinta);
                break;
            case "Friday":
                weekMessage = getResources().getString(R.string.sexta);
                break;
            case "Saturday":
                weekMessage = getResources().getString(R.string.sabado);
                break;


        }

        return weekMessage;
    }






}
