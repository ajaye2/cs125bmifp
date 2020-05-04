package com.example.cs125bmi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class FinalPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final_page);
        if (YourBmi.high) {
            String bDiet = ChooseFoodPreferences.breakfast.get(0) + " for breakfast.";
            TextView b = findViewById(R.id.breakfastDiet);
            b.setText(bDiet);

            String lDiet = ChooseFoodPreferences.lunch.get(0) + " for lunch ";
            TextView l = findViewById(R.id.lunchDiet);
            l.setText(lDiet);

            String dDiet = "And " + ChooseFoodPreferences.dinner.get(0) + " for dinner.";
            TextView d = findViewById(R.id.dinnerDiet);
            d.setText(dDiet);
        } else {
            String bDiet = LowBmiFoodPref.breakfast.get(0) + " for breakfast.";
            TextView b = findViewById(R.id.breakfastDiet);
            b.setText(bDiet);

            String lDiet = LowBmiFoodPref.lunch.get(0) + " for lunch ";
            TextView l = findViewById(R.id.lunchDiet);
            l.setText(lDiet);

            String dDiet = "And " + LowBmiFoodPref.dinner.get(0) + " for dinner.";
            TextView d = findViewById(R.id.dinnerDiet);
            d.setText(dDiet);
        }
    }
}
