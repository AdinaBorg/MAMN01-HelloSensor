package com.example.myfirstapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /** Called when the user taps accelerometer button*/
    public void getToAccelerometer(View view) {
        Intent intent = new Intent(this, DisplayAccelerometerActivity.class);
        startActivity(intent);
    }

    /** Called when the user taps compass button*/
    public void getToCompass(View view) {
        Intent intent = new Intent(this, DisplayCompassActivity.class);
        startActivity(intent);
    }
}
