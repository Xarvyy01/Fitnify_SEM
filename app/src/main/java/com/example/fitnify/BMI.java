package com.example.fitnify;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class BMI extends AppCompatActivity {

    EditText vaha;
    EditText vyska;
    CardView cardBtn;
    TextView textView;

    /**
     * Vytvorenie acttivity a priradenie layoutov do prislušných atribútov
     *
     * @param savedInstanceState
     * @return
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmi);
        vaha = findViewById(R.id.edKg);
        vyska = findViewById(R.id.edFeet);
        cardBtn = findViewById(R.id.cardBtn);
        textView = findViewById(R.id.textViewM);


        cardBtn.setOnClickListener(new View.OnClickListener() {


            /**
             * Nastavenie čo sa stane po stlačeni tlačitka
             *
             * @param v
             * @return
             */
            @Override
            public void onClick(View v) {

                String kg = vaha.getText().toString();
                String meter = vyska.getText().toString();

                float vaha_vypocet = Float.parseFloat(kg);
                float vyska_vypocet = Float.parseFloat(meter) / 100;

                float bmi = vaha_vypocet/(vyska_vypocet * vyska_vypocet);

                if (bmi > 24) {

                    textView.setText("Nadváha " + bmi);

                } else if (bmi > 18) {

                    textView.setText("Normálna váha " + bmi);

                } else {

                    textView.setText("Podváha " + bmi);

                }
            }
        });
    }
}