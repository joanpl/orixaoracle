package orixaoracle.potato.app;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.*;
import java.util.Map.Entry;
import java.util.stream.Collectors;

/**
 * Created by jmpl on 10/4/18.
 */

public class Oracle {

    private HashMap<String, ArrayList<String>> orixa_caracteristica ;

    private Orixas orixas;
    private static boolean ASC = true;
    private static boolean DESC = false;

    private int[] elementsResult = new int[4];




    private int max_yes = 0;


    int[] answers ;
    int[] show ;
    int show_counter = 0;

    private int max_orixa=0;

    int current_orixa = -1;

    private OrixaDB db;
    private int maxCaracteristica = 0;

    public static final int MIN_GAME = 2;
    public static final int MODERATE_GAME = 3;

    public void setLevel (int level ) {

        switch(level) {
            case 0:
               maxCaracteristica = maxCaracteristica < MIN_GAME? maxCaracteristica : MIN_GAME;
               break;
            case 1:
                maxCaracteristica = maxCaracteristica < MODERATE_GAME? maxCaracteristica : MODERATE_GAME;
                break;

            default:

                    if(MainActivity.DEBUG)
                        maxCaracteristica = maxCaracteristica > 1? 1 : maxCaracteristica;
                    else
                        maxCaracteristica = db.getMin_caracteristica();

        }

    }



    public Oracle(OrixaDB db) {

        orixas = new Orixas();
        this.db = db;
        max_orixa = orixas.getOrixas().size(); //16?
        answers = new int[max_orixa];
        show = new int[max_orixa];
        orixa_caracteristica = new HashMap<String,ArrayList<String>>();
        if(db!=null) {

            orixa_caracteristica= db.getOrixas_caracteristicas();
            maxCaracteristica = db.getMin_caracteristica();
           if(MainActivity.DEBUG)
              maxCaracteristica = maxCaracteristica > 1? 1 : maxCaracteristica;
        }
        else {
            for (int i = 0; i < max_orixa; i++) {
                orixa_caracteristica.put(orixas.getOrixas().get(i), new ArrayList<String>());
                answers[i] = 0;
                show[i] = 0;
            }

            //SOME DATA
            orixa_caracteristica.get(Orixas.IANSA).add("Criativo(a)");
            orixa_caracteristica.get(Orixas.IANSA).add("Independente");
            orixa_caracteristica.get(Orixas.ELEGBARA).add("Iniciativa");
            orixa_caracteristica.get(Orixas.OXALA).add("Pacifista");

        }





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
           if(show[orixa_counter] < maxCaracteristica){
              current_orixa = orixa_counter;
              int car= show[orixa_counter];
              show[orixa_counter]++;
              return caract.get(car);
           }


       }
       return "";

    }


public int getMaxQuestions() {
        return maxCaracteristica * max_orixa;

}

public int getCurrentQuestion() {
    return show_counter;
}

    public void setAnswer ( boolean answer) {
        if(answer){
            ++max_yes;
            ++answers[current_orixa];

        }
    }


    public String getResults () {

        String results = "";
        DecimalFormat df = new DecimalFormat("#.##");

        for (int i = 0; i<   max_orixa ; i++ ){

            Double result = new Double(max_yes>0 ?(answers[i] / (float)max_yes) * 100.0  : 0);
            results += orixas.getOrixas().get(i)+" - "+ df.format(result).toString() + "%\n";

        }
        return results;
    }


    public double[] getResultsArray () {

        double[] resultsGrid = new double[orixas.getOrixas().size()];
        String results = "";
        DecimalFormat df = new DecimalFormat("#.##");

        for (int i = 0; i<   max_orixa ; i++ ){

            double result = (max_yes>0 ?(answers[i] / (float)max_yes) * 100.0  : 0);
            results += orixas.getOrixas().get(i)+" - "+ df.format(result).toString() + "%\n";
            resultsGrid[i]= result;

        }
        return resultsGrid;
    }

    public static   Map<String, Double> getPrettyResults(double[] results) {
        HashMap<String, Double> resultsString = new HashMap<>(results.length);
        Orixas orixas = new Orixas();
        for (int i =0; i< results.length; i++)
        {
            resultsString.put(orixas.getOrixas().get(i), results[i]);
        }

        // now let's sort the map in decreasing order of value

        //System.out.println("After sorting descending order......");
        Map<String, Double> sortedMapDesc = sortByComparator(resultsString, DESC);
        if(MainActivity.DEBUG)
         printMap(sortedMapDesc);

        return sortedMapDesc;

    }


    private static Map<String, Double> sortByComparator(Map<String, Double> unsortMap, final boolean order)
    {

        List<Entry<String, Double>> list = new LinkedList<Entry<String, Double>>(unsortMap.entrySet());

        // Sorting the list based on values
        Collections.sort(list, new Comparator<Entry<String, Double>>()
        {
            public int compare(Entry<String, Double> o1,
                               Entry<String, Double> o2)
            {
                if (order)
                {
                    return o1.getValue().compareTo(o2.getValue());
                }
                else
                {
                    return o2.getValue().compareTo(o1.getValue());

                }
            }
        });

        // Maintaining insertion order with the help of LinkedList
        Map<String, Double> sortedMap = new LinkedHashMap<String, Double>();
        for (Entry<String, Double> entry : list)
        {
            sortedMap.put(entry.getKey(), entry.getValue());
        }

        return sortedMap;
    }

    public static void printMap(Map<String, Double> map)
    {
        for (Entry<String, Double> entry : map.entrySet())
        {
            System.out.println("Key : " + entry.getKey() + " Value : "+ entry.getValue());
        }
    }


}
