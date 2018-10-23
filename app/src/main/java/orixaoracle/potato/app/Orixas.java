package orixaoracle.potato.app;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by jmpl on 10/23/18.
 */

class Orixas {


    public final static String  ELEGBARA = "Elegbara";
    public final static String  OGUM = "Ogum";
    public final static String  XANGO = "Xango";
    public final static String  OXUMARE = "Oxumare";
    public final static String  OBALUAIE = "Obaluaie";
    public final static String  OXOSSI = "Oxossi";
    public final static String  OSSAIM = "Ossaim";
    public final static String  OBA = "Oba";
    public static String  NANA = "Nana";
    public final static String  OXUM = "Oxum";
    public final static String  YEMANJA = "Yemanja";
    public final static String  EWA = "Ewa";
    public final static String  IANSA = "Iansa";
    public final static String  TEMPO = "Tempo";
    public final static String  IFA = "Ifa";
    public final static String  OXALA = "Oxala";


    private ArrayList<String> orixas ;


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


}
