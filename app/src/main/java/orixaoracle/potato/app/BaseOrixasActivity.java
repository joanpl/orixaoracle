package orixaoracle.potato.app;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;

import orixaoracle.potato.app.orixas.Elegbara;
import orixaoracle.potato.app.orixas.Ewa;
import orixaoracle.potato.app.orixas.Iansa;
import orixaoracle.potato.app.orixas.Iemanja;
import orixaoracle.potato.app.orixas.Ifa;
import orixaoracle.potato.app.orixas.Nana;
import orixaoracle.potato.app.orixas.Oba;
import orixaoracle.potato.app.orixas.Obaluaie;
import orixaoracle.potato.app.orixas.Ogum;
import orixaoracle.potato.app.orixas.Ossaim;
import orixaoracle.potato.app.orixas.Oxala;
import orixaoracle.potato.app.orixas.Oxossi;
import orixaoracle.potato.app.orixas.Oxum;
import orixaoracle.potato.app.orixas.Oxumare;
import orixaoracle.potato.app.orixas.Tempo;
import orixaoracle.potato.app.orixas.Xango;

public class BaseOrixasActivity extends AppCompatActivity {

    private InterstitialAd mInterstitialAd;

    private Intent intent;

    public static final String TEST_AD ="ca-app-pub-3940256099942544/1033173712"; //

    public static final String REAL_AD1 ="ca-app-pub-8764007559480750/4687444962"; //beforeResults interstitial

    public static final String TEST_AD_BANNER ="ca-app-pub-3940256099942544/6300978111";

    public static final String AD_BANNER_PERGUNTAS = "ca-app-pub-8764007559480750/5909584147"; //no proprio xml

    public static final String REAL_AD2 ="ca-app-pub-8764007559480750/8045800119"; // results interstitial: ca-app-pub-8764007559480750/8045800119
    public static final String REAL_AD3 ="ca-app-pub-8764007559480750/8473249873"; // before orixa: ca-app-pub-8764007559480750/8473249873



    public static final boolean DEBUG =false;
    private boolean shouldLoadAds = true;


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

    @Override
    public void onStart() {
        super.onStart();
        shouldLoadAds= true;
    }

    @Override
    public void onStop() {
        shouldLoadAds= false;
        super.onStop();
    }
    public void goToAllOrixas() {
        intent = new Intent(this, OrixasInfo.class);
        loadShowInterstitial();
        startActivity(intent);

    }
    public void goToStartActivity() {

        intent = new Intent(this, Perguntas.class);

        loadShowInterstitial();
        startActivity(intent);


    }

    public void loadShowInterstitial() {

        if (mInterstitialAd.isLoaded() && shouldLoadAds) {
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
        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {}
        });
      //  MobileAds.initialize(this, "ca-app-pub-8764007559480750~7390517978");
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
                if (DEBUG)
                    System.out.println("Failed to load, error code: " + errorCode);
                startActivity(intent);
            }
            @Override
            public void onAdLoaded() {

                if (DEBUG)
                    System.out.println("Ad Loaded");
               // mInterstitialAd.show();
            }
            @Override
            public void onAdClosed() {
                super.onAdClosed();
                if(shouldLoadAds) { //load the ad only if shouldLoadAds == true
                    mInterstitialAd .loadAd(new AdRequest.Builder().build());
                }

                startActivity(intent);
            }
        });
        mInterstitialAd.loadAd(new AdRequest.Builder().build());
    }

    protected Intent getClassOrixa (String orixa) {
        Intent intent = new Intent(this, Elegbara.class);
        switch (orixa) {
            case Orixas.ELEGBARA:
                intent = new Intent(this, Elegbara.class);

                break;
            case Orixas.OGUM:
                intent = new Intent(this, Ogum.class);

                break;
            case Orixas.OXUMARE:
                intent = new Intent(this, Oxumare.class);

                break;
            case  Orixas.XANGO:
                intent = new Intent(this, Xango.class);

                break;
            case  Orixas.OBALUAIE:
                intent = new Intent(this, Obaluaie.class);

                break;
            case  Orixas.OXOSSI:
                intent = new Intent(this, Oxossi.class);

                break;

            case Orixas.OSSAIM:
                intent = new Intent(this, Ossaim.class);

                break;

            case Orixas.OBA:
                intent = new Intent(this, Oba.class);
                break;

            case Orixas.NANA:
                intent = new Intent(this, Nana.class);
                break;
            case  Orixas.OXUM:
                intent = new Intent(this, Oxum.class);
                break;
            case  Orixas.YEMANJA:
                intent = new Intent(this, Iemanja.class);
                break;
            case  Orixas.EWA:
                intent = new Intent(this, Ewa.class);
                break;
            case  Orixas.IANSA:
                intent = new Intent(this, Iansa.class);

                break;
            case Orixas.TEMPO:
                intent = new Intent(this, Tempo.class);

                break;
            case  Orixas.IFA:
                intent = new Intent(this, Ifa.class);

                break;
            case  Orixas.OXALA:
                intent = new Intent(this, Oxala.class);

                break;


        }
        return intent;

    }

}
