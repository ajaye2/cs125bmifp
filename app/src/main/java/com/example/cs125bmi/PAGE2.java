package com.example.cs125bmi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.material.snackbar.Snackbar;

public class PAGE2 extends AppCompatActivity {
    private EditText height;
    private EditText weight;
    private EditText age;
    private EditText name;
    private Button bmiCalculate;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page2);
        name = findViewById(R.id.editTextN);
        height = findViewById(R.id.editTextH);
        weight = findViewById(R.id.editTextW);
        age = findViewById(R.id.editTextA);

        bmiCalculate = findViewById(R.id.button2);
        bmiCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String n = name.getText().toString();
                double h = Double.parseDouble(height.getText().toString());
                double w = Double.parseDouble(weight.getText().toString());
                int a = Integer.parseInt(age.getText().toString());

                if (n == null || n.length() == 0) {
                    Snackbar.make(view, "You must enter data in every field.",
                            Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                } else if (a < 18) {
                    Snackbar.make(view, "You must be at least 18 years of age to continue.",
                            Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                } else {
                    openPage();
                }

                YourBmi.bmi = (h / w) * 703;
            }
        });
    }

    public void openPage() {
        Intent intent = new Intent(this, YourBmi.class);
        startActivity(intent);
    }
}
