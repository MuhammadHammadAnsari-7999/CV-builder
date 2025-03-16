package com.example.cvbuilder;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class FinalActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final);

        TextView tvName = findViewById(R.id.tvName);
        Button btnShareCV = findViewById(R.id.btnShareCV);

        // Retrieve data from SharedPreferences
        SharedPreferences sharedPreferences = getSharedPreferences("CVData", MODE_PRIVATE);
        String name = sharedPreferences.getString("name", "Not Provided");
        tvName.setText(name);

        // Share CV button
        btnShareCV.setOnClickListener(v -> {
            String cvData = "Name: " + name; // Add more data as needed
            Intent shareIntent = new Intent(Intent.ACTION_SEND);
            shareIntent.setType("text/plain");
            shareIntent.putExtra(Intent.EXTRA_TEXT, cvData);
            startActivity(Intent.createChooser(shareIntent, "Share CV via"));
        });
    }
}