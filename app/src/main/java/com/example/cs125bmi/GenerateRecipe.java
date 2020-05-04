package com.example.cs125bmi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class GenerateRecipe extends AppCompatActivity {
    RequestQueue queue;
    TextView textView;
    Spinner diet;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_generate_recipe);

       // textView = findViewById(R.id.textView9);
        Button getMeal = findViewById(R.id.button4);

        diet = findViewById(R.id.diet);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(GenerateRecipe.this,
                android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.dietList));

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        diet.setAdapter(adapter);

        //Instantiate the RequestQueue.
        queue = Volley.newRequestQueue(this);

        getMeal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                parse();
            }
        });
    }

    public void parse() {

        EditText aller = findViewById(R.id.editText3);
        String allergy = aller.getText().toString();

        String[] arr = allergy.split(" ");

        String pass = "";
        for (int i = 0; i < arr.length; i++) {
            String tmp = pass;
            pass = arr[i].trim() + ", " + tmp;
        }

        String selectedDiet = diet.getSelectedItem().toString();
        //other method of getting selected diet
        /*
        diet.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String a = (String) adapterView.getItemAtPosition(i);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        */
        String url = "https://api.spoonacular.com/mealplanner/generate?" +
                "apiKey=9035f8bbc70447948521e40746228bf8" +
                "&timeFrame=week" +
                "&exclude=" + pass +
                "&diet=" + selectedDiet;

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest
                (Request.Method.GET, url, null, new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            JSONArray array = response.getJSONArray("meals");
                           // String title = array.getString(0);
                            //textView.setText(title);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                }, new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error) {
                        System.out.println("Response: " + " " +  error.toString());
                    }
                });


        queue.add(jsonObjectRequest);
    }
}
