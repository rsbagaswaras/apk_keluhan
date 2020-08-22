package com.example.form_keluhan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class MainActivity extends AppCompatActivity {

    private int waktu_loading=3000;

    //4000=4 detik

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                //setelah loading maka akan langsung berpindah ke bottom nav activity
                Intent home=new Intent(MainActivity.this, BerandaActivity.class);
                startActivity(home);
                finish();

            }
        },waktu_loading);
    }
}