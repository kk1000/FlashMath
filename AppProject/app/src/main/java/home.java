package mobileapplicationdevelopment.flashmath;


import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.os.Handler;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.support.v7.app.ActionBarActivity;
import android.view.View;

import mobileapplicationdevelopment.flashmath.R;

/**
 * Created by nikolaschaconas on 7/17/15.
 */
public class home extends ActionBarActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState)  {

        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.home);
        Typeface myFont = Typeface.createFromAsset(getAssets(), "Cutie Patootie Skinny.ttf");
        TextView myLevel = (TextView) findViewById(R.id.level);
        TextView myEasy = (TextView) findViewById(R.id.easy);
        TextView myHard = (TextView) findViewById(R.id.hard);
        myLevel.setTypeface(myFont);
        myEasy.setTypeface(myFont);
        myEasy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO call function easy

            }
        });
        myHard.setTypeface(myFont);
        myHard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO call function hard
            }
        });

        Button SettingsButton = (Button) findViewById(R.id.settings);
        SettingsButton.setTypeface(myFont);
        SettingsButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Settings(v);
            }
        });

        Button StartButton = (Button) findViewById(R.id.start_button);
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

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.menu_main, menu);
//        return true;
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        // Handle action bar item clicks here. The action bar will
//        // automatically handle clicks on the Home/Up button, so long
//        // as you specify a parent activity in AndroidManifest.xml.
//        int id = item.getItemId();
//
//        //noinspection SimplifiableIfStatement
//        if (id == R.id.action_settings) {
//            return true;
//        }
//
//        return super.onOptionsItemSelected(item);
//    }
}
