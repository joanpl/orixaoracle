package orixaoracle.potato.app;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

/**
 * Created by jmpl on 10/4/18.
 */

public class Oracle {

    private HashMap<String, ArrayList<String>> orixa_caracteristica ;

    private Orixas orixas;

    private int fire = 0;
    private int earth = 0;
    private int water = 0;
    private int air = 0;
    private int max_yes = 0;


    int[] answers ;
    int[] show ;
    int show_counter = 0;

    int max_orixa=0;

    int current_orixa = -1;


    public Oracle() {

        orixas = new Orixas();
        max_orixa = orixas.getOrixas().size();
        answers = new int[max_orixa];
        show = new int[max_orixa];
        orixa_caracteristica = new HashMap<String,ArrayList<String>>();
        for(int i=0; i< max_orixa; i++ ) {
            orixa_caracteristica.put(orixas.getOrixas().get(i), new ArrayList<String>());
            answers[i]= 0;
            show[i]= 0;
        }



        orixa_caracteristica.get(Orixas.IANSA).add("Criativo(a)");
        orixa_caracteristica.get(Orixas.IANSA).add("Independente");
        orixa_caracteristica.get(Orixas.ELEGBARA).add("Iniciativa");
        orixa_caracteristica.get(Orixas.OXALA).add("Pacifista");

    }


    // returns empty string if no more caracteristics are found.
    public String getNext()  {

    int stop = max_orixa;

      while(stop>0) {

           int orixa_counter = (show_counter % max_orixa);
           String orixa_now = orixas.getOrixas().get(orixa_counter);
           ArrayList<String> caract = orixa_caracteristica.get(orixa_now);
           stop--;
           show_counter++;
           if(show[orixa_counter] < caract.size()){
              current_orixa = orixa_counter;
              int car= show[orixa_counter];
              show[orixa_counter]++;
              return caract.get(car);
           }


       }
       return "";

    }




    public void setAnswer ( boolean answer) {
        if(answer){
            ++max_yes;
            ++answers[current_orixa];

        }
    }


    public String getResults () {

        String results = "";

        for (int i = 0; i<   max_orixa ; i++ ){
            results += orixas.getOrixas().get(i)+" - "+ new Double((answers[i] / (float)max_yes) * 100.0 ).toString() + "%\n";

        }
        return results;
    }

}
