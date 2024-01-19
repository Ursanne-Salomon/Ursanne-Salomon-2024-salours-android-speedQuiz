package com.example.speedquiz;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class MainActivity extends AppCompatActivity {

    private MaterialButton BT_NouveauJoueur;
    private TextInputEditText ET_SaisieJoueur1;
    private TextInputEditText ET_SaisieJoueur2;
    private TextView LB_Joueur1;
    private TextInputLayout LT_Joueur1;
    private TextView LB_Joueur2;
    private TextInputLayout LT_Joueur2;
    private MaterialButton BT_NouvellePartie;
    String joueur1 = "";
    String joueur2 = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar mainToolBar = findViewById(R.id.mainToolBar);
        setSupportActionBar(mainToolBar);

        BT_NouvellePartie = findViewById(R.id.bouttonConfirmer);
        BT_NouveauJoueur = findViewById(R.id.bouttonNouveauJoueur);
        ET_SaisieJoueur1 = findViewById(R.id.player1);
        ET_SaisieJoueur2 = findViewById(R.id.player2);
        LB_Joueur1 = findViewById(R.id.label_player1);
        LT_Joueur1 = findViewById(R.id.layout_player1);
        LB_Joueur2 = findViewById(R.id.label_player2);
        LT_Joueur2 = findViewById(R.id.layout_player2);

        ET_SaisieJoueur1.setVisibility(View.INVISIBLE);
        ET_SaisieJoueur2.setVisibility(View.INVISIBLE);
        BT_NouvellePartie.setVisibility(View.INVISIBLE);
    }

    @Override
    protected void onStart() {
        super.onStart();

        // Ajoutez un écouteur de clic au bouton
        BT_NouveauJoueur.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LB_Joueur1.setVisibility(View.VISIBLE);
                LT_Joueur1.setVisibility(View.VISIBLE);
                ET_SaisieJoueur1.setVisibility(View.VISIBLE);
            }
        });

        ET_SaisieJoueur1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                LB_Joueur2.setVisibility(View.VISIBLE);
                LT_Joueur2.setVisibility(View.VISIBLE);
                ET_SaisieJoueur2.setVisibility(View.VISIBLE);
            }

            @Override
            public void afterTextChanged(Editable s) {
                joueur1 = ET_SaisieJoueur1.getText().toString();
            }
        });

        ET_SaisieJoueur2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                BT_NouvellePartie.setVisibility(View.VISIBLE);

                if (!ET_SaisieJoueur1.getText().toString().equals("") && !ET_SaisieJoueur2.getText().toString().equals(""))
                    BT_NouveauJoueur.setEnabled(false);
            }

            @Override
            public void afterTextChanged(Editable s) {
                joueur2 = ET_SaisieJoueur2.getText().toString();
            }
        });

        BT_NouvellePartie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent activityGame = new Intent(MainActivity.this, com.example.speedquiz.GameActivity.class);
                activityGame.putExtra("Joueur1", joueur1);
                activityGame.putExtra("Joueur2", joueur2);
                startActivity(activityGame);
            }
        });

    }
}