package com.example.mocomp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import com.journeyapps.barcodescanner.ScanContract;
import com.journeyapps.barcodescanner.ScanOptions;

import androidx.appcompat.app.AppCompatActivity;

public class ScanQRActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scan_qr);

        Button simulate = findViewById(R.id.button_simulate_scan);
        Button manual = findViewById(R.id.button_manual_entry);
        simulate.setOnClickListener(v -> startScan());

        manual.setOnClickListener(v -> {
            ConditionStorage.increment(ScanQRActivity.this, "error");
            startActivity(new Intent(ScanQRActivity.this, SelectMachineActivity.class));
        });
    }

    private final androidx.activity.result.ActivityResultLauncher<ScanOptions> scanLauncher = registerForActivityResult(new ScanContract(), result -> {
        if (result.getContents() != null) {
            startActivity(new Intent(ScanQRActivity.this, SelectMachineActivity.class));
        }
    });

    private void startScan() {
        ScanOptions options = new ScanOptions();
        options.setDesiredBarcodeFormats(ScanOptions.QR_CODE);
        options.setPrompt("Scan QR Code");
        scanLauncher.launch(options);
    }
}
