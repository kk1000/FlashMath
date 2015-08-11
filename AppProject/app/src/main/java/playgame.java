/**
 * Created by nikolaschaconas on 7/24/15.
 */
package mobileapplicationdevelopment.flashmath;


import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.graphics.Typeface;
import android.os.Bundle;
import android.app.Activity;
import android.preference.PreferenceManager;
import android.util.TypedValue;
import android.graphics.Color;
import android.widget.Button;
import android.os.CountDownTimer;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.view.View;


import java.util.Random;


public class playgame extends Activity{
    private int starCount = 0;
    public int getStarCount(){return starCount;}
    protected void onCreate(Bundle savedInstanceState) {

        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LOCKED);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.playgame);
        final RelativeLayout gameover = (RelativeLayout) findViewById(R.id.gameover);
        final Typeface myFont = Typeface.createFromAsset(getAssets(), "Cutie Patootie Skinny.ttf");
        final EditText answer = (EditText) findViewById(R.id.answer);
        answer.setTypeface(myFont);

        final TextView apostraphes = (TextView)findViewById(R.id.apostraphe);
        apostraphes.setTypeface(myFont);

        final TextView starText = (TextView) findViewById(R.id.startext);
        starText.setTypeface(myFont);

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

        final FrameLayout green_check = (FrameLayout) findViewById(R.id.green_check);

        final FrameLayout red_x = (FrameLayout) findViewById(R.id.red_x);

        //set user image in top corner
        final FrameLayout user = (FrameLayout) findViewById(R.id.userImage);
        if(getIntent().getExtras().getString("user").equals("boy"))
            user.setBackgroundResource(R.drawable.boy);
        else
            user.setBackgroundResource(R.drawable.girl);

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

        final CountDownTimer popUp = new CountDownTimer(1001,1000) {
            public void onTick(long sec){

            }
            public void onFinish() {
                red_x.setVisibility(View.GONE);
                green_check.setVisibility(View.GONE);
            }
        };


        final CountDownTimer timer = new CountDownTimer(15000,1000) {
            Boolean newProblem = true;

            public void onTick(long secRemaining) {
                boolean visible = false;
                myTimer.setText(":" + secRemaining / 1000);
                if(secRemaining < 11000) {
                    myTimer.setTextColor(Color.RED);
                    if(secRemaining % 500 == 0){
                        if(!visible) {
                            myTimer.setVisibility(View.INVISIBLE);
                            visible = true;
                        }
                        else{
                            myTimer.setVisibility(View.VISIBLE);
                            visible = false;
                        }
                    }

                }
                final TextView CorrectAnswer = (TextView) findViewById(R.id.correctanswer);
                int min = 0, max = 0;
                if(newProblem == true) {
                    String level= getIntent().getExtras().getString("level");
                    if(level.equals("easy")) {
                        max = 8;
                    }
                    else if(level.equals("hard")) {
                        max = 12;
                    }

                    int num1 = getRandomNumber(min, max);
                    int num2 = getRandomNumber(min, max);


                    String type = getIntent().getExtras().getString("type");
                    String symbolForOperator = "+";
                    if(type.equals("plus")) {
                        symbolForOperator = "+";
                        CorrectAnswer.setText((num1 + num2)+"");
                    }
                    else if (type.equals("minus")) {
                        symbolForOperator = "-";
                        if(num2 > num1){
                            int tmp = num1;
                            num1 = num2;
                            num2 = tmp;
                        }
                        CorrectAnswer.setText((num1 - num2)+"");
                    }
                    else if (type.equals("multiply")) {
                        symbolForOperator = "*";
                        CorrectAnswer.setText((num1 * num2)+"");
                    }
                    else if (type.equals("divide")) {
                        if(num2 == 0) num2 = 1;
                        if(num1 % num2 != 0){
                            if(num1 % 2 == 0) num2 = 2;
                            else if (num1 % 3 == 0) num2 = 3;
                            else if (num1 % 5 == 0) num2 = 5;
                            else if (num1 % 7 == 0) num2 = 7;
                            else if (num1 % 11 == 0) num2 = 11;
                            else num2 = 1;
                        }
                        symbolForOperator = "/";
                        CorrectAnswer.setText((num1 / num2)+"");
                    }

                    currentProblem.setText(num1 + " " + symbolForOperator + " " + num2);
                    newProblem = false;
                }


                go.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        //if user has correct answer
                        if(Integer.parseInt(CorrectAnswer.getText().toString()) == getAnswer(answer)) {
                            answer.setText("");
                            newProblem = true;
                            red_x.setVisibility(View.GONE);
                            green_check.setVisibility(View.VISIBLE);
                            green_check.bringToFront();
                            popUp.start();
                            starText.setText("x" + ++starCount);
                        }

                        else {
                            answer.setText("");
                            green_check.setVisibility(View.GONE);
                            red_x.setVisibility(View.VISIBLE);
                            red_x.bringToFront();
                            popUp.start();
                        }
                    }
                });

            }

            public void onFinish() {
                gameOver(gameover, currentProblem, answer, go);
                myTimer.setVisibility(View.VISIBLE);
                myTimer.setText(":0");
                if(starCount != 1) {
                    won.setText("WON: " + starCount + " ");
                    apostraphes.setVisibility(View.VISIBLE);
                }
                else {
                    apostraphes.setVisibility(View.GONE);
                    won.setText("WON: " + starCount + " ");
                }

                SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(playgame.this);
                SharedPreferences.Editor editor = preferences.edit();
                if(getIntent().getExtras().getString("user").equals("boy"))
                    editor.putInt("boy_stars", preferences.getInt("boy_stars", 0) + starCount);
                else
                    editor.putInt("girl_stars", preferences.getInt("girl_stars", 0) + starCount);
                editor.apply();
                starCount = 0;
            }
        };

        PlayAgain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myTimer.setTextColor(Color.BLACK);
                RestartGame(gameover, timer, currentProblem, answer, go);
                starText.setText("x" + starCount);
            }
        });



        timer.start();
    }



    public void gameOver(final RelativeLayout gameover, TextView currentProblem, EditText answer, Button go){
        currentProblem.setVisibility(View.GONE);
        gameover.setVisibility(View.VISIBLE);
        answer.setVisibility(View.GONE);
        go.setEnabled(false);
    }

    public void RestartGame(RelativeLayout gameover, CountDownTimer timer, TextView currentProblem, EditText answer, Button go){
        gameover.setVisibility(View.GONE);
        currentProblem.setVisibility(View.VISIBLE);
        answer.setVisibility(View.VISIBLE);
        answer.setText("");
        timer.start();
        go.setEnabled(true);
    }

    public int getRandomNumber(int min, int max) {
        Random rand = new Random();
        return rand.nextInt((max - min) + 1) + min;
    }

    public int getAnswer(EditText answer){
        String ans = answer.getText().toString();
        if(ans.length() != 0)
            return Integer.parseInt(ans);
        else return -1;
    }

}

