package com.example.user10.keerat.activity.activity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
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

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import static android.R.attr.button;

public class SigninActivity extends AppCompatActivity {
    private Button buttonnewuser,btnlogin;
    private EditText editTextemail,editTextpassword;
    private TextView textViewforgotpassword,textViewdntaccnt,textViewterm;
    private String email,password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE); // for hiding title

        getWindow().clearFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);

     /*   android.support.v7.app.ActionBar AB=getSupportActionBar();
        AB.hide();
*/
        setContentView(R.layout.activity_signin);
        editTextemail = (EditText) findViewById(R.id.et_enteremail);
        editTextpassword = (EditText) findViewById(R.id.et_enterpass);
        textViewforgotpassword = (TextView) findViewById(R.id.tv_forgotpass);
        textViewdntaccnt = (TextView) findViewById(R.id.tv_dntaccnt);
        textViewterm = (TextView) findViewById(R.id.tv_term);
        btnlogin = (Button) findViewById(R.id.btn_login);


        Typeface typeface = Typeface.createFromAsset(getAssets(), "font/avenir-next-regular.ttf");
        Typeface typefacebold = Typeface.createFromAsset(getAssets(), "font/avenir-next-bold.ttf");
        Typeface typefacemedium = Typeface.createFromAsset(getAssets(), "font/AvenirNext-Medium.ttf");

        editTextemail.setTypeface(typefacemedium);
        editTextemail.setTextColor(Color.parseColor("#ffffff"));
        editTextpassword.setTypeface(typefacemedium);
        editTextpassword.setTextColor(Color.parseColor("#ffffff"));
        textViewforgotpassword.setTypeface(typefacemedium);
        textViewdntaccnt.setTypeface(typefacemedium);
        textViewterm.setTypeface(typefacemedium);



        buttonnewuser = (Button) findViewById(R.id.btn_newuser);

        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                email=editTextemail.getText().toString().trim();
                password=editTextpassword.getText().toString().trim();
                SignIn();
            }
        });
        buttonnewuser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SigninActivity.this, SignupActivity.class);
                startActivity(intent);
            }
        });
        textViewterm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SigninActivity.this, TermsAndConditions.class);
                startActivity(intent);
            }
        });
    }



    private void SignIn() {




        StringRequest stringRequest = new StringRequest(Request.Method.POST, ConfigInfo.login,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.e("pppppppppp", response);
                        Toast.makeText(getApplicationContext(), response.toString(), Toast.LENGTH_LONG).show();

                        // Toast.makeText(SigninActivity.this,"Login",Toast.LENGTH_SHORT).show();
                      /*  Intent i = new Intent(SigninActivity.this, Registerserviceoptionsenabled.class);

//                        Intent intent = new Intent(OtpConfirmationActivity.this, OtpConfirmationActivity.class);
                        i.putExtra("otpdata", response.toString());
                        i.putExtra("user", userlogin);
                        startActivity(i);*/
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(SigninActivity.this, "Error Sign Up Process.Please Check your entered Credentials", Toast.LENGTH_LONG).show();
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

                params.put("user_login",email );
                params.put("password",password );



                return params;
            }

        };

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }


}





