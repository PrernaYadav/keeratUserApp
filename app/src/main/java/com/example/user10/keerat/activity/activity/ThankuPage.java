package com.example.user10.keerat.activity.activity;

import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import com.example.user10.keerat.R;

public class ThankuPage extends AppCompatActivity {
    TextView tvthanku;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thanku_page);
        tvthanku = (TextView) findViewById(R.id.tv_thanku);
        Typeface typeface=Typeface.createFromAsset(getAssets(), "font/avenir-next-regular.ttf");

        tvthanku.setTypeface(typeface);


    }
}
