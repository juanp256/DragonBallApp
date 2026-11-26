package com.example.dragonballapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;

public class DetalleActivity extends AppCompatActivity {

    ImageView img_detalle;
    TextView txt_detalle_nombre, txt_detalle_raza, txt_detalle_ki, txt_detalle_maxki,
            txt_detalle_afiliacion, txt_detalle_descripcion;
    Button btn_volver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle);

        img_detalle = findViewById(R.id.img_detalle);
        txt_detalle_nombre = findViewById(R.id.txt_detalle_nombre);
        txt_detalle_raza = findViewById(R.id.txt_detalle_raza);
        txt_detalle_ki = findViewById(R.id.txt_detalle_ki);
        txt_detalle_maxki = findViewById(R.id.txt_detalle_maxki);
        txt_detalle_afiliacion = findViewById(R.id.txt_detalle_afiliacion);
        txt_detalle_descripcion = findViewById(R.id.txt_detalle_descripcion);
        btn_volver = findViewById(R.id.btn_volver);

        Glide.with(this).load(getIntent().getStringExtra("imagen")).into(img_detalle);
        txt_detalle_nombre.setText(getIntent().getStringExtra("nombre"));
        txt_detalle_raza.setText("Raza: " + getIntent().getStringExtra("raza"));
        txt_detalle_ki.setText("Ki: " + getIntent().getStringExtra("ki"));
        txt_detalle_maxki.setText("Ki máximo: " + getIntent().getStringExtra("maxKi"));
        txt_detalle_afiliacion.setText("Afiliación: " + getIntent().getStringExtra("afiliacion"));
        txt_detalle_descripcion.setText(getIntent().getStringExtra("descripcion"));

        btn_volver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}