package orixaoracle.potato.app;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;

import java.io.IOException;
import java.io.InputStream;

import java.util.HashMap;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

public class Perguntas extends AppCompatActivity {


    private HashMap<String, Boolean> respostas;
    private Oracle myOracle;
    private AdView mAdView;

    private int count =0;

    private TextView mPergunta;
    private OrixaDB db;
    private InterstitialAd mInterstitialAd;
    private Intent intent;
private ProgressBar progressBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perguntas);
        try {

            InputStream inputStream = getResources().getAssets().open("orixas_caracteristica.csv");
            db = new OrixaDB( inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        myOracle = new Oracle(db);
        respostas = new HashMap<>();
        intent = new Intent(this, Results.class);

        mPergunta = (TextView) findViewById(R.id.caracteristica);

        progressBar = (ProgressBar) findViewById(R.id.progressBar);
        progressBar.setMax(myOracle.getMaxQuestions());
        progressBar.setIndeterminate(false);



        mPergunta.setText(myOracle.getNext()); // if it's empty i need to figure out what to show.

        Button buttonYes = (Button) findViewById(R.id.sim);
        buttonYes.setText("Sim");

        Button buttonNo = (Button) findViewById(R.id.nao);
        buttonNo.setText("Nao");

        buttonYes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sayYeah(true);
            }
        } );

        buttonNo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sayYeah(false);
            }
        } );

        // Sample AdMob app ID: ca-app-pub-8764007559480750~7390517978
        MobileAds.initialize(this, "ca-app-pub-8764007559480750~7390517978");


        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();

        mInterstitialAd = new InterstitialAd(this);
        if(MainActivity.DEBUG) {
            mInterstitialAd.setAdUnitId(MainActivity.TEST_AD);
            mAdView.setAdUnitId(MainActivity.TEST_AD);
        }
        else {
            mInterstitialAd.setAdUnitId(MainActivity.REAL_AD2);
        }


        mInterstitialAd.setAdListener(new AdListener() {
            @Override
            public void onAdLoaded() {
                // Code to be executed when an ad finishes loading.
            }

            @Override
            public void onAdFailedToLoad(int errorCode) {

            }

            @Override
            public void onAdOpened() {
                // Code to be executed when the ad is displayed.
            }

            @Override
            public void onAdLeftApplication() {
                // Code to be executed when the user has left the app.
            }

            @Override
            public void onAdClosed() {
                startActivity(intent);
            }
        });


        mAdView.loadAd(adRequest);
        mInterstitialAd.loadAd(new AdRequest.Builder().build());



    }

    private void sayYeah(boolean answer) {
       myOracle.setAnswer(answer);

       String next= myOracle.getNext();
        this.count++;
        if((count % 10)==0)
            mAdView.loadAd( new AdRequest.Builder().build());
       if(!next.isEmpty()){
            mPergunta.setText(next);
           progressBar.setProgress(myOracle.getCurrentQuestion());

        }
        else {

            intent.putExtra("ANSWERS", myOracle.getResults());


           intent.putExtra("ANSWERSGRID", myOracle.getResultsArray());

           if (mInterstitialAd.isLoaded()) {
               mInterstitialAd.show();
           } else {
               Log.d("TAG", "The interstitial wasn't loaded yet.");
           }

           startActivity(intent);
        }

    }

}
