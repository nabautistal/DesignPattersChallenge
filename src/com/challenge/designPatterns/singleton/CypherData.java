package com.challenge.designPatterns.singleton;

public class CypherData implements CypherInput{
    private static CypherData cyData = null;

    //Variables cifrador
    private String file;
    private String type;
    private String text;
    private String result;

    //Poner constructor en privado
    private CypherData(){

    }

    public static synchronized CypherData getCypherData(){
        if(cyData == null){
            cyData = new CypherData();
        }
        return cyData;
    }

    @Override
    public void setFileName(String fileName) {
        file = fileName;

    }

    @Override
    public String getFileName() {
        return this.file;
    }

    @Override
    public synchronized void setCypherType(String cypherType) {
        type = cypherType.toUpperCase();

    }

    @Override
    public synchronized void setCypherText(String cypherText) {
        text = cypherText;
    }

    @Override
    public String getCypherType() {

        return this.type;
    }

    @Override
    public String getCypherText() {
        return this.text;
    }


}
