package com.example.mocomp;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.widget.Button;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        EditText username = findViewById(R.id.edit_username);
        EditText password = findViewById(R.id.edit_password);
        Button login = findViewById(R.id.button_login);
        login.setOnClickListener(v -> {
            String name = username.getText().toString();
            // Password is ignored in this demo
            UserProfile profile = new UserProfile(name, "Techniker", 100);
            Intent intent = new Intent(LoginActivity.this, MainMenuActivity.class);
            intent.putExtra("user", profile);
            startActivity(intent);
        });
    }
}
