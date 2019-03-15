package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class Nom extends AppCompatActivity {

    private int color;
    private String prenom;
    private String nom;

    public Nom(int color, String prenom, String nom) {
        this.color = color;
        this.prenom = prenom;
        this.nom = nom;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public String getPseudo() {
        return prenom;
    }

    public void setPseudo(String prenom) {
        this.prenom = prenom;
    }

    public String getText() {
        return nom;
    }

    public void setText(String nom) {
        this.nom = nom;
    }

    public void onCreate(Bundle saveInstanceState){
        super.onCreate(saveInstanceState);
        setContentView(R.layout.accueil);

        TextView nom;
        Intent intent = getIntent();
        Bundle b = intent.getExtras();

        nom = (TextView) findViewById(R.id.MsgAccueil);

        if(intent != null)
        {
            String j = (String) b.get("nom");
            nom.setText("Bonjour " + j);
        }
    }
}


