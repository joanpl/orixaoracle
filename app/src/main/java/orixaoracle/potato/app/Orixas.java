package orixaoracle.potato.app;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.UnknownFormatConversionException;

/**
 * Created by jmpl on 10/23/18.
 */

public class Orixas {


    public final static String  ELEGBARA = "Elegbara";

    private final static ArrayList<String>  ELEGBARA_NAMES = new ArrayList<String>(Arrays.asList("elegbara", "elaroie", "exu", "elegua", "eshu"));

    //public final static Date ELEGBARA_DAY = new GregorianCalendar(2000, Calendar.NOVEMBER, 7).getTime();

    public final static Date ELEGBARA_DAY = new GregorianCalendar(2000, Calendar.JUNE, 13).getTime();

    public final static String  OGUM = "Ogum";
    private final static ArrayList<String>  OGUM_NAMES = new ArrayList<String>(Arrays.asList("ogum"));
    public final static Date OGUM_DAY = new GregorianCalendar(2000, Calendar.APRIL, 23).getTime();

    public final static String  XANGO = "Xango";

    private final static ArrayList<String>  XANGO_NAMES = new ArrayList<String>(Arrays.asList("xango", "chango", "shango"));
    public final static Date XANGO_DAY = new GregorianCalendar(2000, Calendar.SEPTEMBER, 30).getTime();


    public final static String  OXUMARE = "Oxumare";

    private final static ArrayList<String>  OXUMARE_NAMES = new ArrayList<String>(Arrays.asList("besseim", "oxumare", "dan"));
    public final static Date OXUMARE_DAY = new GregorianCalendar(2000, Calendar.AUGUST, 24).getTime();



    public final static String  OBALUAIE = "Obaluaie";

    private final static ArrayList<String>  OBALUAIE_NAMES = new ArrayList<String>(Arrays.asList("obaluaie", "omolu"));
    public final static Date OBALUAIE_DAY = new GregorianCalendar(2000, Calendar.AUGUST, 16).getTime();


    public final static String  OXOSSI = "Oxossi";

    private final static ArrayList<String>  OXOSSI_NAMES = new ArrayList<String>(Arrays.asList("oxossi", "ode", "Oshosi"));
    public final static Date OXOSSI_DAY = new GregorianCalendar(2000, Calendar.JANUARY, 20).getTime();

    public final static String  OSSAIM = "Ossaim";
    private final static ArrayList<String>  OSSAIM_NAMES = new ArrayList<String>(Arrays.asList("ossaim", "ossanha", "ossain", "osanyin", "ossaniyn", "ossanhe"));
    public final static Date OSSAIM_DAY = new GregorianCalendar(2000, Calendar.OCTOBER, 5).getTime();

    public final static String  OBA = "Oba";
    private final static ArrayList<String>  OBA_NAMES = new ArrayList<String>(Arrays.asList("oba"));
    public final static Date OBA_DAY = new GregorianCalendar(2000, Calendar.MAY, 30).getTime();

    public final static String  NANA = "Nana";
    public final static Date NANA_DAY = new GregorianCalendar(2000, Calendar.JULY, 16).getTime();
    private final static ArrayList<String>  NANA_NAMES = new ArrayList<String>(Arrays.asList("nana", "buruku", "buluku"));
    public final static String  OXUM = "Oxum";

    private final static ArrayList<String>  OXUM_NAMES = new ArrayList<String>(Arrays.asList("oxum", "ochum", "oshum", "osum"));
    public final static Date OXUM_DAY = new GregorianCalendar(2000, Calendar.DECEMBER, 8).getTime();

    public final static String  YEMANJA = "Yemanja";
    public final static Date YEMANJA_DAY = new GregorianCalendar(2000, Calendar.FEBRUARY, 2).getTime();
    private final static ArrayList<String>  YEMANJA_NAMES = new ArrayList<String>(Arrays.asList("yemanja", "iemanja", "exu"));

    public final static String  EWA = "Ewa";
    public final static Date EWA_DAY = new GregorianCalendar(2000, Calendar.DECEMBER, 13).getTime();
    private final static ArrayList<String>  EWA_NAMES = new ArrayList<String>(Arrays.asList("ewa", "yewa", "iyewa"));

    public final static String  IANSA = "Iansa";
    private final static ArrayList<String>  IANSA_NAMES = new ArrayList<String>(Arrays.asList("oya", "yansa", "iansa"));
    public final static Date IANSA_DAY = new GregorianCalendar(2000, Calendar.DECEMBER, 4).getTime();

    public final static String  TEMPO = "Tempo";
    public final static Date TEMPO_DAY = new GregorianCalendar(2000, Calendar.OCTOBER, 4).getTime();
    private final static ArrayList<String>  TEMPO_NAMES = new ArrayList<String>(Arrays.asList("tempo", "iroko", "loko"));

