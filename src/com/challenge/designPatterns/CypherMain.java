package com.challenge.designPatterns;

import com.challenge.designPatterns.factory.Cypher;
import com.challenge.designPatterns.factory.CypherFactory;
import com.challenge.designPatterns.singleton.CypherData;
import com.challenge.designPatterns.singleton.CypherInput;
import com.challenge.designPatterns.template.FileReader;
import com.challenge.designPatterns.template.ReadInput;

public class CypherMain {
    public static void main(String[] args) {
        //Singleton
        CypherInput in = CypherData.getCypherData();
        in.setFileName("src\\com\\challenge\\designPatterns\\input\\input.txt");
        //Template
        FileReader f = new ReadInput();
        f.vars();
        //Factory
        CypherFactory fact = new CypherFactory();
        String type = in.getCypherType();
        Cypher cy = fact.getCypher(type);
        cy.cypherResult();



    }
}
