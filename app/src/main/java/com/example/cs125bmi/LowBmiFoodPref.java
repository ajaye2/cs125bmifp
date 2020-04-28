package com.example.cs125bmi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;

import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.List;

public class LowBmiFoodPref extends AppCompatActivity {
    static List<String> breakfast = new ArrayList<>();
    static List<String> lunch = new ArrayList<>();
    static List<String> dinner = new ArrayList<>();

    CheckBox breakfast1, breakfast2, breakfast3, breakfast4, breakfast5, breakfast6;
    CheckBox lunch1, lunch2, lunch3, lunch4, lunch5, lunch6;
    CheckBox dinner1, dinner2, dinner3, dinner4, dinner5, dinner6;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_low_bmi_food_pref);


        breakfast1 = findViewById(R.id.breakfast1);
        breakfast1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if (isChecked) {
                    breakfast.add((String) breakfast1.getText());
                }
            }
        });

        breakfast2 = findViewById(R.id.breakfast2);
        breakfast2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    breakfast.add((String) breakfast2.getText());
                }
            }
        });

        breakfast3 = findViewById(R.id.breakfast3);
        breakfast3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    breakfast.add((String) breakfast3.getText());
                }
            }
        });

        breakfast4 = findViewById(R.id.breakfast4);
        breakfast4.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    breakfast.add((String) breakfast4.getText());
                }
            }
        });

        breakfast5 = findViewById(R.id.breakfast5);
        breakfast5.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    breakfast.add((String) breakfast5.getText());
                }
            }
        });

        breakfast6 = findViewById(R.id.breakfast6);
        breakfast6.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    breakfast.add((String) breakfast6.getText());
                }
            }
        });

        lunch1 = findViewById(R.id.lunch1);
        lunch1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    lunch.add((String) lunch1.getText());
                }
            }
        });

        lunch2 = findViewById(R.id.lunch2);
        lunch2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    lunch.add((String) lunch2.getText());
                }
            }
        });

        lunch3 = findViewById(R.id.lunch3);
        lunch3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    lunch.add((String) lunch3.getText());
                }
            }
        });

        lunch4 = findViewById(R.id.lunch4);
        lunch4.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    lunch.add((String) lunch4.getText());
                }
            }
        });

        lunch5 = findViewById(R.id.lunch5);
        lunch5.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    lunch.add((String) lunch5.getText());
                }
            }
        });

        lunch6 = findViewById(R.id.lunch6);
        lunch6.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    lunch.add((String) lunch6.getText());
                }
            }
        });

        dinner1 = findViewById(R.id.dinner1);
        dinner1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    dinner.add((String) dinner1.getText());
                }
            }
        });

        dinner2 = findViewById(R.id.dinner2);
        dinner2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    dinner.add((String) dinner2.getText());
                }
            }
        });

        dinner3 = findViewById(R.id.dinner3);
        dinner3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    dinner.add((String) dinner3.getText());
                }
            }
        });

        dinner4 = findViewById(R.id.dinner4);
        dinner4.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    dinner.add((String) dinner4.getText());
                }
            }
        });

        dinner5 = findViewById(R.id.dinner5);
        dinner5.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    dinner.add((String) dinner5.getText());
                }
            }
        });

        dinner6 = findViewById(R.id.dinner6);
        dinner6.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    dinner.add((String) dinner6.getText());
                }
            }
        });

        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (lunch.size() < 2 || dinner.size() < 2 || breakfast.size() < 2) {
                    Snackbar.make(view, "You must select at least two foods from each section.",
                            Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                    //show alert dialog saying that at least one box from each section should be clicked.
                } else {
                    openFinalPage();
                }
            }
        });
    }

    public void openFinalPage() {
        Intent intent = new Intent(this, FinalPage.class);
        startActivity(intent);
    }
}
