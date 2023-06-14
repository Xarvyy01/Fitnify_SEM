package com.example.fitnify;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Measurements extends AppCompatActivity {

    Button save_button;
    TextView text;
    EditText editText_Arm;

    TextView Text_Chest;
    EditText editText_Chest;

    TextView Text_Legs;
    EditText editText_Legs;

    TextView Text_Back;
    EditText editText_Back;

    String slovo;
    int cislo;
    public static final String ETXT_ARM = "ahoj";
    public static final String TEXT_ARM = "text";

    public static final String ETXT_CHEST = "ahoj";
    public static final String TEXT_CHEST = "texts";

    public static final String ETXT_LEGS = "ahoj";
    public static final String TEXT_LEGS = "textsa";

    public static final String ETXT_BACK = "ahoj";
    public static final String TEXT_BACK = "textsas";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_measurements);

        save_button = findViewById(R.id.save_button);
        text = findViewById(R.id.textView3);
        editText_Arm = findViewById(R.id.edt);

        Text_Chest = findViewById(R.id.textView4);
        editText_Chest = findViewById(R.id.edt2);

        Text_Legs = findViewById(R.id.textView5);
        editText_Legs = findViewById(R.id.edt3);

        Text_Back = findViewById(R.id.textView6);
        editText_Back = findViewById(R.id.edt4);


        save_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                text.setText(editText_Arm.getText().toString());
                Text_Chest.setText(editText_Chest.getText().toString());
                Text_Legs.setText(editText_Legs.getText().toString());
                Text_Back.setText(editText_Back.getText().toString());
                save();
            }
        });
        loadData();
    }

    public void save() {

        SharedPreferences sharedPreferences1 = getSharedPreferences(ETXT_ARM, MODE_PRIVATE);
        SharedPreferences.Editor editor1 = sharedPreferences1.edit();
        editor1.putString(TEXT_ARM, text.getText().toString());

        editor1.apply();

        SharedPreferences sharedPreferences2 = getSharedPreferences(ETXT_CHEST, MODE_PRIVATE);
        SharedPreferences.Editor editor2 = sharedPreferences2.edit();
        editor2.putString(TEXT_CHEST, Text_Chest.getText().toString());

        editor2.apply();

        SharedPreferences sharedPreferences3 = getSharedPreferences(ETXT_LEGS, MODE_PRIVATE);
        SharedPreferences.Editor editor3 = sharedPreferences3.edit();
        editor3.putString(TEXT_LEGS, Text_Legs.getText().toString());

        editor3.apply();

        SharedPreferences sharedPreferences4 = getSharedPreferences(ETXT_BACK, MODE_PRIVATE);
        SharedPreferences.Editor editor4 = sharedPreferences4.edit();
        editor4.putString(TEXT_BACK, Text_Back.getText().toString());

        editor4.apply();

        Toast.makeText(this, "Saved", Toast.LENGTH_SHORT).show();
    }

    public void loadData() {

        SharedPreferences sharedPreferences1 = getSharedPreferences(ETXT_ARM, MODE_PRIVATE);
        slovo = sharedPreferences1.getString(TEXT_ARM, "");
        cislo = 0;
        update(slovo);

        SharedPreferences sharedPreferences2 = getSharedPreferences(ETXT_CHEST, MODE_PRIVATE);
        slovo = sharedPreferences2.getString(TEXT_CHEST, "");
        cislo = 1;
        update(slovo);

        SharedPreferences sharedPreferences3 = getSharedPreferences(ETXT_LEGS, MODE_PRIVATE);
        slovo = sharedPreferences3.getString(TEXT_LEGS, "");
        cislo = 2;
        update(slovo);

        SharedPreferences sharedPreferences4 = getSharedPreferences(ETXT_BACK, MODE_PRIVATE);
        slovo = sharedPreferences4.getString(TEXT_BACK, "");
        cislo = 3;
        update(slovo);
    }

    public void update(String slovo) {

        switch (cislo) {

            case 0:
                text.setText(slovo);
                break;
            case 1:
                Text_Chest.setText(slovo);
                break;
            case 2:
                Text_Legs.setText(slovo);
                break;
            case 3:
                Text_Back.setText(slovo);
                break;
        }




    }
}