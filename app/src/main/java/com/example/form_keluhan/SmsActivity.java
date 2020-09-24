package com.example.form_keluhan;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class SmsActivity extends AppCompatActivity {
    //Variable yang Dibutuhkan Untuk Autentikasi
    String verificationId;
    FirebaseAuth mAuth;


    //Variable Untuk Komponen-komponen Yang Diperlukan
    EditText et_otp;
    Button verify_btn;
    String otp;
    ProgressBar pb_bar;

    // Intent intent;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sms);

        et_otp = findViewById(R.id.et_otp);
        verify_btn = findViewById(R.id.verify_btn);
        pb_bar=findViewById(R.id.pb_bar);
        pb_bar.setVisibility(View.GONE);

        mAuth =FirebaseAuth.getInstance();


    }


    private void verifyOtp(String verificationId, String otp) {
        PhoneAuthCredential credential = PhoneAuthProvider.getCredential(verificationId,otp);

        //sign in user
        signInWithPhoneAuthCredential(credential);
    }


    // wktu user udh masukin kode verifikasi kmu login ke firebase authentication pake phoneCredential,
    // biar data user yang login kesave
    // di firebase
    private void signInWithPhoneAuthCredential(PhoneAuthCredential credential) {
        mAuth.signInWithCredential(credential)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {

                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {

                        otp = et_otp.getText().toString().trim();


                        if (task.isSuccessful()) {
                            pb_bar.setVisibility(View.INVISIBLE);
                            Intent intent = new Intent(SmsActivity.this, Lantai1Activity.class);
                            startActivity(intent);
                            finish();
                        } else  {
                            et_otp.setError("Invalid otp");

                            Toast.makeText(SmsActivity.this, "Something Wrong ",
                                    Toast.LENGTH_SHORT).show();
                        }
                    }
                }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(SmsActivity.this, "Something Wrong " + e, Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void ClickKode(View view){

        EditText  et_otp =  (EditText)findViewById(R.id.et_otp);

        FirebaseDatabase database = FirebaseDatabase.getInstance();

        //Referensi database yang dituju
        DatabaseReference myRef =
                database.getReference("Kode").child(et_otp.getText().toString());

        //memberi nilai pada referensi yang dituju
        myRef.child("Kode").setValue(et_otp.getText().toString());

        Intent intent = new Intent(SmsActivity.this, Lantai1Activity.class);
        startActivity(intent);
        finish();

        Toast.makeText(getApplicationContext(), "Verifikasi Telah Selesai", Toast.LENGTH_SHORT).show();



    }
}