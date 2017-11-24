package com.example.user10.keerat.activity.activity;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ViewTreeObserver;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.user10.keerat.R;

public class SelectCategoryActivity extends AppCompatActivity {
    Spinner spinner_1,spinner_2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_category);

        spinner_1 = (Spinner)findViewById(R.id.spinner1);
        spinner_2 = (Spinner)findViewById(R.id.spinner2);

        spinner_1.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                ((TextView) spinner_1.getSelectedView()).setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            }
        });

        spinner_2.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                ((TextView) spinner_2.getSelectedView()).setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            }
        });
    }
}
