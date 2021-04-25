package com.vmc.getmylocation.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.vmc.getmylocation.R;
import com.vmc.getmylocation.helpers.Utils;

public class GetLocationActivity extends AppCompatActivity {
    final String tag = "GetLoca";
    private EditText latitude, longitude, label;
    private Button search;
    private Utils utils = new Utils();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_location);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        latitude = findViewById(R.id.et_latitude);
        longitude = findViewById(R.id.et_longitude);
        label = findViewById(R.id.et_label);

        search = findViewById(R.id.btn_search);
        search.setOnClickListener(v -> {

            String checkFields = utils.checkAllFields(latitude.getText().toString(), longitude.getText().toString(), label.getText().toString());


            if (!checkFields.equals("false") && !checkFields.equals("Campos invalidos")){
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("geo:0,0?q=" + checkFields));
                Intent chooser = Intent.createChooser(intent, "Lauch");
                startActivity(chooser);
            } else {
                errorDialog(checkFields);
            }

        });

    }

    public void errorDialog(String errDesc) {
        String title = "Erro";
        String message = "Erro desconhecido, favor entrar em contato com o desenvolvedor!";
        if (errDesc.equals("false")){
            title = "Campos Não Preenchidos";
            message = "Favor verificar os campos Latitude e Longitude, eles são obrigatórios!";
        } else {
            title = "Campos Inválidos";
            message = "Os campos Latitude e Longitude foram preenchidos de forma errada, favor verificar sua escrita!";
        }

        new AlertDialog.Builder(this)
                .setTitle(title)
                .setMessage(message)
                .setNegativeButton(android.R.string.yes, null)
                .show();
    }

}