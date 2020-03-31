package com.example.myfirstapp;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.ImageView;

import java.text.DecimalFormat;


public class DisplayAccelerometerActivity extends AppCompatActivity implements SensorEventListener {
    private TextView xText, yText, zText;
    private ImageView image;
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
        if(z > 5 && y < -2){
            moveDown();
        }else if(z < 5 && y > 5){
            moveUp();
        }

        //moves left or right
        if(x > 5 && y < 5) {
            moveRight();
        }else if(x < -5 && y < 5) {
            moveLeft();
        }
    }

   /** public void setTextColor(TextView text) {
        xText.setTextColor(Color.parseColor("#FFCC0000"));
        yText.setTextColor(Color.parseColor("#FFCC0000"));
        zText.setTextColor(Color.parseColor("#FFCC0000"));
        if the highest number should be another color
        text.setTextColor(Color.RED);
    } */

    public void moveLeft() {
            image.setX(image.getX() -10);

    }

    public void moveRight() {
            image.setX(image.getX() +10);
    }

    public void moveUp() {
            image.setY(image.getY() -10);
    }

    public void moveDown() {
            image.setY(image.getY() +10);
    }


    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {
        //not in use
    }
}