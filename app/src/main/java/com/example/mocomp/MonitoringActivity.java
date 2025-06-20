package com.example.mocomp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MonitoringActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_monitoring);
        ConditionStorage.increment(this, "running");

        Button back = findViewById(R.id.button_back_info);
        back.setOnClickListener(v -> {
            startActivity(new Intent(MonitoringActivity.this, MachineInfoActivity.class));
            finish();
        });
    }
}
