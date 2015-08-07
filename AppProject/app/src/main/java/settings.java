/**
 * Created by nikolaschaconas on 7/24/15.
 */
package mobileapplicationdevelopment.flashmath;


import android.app.Fragment;
import android.content.Context;
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


public class settings extends Activity{

    public int boy_target = 0;
    public String boy_reward = "";
    public int boy_stars = 0;
    public int girl_target;
    public String girl_reward;
    public int girl_stars;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.settings);
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LOCKED);

        final Typeface myFont = Typeface.createFromAsset(getAssets(), "Cutie Patootie Skinny.ttf");

        final TextView stars = (TextView) findViewById(R.id.statText);
        final SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        int starNum = preferences.getInt("StarScore", 0);
        stars.setTypeface(myFont);
        stars.setText(starNum + "/");


        final Button saveButton = (Button) findViewById(R.id.save);
        final Button cashButton = (Button) findViewById(R.id.cash);
        saveButton.setTypeface(myFont);
        cashButton.setTypeface(myFont);
        final RadioGroup users = (RadioGroup) findViewById(R.id.radioUsers);
        final RadioButton boyButton = (RadioButton) findViewById(R.id.boy);
        final RadioButton girlButton = (RadioButton) findViewById(R.id.girl);

        final EditText boy_target_string = (EditText) findViewById(R.id.targetText);
        final EditText boy_reward_string = (EditText) findViewById(R.id.rewardText);

        if (boy_target == 0) {
            boy_target_string.setText("Enter goal stars!");
        }
        if (boy_reward == "") {
            boy_reward_string.setText("Enter a reward!");
        }

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (users.getCheckedRadioButtonId() == boyButton.getId()) {
                    if (boy_target == 0) {
                        boy_target_string.setText("Enter goal stars!");
                    }
                    else {
                        boy_target = Integer.parseInt(boy_target_string.getText().toString());

                    }
                    if (boy_reward == "") {
                        boy_reward_string.setText("Enter a reward!");

                    }
                    else {
                        boy_target = Integer.parseInt(boy_target_string.getText().toString());
                        boy_reward = boy_reward_string.getText().toString();
                    }
                    getIntent().putExtra("boy_reward", boy_reward);
                    getIntent().putExtra("boy_target", boy_target);
                }

                BackToHome(v);
            }
        });

        cashButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int starNum = preferences.getInt("StarScore", 0);
                int diff = starNum - 2;
                stars.setTypeface(myFont);
                stars.setText(diff + " /");
                SharedPreferences.Editor editor = preferences.edit();
                editor.putInt("StarScore", diff);
                editor.apply();
            }
        });

        boyButton.setBackgroundResource(R.drawable.boy_pressed);
        boyButton.setChecked(true);

        users.setOnCheckedChangeListener(new OnCheckedChangeListener() {

            public void onCheckedChanged(RadioGroup group, int checkId) {
                if (checkId == R.id.boy) {
                    boyButton.setBackgroundResource(R.drawable.boy_pressed);
                    girlButton.setBackgroundResource(R.drawable.girl);
                } else if (checkId == R.id.girl) {
                    boyButton.setBackgroundResource(R.drawable.boy);
                    girlButton.setBackgroundResource(R.drawable.girl_pressed);
                }
            }
        });

    }

    public void BackToHome(View v) {
        startActivity(new Intent(settings.this, mobileapplicationdevelopment.flashmath.home.class));
    }

}

