package com.challenge.designPatterns.factory;

import com.challenge.designPatterns.singleton.CypherData;
import com.challenge.designPatterns.singleton.CypherInput;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Dictionary;
import java.util.Enumeration;
import java.util.Hashtable;

public class CypherMovido implements Cypher{
    CypherInput in = CypherData.getCypherData();
    String data = in.getCypherText();
    String cypherText = in.getCypherText();

    @Override
    public String cypher() {
        Hashtable<String,String> temp = new Hashtable<>();
        Hashtable<String,String> shift = new Hashtable<>();

        //Agregar elementos temp
        temp.put("a","@");
        temp.put("A","$");
        temp.put("e","%");
        temp.put("E","&");
        temp.put("i","*");
        temp.put("I","/");
        temp.put("o","-");
        temp.put("O","^");
        temp.put("u","<");
        temp.put("U",">");

        //Agregar elementos shift
        shift.put("@","i");
        shift.put("$","I");
        shift.put("%","o");
        shift.put("&","O");
        shift.put("*","u");
        shift.put("/", "U");
        shift.put("-","a");
        shift.put("^", "A");
        shift.put("<","e");
        shift.put(">", "E");

        for (Enumeration k = temp.keys(); k.hasMoreElements();){
            String key = String.valueOf(k.nextElement());
            data = data.replace(key,temp.get(key));

        }

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
