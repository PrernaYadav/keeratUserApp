package com.example.user10.keerat.activity.activity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Build;
import android.support.annotation.IdRes;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.user10.keerat.R;
import com.example.user10.keerat.activity.Class.ConfigInfo;

import java.util.HashMap;
import java.util.Map;

public class MobileOrEmailActivity extends AppCompatActivity {
    private TextView tvotp, tvsendagain, tvlongtext;
    private Button btnenterotp, btnrefnum, btnsubmit;
    private EditText etmobile, etemail;
    TextView tvor;
    private RadioGroup rgmob;
    private RadioButton rbmob,rbemail;
    String mobile, email, idemail, medium,idemob;
    String tv1,id;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otp);


        id = getIntent().getExtras().getString("data");
        idemail = getIntent().getExtras().getString("email");
        idemob = getIntent().getExtras().getString("mob");

        //ID's
        tvotp = (TextView) findViewById(R.id.tv_otp);

        rgmob = (RadioGroup)findViewById(R.id.rg_mobemail);
        rbmob = (RadioButton) findViewById(R.id.rb_mob);
        rbemail = (RadioButton) findViewById(R.id.rb_email);

        Toast.makeText(this, id, Toast.LENGTH_LONG).show();

        rgmob.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, @IdRes int i) {
                if (i==R.id.rb_mob){
                    medium = idemob;

                }else if(i==R.id.rb_email){

                    medium=idemail;

                }
            }});

//        tvor = (TextView) findViewById(R.id.tv_or);


        // tv.setText(getIntent().getStringExtra("data"));





       /* etmobile = (EditText) findViewById(R.id.et_mobilenum);
        etemail = (EditText) findViewById(R.id.et_email);*/



//       medium = etmobile.getText().toString().trim();


        btnsubmit = (Button) findViewById(R.id.btn_submit);


        btnsubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {





               /* if (!etmobile.getText().toString().equals("")){
                    medium = etmobile.getText().toString().trim();

                }else if(!etemail.getText().toString().equals("")){
                    medium = idemail;
                }*/
//                if (!etmobile.getText().toString().equals(" ")){
//
//                }
//               medium = etmobile.getText().toString().trim();
//                medium = etemail.getText().toString().trim();

                submit();

            }
        });


     /*   etmobile.setOnFocusChangeListener(new View.OnFocusChangeListener() {


            public void onFocusChange(View v, boolean hasFocus) {

                tvor.setVisibility(View.INVISIBLE);

//                medium = etmobile.getText().toString();
                if (hasFocus) {

//                    etmobile.setText(medium);
                    etemail.setVisibility(View.GONE);

                }

            }
        });
        etemail.setOnFocusChangeListener(new View.OnFocusChangeListener() {

            public void onFocusChange(View v, boolean hasFocus) {

                tvor.setVisibility(View.INVISIBLE);

                if (hasFocus) {
                    *//*medium = idemail;
                    etemail.setText(medium);
                    etmobile.setVisibility(View.GONE);*//*

                    etemail.setText(idemail);
                    etmobile.setVisibility(View.GONE);

                }
            }
        });*/

        Typeface typeface = Typeface.createFromAsset(getAssets(), "font/avenir-next-regular.ttf");
        Typeface typefacebold = Typeface.createFromAsset(getAssets(), "font/avenir-next-bold.ttf");
        Typeface typefacemedium = Typeface.createFromAsset(getAssets(), "font/AvenirNext-Medium.ttf");

    }

    private void submit() {

        StringRequest stringRequest = new StringRequest(Request.Method.POST, ConfigInfo.otp,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.e("response.....email.....", response);
                        Toast.makeText(getApplicationContext(), response.toString(), Toast.LENGTH_LONG).show();

                        Intent intent = new Intent(MobileOrEmailActivity.this, OtpConfirmationActivity.class);
                        intent.putExtra("otpdata", response.toString());
                        intent.putExtra("medium", medium);
                        intent.putExtra("mobile", idemob);
                        startActivity(intent);
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(MobileOrEmailActivity.this, "Error Sign Up Process.Please Check your entered Credentials", Toast.LENGTH_LONG).show();
                    }
                }) {
            @Override
            protected Map<String, String> getParams() {
               /* SharedPreferences sharedPreferences = getApplicationContext().getSharedPreferences("UserProfile", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("email", email);
                editor.putString("password", password);
                editor.putString("reference", reference);

                //   editor.putString("car_preference", car_preference);
                editor.commit();*/

                Map<String, String> params = new HashMap<String, String>();

                params.put("medium", medium);
                params.put("email_id", idemail);

                Log.e("ghg", "" + params);
                return params;
            }

        };

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }


}

