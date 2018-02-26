package com.firstapp.benesposito.firstapp;

import android.support.v4.view.GestureDetectorCompat;
import android.support.v4.view.MotionEventCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;

import static android.R.attr.action;

public class MainActivity extends AppCompatActivity implements GestureDetector.OnGestureListener,
        GestureDetector.OnDoubleTapListener
{
    private Switch homeGestureSwitch;
    private TextView test;
    private GestureDetectorCompat mDetector;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        homeGestureSwitch = (Switch) findViewById(R.id.homeGestureSwitch);
        test = (TextView) findViewById(R.id.test);

        mDetector = new GestureDetectorCompat(this, this);
        mDetector.setOnDoubleTapListener(this);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event)
    {
        this.mDetector.onTouchEvent(event);
        return super.onTouchEvent(event);
    }

    @Override
    public boolean onSingleTapConfirmed(MotionEvent e) {
        if(homeGestureSwitch.isChecked())
            test.setText("Single Tap Confirmed");

        return true;
    }

    @Override
    public boolean onDoubleTap(MotionEvent e) {
        if(homeGestureSwitch.isChecked())
            test.setText("DOUBLE TAP");

        return true;
    }

    @Override
    public boolean onDoubleTapEvent(MotionEvent e) {
        if(homeGestureSwitch.isChecked())
            test.setText("DOUBLE TAP");

        return true;
    }

    @Override
    public boolean onDown(MotionEvent e) {
        return true;
    }

    @Override
    public void onShowPress(MotionEvent e) {

    }

    @Override
    public boolean onSingleTapUp(MotionEvent e) {
        if(homeGestureSwitch.isChecked())
            test.setText("Single Tap Up");

        return true;
    }

    @Override
    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
        return true;
    }

    @Override
    public void onLongPress(MotionEvent e) {
        if(homeGestureSwitch.isChecked())
            test.setText("Long Press");
    }

    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
        if(homeGestureSwitch.isChecked())
        {
            /*if(velocityX > 2000 && velocityY > -3000 && velocityY < 3000)
                test.setText("RIGHT");
            else if(velocityX < -2000 && velocityY > -3000 && velocityY < 3000)
                test.setText("LEFT");
            else if(velocityY > 2000 && velocityX > -3000 && velocityX < 3000)
                test.setText("DOWN");
            else if(velocityY < -2000 && velocityX > -3000 && velocityX < 3000)
                test.setText("UP");
            else
                test.setText("X: " + velocityX + ", Y: " + velocityY);*/

            double diff = Math.abs(velocityX) - Math.abs(velocityY);
            int THRESHOLD = 0;

            if(velocityX > 0 && diff > THRESHOLD)
                test.setText("RIGHT");
            else if(velocityX < 0 && diff > THRESHOLD)
                test.setText("LEFT");
            else if(velocityY > 0 && -diff > THRESHOLD)
                test.setText("DOWN");
            else if(velocityY < 0 && -diff > THRESHOLD)
                test.setText("UP");
            else
                test.setText("X: " + velocityX + ", Y: " + velocityY + ", diff: " + diff);
        }
        return true;
    }
}
