package com.example.mocomp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainMenuActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        UserProfile profile = (UserProfile) getIntent().getSerializableExtra("user");
        TextView header = findViewById(R.id.text_header);
        if (profile != null) {
            String text = profile.getUsername() + " (" + profile.getRole() + ", " + profile.getEmploymentPercent() + "% )";
            header.setText(text);
        }

        Button selectButton = findViewById(R.id.button_select_machine);
        Button statsButton = findViewById(R.id.button_show_stats);
        Button exitButton = findViewById(R.id.button_exit);

        selectButton.setOnClickListener(v ->
                startActivity(new Intent(MainMenuActivity.this, ScanQRActivity.class)));

        statsButton.setOnClickListener(v ->
                startActivity(new Intent(MainMenuActivity.this, FactoryStatsActivity.class)));

        exitButton.setOnClickListener(v -> finish());
    }
}
