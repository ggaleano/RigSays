package com.rig.rigsays;

/**
 * Created by Geo on 11/28/15.
 */

import java.util.List;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class QuizActivity extends Activity {
    List<Question> quesList;
    int score = 0;
    int qid = 0;
    int question = 0;
    Question currentQ;
    TextView txtQuestion;
    RadioButton rda, rdb, rdc;
    Button butNext;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        DbHelper db = new DbHelper(this);
        quesList = db.getAllQuestions();
        currentQ = quesList.get(qid);
        txtQuestion = (TextView) findViewById(R.id.textView1);
        rda = (RadioButton) findViewById(R.id.radio0);
        rdb = (RadioButton) findViewById(R.id.radio1);
        rdc = (RadioButton) findViewById(R.id.radio2);
        butNext = (Button) findViewById(R.id.button1);
        final ImageView quiz_photo = (ImageView) findViewById(R.id.quiz_photo);





        setQuestionView();


        quiz_photo.setImageResource(R.drawable.ic_volume_up_black_36dp);
        MediaPlayer mp = MediaPlayer.create(getApplicationContext(), R.raw.turkey);
        mp.start();
        quiz_photo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MediaPlayer mp = MediaPlayer.create(getApplicationContext(), R.raw.turkey);
                mp.start();
            }
        });

        butNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RadioGroup grp = (RadioGroup) findViewById(R.id.radioGroup1);
                RadioButton answer = (RadioButton) findViewById(grp.getCheckedRadioButtonId());
                Log.d("yourans", currentQ.getANSWER() + " " + answer.getText());


                if (currentQ.getANSWER().equals(answer.getText())) {
                    score++;
                    Log.d("score", "Your score" + score);
                }

                if (qid < 15) {
                    currentQ = quesList.get(qid);
                    setQuestionView();
                    Log.d("Quiz", "question = " + qid);
                    setImageView(quiz_photo, question);




                } else {
                    Intent intent = new Intent(QuizActivity.this, ResultActivity.class);
                    Bundle b = new Bundle();
                    b.putInt("score", score); //Your score
                    intent.putExtras(b); //Put your score to your next Intent
                    startActivity(intent);
                    finish();
                }


            }
        });



    }

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//// Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.activity_quiz, menu);
//        return true;
//    }

    public void setImageView(ImageView quiz_photo, int question){


        if(question == 2){
            quiz_photo.setClickable(false);
            quiz_photo.setImageResource(R.drawable.frog);


        }
        else if(question == 3){
            //quiz_photo.setClickable(false);
            quiz_photo.setImageResource(R.drawable.eagle);

        }
        else if(question == 4){
            //quiz_photo.setClickable(false);
            quiz_photo.setClickable(true);
            quiz_photo.setImageResource(R.drawable.ic_volume_up_black_36dp);

            MediaPlayer mp = MediaPlayer.create(getApplicationContext(), R.raw.cat);
            mp.start();
            quiz_photo.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    MediaPlayer mp = MediaPlayer.create(getApplicationContext(), R.raw.cat);
                    mp.start();
                }
            });

        }
        else if(question == 5){
            quiz_photo.setClickable(false);
            quiz_photo.setImageResource(R.drawable.dog);


        }
        else if(question == 6){
            quiz_photo.setImageResource(R.drawable.grapes4);


        }else if(question == 7){
            quiz_photo.setImageResource(R.drawable.cherry);


        }else if(question == 8){
            quiz_photo.setImageResource(R.drawable.kiwi);


        }else if(question == 9){
            quiz_photo.setImageResource(R.drawable.strawberry);


        }else if(question == 10){
            quiz_photo.setImageResource(R.drawable.lemon);


        }else if(question == 11){
            quiz_photo.setImageResource(R.drawable.onion);


        }else if(question == 12){
            quiz_photo.setImageResource(R.drawable.spinach);


        }else if(question == 13){
            quiz_photo.setImageResource(R.drawable.radish);


        }else if(question == 14){
            quiz_photo.setImageResource(R.drawable.broccoli);


        }else if(question == 15) {
            quiz_photo.setImageResource(R.drawable.corn);


        }

    }

    private void setQuestionView() {
        txtQuestion.setText(currentQ.getQUESTION());
        rda.setText(currentQ.getOPTA());
        rdb.setText(currentQ.getOPTB());
        rdc.setText(currentQ.getOPTC());
        qid++;
        question++;

    }
}