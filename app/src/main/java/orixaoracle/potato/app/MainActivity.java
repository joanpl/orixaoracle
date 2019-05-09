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

public class MainActivity extends AppCompatActivity {


    private InterstitialAd mInterstitialAd;


    public static final String TEST_AD ="ca-app-pub-3940256099942544/1033173712";
    public static final String REAL_AD1 ="ca-app-pub-8764007559480750/4687444962";


    public static final String REAL_AD2 ="ca-app-pub-8764007559480750/8045800119";

    public static final boolean DEBUG =false;
    private Intent intent;
    private Intent intentAbout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        File rootDataDir = getFilesDir();

        Button button = (Button) findViewById(R.id.button_start);

        button.setText("Iniciar");

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToStartActivity();
            }
        } );




        // Sample AdMob app ID: ca-app-pub-8764007559480750~7390517978
        MobileAds.initialize(this, "ca-app-pub-8764007559480750~7390517978");
        mInterstitialAd = new InterstitialAd(this);
        if(DEBUG)
            mInterstitialAd.setAdUnitId(TEST_AD);
        else
            mInterstitialAd.setAdUnitId(REAL_AD1);



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


        mInterstitialAd.loadAd(new AdRequest.Builder().build());
    }


    private void goToStartActivity() {

        if (mInterstitialAd.isLoaded()) {
            mInterstitialAd.show();
        } else {
            Log.d("TAG", "The interstitial wasn't loaded yet.");
        }
        intent = new Intent(this, Perguntas.class);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menuorixas, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id){
            case R.id.aboutus:
               // Toast.makeText(getApplicationContext(),"Item 1 Selected",Toast.LENGTH_LONG).show();
               intentAbout = new Intent(this, FullscreenActivityAbout.class);
                startActivity(intentAbout);
                return true;
            case R.id.contactus:
              //  Toast.makeText(getApplicationContext(),"Item 2 Selected",Toast.LENGTH_LONG).show();

                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("plain/text");
                intent.putExtra(Intent.EXTRA_EMAIL, new String[] { "orixa@potato-corp.com" });
                intent.putExtra(Intent.EXTRA_SUBJECT, "[Pedido de Funcionalidade]");
                intent.putExtra(Intent.EXTRA_TEXT, "Funcionalidade");
                startActivity(Intent.createChooser(intent, ""));
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }



}
