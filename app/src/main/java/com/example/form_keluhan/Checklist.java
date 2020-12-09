package com.example.form_keluhan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.example.form_keluhan.lantai1.Lantai1Activity;

public class Checklist extends AppCompatActivity {

    private int waktu_loading=2000;

    //4000=4 detik

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_checklist);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                //setelah loading maka akan langsung berpindah ke bottom nav activity
                Intent home=new Intent(Checklist.this, Lantai1Activity.class);
                startActivity(home);
                finish();

            }
        },waktu_loading);
    }
}