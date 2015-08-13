/**
 * Created by nikolaschaconas on 7/24/15.
 */
package mobileapplicationdevelopment.flashmath;


import android.graphics.Color;
import android.view.inputmethod.EditorInfo;
import android.widget.RelativeLayout;
import android.widget.TextView.OnEditorActionListener;
import android.view.KeyEvent;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.graphics.Typeface;
import android.os.Bundle;
import android.app.Activity;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.*;
import android.widget.TextView;
import android.view.View.OnTouchListener;
import android.view.MotionEvent;


public class settings extends Activity{

    public TextView stars;
    private int currentTarget;
    private RelativeLayout majorwindow;
    public SharedPreferences.Editor editor;
    public SharedPreferences preferences;
    public EditText target_field;
    public EditText reward_field;
    public Button cashButton;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.settings);
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LOCKED);

        final Typeface myFont = Typeface.createFromAsset(getAssets(), "Cutie Patootie Skinny.ttf");

        stars = (TextView) findViewById(R.id.statText);
        stars.setTypeface(myFont);
        preferences = PreferenceManager.getDefaultSharedPreferences(this);

        majorwindow = (RelativeLayout) findViewById(R.id.majorwindow);
        final Button saveButton = (Button) findViewById(R.id.save);
        cashButton = (Button) findViewById(R.id.cash);
        saveButton.setTypeface(myFont);
        cashButton.setTypeface(myFont);
        final RadioGroup users = (RadioGroup) findViewById(R.id.radioUsers);
        final RadioButton boyButton = (RadioButton) findViewById(R.id.boy);
        final RadioButton girlButton = (RadioButton) findViewById(R.id.girl);

        target_field = (EditText) findViewById(R.id.targetText);
        reward_field = (EditText) findViewById(R.id.rewardText);
        target_field.setHint("Enter target stars!");
        reward_field.setHint("Enter a reward!");
        target_field.setTypeface(myFont);
        reward_field.setTypeface(myFont);
        editor = preferences.edit();

        boyButton.setBackgroundResource(R.drawable.boy_pressed);
        boyButton.setChecked(true);
        ShowBoySettings();

        target_field.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                int starGoal, starNum;
                if (boyButton.isChecked()) {
                    if (target_field.getText().length() == 0) {
                        starGoal = 0;
                        currentTarget = 0;
                    } else {
                        starGoal = Integer.parseInt(target_field.getText().toString());
                        currentTarget = starGoal;
                    }
                    starNum = preferences.getInt("boy_stars", 0);
                    UpdateBoySettings();
                    ShowBoySettings();
                } else {
                    if (target_field.getText().length() == 0) {
                        starGoal = 0;
                        currentTarget = 0;
                    } else {
                        starGoal = Integer.parseInt(target_field.getText().toString());
                        currentTarget = starGoal;
                    }
                    starNum = preferences.getInt("girl_stars", 0);
                    UpdateGirlSettings();
                    ShowGirlSettings();
                }

                ShowStarGoal(starNum, starGoal);
            }

        });

        //clear focus of text field when done
        target_field.setOnEditorActionListener(new OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_DONE) {
                    target_field.clearFocus();
                    target_field.setCursorVisible(false);
                }
                return false;
            }
        });
        target_field.setOnTouchListener(new OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent event) {
                target_field.setCursorVisible(true);
                return false;
            }
        });

        //clear focus of text field when done
        reward_field.setOnEditorActionListener(new OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if(actionId== EditorInfo.IME_ACTION_DONE){
                    reward_field.setCursorVisible(false);
                    reward_field.setHighlightColor(Color.TRANSPARENT);
                }
                return false;
            }
        });
        reward_field.setOnTouchListener(new OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent event) {
                reward_field.setCursorVisible(true);
                reward_field.setHighlightColor(Color.CYAN);
                return false;
            }
        });



        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (users.getCheckedRadioButtonId() == boyButton.getId()) {
                    UpdateBoySettings();
                }
                else {
                    UpdateGirlSettings();
                }
                BackToHome(v);
            }
        });

        //variables for Cash In notification
        final TextView congratsCash = (TextView) findViewById(R.id.congratsCashIn);
        congratsCash.setTypeface(myFont);
        final Button okButton = (Button) findViewById(R.id.okCash);
        okButton.setTypeface(myFont);
        final RelativeLayout cashInNotif = (RelativeLayout) findViewById(R.id.cashInNotif);

        okButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cashInNotif.setVisibility(View.GONE);
                saveButton.setEnabled(true);
            }
        });

        cashButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(boyButton.isChecked()){
                    int starNum = preferences.getInt("boy_stars", 0);
                    if(starNum >= currentTarget) {
                        ShowStarGoal(starNum - currentTarget,currentTarget);
                        editor.putInt("boy_stars", starNum - currentTarget);
                        editor.putInt("boy_target", 0);
                        editor.putString("boy_reward", "");
                        editor.apply();
                        cashInNotif.setVisibility(View.VISIBLE);
                        saveButton.setEnabled(false);
                        ShowBoySettings();
                    }
                } else {
                    int starNum = preferences.getInt("girl_stars", 0);
                    if(starNum >= currentTarget) {
                        ShowStarGoal(starNum - currentTarget, currentTarget);
                        editor.putInt("girl_stars", starNum - currentTarget);
                        editor.putInt("girl_target", 0);
                        editor.putString("girl_reward", "");
                        editor.apply();
                        cashInNotif.setVisibility(View.VISIBLE);
                        saveButton.setEnabled(false);
                        ShowGirlSettings();
                    }
                }
            }
        });



        users.setOnCheckedChangeListener(new OnCheckedChangeListener() {

            public void onCheckedChanged(RadioGroup group, int checkId) {
                if (checkId == R.id.boy) {
                    boyButton.setBackgroundResource(R.drawable.boy_pressed);
                    girlButton.setBackgroundResource(R.drawable.girl);
                    UpdateGirlSettings();
                    ShowBoySettings();


                } else if (checkId == R.id.girl) {
                    boyButton.setBackgroundResource(R.drawable.boy);
                    girlButton.setBackgroundResource(R.drawable.girl_pressed);
                    UpdateBoySettings();
                    ShowGirlSettings();
                }
            }
        });

    }

    public void BackToHome(View v) {
        startActivity(new Intent(settings.this, mobileapplicationdevelopment.flashmath.home.class));
    }
    public void UpdateGirlSettings() {
        int girl_target;
        if (target_field.getText().length() == 0) {
            girl_target = 0;
        } else {
            girl_target = Integer.parseInt(target_field.getText().toString());
        }
        String girl_reward = reward_field.getText().toString();
        editor.putInt("girl_target",girl_target);
        editor.putString("girl_reward", girl_reward);
        editor.apply();
    }

    public void UpdateBoySettings() {
        int boy_target;
        if (target_field.getText().length() == 0) {
            boy_target = 0;
        } else {
            boy_target = Integer.parseInt(target_field.getText().toString());
        }
        String boy_reward = reward_field.getText().toString();

        editor.putInt("boy_target",boy_target);
        editor.putString("boy_reward", boy_reward);
        editor.apply();
    }

    public void ShowBoySettings() {
        int boy_target = preferences.getInt("boy_target", 0);
        if (boy_target == 0) {
            target_field.setText("");
        }
        else {
            target_field.setText(Integer.toString(boy_target));
        }
        String boy_reward = preferences.getString("boy_reward", "");

            reward_field.setText(boy_reward);


        int starNum = preferences.getInt("boy_stars", 0);

        ShowStarGoal(starNum, boy_target);
        if(starNum < boy_target | boy_target == 0) {
            cashButton.setClickable(false);
            cashButton.setTextColor(Color.GRAY);
        }
        else {
            cashButton.setClickable(true);
            cashButton.setTextColor(Color.BLACK);
        }



    }

    public void ShowGirlSettings() {
        int girl_target = preferences.getInt("girl_target", 0);
        if (girl_target == 0) {
            target_field.setText("");
        }
        else {
            target_field.setText(Integer.toString(girl_target));
        }
        String girl_reward = preferences.getString("girl_reward", "");

            reward_field.setText(girl_reward);

        int starNum = preferences.getInt("girl_stars", 0);
        ShowStarGoal(starNum, girl_target);

        if(starNum < girl_target | girl_target == 0) {
            cashButton.setClickable(false);
            cashButton.setTextColor(Color.GRAY);
        }
        else {
            cashButton.setClickable(true);
            cashButton.setTextColor(Color.BLACK);
        }

    }

    public void ShowStarGoal(int starNum, int StarGoal) {
        if(StarGoal != 0)
            stars.setText(starNum + " / " + StarGoal);
        else if (starNum == 1) {
            stars.setText(starNum + " Star, set your target!");
        }
        else
            stars.setText(starNum +" Stars, set target!");
    }

}

