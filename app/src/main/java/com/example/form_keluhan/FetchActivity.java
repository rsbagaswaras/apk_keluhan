package com.example.form_keluhan;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.firebase.ui.database.FirebaseListAdapter;
import com.firebase.ui.database.FirebaseListOptions;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class FetchActivity extends AppCompatActivity {

    ListView lv;
    FirebaseListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fetch);

        Query query = FirebaseDatabase.getInstance().getReference().child("RSBW");

        lv = findViewById(R.id.ListView);

        FirebaseListOptions<Form> options = new FirebaseListOptions.Builder<Form>()
                .setLayout(R.layout.cardview)
                .setQuery(query,Form.class)
                .build();

        adapter = new FirebaseListAdapter(options) {
            @Override
            protected void populateView(@NonNull View v, @NonNull Object model, int position) {
                TextView tgl_penyampaian = v.findViewById(R.id.tgl_penyampaian);
                TextView nama = v.findViewById(R.id.nama_responden);
                TextView ruangan = v.findViewById(R.id.ruangan);
                TextView kategori = v.findViewById(R.id.kategori);
                TextView keluhan = v.findViewById(R.id.keluhan);

                Form form = (Form) model;
                tgl_penyampaian.setText(form.getTanggal_penyampaian().toString());
                nama.setText(form.getNama_responden().toString());
                ruangan.setText(form.getRuangan().toString());
                kategori.setText(form.getKategori().toString());
                keluhan.setText(form.getKeluhan().toString());
            }
        };
        lv.setAdapter(adapter);
    }

    @Override
    protected void onStart() {
        super.onStart();
        adapter.startListening();
    }

    @Override
    protected void onStop() {
        super.onStop();
        adapter.stopListening();
    }
}