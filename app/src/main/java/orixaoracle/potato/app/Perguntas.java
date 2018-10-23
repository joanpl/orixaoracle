package orixaoracle.potato.app;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

public class Perguntas extends AppCompatActivity {


    private HashMap<String, Boolean> respostas;
    private Oracle myOracle;
    //private ArrayList<String> caracteristicas;
    private int counter = 0;
    private int maxCounter;
    TextView mPergunta;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perguntas);
        myOracle = new Oracle();
        respostas = new HashMap<>();


        mPergunta = (TextView) findViewById(R.id.caracteristica);

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



    }

    private void sayYeah(boolean answer) {
       myOracle.setAnswer(answer);

       String next= myOracle.getNext();

       if(!next.isEmpty()){
            mPergunta.setText(next);
        }
        else {
            Intent intent = new Intent(this, Results.class);
            intent.putExtra("ANSWERS", myOracle.getResults());
            startActivity(intent);

        }

    }

}
