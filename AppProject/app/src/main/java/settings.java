/**
 * Created by nikolaschaconas on 7/24/15.
 */
package mobileapplicationdevelopment.flashmath;


import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Typeface;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.*;

import mobileapplicationdevelopment.flashmath.R;

public class settings extends Activity{
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.settings);
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LOCKED);

        final Typeface myFont = Typeface.createFromAsset(getAssets(), "Cutie Patootie Skinny.ttf");

        final Button saveButton = (Button) findViewById(R.id.save);
        final Button cashButton = (Button) findViewById(R.id.cash);
        saveButton.setTypeface(myFont);
        cashButton.setTypeface(myFont);
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BackToHome(v);
            }
        });

        final RadioGroup users = (RadioGroup) findViewById(R.id.radioUsers);
        final RadioButton boyButton = (RadioButton) findViewById(R.id.boy);
        final RadioButton girlButton = (RadioButton) findViewById(R.id.girl);

        users.setOnCheckedChangeListener(new OnCheckedChangeListener() {

            public void onCheckedChanged(RadioGroup group, int checkId) {
                if (checkId == R.id.boy) {
                    //I just set this to an X to see if it would work. maybe we should set all the other types to grey when something is clicked?
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

