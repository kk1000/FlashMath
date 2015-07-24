package mobileapplicationdevelopment.flashmath;


import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;

import android.util.TypedValue;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.app.Activity;

import mobileapplicationdevelopment.flashmath.R;

/**
 * Created by nikolaschaconas on 7/17/15.
 */
public class home extends Activity{
    @Override
    protected void onCreate(Bundle savedInstanceState)  {
        boolean easy = false, hard = false;

        super.onCreate(savedInstanceState);

        setContentView(R.layout.home);
        Typeface myFont = Typeface.createFromAsset(getAssets(), "Cutie Patootie Skinny.ttf");
        final TextView myLevel = (TextView) findViewById(R.id.level);
        final TextView myEasy = (TextView) findViewById(R.id.easy);
        final TextView myHard = (TextView) findViewById(R.id.hard);
        final TextView myType = (TextView) findViewById(R.id.type);
        myType.setTypeface(myFont);
        myLevel.setTypeface(myFont);


        //Easy Button
        myEasy.setTypeface(myFont);
        myEasy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myHard.setTextSize(TypedValue.COMPLEX_UNIT_SP,30);
                myEasy.setTextSize(TypedValue.COMPLEX_UNIT_SP,40);
            }
        });

        //Hard Button
        myHard.setTypeface(myFont);
        myHard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myEasy.setTextSize(TypedValue.COMPLEX_UNIT_SP,30);
                myHard.setTextSize(TypedValue.COMPLEX_UNIT_SP,40);

            }
        });

        final Button SettingsButton = (Button) findViewById(R.id.settings);
        SettingsButton.setTypeface(myFont);
        SettingsButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //SettingsButton.setHeight(120);
                //SettingsButton.setWidth(420);
                Settings(v);
            }
        });

        final Button StartButton = (Button) findViewById(R.id.start_button);
        StartButton.setTypeface(myFont);
        StartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //SettingsButton.setHeight(120);
                //SettingsButton.setWidth(420);
                StartGame(v);
            }
        });
    }

    public void Settings(View v) {
        startActivity(new Intent(home.this, mobileapplicationdevelopment.flashmath.settings.class));
    }
    public void StartGame(View v) {
            startActivity(new Intent(home.this, mobileapplicationdevelopment.flashmath.playgame.class));
    }

}
