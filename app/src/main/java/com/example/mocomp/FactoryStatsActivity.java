package com.example.mocomp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class FactoryStatsActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_factory_stats);

        Button back = findViewById(R.id.button_back_menu);
        back.setOnClickListener(v -> {
            startActivity(new Intent(FactoryStatsActivity.this, MainMenuActivity.class));
            finish();
        });
    }
}
