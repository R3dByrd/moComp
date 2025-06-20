package com.example.mocomp;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.Button;

import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import android.content.pm.PackageManager;
import android.Manifest;

import com.journeyapps.barcodescanner.BarcodeCallback;
import com.journeyapps.barcodescanner.BarcodeResult;
import com.journeyapps.barcodescanner.DecoratedBarcodeView;
import com.journeyapps.barcodescanner.DefaultDecoderFactory;
import com.google.zxing.BarcodeFormat;

import androidx.appcompat.app.AppCompatActivity;

public class ScanQRActivity extends AppCompatActivity {
    private static final int CAMERA_PERMISSION_REQUEST = 1001;
    private DecoratedBarcodeView qrScannerView;
    private final BarcodeCallback callback = new BarcodeCallback() {
        @Override
        public void barcodeResult(BarcodeResult result) {
            if (result.getText() != null) {
                startActivity(new Intent(ScanQRActivity.this, SelectMachineActivity.class));
            }
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scan_qr);

        qrScannerView = findViewById(R.id.qr_scanner);
        qrScannerView.initializeFromIntent(getIntent());
        java.util.List<BarcodeFormat> formats = java.util.Collections.singletonList(BarcodeFormat.QR_CODE);
        qrScannerView.getBarcodeView().setDecoderFactory(new DefaultDecoderFactory(formats));

        if (ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA) == PackageManager.PERMISSION_GRANTED) {
            qrScannerView.decodeSingle(callback);
        } else {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CAMERA}, CAMERA_PERMISSION_REQUEST);
        }

        Button manual = findViewById(R.id.button_manual_entry);
        manual.setOnClickListener(v -> {
            ConditionStorage.increment(ScanQRActivity.this, "error");
            startActivity(new Intent(ScanQRActivity.this, SelectMachineActivity.class));
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        qrScannerView.resume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        qrScannerView.pause();
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == CAMERA_PERMISSION_REQUEST && grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
            qrScannerView.decodeSingle(callback);
        }
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        return qrScannerView.onKeyDown(keyCode, event) || super.onKeyDown(keyCode, event);
    }
}
