/**
 * Created by nikolaschaconas on 7/24/15.
 */
package mobileapplicationdevelopment.flashmath;


import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.app.Activity;
import android.util.TypedValue;
import android.widget.Button;
import android.os.CountDownTimer;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.view.View;

import org.apache.http.auth.BasicUserPrincipal;
import org.w3c.dom.Text;

import mobileapplicationdevelopment.flashmath.R;

public class playgame extends Activity{
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.playgame);
        final RelativeLayout gameover = (RelativeLayout) findViewById(R.id.gameover);



        final Typeface myFont = Typeface.createFromAsset(getAssets(), "Cutie Patootie Skinny.ttf");
        final TextView myTimer = (TextView) findViewById(R.id.timer);
        myTimer.setTypeface(myFont);

        final TextView TimesUp = (TextView) findViewById(R.id.timesuptext);
        TimesUp.setTypeface(myFont);

        final TextView won = (TextView) findViewById(R.id.won);
        won.setTypeface(myFont);

        final Button BackHome = (Button) findViewById(R.id.back_home);
        BackHome.setTypeface(myFont);

        final Button PlayAgain = (Button) findViewById(R.id.play_again);
        PlayAgain.setTypeface(myFont);


        BackHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(playgame.this, mobileapplicationdevelopment.flashmath.home.class));
            }
        });

        PlayAgain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RestartGame(gameover);
            }
        });


        final Button one = (Button) findViewById(R.id.one);
        one.setTypeface(myFont);

        final Button two = (Button) findViewById(R.id.two);
        two.setTypeface(myFont);
        final Button three = (Button) findViewById(R.id.three);
        three.setTypeface(myFont);
        final Button four = (Button) findViewById(R.id.four);
        four.setTypeface(myFont);
        final Button five = (Button) findViewById(R.id.five);
        five.setTypeface(myFont);
        final Button six = (Button) findViewById(R.id.six);
        six.setTypeface(myFont);
        final Button seven = (Button) findViewById(R.id.seven);
        seven.setTypeface(myFont);
        final Button eight = (Button) findViewById(R.id.eight);
        eight.setTypeface(myFont);
        final Button nine = (Button) findViewById(R.id.nine);
        nine.setTypeface(myFont);
        final Button delete = (Button) findViewById(R.id.delete);
        delete.setTypeface(myFont);
        final Button zero = (Button) findViewById(R.id.zero);
        zero.setTypeface(myFont);
        final Button go = (Button) findViewById(R.id.go);
        go.setTypeface(myFont);

        CountDownTimer timer = new CountDownTimer(5000,0000) {
            public void onTick(long secRemaining) {
                myTimer.setText(":" + secRemaining / 1000);

//                if(secRemaining < 15000) {
//                    //myTimer.setTextColor();
//                }
            }
            public void onFinish() {

                gameOver(gameover, BackHome, PlayAgain);
                myTimer.setText(":0");
            }
        };



        timer.start();


    }

    public void gameOver(final RelativeLayout gameover, Button BackHome, Button PlayAgain){
        gameover.setVisibility(View.VISIBLE);
    }

    public void RestartGame(RelativeLayout gameover){
        gameover.setVisibility(View.GONE);

    }

}

