package com.example.myfirstapp;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.ImageView;
import android.widget.Button;
import android.widget.LinearLayout;

import java.text.DecimalFormat;


public class DisplayAccelerometerActivity extends AppCompatActivity implements SensorEventListener {
    private TextView xText, yText, zText;
    private ImageView image;
    private Button chest, startButton;
    private LinearLayout startBox;
    private TextView congratsText;
    private Sensor mySensor;
    private SensorManager SM;
    private static DecimalFormat df = new DecimalFormat("0.00");


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_accelerometer);

        //create Sensor Manager
        SM = (SensorManager)getSystemService(SENSOR_SERVICE);

        //Accelerometer Sensor
        mySensor = SM.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);

        //Register sensor Listener
        SM.registerListener(this, mySensor, SensorManager.SENSOR_DELAY_NORMAL);

        // Assign TextView
        xText = (TextView)findViewById(R.id.xText);
        yText = (TextView)findViewById(R.id.yText);
        zText = (TextView)findViewById(R.id.zText);
        image = (ImageView)findViewById(R.id.map);
        chest = (Button)findViewById(R.id.chest);
        congratsText = (TextView)findViewById(R.id.congrats);
        startButton = (Button)findViewById(R.id.startButton);
        startBox = (LinearLayout)findViewById(R.id.startBox);

    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        xText.setText("X: " + df.format(event.values[0]));
        yText.setText("Y: " + df.format(event.values[1]));
        zText.setText("Z: " + df.format(event.values[2]));

        double highValue = 0;
        double lowValue = 0;
        double x, y, z;

        x = (double) event.values[0];
        y = (double) event.values[1];
        z = (double) event.values[2];

        //find the biggest of x,y and z and call setTextColor
        /** if( x >= highValue){
            highValue = x;
            setTextColor(xText);
        }

        if( y >= highValue){
            highValue = y;
            setTextColor(yText);
        }

        if( z >= highValue){
            highValue = z;
            setTextColor(zText);
        } */

        //up and down
        if(z > 0 && y < -2){
            if(y < -5) {
                moveDown(30);
                setTextColorRed();
            }else{
                moveDown(10);
                setTextColorBlack();
            }
        }else if(z < 5 && y > 5){
            if(z < 0){
                moveUp(30);
                setTextColorRed();
            }else{
                moveUp(10);
                setTextColorBlack();
            }
        }

        //moves left or right
        if(x > 5 && y < 5) {
            if(y < 0){
                moveRight(30);
                setTextColorRed();
            }else{
                moveRight(10);
                setTextColorBlack();
            }
        }else if(x < -5 && y < 5) {
            if(y < 0){
                moveLeft(30);
                setTextColorRed();
            }else{
                moveLeft(10);
                setTextColorBlack();
            }
        }
    }

    public void setTextColorRed() {
        xText.setTextColor(Color.parseColor("#FFCC0000"));
        yText.setTextColor(Color.parseColor("#FFCC0000"));
        zText.setTextColor(Color.parseColor("#FFCC0000"));
    }

    public void setTextColorBlack() {
        xText.setTextColor(Color.BLACK);
        yText.setTextColor(Color.BLACK);
        zText.setTextColor(Color.BLACK);
    }

    public void moveLeft(int speed) {
        image.setX(image.getX() -speed);
        chest.setX(chest.getX() -speed);
    }

    public void moveRight(int speed) {
        image.setX(image.getX() +speed);
        chest.setX(chest.getX() +speed);
    }

    public void moveUp(int speed) {
        image.setY(image.getY() -speed);
        chest.setY(chest.getY() -speed);
    }

    public void moveDown(int speed) {
        image.setY(image.getY() +speed);
        chest.setY(chest.getY() +speed);
    }

    public void foundChest(View view) {
        congratsText.setText("Congratulations! You found the Treasure!");
    }

    public void startTreasureHunt(View view) {
        startBox.setVisibility(View.INVISIBLE);
    }


    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {
        //not in use
    }
}