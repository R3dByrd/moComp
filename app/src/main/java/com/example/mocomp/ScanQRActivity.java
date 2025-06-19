package com.example.mocomp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class ScanQRActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scan_qr);

        Button simulate = findViewById(R.id.button_simulate_scan);
        simulate.setOnClickListener(v -> {
            // after scan return to main menu
            startActivity(new Intent(ScanQRActivity.this, MainMenuActivity.class));
            finish();
        });
    }
}
