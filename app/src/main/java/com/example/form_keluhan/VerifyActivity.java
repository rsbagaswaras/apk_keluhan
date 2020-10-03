package com.example.form_keluhan;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.FirebaseException;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;

import java.util.concurrent.TimeUnit;

public class VerifyActivity extends AppCompatActivity {


    private TextView tvLogin, tvPhone;
    String phoneNumber;

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
                Intent intent = new Intent(VerifyActivity.this,EmailLoginActivity.class);
                startActivity(intent);
            }
        });
    }


    public void Phone(){
        tvPhone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                phoneNumber = tvPhone.getText().toString().trim();
                sendVerificationCode(phoneNumber);
            }
        });

    }

    // ini code untuk ngirim nomor hp yang bakal di kirimin sms
    // untuk nomornya jangan lupa pake kode negara ya, jgn pake 0
    private void sendVerificationCode(String phoneNumber) {
        phoneNumber = "+62" + phoneNumber;
        PhoneAuthProvider.getInstance().verifyPhoneNumber(
                phoneNumber,
                60,
                TimeUnit.SECONDS,
                this,
                mCall
        );
        Toast.makeText(getApplicationContext(), "Sedang Memverifikasi, Mohon Tunggu", Toast.LENGTH_SHORT).show();
    }

    private PhoneAuthProvider.OnVerificationStateChangedCallbacks mCall = new PhoneAuthProvider.OnVerificationStateChangedCallbacks(){

        @Override
        public void onVerificationCompleted(@NonNull PhoneAuthCredential phoneAuthCredential) {
            String code = phoneAuthCredential.getSmsCode();
        }

        @Override
        public void onVerificationFailed(@NonNull FirebaseException e) {
            Toast.makeText(VerifyActivity.this, "Failed" + e, Toast.LENGTH_SHORT).show();
        }

        //kode verif dikirim
        @Override
        public void onCodeSent(String verificationId, PhoneAuthProvider.ForceResendingToken token) {

            String mVerificationId = verificationId;
            Log.e("VerifyActivity", "Verification id : " + verificationId);
            Intent intent = new Intent(VerifyActivity.this, SmsActivity.class);
            intent.putExtra("verificationId", mVerificationId);
            startActivity(intent);
            finish();
        }
    };

}