package orixaoracle.potato.app.orixas;

import android.os.Bundle;

import androidx.appcompat.widget.Toolbar;

import orixaoracle.potato.app.activities.BaseOrixasActivity;
import orixaoracle.potato.app.R;

public class Oxala extends BaseOrixasActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_oxala);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


    }
}
