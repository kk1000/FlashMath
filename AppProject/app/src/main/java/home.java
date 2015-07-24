package mobileapplicationdevelopment.flashmath;


import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Handler;
import android.widget.Button;
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
        //Typeface myFont = Typeface.createFromAsset(getAssets(), "Cutie Patootie Skinny.ttf");
        //TextView myTextView = (TextView) findViewById(R.id.logo1);
        //TextView mySlogan = (TextView) findViewById(R.id.slogan);

        //mySlogan.setTypeface(myFont);
        Typeface myFont = Typeface.createFromAsset(getAssets(), "Cutie Patootie Skinny.ttf");
        TextView myTextView = (TextView) findViewById(R.id.start_button);
        myTextView.setTypeface(myFont);


        Button button = (Button) findViewById(R.id.start_button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StartGame(v);
            }
        });
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
