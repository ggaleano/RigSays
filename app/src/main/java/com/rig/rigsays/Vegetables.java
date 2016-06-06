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
public class Vegetables extends Activity implements View.OnClickListener {

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
        image1.setImageResource(R.drawable.greenpepper);

        image2 = (ImageView) findViewById(R.id.ImageView02);
        image2.setImageResource(R.drawable.f_greenpepper);

        mp = MediaPlayer.create(this, R.raw.pepper);
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
                                                  mp = MediaPlayer.create(getApplicationContext(), R.raw.pepper);
                                                  mp.start();
                                              }else if(a==1)
                                              {
                                                  mp = MediaPlayer.create(getApplicationContext(), R.raw.eggplant);
                                                  mp.start();
                                              }else if(a==2)

                                              {
                                                  mp = MediaPlayer.create(getApplicationContext(), R.raw.onion);
                                                  mp.start();
                                              }else if(a==3)

                                              {
                                                  mp = MediaPlayer.create(getApplicationContext(), R.raw.corn);
                                                  mp.start();
                                              }else if(a==4)

                                              {
                                                  mp = MediaPlayer.create(getApplicationContext(), R.raw.carrot);
                                                  mp.start();
                                              }else if(a==5)

                                              {
                                                  mp = MediaPlayer.create(getApplicationContext(), R.raw.broccoli);
                                                  mp.start();
                                              }else if(a==6)

                                              {
                                                  mp = MediaPlayer.create(getApplicationContext(), R.raw.radish);
                                                  mp.start();
                                              }else if(a==7)

                                              {
                                                  mp = MediaPlayer.create(getApplicationContext(), R.raw.avocado);
                                                  mp.start();
                                              }else if(a==8)

                                              {
                                                  mp = MediaPlayer.create(getApplicationContext(), R.raw.pumpkin);
                                                  mp.start();
                                              }else if(a==9)

                                              {
                                                  mp = MediaPlayer.create(getApplicationContext(), R.raw.spinach);
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
                image1.setImageResource(R.drawable.greenpepper);
                image2.setImageResource(R.drawable.f_greenpepper);

                mp = MediaPlayer.create(this, R.raw.pepper);
                mp.start();
                a = 0;
                break;

            case R.id.next:
                if (a == 0 && isFirstImage)
                {
                    image1.setImageResource(R.drawable.eggplant);
                    image2.setImageResource(R.drawable.f_eggplant);

                    mp = MediaPlayer.create(this, R.raw.eggplant);
                    mp.start();
                    a = 1;
                }
                else if (a == 1 && isFirstImage)
                {
                    image1.setImageResource(R.drawable.onion);
                    image2.setImageResource(R.drawable.f_onion);

                    mp = MediaPlayer.create(this, R.raw.onion);
                    mp.start();
                    a = 2;
                }
                else if (a == 2 && isFirstImage)
                {
                    image1.setImageResource(R.drawable.corn);
                    image2.setImageResource(R.drawable.f_corn);

                    mp = MediaPlayer.create(this, R.raw.corn);
                    mp.start();
                    a = 3;
                }
                else if (a == 3 && isFirstImage)
                {
                    image1.setImageResource(R.drawable.carrots);
                    image2.setImageResource(R.drawable.f_carrots);

                    mp = MediaPlayer.create(this, R.raw.carrot);
                    mp.start();
                    a = 4;
                }
                else if (a == 4 && isFirstImage)
                {
                    image1.setImageResource(R.drawable.broccoli);
                    image2.setImageResource(R.drawable.f_broccoli);

                    mp = MediaPlayer.create(this, R.raw.broccoli);
                    mp.start();
                    a = 5;
                }
                else if (a == 5 && isFirstImage)
                {
                    image1.setImageResource(R.drawable.radish);
                    image2.setImageResource(R.drawable.f_radish);

                    mp = MediaPlayer.create(this, R.raw.radish);
                    mp.start();
                    a = 6;
                }
                else if (a == 6 && isFirstImage)
                {
                    image1.setImageResource(R.drawable.avocado);
                    image2.setImageResource(R.drawable.f_avocado);

                    mp = MediaPlayer.create(this, R.raw.avocado);
                    mp.start();
                    a = 7;
                }
                else if (a == 7 && isFirstImage)
                {
                    image1.setImageResource(R.drawable.pumpkin);
                    image2.setImageResource(R.drawable.f_pumpkin);

                    mp = MediaPlayer.create(this, R.raw.pumpkin);
                    mp.start();
                    a = 8;
                }
                else if (a == 8 && isFirstImage)
                {
                    image1.setImageResource(R.drawable.spinach);
                    image2.setImageResource(R.drawable.f_spinach);

                    mp = MediaPlayer.create(this, R.raw.spinach);
                    mp.start();
                    a = 9;
                    //image1.setClickable(false);

                }

                break;
            case R.id.previous:
                if (a == 9 && isFirstImage)
                {
                    image1.setImageResource(R.drawable.pumpkin);
                    image2.setImageResource(R.drawable.f_pumpkin);

                    mp = MediaPlayer.create(this, R.raw.pumpkin);
                    mp.start();
                    a = 8;
                }
                else if (a == 8 && isFirstImage)
                {
                    image1.setImageResource(R.drawable.avocado);
                    image2.setImageResource(R.drawable.f_avocado);

                    mp = MediaPlayer.create(this, R.raw.avocado);
                    mp.start();
                    a = 7;
                }
                else if (a == 7 && isFirstImage)
                {
                    image1.setImageResource(R.drawable.radish);
                    image2.setImageResource(R.drawable.f_radish);

                    mp = MediaPlayer.create(this, R.raw.radish);
                    mp.start();
                    a = 6;
                }
                else if (a == 6 && isFirstImage)
                {
                    image1.setImageResource(R.drawable.broccoli);
                    image2.setImageResource(R.drawable.f_broccoli);

                    mp = MediaPlayer.create(this, R.raw.broccoli);
                    mp.start();
                    a = 5;
                }
                else if (a == 5 && isFirstImage)
                {
                    image1.setImageResource(R.drawable.carrots);
                    image2.setImageResource(R.drawable.f_carrots);

                    mp = MediaPlayer.create(this, R.raw.carrot);
                    mp.start();
                    a = 4;
                }
                else if (a == 4 && isFirstImage)
                {
                    image1.setImageResource(R.drawable.corn);
                    image2.setImageResource(R.drawable.f_corn);

                    mp = MediaPlayer.create(this, R.raw.corn);
                    mp.start();
                    a = 3;
                }
                else if (a == 3 && isFirstImage)
                {
                    image1.setImageResource(R.drawable.onion);
                    image2.setImageResource(R.drawable.f_onion);

                    mp = MediaPlayer.create(this, R.raw.onion);
                    mp.start();
                    a = 2;
                }
                else if (a == 2 && isFirstImage)
                {
                    image1.setImageResource(R.drawable.eggplant);
                    image2.setImageResource(R.drawable.f_eggplant);

                    mp = MediaPlayer.create(this, R.raw.eggplant);
                    mp.start();
                    a = 1;
                }
                else if (a == 1 && isFirstImage)
                {
                    image1.setImageResource(R.drawable.greenpepper);
                    image2.setImageResource(R.drawable.f_greenpepper);

                    mp = MediaPlayer.create(this, R.raw.pepper);
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