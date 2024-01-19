package com.example.speedquiz;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.speedquiz.Controllers.GameManager;
import com.example.speedquiz.Models.Question;
import com.google.android.material.button.MaterialButton;

import java.util.Collections;
import java.util.List;

public class GameActivity extends AppCompatActivity {

    private MaterialButton BT_Redémarrer;
    private MaterialButton BT_Menu;
    private MaterialButton BT_Joueur1;
    private MaterialButton BT_Joueur2;

    private TextView TV_Joueur1;
    private TextView TV_Joueur2;
    private TextView questionJoueur1;
    private TextView questionJoueur2;
    private TextView scoreJoueur1;
    private TextView scoreJoueur2;

    private View relativeLayout;
    private int questionEnCoursIndex = 0;
    private List<Question> questions;
    private int scoreJoueur1Value = 0;
    private int scoreJoueur2Value = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        BT_Redémarrer = findViewById(R.id.buttonRestart);
        BT_Menu = findViewById(R.id.buttonMenu);
        BT_Joueur1 = findViewById(R.id.hitButtonJoueur1);
        BT_Joueur2 = findViewById(R.id.hitButtonJoueur2);

        TV_Joueur2 = findViewById(R.id.nomJoueur2);
        TV_Joueur1 = findViewById(R.id.nomJoueur1);
        scoreJoueur1 = findViewById(R.id.scoreJoueur1);
        scoreJoueur2 = findViewById(R.id.scoreJoueur2);

        questionJoueur1 = findViewById(R.id.questionJoueur1);
        questionJoueur2 = findViewById(R.id.questionJoueur2);

        relativeLayout = findViewById(R.id.buttonUtility);

        Intent activityGame = getIntent();

        String joueur1 = activityGame.getStringExtra("Joueur1");
        TV_Joueur1.setText(joueur1);
        String joueur2 = activityGame.getStringExtra("Joueur2");
        TV_Joueur2.setText(joueur2);

        questions = GameManager.getInstance().getQuestions();

        relativeLayout.setVisibility(View.INVISIBLE);

        BT_Redémarrer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Créez une Intent pour redémarrer cette activité
                Intent intent = getIntent();
                finish(); // Terminez l'activité actuelle
                startActivity(intent); // Redémarrez l'activité
                Collections.shuffle(questions);
            }
        });

        BT_Joueur1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                incrementerScoreJoueur(1);
                afficherQuestionSuivante();
            }
        });

        BT_Joueur2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                incrementerScoreJoueur(2);
                afficherQuestionSuivante();
            }
        });

        BT_Menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                retournerAMainActivity();
            }
        });
    }

    private void afficherQuestionSuivante() {
        if (questionEnCoursIndex < questions.size()) {
            String questionEnCours = questions.get(questionEnCoursIndex).getIntitulé();
            questionJoueur1.setText(questionEnCours);
            questionJoueur2.setText(questionEnCours);

            // Incrémente l'index de la question pour la suivante
            questionEnCoursIndex++;
        } else {
            questionJoueur1.setText(R.string.restart_game);
            questionJoueur2.setText(R.string.restart_game);
            relativeLayout.setVisibility(View.VISIBLE);

            // Désactivez les boutons BT_JoueurX si la liste est terminée
            if (GameManager.getInstance().isFinListe()) {
                BT_Joueur1.setEnabled(false);
                BT_Joueur2.setEnabled(false);
            }
        }
    }

    private void retournerAMainActivity() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }

    private void incrementerScoreJoueur(int joueur) {
        if (questionEnCoursIndex > 0) {
            if (joueur == 1) {
                scoreJoueur1Value++;
                scoreJoueur1.setText(String.valueOf(scoreJoueur1Value));
            } else if (joueur == 2) {
                scoreJoueur2Value++;
                scoreJoueur2.setText(String.valueOf(scoreJoueur2Value));
            }
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
    }
}