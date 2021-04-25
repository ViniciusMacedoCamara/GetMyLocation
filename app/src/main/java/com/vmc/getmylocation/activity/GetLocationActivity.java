package com.vmc.getmylocation.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;

import com.vmc.getmylocation.R;
import com.vmc.getmylocation.helpers.Utils;

public class GetLocationActivity extends AppCompatActivity {
    final String tag = "GetLoca";
    private EditText latitude, longitude, local_name;
    private Button search;
    private Utils utils = new Utils();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_location);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        latitude = findViewById(R.id.et_latitude);
        longitude = findViewById(R.id.et_longitude);
        local_name = findViewById(R.id.et_local_name);

        search = findViewById(R.id.btn_search);
        search.setOnClickListener(v -> {
            Log.d("latitude", latitude.getText().toString());
            Log.d("longitude", longitude.getText().toString());
            Log.d("local_name", local_name.getText().toString());

            boolean canContinue = utils.checkAllFields(latitude.getText().toString(), longitude.getText().toString(), local_name.getText().toString());

            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setData(Uri.parse("geo:0,0?q=34.99,-106.61(Treasure)"));
            Intent chooser = Intent.createChooser(intent, "Lauch");
            startActivity(chooser);
            if (canContinue){
                Log.d(tag, "seguir e levar pro google maps");

            } else {
                Log.d(tag, "Deu ruim!");
                new AlertDialog.Builder(this)
                        .setTitle("Delete entry")
                        .setMessage("Are you sure you want to delete this entry?")

                        // Specifying a listener allows you to take an action before dismissing the dialog.
                        // The dialog is automatically dismissed when a dialog button is clicked.
                        .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                // Continue with delete operation
                            }
                        })

                        // A null listener allows the button to dismiss the dialog and take no further action.
                        .setNegativeButton(android.R.string.no, null)
                        .setIcon(android.R.drawable.ic_dialog_alert)
                        .show();
            }

        });

    }
}