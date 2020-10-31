package com.example.form_keluhan;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.firebase.FirebaseException;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;

import java.util.concurrent.TimeUnit;

public class PhoneLoginActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    private ProgressBar loadingProgress;
    private Button regBtn;

    EditText et_phone;
    String phoneNumber;

    private FirebaseAuth mAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phone_login);
        et_phone = findViewById(R.id.et_phone);
        loadingProgress = findViewById(R.id.regProgressBar);
        loadingProgress.setVisibility(View.INVISIBLE);

        //9
        mAuth = FirebaseAuth.getInstance();

        regBtn = findViewById(R.id.regBtn);
        regBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                phoneNumber = et_phone.getText().toString().trim();
                if (phoneNumber.isEmpty()) { //untuk mengecek nomor hp kosong atau tidak
                    et_phone.setError("Invalid Phone Number");
                } else {
                    loadingProgress.setVisibility(View.VISIBLE);
                    sendVerificationCode(phoneNumber);
                }
            }
        });
    }

    private void sendVerificationCode(String phoneNumber) {
        PhoneAuthProvider.getInstance().verifyPhoneNumber(
                "+62" + phoneNumber, //nomor yang diverifikasi
                60,//timeout
                TimeUnit.SECONDS,//unittimeout
                this,
                mCall);
        Toast.makeText(getApplicationContext(), "Sedang Memverifikasi, Mohon Tunggu", Toast.LENGTH_SHORT).show();
    }

    private PhoneAuthProvider.OnVerificationStateChangedCallbacks mCall = new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {

        @Override
        public void onCodeAutoRetrievalTimeOut(@NonNull String s) {
            super.onCodeAutoRetrievalTimeOut(s);

            Log.e(TAG, "onCodeAutoRetrievalTimeOut: " + s);
        }

        @Override
        public void onVerificationCompleted(@NonNull PhoneAuthCredential phoneAuthCredential) {
            Log.e(TAG, "onVerificationCompleted: " + phoneAuthCredential.toString());
        }

        @Override
        public void onVerificationFailed(@NonNull FirebaseException e) {
            Log.e(TAG, "onVerificationFailed: " + e.toString());
            loadingProgress.setVisibility(View.GONE);
        }

        //kode verif dikirim
        @Override
        public void onCodeSent(String verificationId, PhoneAuthProvider.ForceResendingToken token) {
            Log.e(TAG, "onCodeSent: " + token.toString());
            loadingProgress.setVisibility(View.GONE);
            String mVerificationId = verificationId;
            Log.e("MainActivity", "Verification id : " + verificationId);
            Intent intent = new Intent(PhoneLoginActivity.this, KodeActivity.class);
            intent.putExtra("verificationId", mVerificationId);
            startActivity(intent);
            finish();
        }
    };


}