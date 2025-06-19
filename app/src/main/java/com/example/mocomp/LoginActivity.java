package com.example.mocomp;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.widget.Button;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Button login = findViewById(R.id.button_login);
        login.setOnClickListener(v ->
                startActivity(new Intent(LoginActivity.this, MainMenuActivity.class)));
    }
}
