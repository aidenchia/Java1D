package com.example.aidenchia.java1dapp;

import android.content.Intent;
import android.app.DatePickerDialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity
{
    public static final String TAG = "java1d";
    String startTime;
    String endTime;
    TextView creditCost;
    TextView roomsAvailable;
    Spinner startSpinner;
    Spinner endSpinner;
    Button bookButton;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        final TextView displayDate;
        final DatePickerDialog.OnDateSetListener dateSetListener;
        startTime = "7am"; // temporary default value
        endTime = "7am"; // temporary default value

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent intent = getIntent();
        displayDate = (TextView) findViewById(R.id.my_date);
        bookButton = (Button) findViewById(R.id.bookButton);

        dateSetListener = new DatePickerDialog.OnDateSetListener()
        {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                month += 1;
                Log.d(TAG, "onDateSet: dd/mm/yyyy " + day + "/" + month + "/" + year);
                String date_chosen = day + "/" + month + "/" + year;
                displayDate.setText(date_chosen);
            }
        };

        displayDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar cal = Calendar.getInstance();
                int year = cal.get(Calendar.YEAR);
                int month = cal.get(Calendar.MONTH);
                int day = cal.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dialog = new DatePickerDialog(
                        MainActivity.this,
                        android.R.style.Theme_Holo_Dialog_MinWidth,
                        dateSetListener,
                        year,month,day);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();
            }
        });

        // Initialize Spinners
        startSpinner = (Spinner) findViewById(R.id.start_time);
        endSpinner = (Spinner) findViewById(R.id.end_time);
        // Create an array adapter using the string array defined in strings.xml and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,R.array.timings_array, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        startSpinner.setAdapter(adapter);
        endSpinner.setAdapter(adapter);
        startSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                startTime = parent.getItemAtPosition(position).toString();
                Log.i(TAG, "startTime = " + startTime);
                Log.i(TAG, "endTime = " + endTime);
                boolean checkTime = TimeChecker.timeCheck(startTime, endTime);
                if (checkTime == false)
                {
                    Toast.makeText(MainActivity.this, R.string.time_problem, Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        endSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                endTime = parent.getItemAtPosition(position).toString();
                Log.i(TAG, "startTime = " + startTime);
                Log.i(TAG, "endTime = " + endTime);
                boolean checkTime = TimeChecker.timeCheck(startTime, endTime);
                if (checkTime == false)
                {
                    Toast.makeText(MainActivity.this, R.string.time_problem, Toast.LENGTH_LONG).show();
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        bookButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, BookingActivity.class);
                startActivity(intent);
            }
        });










    }
}
