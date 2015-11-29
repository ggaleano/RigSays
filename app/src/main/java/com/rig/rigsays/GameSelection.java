package com.rig.rigsays;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

/**
 * Created by Geo on 10/29/15.
 */
public class GameSelection extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.games_selection);


        GridView gridview = (GridView) findViewById(R.id.gridview);
        gridview.setAdapter(new ImageAdapter(this));

        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v,
                                    int position, long id) {
                Intent intent;

                //more comments here


                if(position == 0){
//                    intent = new Intent(GameSelection.this, Games.class);
//                    startActivity(intent);
//                    Toast.makeText(GameSelection.this, "Coming Soon",
//                            Toast.LENGTH_SHORT).show();
                    intent = new Intent(GameSelection.this, Animals.class);
                    startActivity(intent);
                }
                else if(position == 1){
//                    intent = new Intent(GameSelection.this, Games.class);
//                    startActivity(intent);
                    //toast message ADDED THIS TO
                    //intent = new Intent(GameSelection.this, Flip3d.class);

                    intent = new Intent(GameSelection.this, Fruits.class);

                    startActivity(intent);
                }
                else if(position == 2){
//                    intent = new Intent(GameSelection.this, Games.class);
//                    startActivity(intent);
                    //intent = new Intent(GameSelection.this, QuizActivity.class);

                    intent = new Intent(GameSelection.this, Vegetables.class);

                    startActivity(intent);
                }
                else{
                    intent = new Intent(GameSelection.this, Games.class);
                    startActivity(intent);
                }

//                Toast.makeText(GameSelection.this, "Coming Soon",
//                        Toast.LENGTH_SHORT).show();


            }


        });


    }
}
