package orixaoracle.potato.app.activities;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.style.URLSpan;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.util.Iterator;
import java.util.Map;

import orixaoracle.potato.app.Oracle;
import orixaoracle.potato.app.R;


public class ResultsActivity extends BaseOrixasActivity {
    private static DecimalFormat df2 = new DecimalFormat("#.##");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        TableLayout mTableLayout;
        setContentView(R.layout.activity_results);

        Intent intent = getIntent();


        double[] answersGrid = intent.getDoubleArrayExtra("ANSWERSGRID");





        mTableLayout = (TableLayout) findViewById(R.id.tabelaResultados);

        mTableLayout.setStretchAllColumns(true);

        startLoadData(mTableLayout, Oracle.getPrettyResults(answersGrid) );



        Button button = (Button) findViewById(R.id.repetir);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToStart();
            }
        } );
        // setup the table
        Button button2 = (Button) findViewById(R.id.orixas);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToAllOrixas();
            }
        } );



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

        //Open activity for the Orixa


        labelOrixa.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent intent = getClassOrixa(((TextView)v).getText().toString());
                startActivity(intent);
            }
        });
        makeTextViewHyperlink(labelOrixa);




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



    private void goToStart() {

        Intent intent = new Intent(this, MainActivity.class);

        startActivity(intent);

    }




    public static void makeTextViewHyperlink(TextView tv) {

        SpannableStringBuilder ssb = new SpannableStringBuilder();

        ssb.append(tv.getText());

        ssb.setSpan(new URLSpan("#"), 0, ssb.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        tv.setText(ssb, TextView.BufferType.SPANNABLE);

    }
}