package com.challenge.designPatterns.template;

import com.challenge.designPatterns.singleton.CypherData;
import com.challenge.designPatterns.singleton.CypherInput;

import java.io.File;
import java.io.FileNotFoundException;

import java.util.Scanner;

public class ReadInput extends FileReader{
    CypherInput in = CypherData.getCypherData();
    String filePath = in.getFileName();

    @Override
    public String readFile() {
        String data = "";
        try {
            File file = new File(filePath);
            Scanner scan = new Scanner(file);

            while (scan.hasNextLine()){
                data = data + scan.nextLine() + " ";
            }
            scan.close();


        }catch (FileNotFoundException e){
            e.printStackTrace();
        }
        return data;
    }

    @Override
    public void vars() {
        String data = readFile();
        String[] res = data.split("-");

        int len = res.length;
        String type = "";
        String text = "";
        if (len > 2){
            type = res[0];
            for (int i = 1; i < len; i++){
                text = text + res[i] + " ";
            }
            res = new String[]{type, text};

        }
        in.setCypherType(res[0]);
        in.setCypherText(res[1]);


    }
}
