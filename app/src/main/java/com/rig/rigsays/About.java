package com.rig.rigsays;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

/**
 * Created by Geo on 11/30/15.
 */
public class About extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.about);


    }


    public void goMenu(View view) {
        Intent intent = new Intent(this, GameSelection.class);
        startActivity(intent);
    }
}
