/**
 * Created by nikolaschaconas on 7/24/15.
 */
package mobileapplicationdevelopment.flashmath;


import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Typeface;
import android.os.Bundle;
import android.app.Activity;
import android.util.TypedValue;
import android.widget.Button;
import android.os.CountDownTimer;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.view.View;

import org.apache.http.auth.BasicUserPrincipal;
import org.w3c.dom.Text;

import java.util.Random;

import mobileapplicationdevelopment.flashmath.R;

public class playgame extends Activity{
    protected void onCreate(Bundle savedInstanceState) {

        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LOCKED);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.playgame);
        final RelativeLayout gameover = (RelativeLayout) findViewById(R.id.gameover);
        final Typeface myFont = Typeface.createFromAsset(getAssets(), "Cutie Patootie Skinny.ttf");
        final EditText answer = (EditText) findViewById(R.id.answer);
        answer.setTypeface(myFont);

        final TextView myTimer = (TextView) findViewById(R.id.timer);
        myTimer.setTypeface(myFont);

        final TextView currentProblem = (TextView) findViewById(R.id.problem);
        currentProblem.setTypeface(myFont);

        final TextView TimesUp = (TextView) findViewById(R.id.timesuptext);
        TimesUp.setTypeface(myFont);

        final TextView won = (TextView) findViewById(R.id.won);
        won.setTypeface(myFont);

        final Button BackHome = (Button) findViewById(R.id.back_home);
        BackHome.setTypeface(myFont);

        final Button PlayAgain = (Button) findViewById(R.id.play_again);
        PlayAgain.setTypeface(myFont);


        final Button one = (Button) findViewById(R.id.one);
        one.setTypeface(myFont);
        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                answer.append("1");
            }
        });


        final Button two = (Button) findViewById(R.id.two);
        two.setTypeface(myFont);
        two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                answer.append("2");
            }
        });

        final Button three = (Button) findViewById(R.id.three);
        three.setTypeface(myFont);
        three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                answer.append("3");
            }
        });

        final Button four = (Button) findViewById(R.id.four);
        four.setTypeface(myFont);
        four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                answer.append("4");
            }
        });

        final Button five = (Button) findViewById(R.id.five);
        five.setTypeface(myFont);
        five.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                answer.append("5");
            }
        });

        final Button six = (Button) findViewById(R.id.six);
        six.setTypeface(myFont);
        six.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                answer.append("6");
            }
        });

        final Button seven = (Button) findViewById(R.id.seven);
        seven.setTypeface(myFont);
        seven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                answer.append("7");
            }
        });

        final Button eight = (Button) findViewById(R.id.eight);
        eight.setTypeface(myFont);
        eight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                answer.append("8");
            }
        });

        final Button nine = (Button) findViewById(R.id.nine);
        nine.setTypeface(myFont);
        nine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                answer.append("9");
            }
        });

        final Button delete = (Button) findViewById(R.id.delete);
        delete.setTypeface(myFont);
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String currentText = answer.getText().toString();
                int length = currentText.length();
                if (length != 0) {
                    answer.setText(currentText.substring(0, length - 1));
                    answer.setSelection(length - 1);
                }
            }
        });

        final Button zero = (Button) findViewById(R.id.zero);
        zero.setTypeface(myFont);
        zero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                answer.append("0");
            }
        });

        final Button go = (Button) findViewById(R.id.go);
        go.setTypeface(myFont);


        BackHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(playgame.this, mobileapplicationdevelopment.flashmath.home.class));
            }
        });


        final CountDownTimer timer = new CountDownTimer(60000,1000) {
            Boolean newProblem = true;
            public void onTick(long secRemaining) {
                myTimer.setText(":" + secRemaining / 1000);
                int answer = getAnswer();
                go.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        int number = -1;
                        if(Integer.parseInt(answer.getText().toString()) == number) {
                            answer.setText("");
                            newProblem = true;
                        }
                    }
                });

            }
            public void onFinish() {

                gameOver(gameover, BackHome, PlayAgain, currentProblem, answer);
                myTimer.setText(":0");
            }
        };

        PlayAgain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RestartGame(gameover, timer, currentProblem, answer);
            }
        });



        timer.start();
    }



    public void gameOver(final RelativeLayout gameover, Button BackHome, Button PlayAgain, TextView currentProblem, EditText answer){
        currentProblem.setVisibility(View.GONE);
        gameover.setVisibility(View.VISIBLE);
        answer.setVisibility(View.GONE);

    }

    public void RestartGame(RelativeLayout gameover, CountDownTimer timer, TextView currentProblem, EditText answer){
        gameover.setVisibility(View.GONE);
        currentProblem.setVisibility(View.VISIBLE);
        answer.setVisibility(View.VISIBLE);
        timer.start();

    }

    public int getRandomNumber(int min, int max) {
        Random rand = new Random();
        return rand.nextInt((max - min) + 1) + min;
    }

    public int getAnswer(EditText answer){
        return Integer.parseInt(answer.getText().toString());
    }

}

