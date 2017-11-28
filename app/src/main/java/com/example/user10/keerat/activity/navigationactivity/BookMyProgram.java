package com.example.user10.keerat.activity.navigationactivity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.widget.ListView;

import com.example.user10.keerat.R;
import com.example.user10.keerat.activity.adaptor.BookProgramAdaptor;
import com.example.user10.keerat.activity.model.BookProgramModel;

import java.util.ArrayList;

public class BookMyProgram extends AppCompatActivity {

    ArrayList<BookProgramModel> bookprogramModels;
    ListView listView;
    Toolbar toolbar;
    private static BookProgramAdaptor adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_my_program);
        toolbar = (Toolbar) findViewById(R.id.toolbarbookprogram);
        listView=(ListView)findViewById(R.id.lv_bookprogram);

        if (toolbar != null) {
            ((AppCompatActivity) BookMyProgram.this).setSupportActionBar(toolbar);
            ((AppCompatActivity) BookMyProgram.this).getSupportActionBar().setTitle(Html.fromHtml("<b>Home</b>"));
        }

        bookprogramModels= new ArrayList<>();
        bookprogramModels= new ArrayList<>();

       // bookprogramModels.add(new BookProgramModel("Apple Pie", "abc"));



        adapter= new BookProgramAdaptor(bookprogramModels,getApplicationContext());

        listView.setAdapter(adapter);
    }
}
