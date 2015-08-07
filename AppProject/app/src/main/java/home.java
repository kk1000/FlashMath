package mobileapplicationdevelopment.flashmath;


import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Typeface;
import android.os.Bundle;

import android.util.TypedValue;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup.*;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.app.Activity;

import mobileapplicationdevelopment.flashmath.R;

/**
 * Created by nikolaschaconas on 7/17/15.
 */
public class home extends Activity{

    private boolean levelClicked = false;
    private boolean difficultyClicked = false;
    private boolean userClicked = false;

    @Override
    protected void onCreate(Bundle savedInstanceState)  {
        boolean easy = false, hard = false;

        super.onCreate(savedInstanceState);

        setContentView(R.layout.home);
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LOCKED);

        //setting font for page
        final Typeface myFont = Typeface.createFromAsset(getAssets(), "Cutie Patootie Skinny.ttf");
        final TextView myLevel = (TextView) findViewById(R.id.level);
        final TextView myType = (TextView) findViewById(R.id.type);
        final TextView User = (TextView) findViewById(R.id.user);
        User.setTypeface(myFont);
        myType.setTypeface(myFont);
        myLevel.setTypeface(myFont);

        //selecting easy or hard
        final RadioGroup levelGroup = (RadioGroup) findViewById(R.id.radioGroupLevel);
        final RadioButton easyButton = (RadioButton) findViewById(R.id.easy);
        final RadioButton hardButton = (RadioButton) findViewById(R.id.hard);

        levelGroup.setOnCheckedChangeListener(new OnCheckedChangeListener() {

            public void onCheckedChanged(RadioGroup group, int checkId) {
                if (checkId == R.id.easy) {
                    easyButton.setBackgroundResource(R.drawable.easy_pressed);
                    hardButton.setBackgroundResource(R.drawable.hard);
                    levelClicked = true;
                } else if (checkId == R.id.hard) {
                    easyButton.setBackgroundResource(R.drawable.easy);
                    hardButton.setBackgroundResource(R.drawable.hard_pressed);
                    levelClicked = true;
                }
            }
        });

        //type of math group
        final RadioGroup difficultyGroup = (RadioGroup) findViewById(R.id.radioGroup);
        final RadioButton addButton = (RadioButton) findViewById(R.id.add);
        final RadioButton subtractButton = (RadioButton) findViewById(R.id.subtract);
        final RadioButton multiplyButton = (RadioButton) findViewById(R.id.multiply);
        final RadioButton divideButton = (RadioButton) findViewById(R.id.divide);

        difficultyGroup.setOnCheckedChangeListener(new OnCheckedChangeListener() {

            public void onCheckedChanged(RadioGroup group, int checkId) {
                if(checkId == R.id.add) {
                    addButton.setBackgroundResource(R.drawable.addition_pressed);
                    subtractButton.setBackgroundResource(R.drawable.subtract);
                    multiplyButton.setBackgroundResource(R.drawable.multiply);
                    divideButton.setBackgroundResource(R.drawable.divide);
                    difficultyClicked = true;
                }
                else if (checkId == R.id.subtract) {
                    addButton.setBackgroundResource(R.drawable.addition);
                    subtractButton.setBackgroundResource(R.drawable.subtract_pressed);
                    multiplyButton.setBackgroundResource(R.drawable.multiply);
                    divideButton.setBackgroundResource(R.drawable.divide);
                    difficultyClicked = true;
                }
                else if (checkId == R.id.multiply) {
                    addButton.setBackgroundResource(R.drawable.addition);
                    subtractButton.setBackgroundResource(R.drawable.subtract);
                    multiplyButton.setBackgroundResource(R.drawable.multiply_pressed);
                    divideButton.setBackgroundResource(R.drawable.divide);
                    difficultyClicked = true;
                }
                else {
                    addButton.setBackgroundResource(R.drawable.addition);
                    subtractButton.setBackgroundResource(R.drawable.subtract);
                    multiplyButton.setBackgroundResource(R.drawable.multiply);
                    divideButton.setBackgroundResource(R.drawable.divide_pressed);
                    difficultyClicked = true;
                }
            }
        });

        //clicking boy or girl user
        final RadioGroup userGroup = (RadioGroup) findViewById(R.id.radioGroupUsers);
        final RadioButton boyButton = (RadioButton) findViewById(R.id.boy);
        final RadioButton girlButton = (RadioButton) findViewById(R.id.girl);

        userGroup.setOnCheckedChangeListener(new OnCheckedChangeListener() {


            public void onCheckedChanged(RadioGroup group, int checkId) {
                if (checkId == R.id.boy) {
                    boyButton.setBackgroundResource(R.drawable.boy_pressed);
                    girlButton.setBackgroundResource(R.drawable.girl);
                    userClicked = true;
                } else if (checkId == R.id.girl) {
                    boyButton.setBackgroundResource(R.drawable.boy);
                    girlButton.setBackgroundResource(R.drawable.girl_pressed);
                    userClicked = true;
                }
            }
        });

        final Button SettingsButton = (Button) findViewById(R.id.settings);
        SettingsButton.setTypeface(myFont);
        SettingsButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Settings();
            }
        });

        final TextView needToSelectText = (TextView) findViewById(R.id.needToSelect);
        needToSelectText.setTypeface(myFont);
        final Button okButton = (Button) findViewById(R.id.ok);
        okButton.setTypeface(myFont);
        final RelativeLayout failStart = (RelativeLayout) findViewById(R.id.failToStart);

        okButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                failStart.setVisibility(View.GONE);
            }
        });

        final Button StartButton = (Button) findViewById(R.id.start_button);
        StartButton.setTypeface(myFont);
        StartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (levelClicked && difficultyClicked && userClicked) {
                    StartGame(levelGroup,difficultyGroup, easyButton.getId(), hardButton.getId(),
                            addButton.getId(), subtractButton.getId(), multiplyButton.getId(), divideButton.getId());
                }
                else {
                    failStart.setVisibility(View.VISIBLE);
                }
            }
        });

    }

    public void Settings() {
        startActivity(new Intent(home.this, mobileapplicationdevelopment.flashmath.settings.class));
    }
    public void StartGame(RadioGroup levelGroup, RadioGroup difficultyGroup, int easyID, int hardID, int plus, int minus, int multiply, int divide) {
            Intent startGameIntent = new Intent(home.this, mobileapplicationdevelopment.flashmath.playgame.class);

            int level = levelGroup.getCheckedRadioButtonId();
            if (level == easyID) {
                startGameIntent.putExtra("level","easy");
            }
            else if (level == hardID){
                startGameIntent.putExtra("level","hard");
            }

            int type = difficultyGroup.getCheckedRadioButtonId();
            if(type == plus) {
                startGameIntent.putExtra("type","plus");
            }
            else if (type == minus) {
                startGameIntent.putExtra("type","minus");
            }
            else if (type == multiply) {
                startGameIntent.putExtra("type","multiply");
            }
            else {
                startGameIntent.putExtra("type","divide");
            }

            startActivity(startGameIntent);




    }


}
