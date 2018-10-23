package orixaoracle.potato.app;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by jmpl on 10/23/18.
 */

public class OrixaDB {




    private HashMap<String, ArrayList<String>> orixas_caracteristicas  = new HashMap<String, ArrayList<String>>();

   private  int max_caracteristica =0;

    public OrixaDB(InputStream rootDataDir) throws IOException {

      //  String csvFile = rootDataDir +"/orixas_caracteristica.csv";
        String line = "";
        String cvsSplitBy = ",";

        BufferedReader reader = new BufferedReader(
                new InputStreamReader(rootDataDir));

        while ((line = reader.readLine()) != null) {

            // use comma as separator
            String[] orixa_caracteristica = line.split(cvsSplitBy);
            if(orixa_caracteristica.length > 1 ) {
                String orixa_name= Orixas.normalizeOrixa(orixa_caracteristica[1]);
               if(orixas_caracteristicas.get(orixa_name)== null )
                   orixas_caracteristicas.put(orixa_name, new ArrayList<String>());
                orixas_caracteristicas.get(orixa_name).add(orixa_caracteristica[0]);
                int size = orixas_caracteristicas.get(orixa_name).size();
                if(size > max_caracteristica)
                    max_caracteristica = size;
            }

        }
    }

    public int getMax_caracteristica(){

        return this.max_caracteristica > 2? 2 : this.max_caracteristica;
    }

    public HashMap<String, ArrayList<String>> getOrixas_caracteristicas(){
        return this.orixas_caracteristicas;
    }
}
