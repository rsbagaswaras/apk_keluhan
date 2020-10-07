package com.example.form_keluhan;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class AdminActivity extends AppCompatActivity {

    private FirebaseAuth auth;
    private TextView GetKategori, GetKeluhan, GetKoordinat, GetNama, GetRuangan, GetStatus;
    private String GetUserID;
    private FirebaseDatabase getDatabase;
    private DatabaseReference getRefenence;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);

        getSupportActionBar().setTitle("Laporan 2");
        GetKategori = findViewById(R.id.getkategori);
        GetKeluhan = findViewById(R.id.getkeluhan);
        GetKoordinat = findViewById(R.id.getkoordinat);
        GetNama = findViewById(R.id.getnama);
        GetRuangan = findViewById(R.id.getruangan);
        GetStatus = findViewById(R.id.getstatus);
        auth = FirebaseAuth.getInstance();

//Mendapatkan User ID dari akun yang terautentikasi
        FirebaseUser user = auth.getCurrentUser();
        GetUserID = user.getUid();

        getDatabase = FirebaseDatabase.getInstance();
        getRefenence = getDatabase.getReference();

        /*
         * Mendapatkan referensi dari lokasi Admin dan tutunannya yaitu User ID dari masing-masing
         * akun user dan tutunannya lagi yaitu Mahasiswa, lalu menambahkan ValueEventListener
         * untuk menangani kejadian saat data diambil dari Snapshot.
         */
        getRefenence.child("Keluhan").child(GetUserID).child("Laporan 2").addValueEventListener(new ValueEventListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                String value = dataSnapshot.getValue(String.class);
                //Mengambil value dari salah satu child, dan akan memicu data baru setiap kali diubah
                data_keluhan keluhan = dataSnapshot.getValue(data_keluhan.class);
                GetKategori.setText("Kategori : "+keluhan.getKategori());
                GetKeluhan.setText("Keluhan : "+keluhan.getKeluhan());
                GetKoordinat.setText("Koordinat : "+keluhan.getKoordinat());
                GetNama.setText("Nama : "+keluhan.getNama());
                GetRuangan.setText("Ruangan : "+keluhan.getRuangan());
                GetStatus.setText("Kategori : "+keluhan.getStatus());

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                //Digunakan untuk menangani kejadian Error
                Log.e("Admin", "Error", databaseError.toException());

            }
        });
    }
}