package orixaoracle.potato.orixaoracle;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

public class Perguntas extends AppCompatActivity {


    private HashMap<String, Boolean> respostas;
    private Oracle myOracle;
    private ArrayList<String> caracteristicas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perguntas);
        myOracle = new Oracle();
        respostas = new HashMap<>();

        caracteristicas = new ArrayList<String>(myOracle.getAllCaracteristicas());

        for (String caracteristica: caracteristicas) {
            respostas.put(caracteristica, false);
        }

        TextView mPergunta = (TextView) findViewById(R.id.caracteristica);

        mPergunta.setText(caracteristicas.get(0));


    }
}
