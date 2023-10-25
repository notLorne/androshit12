package com.example.labo15;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.io.IOException;
import java.io.InputStream;

public class MainActivity extends AppCompatActivity {

    private String jsonData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        jsonData = loadJSONFromAsset("login.json");

        RadioButton adminRadioButton = findViewById(R.id.adminRadioButton);
        RadioButton userRadioButton = findViewById(R.id.userRadioButton);
        Button loginButton = findViewById(R.id.loginButton);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userType;
                if (adminRadioButton.isChecked()) {
                    userType = "Admin";
                } else if (userRadioButton.isChecked()) {
                    userType = "User";
                } else {
                    Toast.makeText(MainActivity.this, "Please select user type", Toast.LENGTH_SHORT).show();
                    return;
                }

                EditText usernameEditText = findViewById(R.id.usernameEditText);
                EditText passwordEditText = findViewById(R.id.passwordEditText);
                String enteredUsername = usernameEditText.getText().toString();
                String enteredPassword = passwordEditText.getText().toString();

                if (validateCredentials(userType, enteredUsername, enteredPassword)) {
                    handleSuccessfulLogin(enteredUsername, userType);
                } else {
                    Toast.makeText(MainActivity.this, "Invalid username or password", Toast.LENGTH_SHORT).show();
                }
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

    private boolean validateCredentials(String userType, String enteredUsername, String enteredPassword) {
        try {
            JSONObject jsonObject = new JSONObject(jsonData);
            JSONArray usersArray = userType.equals("Admin") ? jsonObject.getJSONArray("admins") : jsonObject.getJSONArray("users");

            for (int i = 0; i < usersArray.length(); i++) {
                JSONObject user = usersArray.getJSONObject(i);
                String username = user.getString("username");
                String password = user.getString("password");

                if (enteredUsername.equals(username) && enteredPassword.equals(password)) {
                    return true;
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return false;
    }

    private void handleSuccessfulLogin(String username, String userType) {
        Toast.makeText(MainActivity.this, "Login successful!", Toast.LENGTH_SHORT).show();

        Intent intent;
        if (userType.equals("Admin")) {
            intent = new Intent(MainActivity.this, AdminHomeActivity.class);
        } else {
            intent = new Intent(MainActivity.this, UserHomeActivity.class);
        }

        intent.putExtra("USERNAME", username); // Pass the username as an extra
        startActivity(intent);
        finish();
    }
}
