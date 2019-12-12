package orixaoracle.potato.app.activities;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;

import java.io.IOException;
import java.io.InputStream;

import orixaoracle.potato.app.DialogSettings;
import orixaoracle.potato.app.Oracle;
import orixaoracle.potato.app.OrixaDB;
import orixaoracle.potato.app.R;

public class PerguntasActivity extends BaseOrixasActivity {


    private Oracle myOracle;
    private AdView mAdView;

    private int count =0;

    private TextView mPergunta;
    private OrixaDB db;
    private InterstitialAd mInterstitialAd2;
    private Intent intentResults;
    private ProgressBar progressBar;



    private void setUpOracle(){


        try {

            InputStream inputStream = getResources().getAssets().open("orixas_caracteristica.csv");
            db = new OrixaDB( inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        myOracle = new Oracle(db);


        Button buttonYes = findViewById(R.id.sim);
        buttonYes.setText(getString(R.string.yes));

        Button buttonNo = findViewById(R.id.nao);
        buttonNo.setText(getString(R.string.no));

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

    }


    private void setUpAds() {



        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {}
        });
        //  MobileAds.initialize(this, "ca-app-pub-8764007559480750~7390517978");
        mInterstitialAd2 = new InterstitialAd(this);

        mAdView = findViewById(R.id.adView);
        mInterstitialAd2 = new InterstitialAd(this);

       // mAdView.setAdUnitId(AD_BANNER_PERGUNTAS); in XML

        mInterstitialAd2.setAdUnitId(REAL_AD2);
        mInterstitialAd2.setAdListener(new AdListener() {
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
                startActivity(intentResults);
            }
        });


        mAdView.loadAd( new AdRequest.Builder().build());
        mInterstitialAd2.loadAd(new AdRequest.Builder().build());


    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perguntas);
        intentResults = new Intent(this, ResultsActivity.class);
        setUpAds();
        setUpOracle();
        showDialog();

    }

    public void setLevel(int lvl) {
        if (myOracle == null) {
            setUpOracle();
        }
        myOracle.setLevel(lvl);

    }

   private void showDialog() {
       DialogSettings customDialog = new DialogSettings(PerguntasActivity.this);
      // customDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
       customDialog.show();
       customDialog.setOnDismissListener(new DialogInterface.OnDismissListener() {
           @Override
           public void onDismiss(final DialogInterface dialogInterface) {
               progressBar = PerguntasActivity.this.findViewById(R.id.progressBar);
               progressBar.setMax(myOracle.getMaxQuestions());
               progressBar.setIndeterminate(false);
               mPergunta = PerguntasActivity.this.findViewById(R.id.caracteristica);
               mPergunta.setText(myOracle.getNext()); // if it's empty i need to figure out what to show.
           }
       });
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


            intentResults.putExtra("ANSWERS", myOracle.getResults());


           intentResults.putExtra("ANSWERSGRID", myOracle.getResultsArray());

           if (mInterstitialAd2.isLoaded()) {
               mInterstitialAd2.show();
           } else {
               Log.d("TAG", "The interstitial wasn't loaded yet.");
               startActivity(intentResults);
           }
        //   startActivity(intentResults);

        }

    }

}
