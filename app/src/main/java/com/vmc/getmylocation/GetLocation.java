package com.vmc.getmylocation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;

public class GetLocation extends AppCompatActivity {
    private EditText latitude, longitude;
    private Button search;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_location);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        latitude = findViewById(R.id.latitude);
        longitude = findViewById(R.id.longitude);

        search = findViewById(R.id.search);
        search.setOnClickListener(v -> {

        });

    }
}