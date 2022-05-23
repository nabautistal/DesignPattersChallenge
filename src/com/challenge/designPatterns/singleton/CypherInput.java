package com.challenge.designPatterns.singleton;

public interface CypherInput {
    void setFileName(String fileName);
    String getFileName();

    void setCypherType(String cypherType);
    void setCypherText(String cypherText);

    String getCypherType();
    String getCypherText();


}