    public final static String  IFA = "Ifa";
    private final static ArrayList<String>  IFA_NAMES = new ArrayList<String>(Arrays.asList("ifa", "orunmila"));
    public final static Date IFA_DAY =   new GregorianCalendar(2000, Calendar.OCTOBER, 4).getTime();

    public final static String  OXALA = "Oxala";
    public final static Date OXALA_DAY =   new GregorianCalendar(2000, Calendar.DECEMBER, 25).getTime();
    private final static ArrayList<String>  OXALA_NAMES = new ArrayList<String>(Arrays.asList("jesus", "oxala","obatala", "oxalufan", "oxalamin", "oxaguian", "orinxala"));



    private ArrayList<String> orixas ;


    public final static Integer FIRE = 0;
    public final static Integer EARTH = 1;
    public final static Integer WATER = 2;
    public final static Integer AIR = 3;

    public static final Double FIRST_WEIGHT = 0.7;
    public static final Double SECOND_WEIGHT = 0.3;


    HashMap<String, ArrayList<Integer>> orixaElementsMapping;

    public static ArrayList<String> getCommemorationOrixas (int day1, int month1) {

        ArrayList<String> result = new ArrayList<>();
        Calendar cal = Calendar.getInstance();

        cal.setTime(OXALA_DAY);
       int month = cal.get(Calendar.MONTH);
       int day = cal.get(Calendar.DAY_OF_MONTH); // etc.

        if(day == day1 && month == month1)
            result.add(OXALA);

        cal.setTime(TEMPO_DAY);
         month = cal.get(Calendar.MONTH);
         day = cal.get(Calendar.DAY_OF_MONTH); // etc.

        if(day == day1 && month == month1)
            result.add(TEMPO);
        cal.setTime(IFA_DAY);
        month = cal.get(Calendar.MONTH);
        day = cal.get(Calendar.DAY_OF_MONTH); // etc.

        if(day == day1 && month == month1)
            result.add(IFA);

        cal.setTime(IANSA_DAY);
        month = cal.get(Calendar.MONTH);
        day = cal.get(Calendar.DAY_OF_MONTH); // etc.

        if(day == day1 && month == month1)
            result.add(IANSA);

        cal.setTime(EWA_DAY);
        month = cal.get(Calendar.MONTH);
        day = cal.get(Calendar.DAY_OF_MONTH); // etc.

        if(day == day1 && month == month1)
            result.add(EWA);

        cal.setTime(YEMANJA_DAY);
        month = cal.get(Calendar.MONTH);
        day = cal.get(Calendar.DAY_OF_MONTH); // etc.

        if(day == day1 && month == month1)
            result.add(YEMANJA);

        cal.setTime(OXUM_DAY);
        month = cal.get(Calendar.MONTH);
        day = cal.get(Calendar.DAY_OF_MONTH); // etc.

        if(day == day1 && month == month1)
            result.add(OXUM);

        cal.setTime(NANA_DAY);
        month = cal.get(Calendar.MONTH);
        day = cal.get(Calendar.DAY_OF_MONTH); // etc.

        if(day == day1 && month == month1)
            result.add(NANA);

        cal.setTime(OBA_DAY);
        month = cal.get(Calendar.MONTH);
        day = cal.get(Calendar.DAY_OF_MONTH); // etc.

        if(day == day1 && month == month1)
            result.add(OBA);

        cal.setTime(OSSAIM_DAY);
        month = cal.get(Calendar.MONTH);
        day = cal.get(Calendar.DAY_OF_MONTH); // etc.

        if(day == day1 && month == month1)
            result.add(OSSAIM);

        cal.setTime(OXOSSI_DAY);
        month = cal.get(Calendar.MONTH);
        day = cal.get(Calendar.DAY_OF_MONTH); // etc.

        if(day == day1 && month == month1)
            result.add(OXOSSI);

        cal.setTime(OBALUAIE_DAY);
        month = cal.get(Calendar.MONTH);
        day = cal.get(Calendar.DAY_OF_MONTH); // etc.

        if(day == day1 && month == month1)
            result.add(OBALUAIE);

        cal.setTime(XANGO_DAY);
        month = cal.get(Calendar.MONTH);
        day = cal.get(Calendar.DAY_OF_MONTH); // etc.

        if(day == day1 && month == month1)
            result.add(XANGO);

        cal.setTime(OXUMARE_DAY);
        month = cal.get(Calendar.MONTH);
        day = cal.get(Calendar.DAY_OF_MONTH); // etc.

        if(day == day1 && month == month1)
            result.add(OXUMARE);


        cal.setTime(OGUM_DAY);
        month = cal.get(Calendar.MONTH);
        day = cal.get(Calendar.DAY_OF_MONTH); // etc.

        if(day == day1 && month == month1)
            result.add(OGUM);


        cal.setTime(ELEGBARA_DAY);
        month = cal.get(Calendar.MONTH);
        day = cal.get(Calendar.DAY_OF_MONTH); // etc.

        if(day == day1 && month == month1)
            result.add(ELEGBARA);





return result;


    }

