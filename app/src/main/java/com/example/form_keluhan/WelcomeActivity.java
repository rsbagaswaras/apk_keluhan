package com.example.form_keluhan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.form_keluhan.lantai1.Lantai1Activity;

public class WelcomeActivity extends AppCompatActivity {

    Button btn_welcome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        btn_welcome = findViewById(R.id.btn_welcome);
        btn_welcome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent welcome = new Intent(WelcomeActivity.this, Lantai1Activity.class);
                startActivity(welcome);
                finish();
            }
        });
    }
}