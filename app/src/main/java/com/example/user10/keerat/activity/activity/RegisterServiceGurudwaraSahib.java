package com.example.user10.keerat.activity.activity;

import android.graphics.Typeface;
import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.user10.keerat.R;
import com.example.user10.keerat.activity.dynamiceditfield.MyLayoutOperation;
import com.example.user10.keerat.activity.dynamiceditfield.MyLayoutOperation2;

public class RegisterServiceGurudwaraSahib extends AppCompatActivity {

    private Spinner spcountry, spstate, spcity, spcountry2, spstate2, spcity2, spdesiganation, sptimetovisit,
            spdailyfixedprogram;
    private Button btnaddmore1,btnaddmore2;
    private EditText etgurudwaraname, etaddress, etorgcontact,
            etyourname, etnumber, etemailid, etother, etaboutyourself, etplacename, etaddress2,
            etspecificday, ettiming, etothertiming, etprogram, etdateandtiming,
            etotherdetails, etprogram2, etdateandtiming2, etotherdetails2;
    private RadioGroup rgserverfreefood,rgsameplace,rgweeklyprogram,rgmonthlyprogram;
    private LinearLayout  llsameplace, llsameplaceedittext,llweeklyprogram,llmonthlyprogram;
    private RadioButton rby1,rbn1,rby2,rbn2,rby3,rbn3,rby4,rbn4;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registerservicegurudwarasahib);

        llsameplace = (LinearLayout) findViewById(R.id.ll_sameplace);
        llsameplaceedittext = (LinearLayout) findViewById(R.id.ll_sameplaceedittext);
        llmonthlyprogram = (LinearLayout) findViewById(R.id.ll_monthlyprogram);
        llweeklyprogram= (LinearLayout) findViewById(R.id.ll_weeklyprogram);

        //radiobuttom
        rby1 = (RadioButton)findViewById(R.id.rb_y1);
        rbn1 = (RadioButton)findViewById(R.id.rb_n1);
        rby2 = (RadioButton)findViewById(R.id.rb_y2);
        rby2 = (RadioButton)findViewById(R.id.rb_n2);
        rby3 = (RadioButton)findViewById(R.id.rb_y3);
        rbn3 = (RadioButton)findViewById(R.id.rb_n3);
        rby4 = (RadioButton)findViewById(R.id.rb_y4);
        rby4 = (RadioButton)findViewById(R.id.rb_n4);

        //button's id
        btnaddmore1 = (Button) findViewById(R.id.btn_addmore);
        btnaddmore2 = (Button) findViewById(R.id.btn_addmore2);

        //radiogroup

        rgserverfreefood = (RadioGroup)findViewById(R.id.rg_servefreefood);
        rgsameplace = (RadioGroup)findViewById(R.id.rg_sameplace);
        rgweeklyprogram = (RadioGroup)findViewById(R.id.rg_weeklyprogram);
        rgmonthlyprogram = (RadioGroup)findViewById(R.id.rg_monthlyprogram);


