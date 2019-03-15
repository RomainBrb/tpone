package com.example.myapplication;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.myapplication.Nom;
import com.example.myapplication.R;

import java.util.List;

public class NomAdapter extends ArrayAdapter<Nom> {

    public NomAdapter(Context context, List<Nom> noms) {
        super(context, 0, noms);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if(convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.accueil,parent, false);
        }

        TweetViewHolder viewHolder = (TweetViewHolder) convertView.getTag();
        if(viewHolder == null){
            viewHolder = new TweetViewHolder();
            viewHolder.pseudo = (TextView) convertView.findViewById(R.id.prenom);
            viewHolder.text = (TextView) convertView.findViewById(R.id.nom);
            convertView.setTag(viewHolder);
        }

        //getItem(position) va récupérer l'item [position] de la List<Tweet> tweets
        Nom tweet = getItem(position);
        viewHolder.pseudo.setText(tweet.getPseudo());
        viewHolder.text.setText(tweet.getText());

        return convertView;
    }

    private class TweetViewHolder{
        public TextView pseudo;
        public TextView text;

    }
}