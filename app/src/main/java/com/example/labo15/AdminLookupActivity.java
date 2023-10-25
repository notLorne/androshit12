package com.example.labo15;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class AdminLookupActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_lookup);

        EditText usernameEditText = findViewById(R.id.usernameEditText);
        Button loadButton = findViewById(R.id.loadButton);
        TextView userInfoTextView = findViewById(R.id.userInfoTextView);
        Button backButton = findViewById(R.id.backButton);

        loadButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle load button click
                String username = usernameEditText.getText().toString();
                // Perform lookup logic based on username and update userInfoTextView
                // For now, let's assume you have the user information in a string variable called userInfo
                String userInfo = getUserInfoByUsername(username); // Replace this with your actual lookup method
                userInfoTextView.setText(userInfo);
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

    // Placeholder method to simulate user lookup
    private String getUserInfoByUsername(String username) {
        // Implement your logic to fetch user info based on the provided username
        // For now, return a placeholder string
        return "User Info for: " + username;
    }
}
