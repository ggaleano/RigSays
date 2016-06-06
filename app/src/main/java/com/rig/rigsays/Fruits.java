package com.rig.rigsays;

import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.widget.Button;
import android.widget.ImageView;

/**
 * Created by Geo on 11/23/15.
 */
public class Fruits extends Activity implements View.OnClickListener {

    Button next,previous;
    int a = 0;

    Flip3dAnimation rotation;


    private ImageView image1;
    private ImageView image2;

    private boolean isFirstImage = true;

    MediaPlayer mp;

    ImageView soundImage;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.image_flip);

        //image1 = (ImageView) findViewById(R.id.centerImage);

        Button restart = (Button) findViewById(R.id.restart);
        restart.setOnClickListener(this);

        previous = (Button) findViewById(R.id.previous);
        previous.setOnClickListener(this);

        next = (Button) findViewById(R.id.next);
        next.setOnClickListener(this);






        ///code for flipping image1

        image1 = (ImageView) findViewById(R.id.ImageView01);
        image1.setImageResource(R.drawable.grapes4);

        image2 = (ImageView) findViewById(R.id.ImageView02);
        image2.setImageResource(R.drawable.f_grapes);

        mp = MediaPlayer.create(this, R.raw.grape);
        mp.start();

        image2.setVisibility(View.GONE);

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
                                                  mp = MediaPlayer.create(getApplicationContext(), R.raw.grape);
                                                  mp.start();
                                              }else if(a==1)
                                              {
                                                  mp = MediaPlayer.create(getApplicationContext(), R.raw.banana);
                                                  mp.start();
                                              }else if(a==2)

                                              {
                                                  mp = MediaPlayer.create(getApplicationContext(), R.raw.pear);
                                                  mp.start();
                                              }else if(a==3)

                                              {
                                                  mp = MediaPlayer.create(getApplicationContext(), R.raw.cherry);
                                                  mp.start();
                                              }else if(a==4)

                                              {
                                                  mp = MediaPlayer.create(getApplicationContext(), R.raw.watermelon);
                                                  mp.start();
                                              }else if(a==5)

                                              {
                                                  mp = MediaPlayer.create(getApplicationContext(), R.raw.orange);
                                                  mp.start();
                                              }else if(a==6)

                                              {
                                                  mp = MediaPlayer.create(getApplicationContext(), R.raw.kiwi);
                                                  mp.start();
                                              }else if(a==7)

                                              {
                                                  mp = MediaPlayer.create(getApplicationContext(), R.raw.lemon);
                                                  mp.start();
                                              }else if(a==8)

                                              {
                                                  mp = MediaPlayer.create(getApplicationContext(), R.raw.peach);
                                                  mp.start();
                                              }else if(a==9)

                                              {
                                                  mp = MediaPlayer.create(getApplicationContext(), R.raw.strawberry);
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
        rotation =
                new Flip3dAnimation(start, end, centerX, centerY);
        rotation.setDuration(500);
        rotation.setFillAfter(true);
        rotation.setInterpolator(new AccelerateInterpolator());
        rotation.setAnimationListener(new DisplayNextView(isFirstImage, image1, image2));

        if (isFirstImage)
        {
            image1.startAnimation(rotation);
        } else {
            image2.startAnimation(rotation);
        }

    }


    @Override
    public void onClick(View view)
    {

        switch (view.getId())
        {
            case R.id.restart:
                image1.setImageResource(R.drawable.grapes4);
                image2.setImageResource(R.drawable.f_grapes);

                mp = MediaPlayer.create(this, R.raw.grape);
                mp.start();
                a = 0;
                break;

            case R.id.next:
                if (a == 0 && isFirstImage )
                {
                    image1.setImageResource(R.drawable.banana);
                    image2.setImageResource(R.drawable.f_banana);

                    mp = MediaPlayer.create(this, R.raw.banana);
                    mp.start();


                    a = 1;
                }
                else if (a == 1 && isFirstImage)
                {
                    image1.setImageResource(R.drawable.pear);
                    image2.setImageResource(R.drawable.f_pear);

                    mp = MediaPlayer.create(this, R.raw.pear);
                    mp.start();

                    a = 2;
                }
                else if (a == 2 && isFirstImage)
                {
                    image1.setImageResource(R.drawable.cherry);
                    image2.setImageResource(R.drawable.f_cherry);

                    mp = MediaPlayer.create(this, R.raw.cherry);
                    mp.start();
                    a = 3;
                }
                else if (a == 3 && isFirstImage)
                {
                    image1.setImageResource(R.drawable.watermelon);
                    image2.setImageResource(R.drawable.f_watermelon);

                    mp = MediaPlayer.create(this, R.raw.watermelon);
                    mp.start();
                    a = 4;
                }
                else if (a == 4 && isFirstImage)
                {
                    image1.setImageResource(R.drawable.orange);
                    image2.setImageResource(R.drawable.f_orange);

                    mp = MediaPlayer.create(this, R.raw.orange);
                    mp.start();
                    a = 5;
                }
                else if (a == 5 && isFirstImage)
                {
                    image1.setImageResource(R.drawable.kiwi);
                    image2.setImageResource(R.drawable.f_kiwi);

                    mp = MediaPlayer.create(this, R.raw.kiwi);
                    mp.start();
                    a = 6;
                }
                else if (a == 6 && isFirstImage)
                {
                    image1.setImageResource(R.drawable.lemon);
                    image2.setImageResource(R.drawable.f_lemon);

                    mp = MediaPlayer.create(this, R.raw.lemon);
                    mp.start();
                    a = 7;
                }
                else if (a == 7 && isFirstImage)
                {
                    image1.setImageResource(R.drawable.peach);
                    image2.setImageResource(R.drawable.f_peach);

                    mp = MediaPlayer.create(this, R.raw.peach);
                    mp.start();
                    a = 8;
                }
                else if (a == 8 && isFirstImage)
                {
                    image1.setImageResource(R.drawable.strawberry);
                    image2.setImageResource(R.drawable.f_straberry);

                    mp = MediaPlayer.create(this, R.raw.strawberry);
                    mp.start();
                    a = 9;
                    //image1.setClickable(false);
                }
                break;
            case R.id.previous:
                if (a == 9 && isFirstImage)
                {
                    image1.setImageResource(R.drawable.peach);
                    image2.setImageResource(R.drawable.f_peach);

                    mp = MediaPlayer.create(this, R.raw.peach);
                    mp.start();
                    a = 8;
                }
                else if (a == 8 && isFirstImage)
                {
                    image1.setImageResource(R.drawable.lemon);
                    image2.setImageResource(R.drawable.f_lemon);

                    mp = MediaPlayer.create(this, R.raw.lemon);
                    mp.start();
                    a = 7;
                }
                else if (a == 7 && isFirstImage)
                {
                    image1.setImageResource(R.drawable.kiwi);
                    image2.setImageResource(R.drawable.f_kiwi);

                    mp = MediaPlayer.create(this, R.raw.kiwi);
                    mp.start();
                    a = 6;
                }
                else if (a == 6 && isFirstImage)
                {
                    image1.setImageResource(R.drawable.orange);
                    image2.setImageResource(R.drawable.f_orange);

                    mp = MediaPlayer.create(this, R.raw.orange);
                    mp.start();
                    a = 5;
                }
                else if (a == 5 && isFirstImage)
                {
                    image1.setImageResource(R.drawable.watermelon);
                    image2.setImageResource(R.drawable.f_watermelon);

                    mp = MediaPlayer.create(this, R.raw.watermelon);
                    mp.start();
                    a = 4;
                }
                else if (a == 4 && isFirstImage)
                {
                    image1.setImageResource(R.drawable.cherry);
                    image2.setImageResource(R.drawable.f_cherry);

                    mp = MediaPlayer.create(this, R.raw.cherry);
                    mp.start();
                    a = 3;
                }
                else if (a == 3 && isFirstImage)
                {
                    image1.setImageResource(R.drawable.pear);
                    image2.setImageResource(R.drawable.f_pear);

                    mp = MediaPlayer.create(this, R.raw.pear);
                    mp.start();
                    a = 2;
                }
                else if (a == 2 && isFirstImage)
                {
                    image1.setImageResource(R.drawable.banana);
                    image2.setImageResource(R.drawable.f_banana);

                    mp = MediaPlayer.create(this, R.raw.banana);
                    mp.start();
                    a = 1;
                }
                else if (a == 1 && isFirstImage)
                {
                    image1.setImageResource(R.drawable.grapes4);
                    image2.setImageResource(R.drawable.f_grapes);

                    mp = MediaPlayer.create(this, R.raw.grape);
                    mp.start();
                    a =0;
                    //image1.setClickable(false);

                }

//                a--;
//                next.performClick();
//                break;
        }

    }
}