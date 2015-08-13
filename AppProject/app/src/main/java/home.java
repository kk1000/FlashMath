package mobileapplicationdevelopment.flashmath;


import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Typeface;
import android.os.Bundle;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.view.View;
import android.util.TypedValue;
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
    private SharedPreferences preferences;
    private SharedPreferences.Editor editor;
    public TextView myLevel;
    public TextView myType;
    public TextView User;
    public RadioGroup levelGroup;
    public RadioButton easyButton;
    public RadioButton hardButton;
    private RadioGroup userGroup;
    private RadioButton boyButton;
    private RadioButton girlButton;
    RadioGroup operatorGroup;
    RadioButton addButton;
    RadioButton subtractButton;
    RadioButton multiplyButton;
    RadioButton divideButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LOCKED);
    }

    protected void onStart() {
        super.onStart();
        preferences = PreferenceManager.getDefaultSharedPreferences(home.this);
        editor = preferences.edit();
        myLevel = (TextView) findViewById(R.id.level);
        myType = (TextView) findViewById(R.id.type);
        User = (TextView) findViewById(R.id.user);
        //selecting easy or hard
        levelGroup = (RadioGroup) findViewById(R.id.radioGroupLevel);
        easyButton = (RadioButton) findViewById(R.id.easy);
        hardButton = (RadioButton) findViewById(R.id.hard);

        //type of math group
        operatorGroup = (RadioGroup) findViewById(R.id.radioGroup);
        addButton = (RadioButton) findViewById(R.id.add);
        subtractButton = (RadioButton) findViewById(R.id.subtract);
        multiplyButton = (RadioButton) findViewById(R.id.multiply);
        divideButton = (RadioButton) findViewById(R.id.divide);

        boolean easy = false, hard = false;


        //reload buttons if settings were saved
//        String Operation = preferences.getString("operatorGroup", "none");
//        //String Operation = "stb";
//        if(Operation.equals("add")){
//            addButton.setChecked(true);
//            addButton.setBackgroundResource(R.drawable.addition_pressed);
//        }
//        else if(Operation.equals("subtract")) {
//            subtractButton.setChecked(true);
//            subtractButton.setBackgroundResource(R.drawable.subtract_pressed);
//        }
//        else if (Operation.equals("divide")) {
//            divideButton.setChecked(true);
//            divideButton.setBackgroundResource(R.drawable.divide_pressed);
//        }
//        else if (Operation.equals("multiply")) {
//            multiplyButton.setChecked(true);
//            multiplyButton.setBackgroundResource(R.drawable.multiply_pressed);
//        }
//        String Hardness = preferences.getString("difficultyGroup","none");
//        if (Hardness.equals("easy")) {
//            easyButton.setChecked(true);
//            easyButton.setBackgroundResource(R.drawable.easy_pressed);
//        }
//        else if (Hardness.equals("hard")) {
//            hardButton.setChecked(true);
//            hardButton.setBackgroundResource(R.drawable.hard_pressed);
//        }




        //setting font for page
        final Typeface myFont = Typeface.createFromAsset(getAssets(), "Cutie Patootie Skinny.ttf");


        User.setTypeface(myFont);
        myType.setTypeface(myFont);
        myLevel.setTypeface(myFont);


        levelGroup.setOnCheckedChangeListener(new OnCheckedChangeListener() {

            public void onCheckedChanged(RadioGroup group, int checkId) {
                if (checkId == R.id.easy) {
                    easyButton.setBackgroundResource(R.drawable.easy_pressed);
                    hardButton.setBackgroundResource(R.drawable.hard);
                    editor.putString("difficultyGroup", "easy");
                    editor.apply();
                    levelClicked = true;
                } else if (checkId == R.id.hard) {
                    easyButton.setBackgroundResource(R.drawable.easy);
                    hardButton.setBackgroundResource(R.drawable.hard_pressed);
                    editor.putString("difficultyGroup", "hard");
                    editor.apply();
                    levelClicked = true;
                }
            }
        });




        operatorGroup.setOnCheckedChangeListener(new OnCheckedChangeListener() {

            public void onCheckedChanged(RadioGroup group, int checkId) {
                if (checkId == R.id.add) {
                    addButton.setBackgroundResource(R.drawable.addition_pressed);
                    subtractButton.setBackgroundResource(R.drawable.subtract);
                    multiplyButton.setBackgroundResource(R.drawable.multiply);
                    divideButton.setBackgroundResource(R.drawable.divide);
                    editor.putString("operatorGroup", "add");
                    difficultyClicked = true;
                    editor.apply();
                } else if (checkId == R.id.subtract) {
                    addButton.setBackgroundResource(R.drawable.addition);
                    subtractButton.setBackgroundResource(R.drawable.subtract_pressed);
                    multiplyButton.setBackgroundResource(R.drawable.multiply);
                    divideButton.setBackgroundResource(R.drawable.divide);
                    editor.putString("operatorGroup", "subtract");
                    difficultyClicked = true;
                    editor.apply();
                } else if (checkId == R.id.multiply) {
                    addButton.setBackgroundResource(R.drawable.addition);
                    subtractButton.setBackgroundResource(R.drawable.subtract);
                    multiplyButton.setBackgroundResource(R.drawable.multiply_pressed);
                    divideButton.setBackgroundResource(R.drawable.divide);
                    editor.putString("operatorGroup", "multiply");
                    difficultyClicked = true;
                    editor.apply();
                } else {
                    addButton.setBackgroundResource(R.drawable.addition);
                    subtractButton.setBackgroundResource(R.drawable.subtract);
                    multiplyButton.setBackgroundResource(R.drawable.multiply);
                    divideButton.setBackgroundResource(R.drawable.divide_pressed);
                    editor.putString("operatorGroup", "divide");
                    difficultyClicked = true;
                    editor.apply();
                }

            }
        });

        //clicking boy or girl user
        userGroup = (RadioGroup) findViewById(R.id.radioGroupUsers);
        boyButton = (RadioButton) findViewById(R.id.boy);
        girlButton = (RadioButton) findViewById(R.id.girl);

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
        final Button StartButton = (Button) findViewById(R.id.start_button);
        StartButton.setTypeface(myFont);
        final RelativeLayout failStart = (RelativeLayout) findViewById(R.id.failToStart);

        okButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                failStart.setVisibility(View.GONE);
                SettingsButton.setEnabled(true);
                StartButton.setEnabled(true);
            }
        });

        StartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (levelClicked && difficultyClicked && userClicked) {
                    StartGame(levelGroup, operatorGroup, easyButton.getId(), hardButton.getId(),
                            addButton.getId(), subtractButton.getId(), multiplyButton.getId(), divideButton.getId());
                } else {
                    failStart.setVisibility(View.VISIBLE);
                    SettingsButton.setEnabled(false);
                    StartButton.setEnabled(false);
                }
            }
        });

    }

