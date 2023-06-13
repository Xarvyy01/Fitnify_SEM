package com.example.fitnify;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Locale;

public class StopWatch extends AppCompatActivity {


    private int seconds;

    private int hodiny;
    private int minuty;
    private int sekundy;
    private boolean zapinac;
    private boolean overenie;

    Button button_play;
    Button button_stop;
    Button button_reset;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stop_watch);
        button_play = findViewById(R.id.button_play);
        button_stop = findViewById(R.id.button_stop);
        button_reset = findViewById(R.id.button_reset);
        button_play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                start();
            }
        });

        button_stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stop();
            }
        });

        button_reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                reset();
            }
        });

        casovac();

    }

    public void casovac() {

        TextView text = findViewById(R.id.text);
        Handler handler = new Handler();
        handler.post(new Runnable() {


            @Override
            public void run() {


                hodiny = seconds / 3600;
                minuty = seconds / 60;
                sekundy = seconds % 60;
                String cas = String.format(Locale.getDefault(),"%d:%02d:%02d",hodiny, minuty, sekundy);
                text.setText(cas);
                if(zapinac) {

                    seconds = seconds + 1;

                }
                handler.postDelayed(this, 1000);
            }
        });
    }

    public void start() {

        zapinac = true;

    }

    public void stop() {

        zapinac = false;

    }

    public void reset() {

        hodiny = 0;
        minuty = 0;
        sekundy = 0;
        seconds = 0;

    }

}