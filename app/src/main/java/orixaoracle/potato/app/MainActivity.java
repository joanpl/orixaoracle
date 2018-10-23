package orixaoracle.potato.app;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.File;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    private TextView mTextMessage;


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


    }


    private void goToStartActivity() {

        Intent intent = new Intent(this, Perguntas.class);

        startActivity(intent);

    }





}
