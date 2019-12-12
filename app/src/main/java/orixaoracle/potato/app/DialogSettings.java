package orixaoracle.potato.app;

import android.app.Activity;
import android.app.Dialog;

import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.RadioButton;

import orixaoracle.potato.app.activities.PerguntasActivity;


public class DialogSettings extends Dialog implements
        android.view.View.OnClickListener  {

    private Activity activity;
    private int lvl = 2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_dialog_settings);


        Button btnYes = findViewById(R.id.continue_perguntas);
        btnYes.setOnClickListener(this);
    }


    public DialogSettings(Activity activity) {
        super(activity);
        this.activity = activity;
    }


    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.continue_perguntas) {
            RadioButton simples = findViewById(R.id.simples);
            RadioButton normal = findViewById(R.id.normal);
            if (simples.isChecked()) {
                ((PerguntasActivity) activity).setLevel(0);
            } else if (normal.isChecked()) {
                ((PerguntasActivity) activity).setLevel(1);
                //  activity.finish();
            } else {
                ((PerguntasActivity) activity).setLevel(2);
            }
        }

        dismiss();
    }
}
