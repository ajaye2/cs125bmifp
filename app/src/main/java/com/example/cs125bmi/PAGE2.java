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
                String he = height.getText().toString();
                String we = weight.getText().toString();
                String ag = age.getText().toString();
                if (n == null || n.length() == 0 || he == null || we == null
                        || we.length() == 0 || he.length() == 0 || ag == null || ag.length() == 0) {
                    Snackbar.make(view, "You must enter data in every field.",
                            Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                } else if (ag != null  && ag.length() != 0 && Integer.parseInt(ag) < 18) {
                    Snackbar.make(view, "You must be at least 18 years of age to continue.",
                            Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                } else {
                    Double h = Double.parseDouble(he);
                    Double w = Double.parseDouble(we);
                    YourBmi.bmi = (703 * w) / (h * h);
                    openPage();
                }
            }
        });
    }

    public void openPage() {
        Intent intent = new Intent(this, YourBmi.class);
        startActivity(intent);
    }
}
