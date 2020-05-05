package com.example.cs125bmi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

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
    Spinner diet;
    public static JSONObject week;
    public static JSONObject monday;
    public static JSONObject tuesday;
    public static JSONObject wednesday;
    public static JSONObject thursday;
    public static JSONObject friday;
    public static JSONObject saturday;
    public static JSONObject sunday;
    public static JSONArray mondayMeal;
    public static JSONObject mondayMeal0;
    public static String bd;
    public static JSONArray tuesMeal;
    public static JSONObject tuesMeal0;
    public static String ln;
    public static JSONArray weMeal;
    public static JSONObject weMeal0;
    public static String di;
    public static String l1;
    public static String l2;
    public static String l3;

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
                EditText aller = findViewById(R.id.editText3);
                String allergy = aller.getText().toString();

                String[] arr = allergy.split(" ");


                String pass = "";
                for (int i = 0; i < arr.length; i++) {
                    String tmp = pass;
                    pass = arr[i].trim() + ", " + tmp;
                }

                final String selectedDiet = diet.getSelectedItem().toString();
                int calorie = 0;
                if (YourBmi.high) {
                    calorie = 300;
                } else {
                    calorie = 800;
                }

                String url = "https://api.spoonacular.com/mealplanner/generate?apiKey=9035f8bbc70447948521e40746228bf8&timeFrame=week"
                        +"&diet=" + selectedDiet +
                        "&exclude=" + pass
                        +"&targetCalories="+ calorie;

                JsonObjectRequest jsonObjectRequest = new JsonObjectRequest
                        (Request.Method.GET, url, null, new Response.Listener<JSONObject>() {

                            @Override
                            public void onResponse(JSONObject response) {
                                Object toReturn = null;
                                Object toReturnLunch = null;
                                Object toReturnDinner = null;

                                Object li1 = null;
                                Object li2 = null;
                                Object li3 = null;
                                try {
                                    week = response.getJSONObject("week");
                                    monday = week.getJSONObject("monday");
                                    tuesday = week.getJSONObject("tuesday");
                                    wednesday = week.getJSONObject("wednesday");
                                    thursday = week.getJSONObject("thursday");
                                    friday = week.getJSONObject("friday");
                                    saturday = week.getJSONObject("saturday");
                                    sunday = week.getJSONObject("sunday");

                                    mondayMeal = monday.getJSONArray("meals");
                                    mondayMeal0 = mondayMeal.getJSONObject(0);

                                    tuesMeal = tuesday.getJSONArray("meals");
                                    tuesMeal0 = tuesMeal.getJSONObject(0);

                                    weMeal = wednesday.getJSONArray("meals");
                                    weMeal0 = weMeal.getJSONObject(0);

                                    bd = mondayMeal0.getString("title");
                                    ln = tuesMeal0.getString("title");
                                    di = weMeal0.getString("title");

                                    l1 = mondayMeal0.getString("sourceUrl");
                                    l2 = tuesMeal0.getString("sourceUrl");
                                    l3 = weMeal0.getString("sourceUrl");

                                    toReturn = bd;
                                    toReturnLunch = ln;
                                    toReturnDinner = di;

                                    li1 = l1;
                                    li2 = l2;
                                    li3 = l3;
                                    //System.out.println("text " + bd);

                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }


                                FinalPage.link1 = (String) li1;
                                FinalPage.link2 = (String) li2;
                                FinalPage.link3 = (String) li3;


                                FinalPage.one = (String) toReturn;
                                bd = (String) toReturn;

                                FinalPage.two = (String) toReturnLunch;
                                ln = (String) toReturnLunch;

                                FinalPage.three = (String) toReturnDinner;
                                di = (String) toReturnDinner;


                            }
                        }, new Response.ErrorListener() {

                            @Override
                            public void onErrorResponse(VolleyError error) {
                                Toast.makeText(GenerateRecipe.this, "Something Went Wrong", Toast.LENGTH_SHORT).show();
                                error.printStackTrace();
                                System.out.println("Response: " + " " +  error.toString());
                            }
                        });
                MySingleton.getInstance(GenerateRecipe.this).addToRequest(jsonObjectRequest);
                if (bd != null || ln != null || di != null) {
                    Intent a = new Intent(getApplicationContext(), FinalPage.class);
                    startActivity(a);
                }
            }

        });
    }

}