//spinners
        spcountry = (Spinner) findViewById(R.id.sp_countryguru);
        spstate = (Spinner) findViewById(R.id.sp_stateguru);
        spcity = (Spinner) findViewById(R.id.sp_cityguru);
        spcountry2 = (Spinner) findViewById(R.id.sp_country2);
        spstate2 = (Spinner) findViewById(R.id.sp_state2);
        spcity2 = (Spinner) findViewById(R.id.sp_city2);
        spdesiganation = (Spinner) findViewById(R.id.sp_designation);
        sptimetovisit = (Spinner) findViewById(R.id.sp_timetovisit);
        spdailyfixedprogram = (Spinner) findViewById(R.id.sp_fixedprogram);

        //edittexts

        etgurudwaraname = (EditText) findViewById(R.id.et_entergurudwaraname);
        etaddress = (EditText) findViewById(R.id.et_enteraddress);
        etorgcontact = (EditText) findViewById(R.id.et_orgcontact);
        etyourname = (EditText) findViewById(R.id.et_enterurname);
        etnumber = (EditText) findViewById(R.id.et_entermobilenum);
        etemailid = (EditText) findViewById(R.id.et_enteremailid);
        etother = (EditText) findViewById(R.id.et_other);
        etaboutyourself = (EditText) findViewById(R.id.et_abtyourself);
        etplacename = (EditText) findViewById(R.id.et_placename);
        etaddress2 = (EditText) findViewById(R.id.et_address2);
        etspecificday = (EditText) findViewById(R.id.et_specificday);
        ettiming = (EditText) findViewById(R.id.et_timing);
        etothertiming = (EditText) findViewById(R.id.et_othertiming);
        etprogram = (EditText) findViewById(R.id.et_nameofprogram);
        etdateandtiming = (EditText) findViewById(R.id.et_dateandtiming);
        etotherdetails = (EditText) findViewById(R.id.et_otherdetail);
        etprogram2 = (EditText) findViewById(R.id.et_nameofprogram2);
        etdateandtiming2 = (EditText) findViewById(R.id.et_dateandtiming2);
        etotherdetails2 = (EditText) findViewById(R.id.et_otherdetail2);


        Typeface typeface = Typeface.createFromAsset(getAssets(), "font/avenir-next-regular.ttf");
        Typeface typefacebold = Typeface.createFromAsset(getAssets(), "font/avenir-next-bold.ttf");
        Typeface typefacemedium = Typeface.createFromAsset(getAssets(), "font/AvenirNext-Medium.ttf");

        //typefaces
        etgurudwaraname.setTypeface(typefacemedium);
        etaddress.setTypeface(typefacemedium);
        etorgcontact.setTypeface(typefacemedium);
        etyourname.setTypeface(typefacemedium);
        etnumber.setTypeface(typefacemedium);
        etemailid.setTypeface(typefacemedium);
        etother.setTypeface(typefacemedium);
        etplacename.setTypeface(typefacemedium);
        etaddress2.setTypeface(typefacemedium);
        ettiming.setTypeface(typefacemedium);
        etprogram.setTypeface(typefacemedium);
        etotherdetails.setTypeface(typefacemedium);
        etprogram2.setTypeface(typefacemedium);
        etdateandtiming2.setTypeface(typefacemedium);
        etotherdetails2.setTypeface(typefacemedium);

        //dynamically adding edit text field
        MyLayoutOperation.add(this, btnaddmore1);
        MyLayoutOperation2.add2(this, btnaddmore2);

        //Radio group performance for setting of  visibility of views

        rgserverfreefood.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, @IdRes int i) {
                if (i==R.id.rb_y1){
                    llsameplace.setVisibility(View.VISIBLE);
                }else if(i==R.id.rb_n1){
                   // llsameplace.setVisibility(View.INVISIBLE);
                }
            }});
        rgsameplace.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, @IdRes int i) {
                if (i==R.id.rb_y2){
                  //  llsameplaceedittext.setVisibility(View.INVISIBLE);
                }else if (i==R.id.rb_n2){
                    llsameplaceedittext.setVisibility(View.VISIBLE);
                }
            }
        });
        rgweeklyprogram.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, @IdRes int i) {
                if(i==R.id.rb_y3){
                    llweeklyprogram.setVisibility(View.VISIBLE);
                }
            }
        });

        rgmonthlyprogram.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, @IdRes int i) {
                if (i==R.id.rb_y4){
                    llmonthlyprogram.setVisibility(View.VISIBLE);
                }
            }
        });






        spcountry.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                ((TextView) spcountry.getSelectedView()).setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            }
        });


        spstate.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                ((TextView) spstate.getSelectedView()).setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            }
        });

        spcity.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                ((TextView) spcity.getSelectedView()).setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            }
        });

        spcountry2.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                ((TextView) spcountry2.getSelectedView()).setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            }
        });


        spstate2.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                ((TextView) spstate2.getSelectedView()).setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            }
        });

        spcity2.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                ((TextView) spcity2.getSelectedView()).setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            }
        });

        spdesiganation.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                ((TextView) spdesiganation.getSelectedView()).setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            }
        });

        sptimetovisit.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                ((TextView) sptimetovisit.getSelectedView()).setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            }
        });

        spdailyfixedprogram.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                ((TextView) spdailyfixedprogram.getSelectedView()).setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            }
        });

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

// Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;

    }}

