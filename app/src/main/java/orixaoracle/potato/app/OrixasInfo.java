package orixaoracle.potato.app;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import orixaoracle.potato.app.orixas.*;

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
           case R.id.oxumare:
               intentAbout = new Intent(this, Oxumare.class);
               startActivity(intentAbout);
               break;
           case R.id.xango:
               intentAbout = new Intent(this, Xango.class);
               startActivity(intentAbout);
               break;
           case R.id.obaluaie:
               intentAbout = new Intent(this, Obaluaie.class);
               startActivity(intentAbout);
               break;
           case R.id.oxossi:
               intentAbout = new Intent(this, Oxossi.class);
               startActivity(intentAbout);
               break;

           case R.id.ossaim:
               intentAbout = new Intent(this, Ossaim.class);
               startActivity(intentAbout);
               break;

           case R.id.oba:
               intentAbout = new Intent(this, Oba.class);
               startActivity(intentAbout);
               break;

           case R.id.nana:
               intentAbout = new Intent(this, Nana.class);
               startActivity(intentAbout);
               break;
           case R.id.oxum:
               intentAbout = new Intent(this, Oxum.class);
               startActivity(intentAbout);
               break;
           case R.id.yemanja:
               intentAbout = new Intent(this, Iemanja.class);
               startActivity(intentAbout);
               break;


       }

    }
}
