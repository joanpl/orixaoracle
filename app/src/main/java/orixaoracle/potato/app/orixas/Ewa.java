package orixaoracle.potato.app.orixas;

import android.os.Bundle;

import androidx.appcompat.widget.Toolbar;

import orixaoracle.potato.app.activities.BaseOrixasActivity;
import orixaoracle.potato.app.R;

public class Ewa extends BaseOrixasActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ewa);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


    }
}
