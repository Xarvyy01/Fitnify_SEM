package com.example.fitnify;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.Locale;

public class StopWatch extends AppCompatActivity {


    private int seconds;

    private int hodiny;
    private int minuty;
    private int sekundy;
    private boolean zapinac;
    private boolean overenie;

    ImageButton button_play;
    ImageButton button_stop;
    ImageButton button_reset;

    /**
     * Vytvorenie acttivity a priradenie layoutov do prislušných atribútov
     *
     * @param savedInstanceState
     * @return
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stop_watch);
        button_play = findViewById(R.id.button_play);
        button_stop = findViewById(R.id.button_stop);
        button_reset = findViewById(R.id.button_reset);

        /**
         * Nastavenie čo sa stane po stlačeni tlačitka
         *
         * @param v
         * @return
         */
        button_play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                start();
            }
        });
        /**
         * Nastavenie čo sa stane po stlačeni tlačitka
         *
         * @param v
         * @return
         */
        button_stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stop();
            }
        });
        /**
         * Nastavenie čo sa stane po stlačeni tlačitka
         *
         * @param v
         * @return
         */
        button_reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                reset();
            }
        });

        casovac();

    }

    /**
     * Metoda časovaneho loopu
     * @param
     * @return
     */
    public void casovac() {

        TextView text = findViewById(R.id.text);
        Handler handler = new Handler();
        handler.post(new Runnable() {

            /**
             * Metoda načíta hodiny, mintúty a sekundy a spusti znova cyklus kazdu jednu sekundu
             * @param
             * @return
             */
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

    /**
     * metoda ktora zapne stopky
     * @param
     * @return
     */
    public void start() {

        zapinac = true;

    }

    /**
     * metoda ktora zastavi stopky
     * @param
     * @return
     */
    public void stop() {

        zapinac = false;

    }

    /**
     * metoda ktora resetne stopky
     * @param
     * @return
     */
    public void reset() {

        hodiny = 0;
        minuty = 0;
        sekundy = 0;
        seconds = 0;

    }

}