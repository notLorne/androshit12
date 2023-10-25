package com.example.labo15;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;

public class AdminMailActivity extends AppCompatActivity {

    private EditText editTextMailTarget;
    private EditText editTextMailTitle;
    private EditText editTextMessage;
    private Button buttonSend;
    private Button buttonClear;
    private Button buttonBackHome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_mail);

        editTextMailTarget = findViewById(R.id.editTextMailTarget);
        editTextMailTitle = findViewById(R.id.editTextMailTitle);
        editTextMessage = findViewById(R.id.editTextMessage);
        buttonSend = findViewById(R.id.buttonSend);
        buttonClear = findViewById(R.id.buttonClear);
        buttonBackHome = findViewById(R.id.buttonBackHome);

        buttonSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String recipient = editTextMailTarget.getText().toString();
                String subject = editTextMailTitle.getText().toString();
                String message = editTextMessage.getText().toString();

                // For homework, you can print the values to the console
                System.out.println("Recipient: " + recipient);
                System.out.println("Subject: " + subject);
                System.out.println("Message: " + message);
            }
        });

        buttonClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Clear all EditText fields
                editTextMailTarget.setText("");
                editTextMailTitle.setText("");
                editTextMessage.setText("");
            }
        });

        buttonBackHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
