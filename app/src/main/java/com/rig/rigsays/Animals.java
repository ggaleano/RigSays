package com.rig.rigsays;

import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.widget.Button;
import android.widget.ImageView;

/**
 * Created by Iker on 11/23/15.
 */
public class Animals extends Activity implements View.OnClickListener {


    Button next, previous;
    int a = 0;


    private ImageView image1;
    private ImageView image2;

    private boolean isFirstImage = true;


    MediaPlayer mp;

    ImageView soundImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.image_flip);

        //image = (ImageView) findViewById(R.id.centerImage);

        Button restart = (Button) findViewById(R.id.restart);
        restart.setOnClickListener(this);

        previous = (Button) findViewById(R.id.previous);
        previous.setOnClickListener(this);

        next = (Button) findViewById(R.id.next);
        next.setOnClickListener(this);


//        final MediaPlayer mMonkey = MediaPlayer.create(this, R.raw.monkey);
//        final MediaPlayer mCow = MediaPlayer.create(this, R.raw.cow);
//        final MediaPlayer mEagle = MediaPlayer.create(this, R.raw.eagle);


        ///code for flipping image1

        image1 = (ImageView) findViewById(R.id.ImageView01);
        image1.setImageResource(R.drawable.monkey);

        image2 = (ImageView) findViewById(R.id.ImageView02);
        image2.setImageResource(R.drawable.f_monkey);

        image2.setVisibility(View.GONE);

        mp = MediaPlayer.create(this, R.raw.monkey);
        mp.start();

        image1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (isFirstImage) {
                    applyRotation(0, 90);
                    isFirstImage = !isFirstImage;

                } else {
                    applyRotation(0, -90);
                    isFirstImage = !isFirstImage;
                }
            }
        });


        soundImage = (ImageView) findViewById(R.id.soundView);

        soundImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (a == 0) {
                    mp = MediaPlayer.create(getApplicationContext(), R.raw.monkey);
                    mp.start();
                    }else if(a==1)
                {
                mp = MediaPlayer.create(getApplicationContext(), R.raw.cow);
                mp.start();
                }else if(a==2)

                {
                    mp = MediaPlayer.create(getApplicationContext(), R.raw.eagle);
                    mp.start();
                }else if(a==3)

                {
                    mp = MediaPlayer.create(getApplicationContext(), R.raw.tiger);
                    mp.start();
                }else if(a==4)

                {
                    mp = MediaPlayer.create(getApplicationContext(), R.raw.dog);
                    mp.start();
                }else if(a==5)

                {
                    mp = MediaPlayer.create(getApplicationContext(), R.raw.turkey);
                    mp.start();
                }else if(a==6)

                {
                    mp = MediaPlayer.create(getApplicationContext(), R.raw.dolphin);
                    mp.start();
                }else if(a==7)

                {
                    mp = MediaPlayer.create(getApplicationContext(), R.raw.cat);
                    mp.start();
                }else if(a==8)

                {
                    mp = MediaPlayer.create(getApplicationContext(), R.raw.frog);
                    mp.start();
                }else if(a==9)

                {
                    mp = MediaPlayer.create(getApplicationContext(), R.raw.elephant);
                    mp.start();
                }

        }
    }

    );

}


    private void applyRotation(float start, float end) {
// Find the center of image1
        final float centerX = image1.getWidth() / 2.0f;
        final float centerY = image1.getHeight() / 2.0f;

// Create a new 3D rotation with the supplied parameter
// The animation listener is used to trigger the next animation
        final Flip3dAnimation rotation =
                new Flip3dAnimation(start, end, centerX, centerY);
        rotation.setDuration(500);
        rotation.setFillAfter(true);
        rotation.setInterpolator(new AccelerateInterpolator());
        rotation.setAnimationListener(new DisplayNextView(isFirstImage, image1, image2));

        if (isFirstImage) {
            image1.startAnimation(rotation);
        } else {
            image2.startAnimation(rotation);
        }

    }


    @Override
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.restart:
                image1.setImageResource(R.drawable.monkey);
                image2.setImageResource(R.drawable.f_monkey);

                mp = MediaPlayer.create(this, R.raw.monkey);
                mp.start();
                a = 0;

                break;

            case R.id.next:
                if (a == 0 && isFirstImage) {
                    image1.setImageResource(R.drawable.cow);
                    image2.setImageResource(R.drawable.f_cow);

                    mp = MediaPlayer.create(this, R.raw.cow);
                    mp.start();
                    a = 1;
                } else if (a == 1 && isFirstImage) {
                    image1.setImageResource(R.drawable.eagle);
                    image2.setImageResource(R.drawable.f_eagle);

                    mp = MediaPlayer.create(this, R.raw.eagle);
                    mp.start();
                    a = 2;
                } else if (a == 2 && isFirstImage) {
                    image1.setImageResource(R.drawable.tiger);
                    image2.setImageResource(R.drawable.f_tiger);

                    mp = MediaPlayer.create(this, R.raw.tiger);
                    mp.start();
                    a = 3;
                } else if (a == 3 && isFirstImage) {
                    image1.setImageResource(R.drawable.dog);
                    image2.setImageResource(R.drawable.f_dog);

                    mp = MediaPlayer.create(this, R.raw.dog);
                    mp.start();
                    a = 4;
                } else if (a == 4 && isFirstImage) {
                    image1.setImageResource(R.drawable.turkey);
                    image2.setImageResource(R.drawable.f_turkey);

                    mp = MediaPlayer.create(this, R.raw.turkey);
                    mp.start();
                    a = 5;
                } else if (a == 5 && isFirstImage) {
                    image1.setImageResource(R.drawable.dolphin);
                    image2.setImageResource(R.drawable.f_dolphin);

                    mp = MediaPlayer.create(this, R.raw.dolphin);
                    mp.start();
                    a = 6;
                } else if (a == 6 && isFirstImage) {
                    image1.setImageResource(R.drawable.cat);
                    image2.setImageResource(R.drawable.f_cat);

                    mp = MediaPlayer.create(this, R.raw.cat);
                    mp.start();
                    a = 7;
                } else if (a == 7 && isFirstImage) {
                    image1.setImageResource(R.drawable.frog);
                    image2.setImageResource(R.drawable.f_frog);

                    mp = MediaPlayer.create(this, R.raw.frog);
                    mp.start();
                    a = 8;
                } else if (a == 8 && isFirstImage) {
                    image1.setImageResource(R.drawable.elephant);
                    image2.setImageResource(R.drawable.f_elephant);

                    mp = MediaPlayer.create(this, R.raw.elephant);
                    mp.start();
                    a = 9;
                    //image1.setClickable(false);
                }
                break;

            case R.id.previous:
                if (a == 9 && isFirstImage) {
                    image1.setImageResource(R.drawable.frog);
                    image2.setImageResource(R.drawable.f_frog);

                    mp = MediaPlayer.create(this, R.raw.frog);
                    mp.start();
                    a = 8;
                } else if (a == 8 && isFirstImage) {
                    image1.setImageResource(R.drawable.cat);
                    image2.setImageResource(R.drawable.f_cat);

                    mp = MediaPlayer.create(this, R.raw.cat);
                    mp.start();
                    a = 7;
                } else if (a == 7 && isFirstImage) {
                    image1.setImageResource(R.drawable.dolphin);
                    image2.setImageResource(R.drawable.f_dolphin);

                    mp = MediaPlayer.create(this, R.raw.dolphin);
                    mp.start();
                    a = 6;
                } else if (a == 6 && isFirstImage) {
                    image1.setImageResource(R.drawable.turkey);
                    image2.setImageResource(R.drawable.f_turkey);

                    mp = MediaPlayer.create(this, R.raw.turkey);
                    mp.start();
                    a = 5;
                } else if (a == 5 && isFirstImage) {
                    image1.setImageResource(R.drawable.dog);
                    image2.setImageResource(R.drawable.f_dog);

                    mp = MediaPlayer.create(this, R.raw.dog);
                    mp.start();
                    a = 4;
                } else if (a == 4 && isFirstImage) {
                    image1.setImageResource(R.drawable.tiger);
                    image2.setImageResource(R.drawable.f_tiger);
                    ;
                    mp = MediaPlayer.create(this, R.raw.tiger);
                    mp.start();
                    a = 3;
                } else if (a == 3 && isFirstImage) {
                    image1.setImageResource(R.drawable.eagle);
                    image2.setImageResource(R.drawable.f_eagle);

                    mp = MediaPlayer.create(this, R.raw.eagle);
                    mp.start();
                    a = 2;
                } else if (a == 2 && isFirstImage) {
                    image1.setImageResource(R.drawable.cow);
                    image2.setImageResource(R.drawable.f_cow);

                    mp = MediaPlayer.create(this, R.raw.cow);
                    mp.start();
                    a = 1;
                } else if (a == 1 && isFirstImage) {
                    image1.setImageResource(R.drawable.monkey);
                    image2.setImageResource(R.drawable.f_monkey);

                    mp = MediaPlayer.create(this, R.raw.monkey);
                    mp.start();
                    a = 0;
                    image1.setClickable(false);


                }


//                a--;
//                next.performClick();
//                break;
        }

    }
}
