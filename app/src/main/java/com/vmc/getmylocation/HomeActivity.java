package com.vmc.getmylocation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class HomeActivity extends AppCompatActivity {
    private Button start;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        start = findViewById(R.id.start);
        start.setOnClickListener(v -> {
            Intent intent = new Intent(this, GetLocation.class);
            startActivity(intent);
        });
    }
}