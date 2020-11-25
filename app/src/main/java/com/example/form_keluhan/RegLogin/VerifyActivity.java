package com.example.form_keluhan.RegLogin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.form_keluhan.R;

public class VerifyActivity extends AppCompatActivity {


    private TextView tvLogin, tvPhone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verify);

        tvLogin = findViewById(R.id.tvLogin);
        tvPhone = findViewById(R.id.tvPhone);
        Login();
        Phone();
    }

    //On click listener to tv login to move to login activity
    public void Login() {
        tvLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(VerifyActivity.this, EmailLoginActivity.class);
                startActivity(intent);
            }
        });
    }


    public void Phone(){
        tvPhone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(VerifyActivity.this, SmsActivity.class);
                startActivity(intent);
            }
        });

    }
}