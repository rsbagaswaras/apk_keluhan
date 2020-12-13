package com.example.form_keluhan;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.form_keluhan.lantai1.Lantai1Activity;
import com.example.form_keluhan.lantai2.Lantai2Activity;
import com.firebase.ui.auth.AuthUI;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

public class DashboardActivity extends AppCompatActivity {

    LinearLayout linear1, linear2;
    TextView txt_logout;
    private boolean doubleBacktoExit = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        linear1 = findViewById(R.id.linear1);
        linear1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent linear1 = new Intent(getApplicationContext(), Lantai1Activity.class);
                startActivity(linear1);

            }
        });
        linear2 = findViewById(R.id.linear2);
        linear2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent linear2 = new Intent(getApplicationContext(), Lantai2Activity.class);
                startActivity(linear2);

            }
        });

        txt_logout = findViewById(R.id.txt_logout);
        txt_logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signOut();

            }
        });
    }

    private void signOut(){
        AuthUI.getInstance()
                .signOut(DashboardActivity.this)
                .addOnCompleteListener(new OnCompleteListener<Void>(){

                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        Intent loginActivity = new Intent(DashboardActivity.this, LoginActivity.class);
                        startActivity(loginActivity);

                    }
                });
    }

    @Override
    public void onBackPressed() {
        if (doubleBacktoExit){
            super.onBackPressed();
            return;
        }
        this.doubleBacktoExit = true;
        Toast.makeText(this, "Tekan Lagi Untuk Keluar",Toast.LENGTH_SHORT).show();

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                doubleBacktoExit = false;
            }
        }, 2000);
    }
}