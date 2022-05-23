package com.challenge.designPatterns.factory;

public class CypherFactory {

    //Factory method
    public Cypher getCypher(String cypherType){
        if (cypherType.equals("MOVIDO")){
            return new CypherMovido();
        }else {
            return new CypherNumeros();
        }
    }

}
