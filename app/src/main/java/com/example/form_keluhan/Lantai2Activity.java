package com.example.form_keluhan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class Lantai2Activity extends AppCompatActivity {
    ImageView imageView;
    Button btn_a, btn_b, btn_c, btn_d, btn_e, btn_f, btn_g, btn_h;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lantai2);

        imageView = findViewById(R.id.img_lantai2);

        btn_a = findViewById(R.id.btn_a);
        btn_a.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Lantai2Activity.this, KomiteMedikActivity.class);
                startActivity(intent);
            }
        });
        btn_b = findViewById(R.id.btn_b);
        btn_b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Lantai2Activity.this, RekapMedikActivity.class);
                startActivity(intent);
            }
        });
        btn_c = findViewById(R.id.btn_c);
        btn_c.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =  new Intent(Lantai2Activity.this, KasubacActivity.class);
                startActivity(intent);
            }
        });
        btn_d = findViewById(R.id.btn_d);
        btn_d.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Lantai2Activity.this, AuditoriumActivity.class);
                startActivity(intent);
            }
        });
        btn_e = findViewById(R.id.btn_e);
        btn_e.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Lantai2Activity.this, RuangDirekturActivity.class);
                startActivity(intent);
            }
        });
        btn_f = findViewById(R.id.btn_f);
        btn_f.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Lantai2Activity.this, RuangAkreditasiActivity.class);
                startActivity(intent);
            }
        });
        btn_g = findViewById(R.id.btn_g);
        btn_g.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Lantai2Activity.this, KamarMandiActivity.class);
                startActivity(intent);
            }
        });
        btn_h = findViewById(R.id.btn_h);
        btn_h.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Lantai2Activity.this, PanelListrikActivity.class);
                startActivity(intent);
            }
        });


    }






}
