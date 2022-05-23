package com.challenge.designPatterns.factory;

import com.challenge.designPatterns.singleton.CypherData;
import com.challenge.designPatterns.singleton.CypherInput;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Hashtable;

public class CypherNumeros implements Cypher{
    CypherInput in = CypherData.getCypherData();
    String data = in.getCypherText();
    String cypherText = in.getCypherText();

    @Override
    public String cypher() {
        Hashtable<String,String> shift = new Hashtable<>();

        //Agregar elementos shift
        shift.put("a", "9");
        shift.put("A", "6");
        shift.put("e", "3");
        shift.put("E", "8");
        shift.put("i", "1");
        shift.put("I", "2");
        shift.put("o", "0");
        shift.put("O", "5");
        shift.put("u", "4");
        shift.put("U", "7");

        for (Enumeration k = shift.keys(); k.hasMoreElements();){
            String key = String.valueOf(k.nextElement());
            data = data.replace(key,shift.get(key));

        }
        return data;

    }

    @Override
    public void cypherResult() {
        try {
            String data = cypher();
            File myObj = new File("src\\com\\challenge\\designPatterns\\output\\output.txt");
            boolean result;
            if (myObj.createNewFile()) result = true;
            else result = false;

            FileWriter myWriter = new FileWriter("src\\com\\challenge\\designPatterns\\output\\output.txt",false);
            String orig = "Original: " + cypherText + "\n";
            String cod = "Codificacion: " + data;
            myWriter.write(orig);
            myWriter.write(cod);
            System.out.print(orig);
            System.out.println(cod);

            myWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
