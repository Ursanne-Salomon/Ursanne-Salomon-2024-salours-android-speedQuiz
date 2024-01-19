package com.example.speedquiz.Models;
import java.util.ArrayList;
import java.util.List;

public class QuestionData {
    private final ArrayList<Question> listeDeQuestions = new ArrayList<>();

    public QuestionData() {
        listeDeQuestions.add(new Question("La Terre est-elle ronde ?", true));
        listeDeQuestions.add(new Question("Le soleil tourne-t-il autour de la Terre ?", false));
        listeDeQuestions.add(new Question("2 + 2 font-ils 4 ?", true));
        listeDeQuestions.add(new Question("Les poissons peuvent-ils respirer sous l'eau ?", true));
        listeDeQuestions.add(new Question("Les humains peuvent-ils voir les ultraviolets ?", false));
        listeDeQuestions.add(new Question("L'eau bout-elle à 100 degrés Celsius au niveau de la mer ?", true));
        listeDeQuestions.add(new Question("Le Mont Everest est-il la plus haute montagne du monde ?", true));
        listeDeQuestions.add(new Question("Est-ce que le son voyage plus vite dans l'eau que dans l'air ?", true));
        listeDeQuestions.add(new Question("Vénus est-elle plus proche du Soleil que la Terre ?", true));
        listeDeQuestions.add(new Question("La lumière du soleil atteint-elle la Terre en environ 8 minutes ?", true));
        listeDeQuestions.add(new Question("Les adultes ont-ils plus d'os que les bébés ?", false));
        listeDeQuestions.add(new Question("Pluton est-elle toujours considérée comme une planète majeure du système solaire ?", false));
        listeDeQuestions.add(new Question("Le cœur humain a-t-il quatre chambres ?", true));
        listeDeQuestions.add(new Question("L'ADN est-il une structure en forme de double hélice ?", true));
        listeDeQuestions.add(new Question("La Grande Muraille de Chine est-elle visible depuis l'espace ?", false));
        listeDeQuestions.add(new Question("Les requins sont-ils des mammifères ?", false));
        listeDeQuestions.add(new Question("L'atmosphère terrestre est-elle composée principalement d'oxygène ?", false));
        listeDeQuestions.add(new Question("Le chocolat est-il toxique pour les chiens ?", true));
        listeDeQuestions.add(new Question("Les dents de requin sont-elles plus dures que l'acier ?", false));
        listeDeQuestions.add(new Question("L'Empire State Building se trouve-t-il à New York ?", true));
    }

    public List<Question> getQuestions() {
        return listeDeQuestions;
    }
}
