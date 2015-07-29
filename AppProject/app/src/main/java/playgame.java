/**
 * Created by nikolaschaconas on 7/24/15.
 */
package mobileapplicationdevelopment.flashmath;


import android.graphics.Typeface;
import android.os.Bundle;
import android.app.Activity;
import android.widget.Button;

import org.apache.http.auth.BasicUserPrincipal;

import mobileapplicationdevelopment.flashmath.R;

public class playgame extends Activity{
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.playgame);

        final Typeface myFont = Typeface.createFromAsset(getAssets(), "Cutie Patootie Skinny.ttf");
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
        final Button zero = (Button) findViewById(R.id.zero);
        zero.setTypeface(myFont);
        final Button delete = (Button) findViewById(R.id.delete);
        delete.setTypeface(myFont);
        final Button go = (Button) findViewById(R.id.go);
        go.setTypeface(myFont);













    }

}

