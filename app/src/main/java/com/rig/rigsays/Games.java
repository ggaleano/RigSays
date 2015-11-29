package com.rig.rigsays;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by ikergonzalez on 11/4/15.
 */
public class Games extends Activity {

    MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.games);

        mediaPlayer = MediaPlayer.create(this, R.raw.cow);
        mediaPlayer.start();

        final TextView mTextField = (TextView) findViewById(R.id.mTextField);

        new CountDownTimer(10000, 1000) {

            public void onTick(long millisUntilFinished) {
                mTextField.setText("Time Remaining " + millisUntilFinished / 1000);
            }

            public void onFinish() {
                //mTextField.setText("done!");
                Intent intent = new Intent(Games.this, GameSelection.class);
                startActivity(intent);

            }
        }.start();

    }

    public void onRadioButtonClicked(View view) {


        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch (view.getId()) {
            case R.id.radio_1:
                if (checked)

                    break;
            case R.id.radio_2:
                if (checked)

                    break;

            case R.id.radio_3:
                if (checked)

                    break;

            case R.id.radio_4:
                if (checked)

                    break;
        }
    }

    public void submit(View view) {
        RadioButton b1 = (RadioButton) findViewById(R.id.radio_1);
        RadioButton b2 = (RadioButton) findViewById(R.id.radio_2);
        RadioButton b3 = (RadioButton) findViewById(R.id.radio_3);
        RadioButton b4 = (RadioButton) findViewById(R.id.radio_4);

        RelativeLayout bg = (RelativeLayout) findViewById(R.id.background);
        Button submit = (Button) findViewById(R.id.buttonName);
        TextView text = (TextView) findViewById(R.id.text);

        if (b1.isChecked()) {
            Toast.makeText(getApplicationContext(), "Wrong Answer",
                    Toast.LENGTH_SHORT).show();

        } else if (b2.isChecked()) {
            Toast.makeText(getApplicationContext(), "Correct!",
                    Toast.LENGTH_SHORT).show();

        } else if (b3.isChecked()) {

            Toast.makeText(getApplicationContext(), "Wrong Answer",
                    Toast.LENGTH_SHORT).show();

        } else if (b4.isChecked()) {

            Toast.makeText(getApplicationContext(), "Wrong Answer",
                    Toast.LENGTH_SHORT).show();
        }
    }



    @Override
    protected void onResume() {
        super.onResume();
        mediaPlayer.start();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mediaPlayer.release();
    }

    @Override
    protected void onPause() {
        super.onPause();
        mediaPlayer.pause();
    }

    public void goToGames(View view) {
        Intent intent = new Intent(this, GameSelection.class);
        startActivity(intent);

    }

    public void activateSound(View view) {
        mediaPlayer = MediaPlayer.create(this, R.raw.cow);
        mediaPlayer.start();
    }
}
