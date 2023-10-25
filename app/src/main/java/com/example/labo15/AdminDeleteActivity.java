package com.example.labo15;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.io.IOException;
import java.io.InputStream;

public class AdminDeleteActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_delete);

        LinearLayout userListLayout = findViewById(R.id.userListLayout);
        EditText idEditText = findViewById(R.id.idEditText);
        Button deleteButton = findViewById(R.id.deleteButton);
        Button backButton = findViewById(R.id.backButton);

        // Load JSON data from login.json
        String jsonData = loadJSONFromAsset("login.json");

        try {
            JSONObject jsonObject = new JSONObject(jsonData);
            JSONArray usersArray = jsonObject.getJSONArray("users");

            // Populate the user list dynamically
            for (int i = 0; i < usersArray.length(); i++) {
                JSONObject userObject = usersArray.getJSONObject(i);
                String firstName = userObject.getJSONObject("info").getString("firstName");
                String lastName = userObject.getJSONObject("info").getString("lastName");

                TextView userTextView = new TextView(this);
                userTextView.setText("User " + (i + 1) + ": " + firstName + " " + lastName);
                userListLayout.addView(userTextView);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

        deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle delete button click
                String userId = idEditText.getText().toString();
                // Perform deletion logic based on userId
            }
        });

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle back button click
                finish(); // Close the current activity and go back to the previous one
            }
        });
    }

    private String loadJSONFromAsset(String filename) {
        String json;
        try {
            InputStream inputStream = getAssets().open(filename);
            int size = inputStream.available();
            byte[] buffer = new byte[size];
            inputStream.read(buffer);
            inputStream.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException e) {
            e.printStackTrace();
            json = "{}"; // Provide a default or empty JSON object in case of failure
        }
        return json;
    }
}
