package com.example.cs125bmi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class YourBmi extends AppCompatActivity {

    public static double bmi;
    public static boolean ageCheck;
    public TextView message;
    public Button c;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_your_bmi);

        message = findViewById(R.id.textView7);
        if (ageCheck) {
            message.setText(R.string.message);
        } else {
            message.setText(R.string.message);
        }

        c = findViewById(R.id.button3);
        c.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), ChooseFoodPreferences.class);
                startActivity(i);
            }
        });


    }
}
