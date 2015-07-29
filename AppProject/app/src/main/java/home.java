package mobileapplicationdevelopment.flashmath;


import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;

import android.util.TypedValue;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup.*;
import android.widget.RadioGroup;
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
        final Typeface myFont = Typeface.createFromAsset(getAssets(), "Cutie Patootie Skinny.ttf");
        final TextView myLevel = (TextView) findViewById(R.id.level);
        final TextView myEasy = (TextView) findViewById(R.id.easy);
        final TextView myHard = (TextView) findViewById(R.id.hard);
        final TextView myType = (TextView) findViewById(R.id.type);
        final TextView User = (TextView) findViewById(R.id.user);
        User.setTypeface(myFont);
        myType.setTypeface(myFont);
        myLevel.setTypeface(myFont);


        //Easy Button
        myEasy.setTypeface(myFont);
        myEasy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myHard.setTextSize(TypedValue.COMPLEX_UNIT_SP, 30);
                myHard.setTypeface(myFont,Typeface.NORMAL);
                myEasy.setTextSize(TypedValue.COMPLEX_UNIT_SP, 40);
                myEasy.setTypeface(myFont,Typeface.BOLD);

            }
        });

        //Hard Button
        myHard.setTypeface(myFont);
        myHard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myEasy.setTextSize(TypedValue.COMPLEX_UNIT_SP, 30);
                myEasy.setTypeface(myFont, Typeface.NORMAL);
                myHard.setTextSize(TypedValue.COMPLEX_UNIT_SP, 40);
                myHard.setTypeface(myFont,Typeface.BOLD);
            }
        });


        final RadioGroup difficultyGroup = (RadioGroup) findViewById(R.id.radioGroup);
        final RadioButton addButton = (RadioButton) findViewById(R.id.add);
        final RadioButton subtractButton = (RadioButton) findViewById(R.id.subtract);
        final RadioButton multiplyButton = (RadioButton) findViewById(R.id.multiply);
        final RadioButton divideButton = (RadioButton) findViewById(R.id.divide);

        difficultyGroup.setOnCheckedChangeListener(new OnCheckedChangeListener() {


            public void onCheckedChanged(RadioGroup group, int checkId) {
                if(checkId == R.id.add) {
                    //I just set this to an X to see if it would work. maybe we should set all the other types to grey when something is clicked?
                    addButton.setBackgroundResource(R.drawable.red_x);

                }
                else if (checkId == R.id.subtract) {
                    addButton.setBackgroundResource(R.drawable.addition);
                }
                else if (checkId == R.id.multiply) {
                    addButton.setBackgroundResource(R.drawable.addition);
                }
                else {
                    addButton.setBackgroundResource(R.drawable.addition);
                }
            }
        });


        final Button SettingsButton = (Button) findViewById(R.id.settings);
        SettingsButton.setTypeface(myFont);
        SettingsButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Settings(v);
            }
        });

        final Button StartButton = (Button) findViewById(R.id.start_button);
        StartButton.setTypeface(myFont);
        StartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
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
