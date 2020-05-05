package com.example.cs125bmi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class FinalPage extends AppCompatActivity {



    public static String me;
    public static String one;
    public static String two;
    public static String three;
    public static String link1;
    public static String link2;
    public static String link3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final_page);



        JSONObject week = GenerateRecipe.week;
        JSONObject monday = GenerateRecipe.monday;
        JSONObject tuesday = GenerateRecipe.tuesday;
        JSONObject wednesday = GenerateRecipe.wednesday;
        JSONObject thursday = GenerateRecipe.thursday;
        JSONObject friday = GenerateRecipe.friday;
        JSONObject saturday = GenerateRecipe.saturday;
        JSONObject sunday = GenerateRecipe.sunday;


        System.out.println(" text2 " + me);

        TextView b = findViewById(R.id.breakfastDiet);
        TextView l = findViewById(R.id.lunchDiet);



        TextView a = findViewById(R.id.textView9);
        TextView m = findViewById(R.id.textView10);



        b.setText(one);
        l.setText(two);


        a.setText(link1);
        m.setText(link2);

/*
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

 */
    }

}
