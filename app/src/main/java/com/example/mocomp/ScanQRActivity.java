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
        Button manual = findViewById(R.id.button_manual_entry);

        simulate.setOnClickListener(v -> {
            startActivity(new Intent(ScanQRActivity.this, MachineInfoActivity.class));
            finish();
        });

        manual.setOnClickListener(v ->
                startActivity(new Intent(ScanQRActivity.this, SelectMachineActivity.class)));
    }
}
