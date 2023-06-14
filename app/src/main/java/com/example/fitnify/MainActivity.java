package com.example.fitnify;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button button_calendar;
    Button button_stopwatch;
    Button button_bmi;

    Button button_measurements;

    /**
     * Vytvorenie acttivity a priradenie layoutov do prislušných atribútov
     *
     * @param savedInstanceState
     * @return
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button_calendar = findViewById(R.id.button5);
        button_calendar.setOnClickListener(new View.OnClickListener() {
            /**
             * Nastavenie čo sa stane po stlačeni tlačitka
             *
             * @param v
             * @return
             */
            @Override
            public void onClick(View v) {
                openExercise();
            }
        });

        button_stopwatch = findViewById(R.id.button6);
        button_stopwatch.setOnClickListener(new View.OnClickListener() {
            /**
             * Nastavenie čo sa stane po stlačeni tlačitka
             *
             * @param v
             * @return
             */
            @Override
            public void onClick(View v) {
                openStopWatch();
            }
        });

        button_bmi = findViewById(R.id.button4);
        button_bmi.setOnClickListener(new View.OnClickListener() {
            /**
             * Nastavenie čo sa stane po stlačeni tlačitka
             *
             * @param v
             * @return
             */
            @Override
            public void onClick(View v) {
                openBMI();
            }
        });

        button_measurements = findViewById(R.id.button8);
        button_measurements.setOnClickListener(new View.OnClickListener() {
            /**
             * Nastavenie čo sa stane po stlačeni tlačitka
             *
             * @param v
             * @return
             */
            @Override
            public void onClick(View v) {
                openMeasurements();
            }
        });
    }

    /**
     * Funkcia ktorá otvorí aktivitu Exercise
     *
     * @return
     */
    public void openExercise() {

        Intent intent = new Intent(this, Exercises.class);
        startActivity(intent);


    }

    /**
     * Funkcia ktorá otvorí aktivitu StopWatch
     *
     * @return
     */
    public void openStopWatch() {

        Intent intent = new Intent(this, StopWatch.class);
        startActivity(intent);

    }

    /**
     * Funkcia ktorá otvorí aktivitu BMI
     *
     * @return
     */
    public void openBMI() {

        Intent intent = new Intent(this, BMI.class);
        startActivity(intent);

    }

    /**
     * Funkcia ktorá otvorí aktivitu Measurements
     *
     * @return
     */
    public void openMeasurements() {

        Intent intent = new Intent(this, Measurements.class);
        startActivity(intent);


    }
}