package orixaoracle.potato.app;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.widget.Toolbar;

import android.view.View;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;

import orixaoracle.potato.app.orixas.*;

public class OrixasInfo extends BaseOrixasActivity  implements View.OnClickListener  {

    private AdView mAdView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_orixas_info);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);



        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });
        mAdView = findViewById(R.id.bannerorixas);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

    }

private void loadBanner() {

    mAdView.loadAd(new AdRequest.Builder().build());
}


    @Override
    public void onClick(View v) {
        Intent intentAbout;
        loadBanner();
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
           case R.id.ewa:
               intentAbout = new Intent(this, Ewa.class);
               startActivity(intentAbout);
               break;
           case R.id.iansa:
               intentAbout = new Intent(this, Iansa.class);
               startActivity(intentAbout);
               break;
           case R.id.tempo:
               intentAbout = new Intent(this, Tempo.class);
               startActivity(intentAbout);
               break;
           case R.id.ifa:
               intentAbout = new Intent(this, Ifa.class);
               startActivity(intentAbout);
               break;
           case R.id.oxala:
               intentAbout = new Intent(this, Oxala.class);
               startActivity(intentAbout);
               break;




       }

    }
}
