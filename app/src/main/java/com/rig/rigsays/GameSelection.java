package com.rig.rigsays;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Toast;

/**
 * Created by Geo on 10/29/15.
 */
public class GameSelection extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.games_selection);

        ImageView iv1 = (ImageView) findViewById(R.id.animals);
        ImageView iv2 = (ImageView) findViewById(R.id.fruits);
        ImageView iv3 = (ImageView) findViewById(R.id.vegetables);
        ImageView iv4 = (ImageView) findViewById(R.id.quiz);

        iv1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(GameSelection.this, Animals.class);
                startActivity(intent);

            }
        });

        iv2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(GameSelection.this, Fruits.class);
                startActivity(intent);
            }
        });

        iv3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(GameSelection.this, Vegetables.class);
                startActivity(intent);
            }
        });

        iv4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(GameSelection.this, QuizActivity.class);
                startActivity(intent);
            }
        });

    }

    public void goToAbout(View view) {
        Intent intent = new Intent(this, About.class);
        startActivity(intent);
    }
}
