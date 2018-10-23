package orixaoracle.potato.app;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Results extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);

        Intent intent = getIntent();

        String answers = intent.getStringExtra("ANSWERS");
        TextView mResultado = (TextView) findViewById(R.id.resultados);
        mResultado.setText(answers);


        Button button = (Button) findViewById(R.id.repetir);



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




