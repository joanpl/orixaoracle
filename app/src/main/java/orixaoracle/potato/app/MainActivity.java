package orixaoracle.potato.app;

import android.content.Intent;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import android.widget.Toast;

import java.io.File;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.InterstitialAd;

import com.google.android.gms.ads.AdRequest;

public class MainActivity extends BaseOrixasActivity {





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



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









}
