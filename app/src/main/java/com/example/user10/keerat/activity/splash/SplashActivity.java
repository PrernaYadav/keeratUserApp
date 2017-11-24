package com.example.user10.keerat.activity.splash;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.user10.keerat.R;

public class SplashActivity extends AppCompatActivity {

    TextView textView;


    // Splash screen timer
    private static int SPLASH_TIME_OUT = 3000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

   /*  requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        android.support.v7.app.ActionBar AB=getSupportActionBar();
        AB.hide();
*/



        textView = (TextView)findViewById(R.id.tv_splash);
        Typeface typeface=Typeface.createFromAsset(getAssets(), "font/avenir-next-regular.ttf");

        textView.setTypeface(typeface);


        new Handler().postDelayed(new Runnable() {


            @Override
            public void run() {
                // Start your app main activity
                Intent i = new Intent(SplashActivity.this, IntroActivity.class);
                startActivity(i);

                // close this activity
                finish();
            }
        }, SPLASH_TIME_OUT);
    }
}
