package com.example.myapplication;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ListView mListView;
    String[] prenoms = new String[]{
            "Antoine", "Benoit", "Cyril", "David", "Eloise", "Florent",
            "Gerard", "Hugo", "Ingrid", "Jonathan", "Kevin", "Logan",
            "Mathieu", "Noemie", "Olivia", "Philippe", "Quentin", "Romain",
            "Sophie", "Tristan", "Ulric", "Vincent", "Willy", "Xavier", "Yann", "Zoé"
    };

    private Button validForm ;
    public String Tnom;
    public String Tprenom;
    public EditText nom,prenom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mListView = (ListView) findViewById(R.id.listView);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        this.nom = findViewById(R.id.nom);
        this.prenom = findViewById(R.id.prenom);
        this.validForm = findViewById(R.id.buttonA);

        validForm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent secondActi = new Intent(getApplicationContext(),NomAdapter.class);
                startActivity(secondActi);
                Tnom=nom.getText().toString();
                Tprenom=prenom.getText().toString();
                Toast.makeText(getApplicationContext(), "Bienvenue !" + Tnom + " " + Tprenom, Toast.LENGTH_LONG).show();
                finish();
            }
        });}

    private List<Nom> genererNom(){
        List<Nom> noms = new ArrayList<Nom>();
        noms.add(new Nom(Color.BLACK, "Florent", "Debe"));
        noms.add(new Nom(Color.BLUE, "Kevin", "Ardino"));
        noms.add(new Nom(Color.GREEN, "Logan", "Lassalle"));
        noms.add(new Nom(Color.RED, "Mathieu", "Carrere"));
        noms.add(new Nom(Color.GRAY, "Willy", "Nardinemouk"));
        return noms;
    }

    private void afficherListeNom(){
        List<Nom> noms = genererNom();

        NomAdapter adapter = new NomAdapter(MainActivity.this, noms);
        mListView.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
