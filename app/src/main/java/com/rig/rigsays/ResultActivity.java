package com.rig.rigsays;

/**
 * Created by Geo on 11/28/15.
 */
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.RatingBar;
import android.widget.TextView;
public class ResultActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
//get rating bar object
        RatingBar bar=(RatingBar)findViewById(R.id.ratingBar1);
//get text view
        TextView t=(TextView)findViewById(R.id.textResult);
//get score
        Bundle b = getIntent().getExtras();
        int score= b.getInt("score");
//display score
        bar.setRating(score);
        bar.setClickable(false);
        switch (score)
        {
            case 1: t.setText("Oopsie! Better Luck Next Time!");
                break;
            case 2: t.setText("Oopsie! Better Luck Next Time!");
                break;
            case 3: t.setText("Oopsie! Better Luck Next Time!");
                break;
            case 4: t.setText("Oopsie! Better Luck Next Time!");
                break;
            case 5: t.setText("Oopsie! Better Luck Next Time!");
                break;
            case 6: t.setText("Hmmmm.. Someone's been reading a lot of trivia");
                break;
            case 7: t.setText("Hmmmm.. Someone's been reading a lot of trivia");
                break;
            case 8: t.setText("Hmmmm.. Someone's been reading a lot of trivia");
                break;
            case 9: t.setText("Hmmmm.. Someone's been reading a lot of trivia");
                break;
            case 10: t.setText("Hmmmm.. Someone's been reading a lot of trivia");
                break;
            case 11:t.setText("Who are you? A trivia wizard???");
                break;
            case 12:t.setText("Who are you? A trivia wizard???");
                break;
            case 13:t.setText("Who are you? A trivia wizard???");
                break;
            case 14:t.setText("Who are you? A trivia wizard???");
                break;
            case 15:t.setText("Who are you? A trivia wizard???");
                break;
        }
    }
//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//// Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.activity_result, menu);
//        return true;
//    }
}