package com.example.user10.keerat.activity.activity;

import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.user10.keerat.R;

public class TermsAndConditions extends AppCompatActivity {
    TextView tvterms,tvconditions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_terms_and_conditions);
        tvterms = (TextView)findViewById(R.id.tv_terms);
        tvconditions = (TextView)findViewById(R.id.tv_conditions);

        Typeface typeface=Typeface.createFromAsset(getAssets(), "font/avenir-next-regular.ttf");
        Typeface typefacebold=Typeface.createFromAsset(getAssets(), "font/avenir-next-bold.ttf");
        Typeface typefacemedium=Typeface.createFromAsset(getAssets(), "font/AvenirNext-Medium.ttf");
        tvterms.setTypeface(typefacebold);
        tvconditions.setTypeface(typeface);



    }
}
