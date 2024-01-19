package com.example.speedquiz.Controllers;

import com.example.speedquiz.Models.Question;
import com.example.speedquiz.Models.QuestionData;

import java.util.ArrayList;

public class GameManager {

    private static GameManager instance;
    private QuestionData dbHelper;
    private boolean finListe = true;

    private GameManager() {
        dbHelper = new QuestionData();
    }

    public static GameManager getInstance() {
        if (instance == null) {
            instance = new GameManager();
        }
        return instance;
    }

    public ArrayList<Question> getQuestions() {
        return (ArrayList<Question>) dbHelper.getQuestions();
    }

    public boolean isFinListe() {
        return finListe;
    }

    public void setFinListe(boolean finListe) {
        this.finListe = finListe;
    }
}