package com.example.form_keluhan;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;


import com.google.firebase.FirebaseException;

import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;


import java.util.concurrent.TimeUnit;

public class SmsActivity extends AppCompatActivity {

    TextView countDownTimer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sms);

        final EditText inputMobile = findViewById(R.id.inputMobile);
        final Button buttonGetOTP = findViewById(R.id.buttonGetOTP);
        final ProgressBar progressBar = findViewById(R.id.progressBar);

        buttonGetOTP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (inputMobile.getText().toString().trim().isEmpty()) {
                    Toast.makeText(SmsActivity.this, "Enter Mobile", Toast.LENGTH_SHORT).show();
                    return;
                }

                progressBar.setVisibility(View.VISIBLE);
                buttonGetOTP.setVisibility(View.INVISIBLE);

                PhoneAuthProvider.getInstance().verifyPhoneNumber(
                        "+628" + inputMobile.getText().toString(),
                        30,
                        TimeUnit.SECONDS,
                        SmsActivity.this,
                        new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
                            @Override
                            public void onVerificationCompleted(@NonNull PhoneAuthCredential phoneAuthCredential) {
                                progressBar.setVisibility(View.GONE);
                                buttonGetOTP.setVisibility(View.VISIBLE);

                            }

                            @Override
                            public void onVerificationFailed(@NonNull FirebaseException e) {
                                progressBar.setVisibility(View.GONE);
                                buttonGetOTP.setVisibility(View.VISIBLE);
                                Toast.makeText(SmsActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                            }

                            @Override
                            public void onCodeSent(@NonNull String verificationId, @NonNull PhoneAuthProvider.ForceResendingToken forceResendingToken) {
                                progressBar.setVisibility(View.GONE);
                                buttonGetOTP.setVisibility(View.VISIBLE);

                                Intent intent = new Intent(getApplicationContext(), VerifyOtpActivity.class);
                                intent.putExtra("mobile", inputMobile.getText().toString());
                                intent.putExtra("verificationId", verificationId);
                                startActivity(intent);


                            }

                        }
                );


                new CountDownTimer (60 * 1000, 1000) {
                    @Override
                    public void onTick(long millisUntilFinished) {
                        int minutes = (int) ((millisUntilFinished / (1000 * 60)) % 60);
                        int seconds = (int) (millisUntilFinished / 1000) % 60;
                        countDownTimer.setText(minutes + ":" + " " + seconds + " " + "left");
                    }

                    @Override
                    public void onFinish() {
                        countDownTimer.setText("done");
                    }
                };


            }
        });


        countDownTimer = findViewById(R.id.countDownTimer);


    }

}