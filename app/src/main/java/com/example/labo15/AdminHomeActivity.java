package com.example.labo15;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;


public class AdminHomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_home);

        Button addButton = findViewById(R.id.addButton);
        Button editButton = findViewById(R.id.editButton);
        Button deleteButton = findViewById(R.id.deleteButton);
        Button viewButton = findViewById(R.id.viewButton);
        Button emailButton = findViewById(R.id.emailButton);

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle add button click
            }
        });

        editButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle edit button click
            }
        });

        deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle delete button click
            }
        });

        viewButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle view button click
            }
        });

        emailButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle email button click
            }
        });

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle add button click
                Intent intent = new Intent(AdminHomeActivity.this, AdminAddActivity.class);
                startActivity(intent);
            }
        });

        deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle delete button click
                Intent intent = new Intent(AdminHomeActivity.this, AdminDeleteActivity.class);
                startActivity(intent); // Start AdminDeleteActivity when delete button is clicked
            }
        });

        viewButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle view button click
                Intent intent = new Intent(AdminHomeActivity.this, AdminLookupActivity.class);
                startActivity(intent); // Start AdminLookupActivity when the View button is clicked
            }
        });

    }


    // Implement the corresponding methods for button clicks here
    // For example:
    /*
    public void onAddButtonClick(View view) {
        // Handle add button click
    }

    public void onEditButtonClick(View view) {
        // Handle edit button click
    }

    public void onDeleteButtonClick(View view) {
        // Handle delete button click
    }

    public void onViewButtonClick(View view) {
        // Handle view button click
    }

    public void onEmailButtonClick(View view) {
        // Handle email button click
    }
    */
}