    private void initOrixaElementsMapping() {

        orixaElementsMapping = new HashMap<>();
        orixaElementsMapping.put(ELEGBARA, new ArrayList<Integer>(Arrays.asList(FIRE,FIRE)));
        orixaElementsMapping.put(OGUM, new ArrayList<Integer>(Arrays.asList(FIRE,EARTH)));
        orixaElementsMapping.put(OXUMARE, new ArrayList<Integer>(Arrays.asList(FIRE,WATER)));
        orixaElementsMapping.put(XANGO, new ArrayList<Integer>(Arrays.asList(FIRE,AIR)));

        orixaElementsMapping.put(OBALUAIE, new ArrayList<Integer>(Arrays.asList(EARTH,FIRE)));
        orixaElementsMapping.put(OXOSSI, new ArrayList<Integer>(Arrays.asList(EARTH,EARTH)));
        orixaElementsMapping.put(OSSAIM, new ArrayList<Integer>(Arrays.asList(EARTH,WATER)));
        orixaElementsMapping.put(OBA, new ArrayList<Integer>(Arrays.asList(EARTH,AIR)));

        orixaElementsMapping.put(NANA, new ArrayList<Integer>(Arrays.asList(WATER,FIRE)));
        orixaElementsMapping.put(OXUM, new ArrayList<Integer>(Arrays.asList(WATER,EARTH)));
        orixaElementsMapping.put(YEMANJA, new ArrayList<Integer>(Arrays.asList(WATER,WATER)));
        orixaElementsMapping.put(EWA, new ArrayList<Integer>(Arrays.asList(WATER,AIR)));

        orixaElementsMapping.put(IANSA, new ArrayList<Integer>(Arrays.asList(AIR,FIRE)));
        orixaElementsMapping.put(TEMPO, new ArrayList<Integer>(Arrays.asList(AIR,EARTH)));
        orixaElementsMapping.put(IFA, new ArrayList<Integer>(Arrays.asList(AIR,WATER)));
        orixaElementsMapping.put(OXALA, new ArrayList<Integer>(Arrays.asList(AIR,AIR)));
    }


    public Orixas(){
        orixas = new ArrayList<String>();
        orixas.add(ELEGBARA);
        orixas.add(OGUM);
        orixas.add(XANGO);
        orixas.add(OXUMARE);
        orixas.add(OBALUAIE);
        orixas.add(OXOSSI);
        orixas.add(OSSAIM);
        orixas.add(OBA);
        orixas.add(NANA);
        orixas.add(OXUM);
        orixas.add(YEMANJA);
        orixas.add(EWA);
        orixas.add(IANSA);
        orixas.add(TEMPO);
        orixas.add(IFA);
        orixas.add(OXALA);
        initOrixaElementsMapping();

    }

    public ArrayList<String> getOrixas(){
        return orixas;
    }



    //TODO NEEDS works on acentos
    public static String normalizeOrixa (String orixaName) {

        String lowerOrixaName = orixaName.toLowerCase().trim();
        if(ELEGBARA_NAMES.contains(lowerOrixaName))
           return ELEGBARA;
        else if(OGUM_NAMES.contains(lowerOrixaName))
            return OGUM;
        else if(OXUMARE_NAMES.contains(lowerOrixaName))
            return OXUMARE;
        else if(XANGO_NAMES.contains(lowerOrixaName))
            return XANGO;
        else if(OBALUAIE_NAMES.contains(lowerOrixaName))
            return OBALUAIE;
        else if(OXOSSI_NAMES.contains(lowerOrixaName))
            return OXOSSI;
        else if(OSSAIM_NAMES.contains(lowerOrixaName))
            return OSSAIM;
        else if(OBA_NAMES.contains(lowerOrixaName))
            return OBA;
        else if(NANA_NAMES.contains(lowerOrixaName))
            return NANA;
        else if(OXUM_NAMES.contains(lowerOrixaName))
            return OXUM;
        else if(YEMANJA_NAMES.contains(lowerOrixaName))
            return YEMANJA;
        else if(EWA_NAMES.contains(lowerOrixaName))
            return EWA;
        else if(IANSA_NAMES.contains(lowerOrixaName))
            return IANSA;
        else if(TEMPO_NAMES.contains(lowerOrixaName))
            return TEMPO;
        else if(IFA_NAMES.contains(lowerOrixaName))
            return IFA;
        else if(OXALA_NAMES.contains(lowerOrixaName))
            return OXALA;
        else {
            System.out.println("GRRRRRRRR: *********** " + lowerOrixaName);
            throw new UnknownFormatConversionException("unknown orixa");
        }

    }

}


