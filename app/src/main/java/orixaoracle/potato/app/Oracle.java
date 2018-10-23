package orixaoracle.potato.orixaoracle;

import java.util.Collection;
import java.util.HashMap;

/**
 * Created by jmpl on 10/4/18.
 */

public class Oracle {

    private HashMap<String, String> orixa_caracteristica;


    public Oracle() {

        orixa_caracteristica = new HashMap<String,String>();
        orixa_caracteristica.put("Iansa", "Criativo(a)");
        orixa_caracteristica.put("Iansa", "Independente");
        orixa_caracteristica.put("Elegbara", "Iniciativa");
        orixa_caracteristica.put("Oxala", "Pacifista");

    }


    public Collection<String> getAllCaracteristicas() {
        return orixa_caracteristica.values();
    }


}
