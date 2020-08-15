package com.example.form_keluhan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class BerandaActivity extends AppCompatActivity {

    Button btn_lantai1, btn_lantai2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_beranda);

        btn_lantai1 = findViewById(R.id.btn_lantai1);
        btn_lantai1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(BerandaActivity.this, Lantai1Activity.class);
                startActivity(intent);
            }
        });

        btn_lantai2 = findViewById(R.id.btn_lantai2);
        btn_lantai2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(BerandaActivity.this, Lantai2Activity.class);
                startActivity(intent);
            }
        });
    }
}
