package orixaoracle.potato.app;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.util.Iterator;
import java.util.Map;


public class Results extends AppCompatActivity {
    private static DecimalFormat df2 = new DecimalFormat("#.##");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        TableLayout mTableLayout;
        setContentView(R.layout.activity_results);

        Intent intent = getIntent();

      //  String answers = intent.getStringExtra("ANSWERS");
       // TextView mResultado = (TextView) findViewById(R.id.resultados);

     //   mResultado.setText(answers);






        double[] answersGrid = intent.getDoubleArrayExtra("ANSWERSGRID");





        mTableLayout = (TableLayout) findViewById(R.id.tabelaResultados);

        mTableLayout.setStretchAllColumns(true);

        startLoadData(mTableLayout, Oracle.getPrettyResults(answersGrid) );



        Button button = (Button) findViewById(R.id.repetir);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToStartActivity();
            }
        } );
        // setup the table




    }



private void startLoadData(TableLayout tl, Map<String, Double> prettyResults) {



        int head_id = 10;
        int label_orixa_id = 20;
        int label_percentagem_id = 21;
        LinearLayout.LayoutParams tableRowParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        tableRowParams.setMargins(20, 0, 20, 10);
        TableRow tr_head = new TableRow(this);
        tr_head.setId(head_id);
        tr_head.setBackgroundColor(Color.parseColor("#f9a159")); // or #59b1f9
        tr_head.setLayoutParams(tableRowParams);




    TableRow.LayoutParams params = new TableRow.LayoutParams(0, TableRow.LayoutParams.WRAP_CONTENT, 1f);
    params.setMargins(20, 0, 20, 0);

        TextView label_orixa = new TextView(this);
        label_orixa.setId(label_orixa_id);
        label_orixa.setText("Orixa");
        label_orixa.setTextColor(Color.WHITE);
    label_orixa.setLayoutParams(params);
    tr_head.setBackgroundColor(Color.parseColor("#f9a159")); // or #59b1f9

     //  label_orixa.setPadding(10, 5, 5, 5);
        tr_head.addView(label_orixa);// add the column to the table row here

        TextView percentagem = new TextView(this);
        percentagem.setId(label_percentagem_id);// define id that must be unique
        percentagem.setText("Percentagem (%)"); // set the text for the header
        percentagem.setTextColor(Color.WHITE); // set the color
    tr_head.setBackgroundColor(Color.parseColor("#f9a159")); // or #59b1f9
      //  percentagem.setPadding(20, 5, 5, 5); // set the padding (if required)
    percentagem.setLayoutParams(params);
        tr_head.addView(percentagem); // add the column to the table row here

    tl.addView(tr_head, new TableLayout.LayoutParams(tableRowParams));



    Iterator iterResults = prettyResults.entrySet().iterator();
    int count = 0;

    while (iterResults.hasNext()) {
        Map.Entry<String, Double> orixa_value = ( Map.Entry<String, Double>)iterResults.next();
        Double percentage = (orixa_value.getValue());// get the second variable

        // Create the table row
        TableRow tr = new TableRow(this);
        if(count%2==0)      tr.setBackgroundColor(Color.parseColor("#2088af")); // or #59b1f9
          //  tr.setBackgroundColor(Color.GRAY);

        tr.setId(100+count);
        tr.setLayoutParams(tableRowParams);

        //Create two columns to add as table data
        // Create a TextView to add date
        TextView labelOrixa = new TextView(this);
        labelOrixa.setLayoutParams(params);
        labelOrixa.setId(200+count);
        labelOrixa.setText(orixa_value.getKey());
        label_orixa.setTextSize(18);
       // labelOrixa.setPadding(2, 0, 5, 0);
        if(count%2==0) labelOrixa.setTextColor(Color.WHITE);
        else  labelOrixa.setTextColor(Color.GRAY);
        tr.addView(labelOrixa);
        TextView labelWEIGHT = new TextView(this);
        labelWEIGHT.setLayoutParams(params);
        label_orixa.setTextSize(18);
        labelWEIGHT.setId(200+count);
        labelWEIGHT.setText(df2.format(percentage));
        if(count%2==0)  labelWEIGHT.setTextColor(Color.WHITE);
        else labelWEIGHT.setTextColor(Color.GRAY);
        tr.addView(labelWEIGHT);

        // finally add this to the table row
        tl.addView(tr, tr_head.getLayoutParams());
        count++;
    }

}




    private void goToStartActivity() {

        Intent intent = new Intent(this, Perguntas.class);

        startActivity(intent);

    }

//    private void initializeGraph(){
//
//        GraphView graph = (GraphView) findViewById(R.id.graph_answers);
//
//
//        Orixas orixaNames = new Orixas();
//        // use static labels for horizontal and vertical labels
//        StaticLabelsFormatter staticLabelsFormatter = new StaticLabelsFormatter(graph);
//      //  staticLabelsFormatter.setHorizontalLabels(new String[] {"old", "middle", "new"});
//        String[] names = new String[orixaNames.getOrixas().size()];
//        orixaNames.getOrixas().toArray(names);
//        staticLabelsFormatter.setVerticalLabels(names);
//        graph.getGridLabelRenderer().setLabelFormatter(staticLabelsFormatter);
//
//        BarGraphSeries<DataPoint> series = new BarGraphSeries<>(new DataPoint[] {
//                new DataPoint(0, -1),
//                new DataPoint(1, 5),
//                new DataPoint(2, 3),
//                new DataPoint(3, 2),
//                new DataPoint(4, 6)
//        });
//        graph.addSeries(series);
//
//
//// styling
//        series.setValueDependentColor(new ValueDependentColor<DataPoint>() {
//            @Override
//            public int get(DataPoint data) {
//                return Color.rgb((int) data.getX()*255/4, (int) Math.abs(data.getY()*255/6), 100);
//            }
//        });
//
//        series.setSpacing(50);
//
//// draw values on top
//        series.setDrawValuesOnTop(true);
//        series.setValuesOnTopColor(Color.RED);
////series.setValuesOnTopSize(50);
//    }




}