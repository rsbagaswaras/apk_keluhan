package com.example.form_keluhan;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import cyd.awesome.material.AwesomeText;
import cyd.awesome.material.FontCharacterMaps;

import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class AdminActivity extends AppCompatActivity{

private EditText username, password;
private Button login;
Switch active;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);

            username = findViewById(R.id.username);
            password = findViewById(R.id.password);
            login = findViewById(R.id.btn_login);
            active= findViewById(R.id.active);

            login.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference();
                    databaseReference.child("login admin").addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {
                            String input1 = username.getText().toString();
                            String input2 = password.getText().toString();

                            if (snapshot.child(input1).exists()) {
                                if (snapshot.child(input2).exists()) {
                                    if (active.isChecked()){
                                        if (snapshot.child("as").equals("admin")) {
                                            preferences.setDataLogin(AdminActivity.this, true );
                                            preferences.setDataAs(AdminActivity.this, "admin");
                                        }else {
                                            preferences.setDataLogin(AdminActivity.this, true);
                                        }
                                    }

                                }else {
                                    Toast.makeText(AdminActivity.this, "Kata Sandi Salah", Toast.LENGTH_SHORT).show();

                                }

                            }else {
                                Toast.makeText(AdminActivity.this,"Data belum terdaftar", Toast.LENGTH_SHORT).show();

                            }


                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {

                        }
                    });

                }
            });
    }
}