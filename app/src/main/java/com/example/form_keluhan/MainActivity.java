package com.example.form_keluhan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.example.form_keluhan.Fetching.FetchActivity;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {

    private int waktu_loading=2000;
    private FirebaseAuth mAuth, mAuthAdmin;

    //4000=4 detik

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mAuth = FirebaseAuth.getInstance();
        mAuthAdmin = FirebaseAuth.getInstance();

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                //apabila sudah login, maka berpindah ke dashboard activity
                if (mAuth == null){
                    Intent home = new Intent(MainActivity.this, LoginActivity.class);
                    startActivity(home);
                    finish();
               }else {
                    //sapabila belum login, maka berpindah ke login activity
                    Intent login = new Intent(MainActivity.this, DashboardActivity.class);
                    login.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(login);
                    finish();

                }

            }
        },waktu_loading);
    }
}
