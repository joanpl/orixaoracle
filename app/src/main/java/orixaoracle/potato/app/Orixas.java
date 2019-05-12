package orixaoracle.potato.app;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.UnknownFormatConversionException;

/**
 * Created by jmpl on 10/23/18.
 */

class Orixas {


    public final static String  ELEGBARA = "Elegbara";

    private final static ArrayList<String>  ELEGBARA_NAMES = new ArrayList<String>(Arrays.asList("elegbara", "elaroie", "exu", "elegua", "eshu"));
    public final static String  OGUM = "Ogum";

    private final static ArrayList<String>  OGUM_NAMES = new ArrayList<String>(Arrays.asList("ogum"));
    public final static String  XANGO = "Xango";

    private final static ArrayList<String>  XANGO_NAMES = new ArrayList<String>(Arrays.asList("xango", "chango", "shango"));
    public final static String  OXUMARE = "Oxumare";

    private final static ArrayList<String>  OXUMARE_NAMES = new ArrayList<String>(Arrays.asList("besseim", "oxumare", "dan"));
    public final static String  OBALUAIE = "Obaluaie";

    private final static ArrayList<String>  OBALUAIE_NAMES = new ArrayList<String>(Arrays.asList("obaluaie", "omolu"));
    public final static String  OXOSSI = "Oxossi";

    private final static ArrayList<String>  OXOSSI_NAMES = new ArrayList<String>(Arrays.asList("oxossi", "ode", "Oshosi"));
    public final static String  OSSAIM = "Ossaim";
    private final static ArrayList<String>  OSSAIM_NAMES = new ArrayList<String>(Arrays.asList("ossaim", "ossanha", "ossain", "osanyin", "ossaniyn", "ossanhe"));
    public final static String  OBA = "Oba";

    private final static ArrayList<String>  OBA_NAMES = new ArrayList<String>(Arrays.asList("oba"));
    public final static String  NANA = "Nana";

    private final static ArrayList<String>  NANA_NAMES = new ArrayList<String>(Arrays.asList("nana", "buruku", "buluku"));
    public final static String  OXUM = "Oxum";

    private final static ArrayList<String>  OXUM_NAMES = new ArrayList<String>(Arrays.asList("oxum", "ochum", "oshum", "osum"));
    public final static String  YEMANJA = "Yemanja";

    private final static ArrayList<String>  YEMANJA_NAMES = new ArrayList<String>(Arrays.asList("yemanja", "iemanja", "exu"));
    public final static String  EWA = "Ewa";

    private final static ArrayList<String>  EWA_NAMES = new ArrayList<String>(Arrays.asList("ewa", "yewa", "iyewa"));
    public final static String  IANSA = "Iansa";

    private final static ArrayList<String>  IANSA_NAMES = new ArrayList<String>(Arrays.asList("oya", "yansa", "iansa"));
    public final static String  TEMPO = "Tempo";

    private final static ArrayList<String>  TEMPO_NAMES = new ArrayList<String>(Arrays.asList("tempo", "iroko", "loko"));
    public final static String  IFA = "Ifa";

    private final static ArrayList<String>  IFA_NAMES = new ArrayList<String>(Arrays.asList("ifa", "orunmila"));
    public final static String  OXALA = "Oxala";

    private final static ArrayList<String>  OXALA_NAMES = new ArrayList<String>(Arrays.asList("jesus", "oxala","obatala", "oxalufan", "oxalamin", "oxaguian", "orinxala"));


    private ArrayList<String> orixas ;


    public final static Integer FIRE = 0;
    public final static Integer EARTH = 1;
    public final static Integer WATER = 2;
    public final static Integer AIR = 3;


    HashMap<String, ArrayList<Integer>> orixaElementsMapping;

    private void initOrixaElementsMapping() {

        orixaElementsMapping = new HashMap<>();
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