//    protected void onRestart() {
//        super.onRestart();
//
//    }

    public void Settings() {
        startActivity(new Intent(home.this, mobileapplicationdevelopment.flashmath.settings.class));
    }
    public void StartGame(RadioGroup levelGroup, RadioGroup operatorGroup, int easyID, int hardID, int plus, int minus, int multiply, int divide) {
            Intent startGameIntent = new Intent(home.this, mobileapplicationdevelopment.flashmath.playgame.class);

            int level = levelGroup.getCheckedRadioButtonId();
            if (level == easyID) {
                startGameIntent.putExtra("level", "easy");
            }
            else if (level == hardID){
                startGameIntent.putExtra("level", "hard");
            }

            int type = operatorGroup.getCheckedRadioButtonId();
            if(type == plus) {
                startGameIntent.putExtra("type","plus");
            }
            else if (type == minus) {
                startGameIntent.putExtra("type", "minus");

            }
            else if (type == multiply) {
                startGameIntent.putExtra("type", "multiply");

            }
            else {
                startGameIntent.putExtra("type", "divide");

            }

            if(boyButton.isChecked()) {
                startGameIntent.putExtra("user", "boy");
            }
            else
                startGameIntent.putExtra("user","girl");


            startActivity(startGameIntent);
    }



}
