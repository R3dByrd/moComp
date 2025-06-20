package com.example.mocomp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import org.json.JSONArray;
import org.json.JSONObject;
import java.util.List;
import java.util.Arrays;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;


import androidx.appcompat.app.AppCompatActivity;
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter;

public class FactoryStatsActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_factory_stats);

        BarChart chart = findViewById(R.id.bar_chart);
        fetchRemoteData(() -> updateChart(chart));
        updateChart(chart);

        Button back = findViewById(R.id.button_back_menu);
        back.setOnClickListener(v -> {
            startActivity(new Intent(FactoryStatsActivity.this, MainMenuActivity.class));
            finish();
        });
    }

    private void fetchRemoteData(Runnable onComplete) {
        new Thread(() -> {
            try {
                URL url = new URL("https://example.com/posts.json");
                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                StringBuilder sb = new StringBuilder();
                String line;
                while ((line = reader.readLine()) != null) sb.append(line);
                reader.close();

                JSONObject obj = new JSONObject(sb.toString());
                JSONArray posts = obj.getJSONArray("posts");
                for (int i = 0; i < posts.length(); i++) {
                    JSONObject p = posts.getJSONObject(i);
                    String value = p.getString("value");
                    ConditionStorage.increment(FactoryStatsActivity.this, value);
                }
            } catch (Exception ignored) {
            }
            runOnUiThread(onComplete);
        }).start();
    }

    private void updateChart(BarChart chart) {
        int running = ConditionStorage.get(this, "running");
        int stopped = ConditionStorage.get(this, "stopped");
        int error = ConditionStorage.get(this, "error");

        BarDataSet set = new BarDataSet(java.util.Arrays.asList(
                new BarEntry(0, running),
                new BarEntry(1, stopped),
                new BarEntry(2, error)
        ), "Machine States");
        BarData data = new BarData(set);
        chart.setData(data);
        List<String> labels = Arrays.asList("läuft", "steht", "error");
        XAxis xAxis = chart.getXAxis();
        xAxis.setGranularity(1f);
        xAxis.setValueFormatter(new IndexAxisValueFormatter(labels));
        chart.invalidate();
    }
}
