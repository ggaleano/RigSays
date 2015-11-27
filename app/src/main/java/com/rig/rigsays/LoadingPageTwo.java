package com.rig.rigsays;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

/**
 * Created by ikergonzalez on 11/23/15.
 */
public class LoadingPageTwo extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.loading_page_two);

        final ImageView iv = (ImageView) findViewById(R.id.imageView);
        final Animation an = AnimationUtils.loadAnimation(getBaseContext(), R.anim.fade_out);
        final Animation an2 = AnimationUtils.loadAnimation(getBaseContext(),R.anim.fade_in);



        iv.startAnimation(an);
        an.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                iv.startAnimation(an);
                iv.startAnimation(an2);

                finish();

//                Intent i = new Intent(LoadingPage.this, LoadingPageTwo.class);
//                startActivity(i);

                Intent intent = new Intent();
                intent.setClass(LoadingPageTwo.this, LoadingPageThree.class);
                startActivity(intent);
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);

            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

    }

}
