package com.rig.rigsays;

import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

/**
 * Created by Geo on 11/23/15.
 */
public class Vegetables extends Activity implements View.OnClickListener {

    ImageView image;
    Button next;
    int a = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.vegetables);

        image = (ImageView) findViewById(R.id.centerImage);

        Button restart = (Button) findViewById(R.id.restart);
        restart.setOnClickListener(this);

        Button previous = (Button) findViewById(R.id.previous);
        previous.setOnClickListener(this);

        next = (Button) findViewById(R.id.next);
        next.setOnClickListener(this);

    }


    @Override
    public void onClick(View view)
    {

        switch (view.getId())
        {
            case R.id.restart:
                image.setImageResource(R.drawable.garlic);
                a = 0;
                break;

            case R.id.next:
                if (a == 0)
                {
                    image.setImageResource(R.drawable.greenpepper);
                    a = 1;
                }
                else if (a == 1)
                {
                    image.setImageResource(R.drawable.eggplant);
                    a = 2;
                }
                else if (a == 2)
                {
                    image.setImageResource(R.drawable.onion);
                    a = 3;
                }
                else if (a == 3)
                {
                    image.setImageResource(R.drawable.corn);
                    a = 4;
                }
                else if (a == 4)
                {
                    image.setImageResource(R.drawable.carrots);
                    a = 5;
                }
                else if (a == 5)
                {
                    image.setImageResource(R.drawable.broccoli);
                    a = 6;
                }
                else if (a == 6)
                {
                    image.setImageResource(R.drawable.potato);
                    a = 7;
                }
                else if (a == 7)
                {
                    image.setImageResource(R.drawable.radish);
                    a = 8;
                }
                else if (a == 8)
                {
                    image.setImageResource(R.drawable.avocado);
                    a = 9;
                }
                else if (a == 9)
                {
                    image.setImageResource(R.drawable.pumpkin);
                    a = 10;
                }
                else if (a == 10)
                {
                    image.setImageResource(R.drawable.spinach);
                    image.setClickable(false);
                }
                break;
            case R.id.previous:
                a--;
                next.performClick();
                break;
        }

    }
}