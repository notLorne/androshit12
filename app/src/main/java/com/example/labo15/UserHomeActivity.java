package com.example.labo15;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;

public class UserHomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_home);

        Button editButton = findViewById(R.id.editButton);
        Button emailButton = findViewById(R.id.emailButton);

        editButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle edit button click
                Intent intent = new Intent(UserHomeActivity.this, UserEditActivity.class);
                startActivity(intent);
            }
        });

        emailButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle email button click
                Intent intent = new Intent(UserHomeActivity.this, UserMailActivity.class);
                startActivity(intent);
            }
        });
    }
}
