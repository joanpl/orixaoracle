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

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;

import java.io.File;

public class BaseOrixasActivity extends AppCompatActivity {

    private InterstitialAd mInterstitialAd;

    private Intent intent;

    public static final String TEST_AD ="ca-app-pub-3940256099942544/1033173712";
    public static final String REAL_AD1 ="ca-app-pub-8764007559480750/4687444962";
    public static final String TEST_AD_BANNER ="ca-app-pub-3940256099942544/6300978111";



    public static final String REAL_AD2 ="ca-app-pub-8764007559480750/8045800119";
    public static final String REAL_AD3 ="ca-app-pub-8764007559480750/8473249873";



    public static final boolean DEBUG =false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initAddInterstitial();
    }

    public Intent getIntentResult() {
        return this.intent;
    }

    public  void setIntentResult (Intent setIntent) {
        this.intent = setIntent;
    }


    public void goToAllOrixas() {
        intent = new Intent(this, OrixasInfo.class);
        loadShowInterstitial();
   //     startActivity(intent);

    }
    public void goToStartActivity() {

        intent = new Intent(this, Perguntas.class);
        loadShowInterstitial();
//        startActivity(getIntent());


    }

    public void loadShowInterstitial() {

        if (mInterstitialAd.isLoaded()) {
            mInterstitialAd.show();
        } else {
            Log.d("TAG", "The interstitial wasn't loaded yet.");
            //  Toast.makeText(getApplicationContext(),"Ad Loaded", Toast.LENGTH_SHORT).show();
        }
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
                Intent intentAbout = new Intent(this, FullscreenActivityAbout.class);
                startActivity(intentAbout);
                return true;

            case R.id.startquestions:

                goToStartActivity();
                return true;
            case R.id.orixasinfo:

                goToAllOrixas();
                return true;
            case R.id.contactus:


                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("plain/text");
                intent.putExtra(Intent.EXTRA_EMAIL, new String[] { "orixa@potato-corp.com" });
                intent.putExtra(Intent.EXTRA_SUBJECT, "[Pedido de Funcionalidade]");
                intent.putExtra(Intent.EXTRA_TEXT, "Funcionalidade");
                startActivity(Intent.createChooser(intent, ""));
                Toast.makeText(getApplicationContext(),"Obrigada pelo seu contacto.",Toast.LENGTH_LONG).show();
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void initAddInterstitial() {
        // Sample AdMob app ID: ca-app-pub-8764007559480750~7390517978
        MobileAds.initialize(this, "ca-app-pub-8764007559480750~7390517978");
        mInterstitialAd = new InterstitialAd(this);
        if(DEBUG) {
            mInterstitialAd.setAdUnitId(TEST_AD);

        }
        else {
            mInterstitialAd.setAdUnitId(REAL_AD1);

        }

        mInterstitialAd.setAdListener(new AdListener() {
            @Override
            public void onAdFailedToLoad(int errorCode) {
                startActivity(intent);
            }
            @Override
            public void onAdLoaded() {

               // mInterstitialAd.show();
            }
            @Override
            public void onAdClosed() {
                startActivity(intent);
            }
        });
        mInterstitialAd.loadAd(new AdRequest.Builder().build());
    }


}
