package com.example.cs125bmi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.text.DecimalFormat;

public class YourBmi extends AppCompatActivity {

    public static double bmi;
    public static boolean average = false;
    public static boolean high = false;
    public TextView message;
    public TextView foodpref;
    public Button c;
    public String reading;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_your_bmi);

        if (bmi < 18.5) {
            reading = "Your BMI is below Average. Click on continue to create a diet";
            high = false;
        } else if (bmi >= 18.5 && bmi <= 24.9) {
            reading = "Your BMI is normal. Keep up the great work!";
            average = true;
        } else if (bmi >= 25.0 && bmi <= 29.9) {
            reading = "Your BMI is above average. You are overweight. Click on continue to create a diet";
            high = true;
        } else if (bmi >= 30.0) {
            reading = "Your BMI is above average. You are obese. Click on continue to create a diet";
            high = true;
        }

        DecimalFormat df = new DecimalFormat("#.##");
        message = findViewById(R.id.textView7);
        foodpref = findViewById(R.id.textView8);

        String m = getString(R.string.YourBmi) + " " + df.format(bmi);

        message.setText(m);
        foodpref.setText(reading);

        c = findViewById(R.id.button3);
        if (average) {
            c.setVisibility(View.INVISIBLE);
        }
        c.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), GenerateRecipe.class);
                startActivity(i);
                /*
                if (high) {
                    Intent i = new Intent(getApplicationContext(), ChooseFoodPreferences.class);
                    startActivity(i);
                } else {
                    Intent a = new Intent(getApplicationContext(), LowBmiFoodPref.class);
                    startActivity(a);
                }

                 */
            }
        });
    }
}
