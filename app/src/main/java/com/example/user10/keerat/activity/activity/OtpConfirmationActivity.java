package com.example.user10.keerat.activity.activity;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
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
import java.util.concurrent.TimeUnit;

public class OtpConfirmationActivity extends AppCompatActivity {
    private  TextView tvtimer,tventerotp;
 private EditText etotp;
    private Button btn;
    private String iddmail,otp,userlogin,medium;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otp_confirmation);
        etotp = (EditText) findViewById(R.id.et_otp);
        tventerotp=(TextView) findViewById(R.id.tv_enterotp);
        medium= this.getIntent().getStringExtra("medium");

        tventerotp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Resend();
            }
        });

       /* String id = getIntent().getExtras().getString("otpdata");
        iddmail = getIntent().getExtras().getString("email");*/

       // otp=etotp.getText().toString().trim();


        btn = (Button) findViewById(R.id.btn_submitotp);


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               /* Intent i = new Intent(OtpConfirmationActivity.this,Registerserviceoptionsenabled.class);
                startActivity(i);*/
                otpsubmit();
            }
        });



        tvtimer = (TextView) findViewById(R.id.tv_timer);
        tvtimer.setText("00:03:00");
        final CounterClass timer = new CounterClass(180000, 1000);
        timer.start();
    }

    public class CounterClass extends CountDownTimer {
        public CounterClass(long millisInFuture, long countDownInterval) {
            super(millisInFuture, countDownInterval);
        }

        @Override
        public void onFinish() {
//            tvtimer.setText("Time Out.");

            resend();






        }



        @Override
        public void onTick(long millisUntilFinished) {
            long millis = millisUntilFinished;
            String hms = String.format("%02d:%02d:%02d", TimeUnit.MILLISECONDS.toHours(millis), TimeUnit.MILLISECONDS.toMinutes(millis) - TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS.toHours(millis)), TimeUnit.MILLISECONDS.toSeconds(millis) - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(millis)));
            System.out.println(hms);
            tvtimer.setText(hms);
        }
    }

    private void otpsubmit() {

        String data=this.getIntent().getStringExtra("otpdata");

        try {


            JSONObject result = new JSONObject(data);
            JSONArray routearray = result.getJSONArray("otp_info");
            for (int i = 0; i < routearray.length(); i++) {

                 userlogin = routearray.getJSONObject(i).getString("user_login");

            }

        } catch (Exception e) {
            e.printStackTrace();
        }



        StringRequest stringRequest = new StringRequest(Request.Method.POST, ConfigInfo.verify,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.e("response.....email.....", response);
                        Toast.makeText(getApplicationContext(), response.toString(), Toast.LENGTH_LONG).show();
                        Intent i = new Intent(OtpConfirmationActivity.this,Registerserviceoptionsenabled.class);

//                        Intent intent = new Intent(OtpConfirmationActivity.this, OtpConfirmationActivity.class);
                        i.putExtra("otpdata", response.toString());
                        i.putExtra("user",userlogin);
                        startActivity(i);
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(OtpConfirmationActivity.this, "Error Sign Up Process.Please Check your entered Credentials", Toast.LENGTH_LONG).show();
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

                params.put("otp", etotp.getText().toString().trim());
                params.put("email_id", medium);


                return params;
            }

        };

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }

public void resend(){

    String data=this.getIntent().getStringExtra("otpdata");

    try {


        JSONObject result = new JSONObject(data);
        JSONArray routearray = result.getJSONArray("otp_info");
        for (int i = 0; i < routearray.length(); i++) {

            userlogin = routearray.getJSONObject(i).getString("user_login");

        }

    } catch (Exception e) {
        e.printStackTrace();
    }


    StringRequest stringRequest = new StringRequest(Request.Method.POST, ConfigInfo.delete,
            new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {
                    Log.e("response..........", response);
                    Toast.makeText(getApplicationContext(),response.toString(), Toast.LENGTH_LONG).show();

                    /*Intent intent = new Intent(OtpConfirmationActivity.this, MobileOrEmailActivity.class);
                    intent.putExtra("data",response.toString());
                    intent.putExtra("email",email);
                    startActivity(intent);*/
                }
            },
            new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    Toast.makeText(OtpConfirmationActivity.this, "Error Sign Up Process.Please Check your entered Credentials", Toast.LENGTH_LONG).show();
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
            params.put("email_id", medium);

            return params;
        }

    };

    RequestQueue requestQueue = Volley.newRequestQueue(this);
    requestQueue.add(stringRequest);
}

public void Resend(){

    String data=this.getIntent().getStringExtra("otpdata");

    try {


        JSONObject result = new JSONObject(data);
        JSONArray routearray = result.getJSONArray("otp_info");
        for (int i = 0; i < routearray.length(); i++) {

            userlogin = routearray.getJSONObject(i).getString("user_login");

        }

    } catch (Exception e) {
        e.printStackTrace();
    }


    StringRequest stringRequest = new StringRequest(Request.Method.POST, ConfigInfo.resend,
            new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {
                    Log.e("response..........", response);
                    Toast.makeText(getApplicationContext(),response.toString(), Toast.LENGTH_LONG).show();

                    Intent intent = new Intent(OtpConfirmationActivity.this, MobileOrEmailActivity.class);
                    intent.putExtra("data",response.toString());
                    intent.putExtra("user",userlogin);
                    startActivity(intent);
                }
            },
            new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    Toast.makeText(OtpConfirmationActivity.this, "Error Sign Up Process.Please Check your entered Credentials", Toast.LENGTH_LONG).show();
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
            params.put("email_id", medium);

            return params;
        }

    };

    RequestQueue requestQueue = Volley.newRequestQueue(this);
    requestQueue.add(stringRequest);


}


}



