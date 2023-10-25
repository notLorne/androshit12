package com.example.labo15;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;

public class UserEditActivity extends AppCompatActivity {

    private JSONObject jsonData;
    private String username;

    private EditText firstNameEditText;
    private EditText lastNameEditText;
    private EditText monthEditText;
    private EditText dayEditText;
    private EditText yearEditText;
    private EditText numberEditText;
    private EditText streetEditText;
    private EditText cityEditText;
    private EditText stateEditText;
    private EditText postalEditText;
    private EditText countryEditText;
    private EditText workEditText;
    private EditText emailEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_edit);

        // Retrieve USERNAME from intent
        username = getIntent().getStringExtra("USERNAME");

        // Load JSON data from file
        try {
            InputStream inputStream = getAssets().open("data.json");
            int size = inputStream.available();
            byte[] buffer = new byte[size];
            inputStream.read(buffer);
            inputStream.close();
            String jsonString = new String(buffer, "UTF-8");
            jsonData = new JSONObject(jsonString);

            // Find EditText fields in the layout
            firstNameEditText = findViewById(R.id.editFirstName);
            lastNameEditText = findViewById(R.id.editLastName);
            monthEditText = findViewById(R.id.editMonth);
            dayEditText = findViewById(R.id.editDay);
            yearEditText = findViewById(R.id.editYear);
            numberEditText = findViewById(R.id.editNumber);
            streetEditText = findViewById(R.id.editStreet);
            cityEditText = findViewById(R.id.editCity);
            stateEditText = findViewById(R.id.editState);
            postalEditText = findViewById(R.id.editPostal);
            countryEditText = findViewById(R.id.editCountry);
            workEditText = findViewById(R.id.editWork);
            emailEditText = findViewById(R.id.editEmail);

            // Load user data into the EditText fields
            loadUserData();
        } catch (IOException | JSONException e) {
            e.printStackTrace();
        }

        // Button to accept changes
        Button acceptButton = findViewById(R.id.btnAcceptChanges);
        acceptButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveChanges();
            }
        });

        // Button to reset fields
        Button resetButton = findViewById(R.id.btnReset);
        resetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadUserData();
            }
        });

        // Button to go back to UserMainActivity
        Button backHomeButton = findViewById(R.id.btnBackHome);
        backHomeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void loadUserData() {
        try {
            JSONArray users = jsonData.getJSONArray("users");
            for (int i = 0; i < users.length(); i++) {
                JSONObject user = users.getJSONObject(i);
                if (user.getString("username").equals(username)) {
                    JSONObject userInfo = user.getJSONObject("info");
                    firstNameEditText.setText(userInfo.getString("firstName"));
                    lastNameEditText.setText(userInfo.getString("lastName"));

                    JSONObject birthday = userInfo.getJSONObject("birthday");
                    monthEditText.setText(String.valueOf(birthday.getInt("month")));
                    dayEditText.setText(String.valueOf(birthday.getInt("day")));
                    yearEditText.setText(String.valueOf(birthday.getInt("year")));

                    JSONObject address = userInfo.getJSONObject("address");
                    numberEditText.setText(address.getString("number"));
                    streetEditText.setText(address.getString("street"));
                    cityEditText.setText(address.getString("city"));
                    stateEditText.setText(address.getString("state"));
                    postalEditText.setText(address.getString("postal"));
                    countryEditText.setText(address.getString("country"));

                    workEditText.setText(userInfo.getString("work"));
                    emailEditText.setText(userInfo.getString("email"));
                    break;
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private void saveChanges() {
        try {
            JSONArray users = jsonData.getJSONArray("users");
            for (int i = 0; i < users.length(); i++) {
                JSONObject user = users.getJSONObject(i);
                if (user.getString("username").equals(username)) {
                    JSONObject userInfo = user.getJSONObject("info");
                    userInfo.put("firstName", firstNameEditText.getText().toString());
                    userInfo.put("lastName", lastNameEditText.getText().toString());

                    JSONObject birthday = userInfo.getJSONObject("birthday");
                    birthday.put("month", Integer.parseInt(monthEditText.getText().toString()));
                    birthday.put("day", Integer.parseInt(dayEditText.getText().toString()));
                    birthday.put("year", Integer.parseInt(yearEditText.getText().toString()));

                    JSONObject address = userInfo.getJSONObject("address");
                    address.put("number", numberEditText.getText().toString());
                    address.put("street", streetEditText.getText().toString());
                    address.put("city", cityEditText.getText().toString());
                    address.put("state", stateEditText.getText().toString());
                    address.put("postal", postalEditText.getText().toString());
                    address.put("country", countryEditText.getText().toString());

                    userInfo.put("work", workEditText.getText().toString());
                    userInfo.put("email", emailEditText.getText().toString());

                    // Save the updated JSON data back to the file
                    saveJSONToFile(jsonData.toString());
                    break;
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private void saveJSONToFile(String json) {
        try {
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(this.openFileOutput("data.json", MODE_PRIVATE));
            outputStreamWriter.write(json);
            outputStreamWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
