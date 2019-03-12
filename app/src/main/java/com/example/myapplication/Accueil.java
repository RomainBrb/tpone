package com.example.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class Accueil extends AppCompatActivity {

    public void onCreate(Bundle saveInstanceState){
        super.onCreate(saveInstanceState);
        setContentView(R.layout.Accueil);

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


