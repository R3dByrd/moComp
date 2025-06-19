package com.example.mocomp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MachineInfoActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_machine_info);

        Button back = findViewById(R.id.button_back_main);
        Button monitor = findViewById(R.id.button_monitor);
        Button maintenance = findViewById(R.id.button_maintenance);

        back.setOnClickListener(v -> {
            startActivity(new Intent(MachineInfoActivity.this, MainMenuActivity.class));
            finish();
        });

        monitor.setOnClickListener(v ->
                startActivity(new Intent(MachineInfoActivity.this, MonitoringActivity.class)));

        maintenance.setOnClickListener(v ->
                startActivity(new Intent(MachineInfoActivity.this, MaintenanceActivity.class)));
    }
}
