package orixaoracle.potato.app;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import orixaoracle.potato.app.orixas.Elegbara;
import orixaoracle.potato.app.orixas.Ogum;

public class OrixasInfo extends AppCompatActivity  implements View.OnClickListener  {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_orixas_info);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


    }




    @Override
    public void onClick(View v) {
        Intent intentAbout;
       switch( v.getId()) {

           case R.id.elegbara:
                intentAbout = new Intent(this, Elegbara.class);
               startActivity(intentAbout);
               break;
           case R.id.ogum:
                intentAbout = new Intent(this, Ogum.class);
               startActivity(intentAbout);
               break;


       }

    }
}
