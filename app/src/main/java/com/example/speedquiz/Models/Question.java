package com.example.speedquiz.Models;

public class Question {
    private String intitulé;
    private boolean réponse;

    public Question(String intitulé, boolean réponse){
        this.intitulé = intitulé;
        this.réponse = réponse;
    }

    public String getIntitulé() {
        return intitulé;
    }

    public boolean getRéponse() {
        return réponse;
    }
}
