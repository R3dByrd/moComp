package com.example.mocomp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class SelectMachineActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_machine);

        Button confirm = findViewById(R.id.button_confirm);
        confirm.setOnClickListener(v ->
                startActivity(new Intent(SelectMachineActivity.this, MachineInfoActivity.class)));
    }
}
