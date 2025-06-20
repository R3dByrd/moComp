package com.example.mocomp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MaintenanceActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maintenance);
        ConditionStorage.increment(this, "stopped");

        Button back = findViewById(R.id.button_back_info);
        back.setOnClickListener(v -> {
            startActivity(new Intent(MaintenanceActivity.this, MachineInfoActivity.class));
            finish();
        });
    }
}
