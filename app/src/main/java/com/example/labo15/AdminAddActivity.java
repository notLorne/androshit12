package com.example.labo15;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;

public class AdminAddActivity extends AppCompatActivity {

    private EditText usernameEditText, passwordEditText, firstNameEditText, lastNameEditText;
    private EditText monthEditText, dayEditText, yearEditText;
    private EditText numberEditText, streetEditText, cityEditText, stateEditText, postalEditText, countryEditText;
    private EditText workEditText, emailEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_add);

        // Initialize EditText fields
        usernameEditText = findViewById(R.id.usernameEditText);
        passwordEditText = findViewById(R.id.passwordEditText);
        firstNameEditText = findViewById(R.id.firstNameEditText);
        lastNameEditText = findViewById(R.id.lastNameEditText);
        monthEditText = findViewById(R.id.monthEditText);
        dayEditText = findViewById(R.id.dayEditText);
        yearEditText = findViewById(R.id.yearEditText);
        numberEditText = findViewById(R.id.numberEditText);
        streetEditText = findViewById(R.id.streetEditText);
        cityEditText = findViewById(R.id.cityEditText);
        stateEditText = findViewById(R.id.stateEditText);
        postalEditText = findViewById(R.id.postalEditText);
        countryEditText = findViewById(R.id.countryEditText);
        workEditText = findViewById(R.id.workEditText);
        emailEditText = findViewById(R.id.emailEditText);

        Button saveButton = findViewById(R.id.saveButton);
        Button clearButton = findViewById(R.id.clearButton);
        Button backButton = findViewById(R.id.backButton);

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Implement the logic to save the data
                // You can retrieve the input values using getText() method on EditText fields
            }
        });

        clearButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Clear all EditText fields
                clearFields();
            }
        });

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Implement logic to go back to Admin Home Activity
                finish(); // This will close the current activity and return to the previous one
            }
        });
    }

    // Method to clear all EditText fields
    private void clearFields() {
        usernameEditText.setText("");
        passwordEditText.setText("");
        firstNameEditText.setText("");
        lastNameEditText.setText("");
        monthEditText.setText("");
        dayEditText.setText("");
        yearEditText.setText("");
        numberEditText.setText("");
        streetEditText.setText("");
        cityEditText.setText("");
        stateEditText.setText("");
        postalEditText.setText("");
        countryEditText.setText("");
        workEditText.setText("");
        emailEditText.setText("");
    }
}
