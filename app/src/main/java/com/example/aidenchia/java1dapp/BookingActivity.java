package com.example.aidenchia.java1dapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class BookingActivity extends AppCompatActivity
{
    TextView roomsAvailable;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking);

        // INITIALIZE
        roomsAvailable = (TextView) findViewById(R.id.rooms_available);
        roomsAvailable.setText(R.string.rooms_available);


    }

}
