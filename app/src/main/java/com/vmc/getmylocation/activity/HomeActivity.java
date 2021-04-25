package com.vmc.getmylocation.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import com.vmc.getmylocation.R;

public class HomeActivity extends AppCompatActivity {
    private Button start;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        getSupportActionBar().hide();

        start = findViewById(R.id.start);
        start.setOnClickListener(v -> {
            Intent intent = new Intent(this, GetLocationActivity.class);
            startActivity(intent);
        });
    }
}