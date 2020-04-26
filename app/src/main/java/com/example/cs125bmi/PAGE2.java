package com.example.cs125bmi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class PAGE2 extends AppCompatActivity {
    private EditText height;
    private EditText weight;
    private EditText age;
    private Button bmiCalculate;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page2);


        height = findViewById(R.id.editTextH);
        weight = findViewById(R.id.editTextW);
        age = findViewById(R.id.editTextA);

        bmiCalculate = findViewById(R.id.button2);
        bmiCalculate.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
               openPage();
/*
                double h = Double.parseDouble(height.getText().toString());
                double w = Double.parseDouble(weight.getText().toString());
                int a = Integer.parseInt(age.getText().toString());
                if (a < 18) {
                    YourBmi.ageCheck = true;
                }

                YourBmi.bmi = (h / w) * 703;

 */
            }
        });


    }

    public void openPage() {
        Intent intent = new Intent(this, YourBmi.class);
        startActivity(intent);
    }
}
